package task214;

public class no1 {

	public static void main(String[] args) {
		// Studentクラス呼出
		// 生徒名を設定
		Student tanaka = new Student();
		Student suzuki = new Student();
		Student sato = new Student();
		// それぞれ名前を設定
		tanaka.setName("田中太郎");
		suzuki.setName("鈴木一郎");
		sato.setName("佐藤二郎");
		// 名前の配列を作成
		// 名前の配列
		String[] name = new String[3];
		// 設定した名前を値として渡す
		name[0] = tanaka.getName();
		name[1] = suzuki.getName();
		name[2] = sato.getName();

		// 科目ごとの得点 問1で使用
		int[] japanese = {75, 85, 78};
		int[] math = {80, 72, 90};
		int[] science = {85, 90, 92};
		int[] society = {88, 95, 75};
		int[] english = {92, 83, 88};
		// Studentクラス呼出
		// 科目ごとの得点を設定
		Student japaneseScore = new Student();
		Student mathScore = new Student();
		Student scienceScore = new Student();
		Student societyScore = new Student();
		Student englishScore = new Student();
		japaneseScore.setScore(japanese);
		mathScore.setScore(math);
		scienceScore.setScore(science);
		societyScore.setScore(society);
		englishScore.setScore(english);
		// 科目ごとの得点配列を作成
		int[][] subjectScore = new int[5][];
		// 値として渡す
		subjectScore[0] = japaneseScore.getScore();
		subjectScore[1] = mathScore.getScore();
		subjectScore[2] = scienceScore.getScore();
		subjectScore[3] = societyScore.getScore();
		subjectScore[4] = englishScore.getScore();

		// 生徒ごとの得点 問2,問3で使用
		int[] tanakaScore = {75, 80, 85, 88, 92};
		int[] suzukiScore = {85, 72, 90, 95, 83};
		int[] satoScore = {78, 90, 92, 75, 88};
		// Studentクラス呼出
		// 生徒ごとの得点を設定
		Student studentScore1 = new Student();
		Student studentScore2 = new Student();
		Student studentScore3 = new Student();
		studentScore1.setScore(tanakaScore);
		studentScore2.setScore(suzukiScore);
		studentScore3.setScore(satoScore);
		// 生徒ごとの得点配列
		int[][] studentScore = new int[3][];
		// 設定した得点を値として渡す
		studentScore[0] = studentScore1.getScore();
		studentScore[1] = studentScore2.getScore();
		studentScore[2] = studentScore3.getScore();

		// Studentクラスを呼出 科目名を設定
		Student subject1 = new Student();
		Student subject2 = new Student();
		Student subject3 = new Student();
		Student subject4 = new Student();
		Student subject5 = new Student();
		// 科目名を設定
		subject1.setSubject("国語");
		subject2.setSubject("数学");
		subject3.setSubject("理科");
		subject4.setSubject("社会");
		subject5.setSubject("英語");
		// 科目名の配列
		String[] subject = new String[5];
		// 設定した科目名を値として渡す
		subject[0] = subject1.getSubject();
		subject[1] = subject2.getSubject();
		subject[2] = subject3.getSubject();
		subject[3] = subject4.getSubject();
		subject[4] = subject5.getSubject();
		
		// 解答結果
		// subjectHighScore呼出
		System.out.println("問1 解答");
		subjectHighScore(name, subject, subjectScore);
		System.out.println();
		System.out.println("問2 解答");
		// maxSum呼出
		maxSum(name, studentScore);
		System.out.println();
		System.out.println("問3 解答");
		// average呼出
		average(name, studentScore);
	}

	// 科目ごとの最高得点者を出力 問1
	private static void subjectHighScore(String[] name, String[] subject, int[][] score) {

		for (int i = 0; i < score.length; i++) {
			// 最高得点
			// 初期値はインデックス0
			int maxScore = score[i][0];
			// 最高得点者の名前
			// 初期値はインデックス0
			String maxName = name[0];
			for (int j = 1; j < name.length; j++) {
				// インデックス0より大きければ
				if (maxScore < score[i][j]) {
					// 最高得点の値を入れ替え
					maxScore = score[i][j];
					// 最高得点社者の名前の値を入れ替え
					maxName = name[j];
				}
			}
			// 結果を出力
			System.out.println(subject[i] + " : " + maxName + " 得点は " + maxScore);
		}
	}

	// 最高得点の人を出力 問2
	private static void maxSum(String[] name, int[][] score) {
		// scoreSumメソッド呼出
		int[] sum = scoreSum(name, score);
		// 最も高い得点
		// 初期値はインデックス0
		int maxSum = sum[0];
		// 最も得点が高い人
		// 初期値はインデックス0
		String maxName = name[0];
		// インデックス1以降がmaxSumより高ければ、値を入れ替える
		for (int j = 1; j < sum.length; j++) {
			if (maxSum < sum[j]) {
				maxSum = sum[j];
				maxName = name[j];
			}
		}

		System.out.println("合計得点が一番高い人は"
			+ maxName + "さんです。");
		System.out.println("合計点 :" + maxSum);
	}

	// 合計得点を出力(整数) 問2
	private static int[] scoreSum(String[] name, int[][] score) {
		int[] sum = new int[name.length];
		// 人数分合計得点を出力
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				sum[i] += score[i][j];
			}
		}
		return sum;
	}

	// 平均点を出力(小数第1位まで) 問3
	private static void average(String[] name, int[][] score) {
		// scoreSumを呼出
		double[] sum = avgScoreSum(name, score);
		// 平均点
		double[] avg = new double[name.length];

		for (int z = 0; z < avg.length; z++) {
			avg[z] = sum[z] / 5;
			System.out.println(name[z]
				+ "さんの5教科の平均点は" + avg[z]
				+ "です。");
		}

	}

	// 合計点出力 問3
	private static double[] avgScoreSum(String[] name, int[][] score) {
		// 合計点
		double[] sum = new double[name.length];

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				sum[i] += score[i][j];
			}
		}
		// 合計点を値として渡す
		return sum;
	}

}

// クラス作成
// 生徒名,成績,科目名を作成し、値として渡すクラス
/*
class Student {
	// 生徒名
	String studentName;
	// 生徒ごとの点数
	int[] studentScore;
	// 科目名
	String subjectName;

	// 生徒名を設定
	public void setName(String name) {
		studentName = name;
	}

	// 設定した名前を値として渡す
	public String getName() {
		return studentName;
	}

	// 得点を設定
	public void setScore(int[] score) {
		studentScore = score;
	}

	// 設定した得点を値として渡す
	public int[] getScore() {
		return studentScore;
	}

	// 科目名を設定
	public void setSubject(String subject) {
		subjectName = subject;
	}

	// 設定した科目名を値として渡す
	public String getSubject() {
		return subjectName;
	}

}
*/
