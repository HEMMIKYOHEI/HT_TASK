package task47;

// 配列を文字列として表示出来るようにする
import java.util.Arrays;

public class no1 {

	public static void main(String[] args) {
		// 配列を作成
		int[] num = {67, 88, 3, 32, 90, 1, 44, 8, 9};
		// reverseメソッドを呼出
		int[] result = reverse(num);

		// 配列を出力
		System.out.println(Arrays.toString(result));
	}

	// 配列内の要素を逆順にするメソッド
	private static int[] reverse(int[] src) {
		// 逆順にしたint[] srcを入れる
		int[] temp = new int[src.length];

		// 外でidx = 0で初期化しておく
		int idx = 0;
		// iは最大から減算していき、idxは0から加算する
		// 最小インデックススタートj,最大インデックススタート
		for (int i = temp.length - 1; i >= 0; i--, idx++) {
			temp[idx] = src[i];
		}

		// tempを値として渡す
		return temp;
	}
}
