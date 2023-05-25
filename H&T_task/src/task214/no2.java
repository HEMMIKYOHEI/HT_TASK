package task214;

public class no2 {

	public static void main(String[] args) {
		// 名前
		String[] name = {"田中太郎", "鈴木一郎",
			"佐藤二郎"};
		// 得点
		int[][] score = {{75, 80, 85, 88, 92}, {85, 72, 90, 95, 83},
			{78, 90, 92, 75, 88}};
		// maxSumメソッドを呼出
		maxSum(name, score);
	}

	// 最高得点の人を出力
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

	// 合計得点を出力
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

}
