package task216remake;

public class SellItems extends Items {
	// 通し番号
	public int _id;
	// 売上価格
	public int _earningPrice;
	// 売上個数
	public int _earningNum;

	/**
	 * コンストラクタ SellItems 販売データ登録.
	 * @throws ParseException
	 */
	public SellItems(int id, int earningPrice, int earningNum) {
		_id = id;
		_earningPrice = earningPrice;
		_earningNum = earningNum;
	}

	/**
	*通し番号を値として返す.
	*@return 通し番号
	*/
	public int getId() {
		return _id;
	}

	/**
	*売上価格を値として返す.
	*@return 売上価格
	*/
	public int getEarningPrice() {
		return _earningPrice;
	}

	/**
	*売上個数を値として返す.
	*@return 売上個数
	*/
	public int getEarningNum() {
		return _earningNum;
	}

}
