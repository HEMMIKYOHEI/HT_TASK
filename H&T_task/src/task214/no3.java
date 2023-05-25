package task214;

public class no3 {

	public static void main(String[] args) {
		// 名前
		String[] name = {"田中太郎", "鈴木一郎",
			"佐藤二郎"};
		// 得点
		int[][] score = {{75, 80, 85, 88, 92}, {85, 72, 90, 95, 83}, {78, 90, 92, 75, 88}};
		// averageメソッド呼出
		avarage(name, score);

	}

	// 平均点を出力(小数第1位まで)
	private static void avarage(String[] name, int[][] score) {
		// scoreSumを呼出
		double[] sum = scoreSum(name, score);
		// 平均点
		double[] avg = new double[name.length];

		for (int z = 0; z < avg.length; z++) {
			avg[z] = sum[z] / 5;
			System.out.println(name[z]
				+ "さんの5教科の平均点は" + avg[z]
				+ "です。");
		}

	}

	// 合計点出力
	private static double[] scoreSum(String[] name, int[][] score) {
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
