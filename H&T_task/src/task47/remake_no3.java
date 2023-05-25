package task47;

public class remake_no3 {

	public static void main(String[] args) {
		//  isPrimeメソッド呼出
		boolean result = isPrime(79);
		// 結果出力
		System.out.println(result);
	}

	// 素数判定メソッド
	private static boolean isPrime(int num) {
		if (num < 2) {
			// 1は素数ではない
			return false;
		}
		else if (num == 2) {
			// 2は素数
			return true;
		}
		else if (num % 2 == 0) {
			// 2以外の偶数は素数ではない
			return false;
		}
		// 1から入力数値までループ(1と自分自身以外に正の約数がないを調べる)
		int yakusu = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				yakusu++;
			}
		}
		// 1と自分自身のみなら素数
		return (yakusu == 2);
	}
}
