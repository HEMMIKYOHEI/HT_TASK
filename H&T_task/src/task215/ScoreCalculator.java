package task215;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

/**
*ScoreCalculatorクラス
*@author Hemmi
*/
public class ScoreCalculator {
	// 生徒のデータを格納
	private ArrayList<Student> _students;

	// コンストラクタ
	public ScoreCalculator(ArrayList<Student> studentList) {
		/**
		* コンストラクタ ScoreCalculator
		* @param studentList 生徒データ格納
		*/
		if (studentList == null || studentList.isEmpty()) {
			throw new IllegalArgumentException(
				"生徒データが空です");
		}
		_students = studentList;
	}

	private int getTopTotalScore() {
		/**
		* getTopTotalScoreメソッド
		*5教科の合計が一番高い点数を取得
		*/
		// 最高得点
		int maxTotalScore = -1;
		for (Student student : _students) {
			// 合計点
			int total = student.sum();
			// 最高得点を入れる
			maxTotalScore = Math.max(total, maxTotalScore);
		}
		// 値として渡す
		return maxTotalScore;
	}

	public void printTopStudentNameOfTotalResult() {
		/**
		* printTopStudentNameOfTotalResultメソッド
		*一番高い点数が実際に生徒リストの中に存在するとき、その生徒名、得点を出力
		*/
		// 最高得点
		int maxTotalScore = getTopTotalScore();
		// 最高得点の生徒のデータを格納
		ArrayList<Student> topStudents = new ArrayList<>();
		for (Student student : _students) {
			if (maxTotalScore == student.sum()) {
				topStudents.add(student);
			}
		}
		// 最高得点者を出力
		for (Student top : topStudents) {
			System.out.println("1位は" + top.getName() + "さんです");
		}
	}

	public String[] printAverageScoreOfEachSubject() {
		/**
		 * printAverageScoreOfEachSubjectメソッド
		 *科目ごとの平均点を出力
		 */
		// 出力結果を格納
		String[] answer = new String[Student.Subject.values().length];
		int index = 0;
		// 科目ごとに得点を加算していく
		for (Student.Subject subject : Student.Subject.values()) {

			int totalScore = 0;
			for (Student student : _students) {
				int score = student.getTargetScore(subject);
				totalScore += score;
			}
			// 平均点
			int average = totalScore / _students.size();
			String averageToString = String.valueOf(average);
			String subjectName = Student.convertSubjectToName(subject);
			// 結果出力
			answer[index] = subjectName + "の平均点は" + averageToString
				+ "点です";
			index++;
		}
		// 出力結果を値として渡す
		return answer;
	}

	public void printTargetStudentRank() {
		/**
		* printTargetStudentRankメソッド
		*指定した生徒の順位を出力
		*/
		// 生徒データを格納<生徒名、合計点>
		Map<String, Integer> studentList = new LinkedHashMap<>();

		for (Student student : _students) {
			int total = student.sum();
			studentList.put(student.getName(), total);
		}
		// 合計点を基準にデータを昇順に並び変える
		List<Map.Entry<String, Integer>> entries = new LinkedList<>(studentList.entrySet());
		Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
		// 生徒データを格納<生徒名,合計点>
		LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
		// 昇順に並び変えたデータを再登録
		for (Map.Entry<String, Integer> entry : entries) {
			result.put(entry.getKey(), entry.getValue());
		}
		// 順位
		int rank = 0;
		// 同率得点の人数
		int count = 1;
		// ループ内にて前の人の人数
		int oldScore = -1;
		// 指定した生徒の順位を出力
		for (Map.Entry<String, Integer> e : result.entrySet()) {
			String name = e.getKey();
			int score = e.getValue();
			int totalScore = score;
			// 前の人と同じ得点だった場合
			if (oldScore == totalScore) {
				// 人数をカウント
				count++;
			}
			else {
				// 順位をカウントした分増加
				rank += count;
				// カウンターを1に戻す
				count = 1;
			}

			if (name.equals("田中太郎") || name.equals("鈴木一郎")
				|| name.equals("佐藤二郎")) {
				System.out.println(name + "さんの順位は" + rank
					+ "位です");
			}
			// 前の人として得点を登録
			oldScore = totalScore;
		}
	}
}
