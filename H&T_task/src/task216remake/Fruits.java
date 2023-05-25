package task216remake;

import java.text.ParseException;

/**
*Fruitsクラス
*@author Hemmi
*サブクラス
*/

public class Fruits extends Items {
	/**
	 * コンストラクタ Fruits 果物データを登録.
	 *@throws ParseException
	 */
	public Fruits(int id, String name, int purchasingNum, String purchasingDay,
		int purchasingPrice, int expirationDate) throws ParseException {
		// スーパーコンストラクタ呼出
		super(id, name, purchasingNum, purchasingDay, purchasingPrice, expirationDate);
	}

	/*
	 * 売上合計を値として渡す.
	 * @throws ParseException
	 * @return 売上合計
	 */
	public int earningSum(int earningPrice, int earningNum) throws ParseException {
		// 結果格納
		double result = 0;
		// 売上合計
		result = earningPrice * earningNum;
		// 購入日時
		String now = "2021/06/27";
		// 経過日数
		int numberOfDaysElapsed = differenceDays(now, _purchasingDay);
		// 消費期限までの残りの日数
		int limit_day = _expirationDate - numberOfDaysElapsed;
		// 5日前だったら
		if (limit_day <= 5) {
			// 売上合計を2割り引き
			result = result * 0.7;
		}
		return (int) result;
	}

}
