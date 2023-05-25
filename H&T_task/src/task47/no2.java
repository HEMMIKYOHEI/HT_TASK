package task47;

public class no2 {

	public static void main(String[] args) {
		// aを定義
		int a = 12222;
		// bを定義
		int b = 3333;

		while (b > 0) {

			// a/bの余剰
			int r = a % b;
			// 計算式を出力
			System.out.println(a + "%" + b + "=" + r);
			System.out.println();

			// aをbに変更
			a = b;
			// bをrに変更
			b = r;
		}
		// 最大公約数を出力
		System.out.println("aとbの最大公約数は" + a
			+ "である");

	}

}
