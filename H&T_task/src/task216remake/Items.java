package task216remake;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

/**
*Itemsクラス
*@author Hemmi
*スーパークラス
*/

public class Items {
	// 通し番号
	public int _id;
	// 商品名
	public String _name;
	// 仕入個数
	public int _purchasingNum;
	// 仕入日
	public String _purchasingDay;
	// 仕入価格
	public int _purchasingPrice;
	// 売上価格
	public int _earningPrice;
	// 売上個数
	public int _earningNum;
	// 消費期限までの日数
	public int _expirationDate;

	/**
	 * コンストラクタ Items 商品データ登録.
	 * @throws ParseException
	 */
	public Items(int id, String name, int purchasingNum, String purchasingDay,
		int purchasingPrice, int expirationDate) throws ParseException {
		_id = id;
		_name = name;
		_purchasingNum = purchasingNum;
		_purchasingPrice = purchasingPrice;
		_expirationDate = expirationDate;
		_purchasingDay = purchasingDay;
	}

	public Items() {}

	/**
	*通し番号を値として返す.
	*@return 通し番号
	*/
	public int getId() {
		return _id;
	}

	/**
	*商品名を値として渡す.
	*@return 商品名
	*/
	public String getName() {
		return _name;
	}

	/*
	 * 仕入価格を値として渡す
	 * @return 仕入価格
	 */
	public int getPurchasingPrice() {
		return _purchasingPrice;
	}

	/**
	*仕入個数を値として渡す.
	*@return 仕入個数
	*/
	public int getPurchasingNum() {
		return _purchasingNum;
	}

	/**
	*仕入合計を値として渡す.
	*@return 仕入合計
	*/
	public int purchasingSum() {
		// 仕入合計量
		int sum = _purchasingPrice * _purchasingNum;
		return sum;
	}

	/**
	*売上合計を値として渡す.
	*@return 売上合計
	*@throws ParseException
	*/
	public int earningSum(int earningPrice, int earningNum) throws ParseException {
		// 結果格納
		int result = 0;
		// 売上合計
		result = earningPrice * earningNum;
		return result;
	}

	public int getItemLeft(int earningNum) {
		int itemLeft = _purchasingNum - earningNum;
		return itemLeft;
	}

	/**
	*仕入日から販売日までの経過日数を値として渡す.
	*@return 経過日数
	*@throws ParseException
	*/
	public int differenceDays(String now, String purchasing_day) throws ParseException {
		// Dateインスタンス作成 購入日格納
		Date date1 = DateFormat.getDateInstance().parse(now);
		// Dateインスタンス作成 仕入日格納
		Date date2 = DateFormat.getDateInstance().parse(purchasing_day);
		// 購入日取得
		long datetime1 = date1.getTime();
		// 仕入日取得
		long datetime2 = date2.getTime();
		// 1日(秒)
		long one_date_time = 1000 * 60 * 60 * 24;
		// 購入日取得-仕入日取得/1日
		// 経過日数計算
		long diffDays = (datetime1 - datetime2) / one_date_time;
		return (int) diffDays;
	}

}
