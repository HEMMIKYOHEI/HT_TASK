package task216remake;

import java.text.ParseException;

/**
*Vegetableクラス
*@author Hemmi
*サブクラス
*/

public class Vegetable extends Items {
	/**
	 * コンストラクタ Vegetable 野菜データを登録.
	 *@throws ParseException
	 */
	public Vegetable(int id, String name, int purchasingNum, String purchasingDay,
		int purchasingPrice, int expirationDate) throws ParseException {
		// スーパーコンストラクタ呼出
		super(id, name, purchasingNum, purchasingDay, purchasingPrice, expirationDate);
	}

	/*
	 *売上合計を値として渡す.
	 *@throws ParseException
	 *@return 売上合計
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
		// 3日前だったら
		if (limit_day <= 3) {
			// 売上合計を2割り引き
			result = result * 0.8;
		}
		return (int) result;
	}

}
