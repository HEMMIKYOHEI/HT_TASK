package task47;

public class no3 {

	public static void main(String[] args) {
		// フラグを立てる
		int flg = 0;

		// 2から100までのループ
		for (int i = 2; i <= 100; i++) {
			// 2からiまでのループ
			// 例:i=5の時→5を2,3,4で割る
			for (int j = 2; j < i; j++) {
				// iをjで割り切れる場合
				if (i % j == 0) {
					// flgを1にする→素数ではない
					flg = 1;
				}
			}
			// flgが0の場合、素数なので表示
			if (flg == 0) {
				System.out.println(i);
			}
			// flgを0に戻す
			flg = 0;
		}

	}

}
