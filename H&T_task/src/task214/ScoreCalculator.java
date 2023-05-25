package task214;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScoreCalculator {
	// 生徒の情報(Studentクラスで作成)を収納
	private ArrayList<Student> _students;

	// コンストラクタ 呼出時に処理開始
	// データが空の場合はエラー表示
	public ScoreCalculator(ArrayList<Student> studentList) {
		if (studentList == null || studentList.isEmpty()) {
			throw new IllegalArgumentException(
				"生徒データが空です");
		}
		_students = studentList;
	}

	// 科目ごとの最高得点を算出
	private int getMaxScoreOfTargetSubject(Student.Subject subject) {
		// 最高得点 初期値-1
		int maxScore = -1;
		// studentに
		for (Student student : _students) {
			// 点数を値として返す
			int score = student.getTargetScore(subject);
			// scoreとmaxScoreを比較し、点数の高い方を適用
			maxScore = Math.max(score, maxScore);
		}
		// 最終結果を値として返す
		return maxScore;
	}

	// 合計点数の最高得点を算出
	private int getTopTotalScore() {
		// 最高得点 初期値-1
		int maxTotalScore = -1;
		for (Student student : _students) {
			// 合計点を値として返す
			int total = student.sum();
			// totalとmaxTotalScoreを比較し、大きい方を適用
			maxTotalScore = Math.max(total, maxTotalScore);
		}
		// 値として返す
		return maxTotalScore;
	}

	// 科目ごとの最高得点者を出力
	public void printTopStudentNameOfEachSubject() {
		// 最高得点者を収納
		LinkedHashMap<Student.Subject, ArrayList<Student>> topStudentMap = new LinkedHashMap<>();

		for (Student.Subject subject : Student.Subject.values()) {
			ArrayList<Student> topStudentList = new ArrayList<>();
			int maxScore = getMaxScoreOfTargetSubject(subject);
			for (Student student : _students) {
				// 実際にリストに最高得点の点数があるかチェック
				if (maxScore == student.getTargetScore(subject)) {
					// 登録
					topStudentList.add(student);
				}
			}

			// 教科ごとに1位の生徒を登録する
			topStudentMap.put(subject, topStudentList);
		}

		// 結果を出力
		for (Map.Entry<Student.Subject, ArrayList<Student>> entry : topStudentMap.entrySet()) {
			// キーを呼び出す(JAPANESE...)
			Student.Subject key = entry.getKey();
			// キーを呼び出す(鈴木一郎...)
			ArrayList<Student> value = entry.getValue();
			for (Student top : value) {
				// 科目名を日本語に変換
				String subjectName = Student.translateSubjectIntoJapanese(key);
				// 出力
				System.out.println(subjectName + " : " + top.getName());
			}
		}
	}

	// 合計点が最も高い生徒名を出力
	public void printTopStudentNameOfTotalResult() {
		// 最高得点を値として返す
		int maxTotalScore = getTopTotalScore();

		// 最高得点の生徒を収納する
		ArrayList<Student> topStudents = new ArrayList<>();
		for (Student student : _students) {
			// 生徒のリストを参照し、最高得点が存在するかチェック
			if (maxTotalScore == student.sum()) {
				// 追加する
				topStudents.add(student);
			}
		}

		// 最高得点の生徒を出力する
		for (Student top : topStudents) {
			// 最高得点を持つ生徒名を値として返し、出力
			System.out.println("勝者! : " + top.getName());
		}
	}

	// 生徒の科目ごとの平均点を出力
	public void printAverageScoreOfEachStudent() {

		for (Student student : _students) {
			// 小数第1込みの合計点を値として返す
			double totalScore = student.sum();
			// 平均点
			double average = totalScore / Student.Subject.values().length;
			/*
			 * format 文の整形を行う %.1f⇒1.1 %.3f⇒1.111
			 */
			System.out.println(String.format(student.getName()
				+ "の5教科の平均点は%.1f点", average));
		}
	}

}
