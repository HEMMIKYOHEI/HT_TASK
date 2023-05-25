package task216remake;

import java.util.ArrayList;
import java.text.ParseException;

/**
*Calculatorクラス
*@author Hemmi
*/

public class Calculator {
	// 商品データをリストに格納
	private ArrayList<Items> _list;
	// 販売データをリストに格納
	private ArrayList<SellItems> _sellItemsList;

	/**
	 * コンストラクタ Calculator データを用いて計算.
	 */
	public Calculator(ArrayList<Items> list, ArrayList<SellItems> sellItemsList) {
		_list = list;
		_sellItemsList = sellItemsList;
	}

	/**
	*同じ通し番号の商品データを値として返す.
	*@return 同じ通し番号の商品データ
	*/
	public Items findItem(int itemId) {
		// 商品データ格納
		Items targetItem = null;
		// 商品データループ
		for (Items item : _list) {
			// 同じ通し番号だったら
			if (item.getId() == itemId) {
				// データ格納
				targetItem = item;
				// 処理終了
				break;
			}
		}
		return targetItem;
	}

	/**
	*仕入合計を出力.
	*/
	public void printTotalPurchasingAmount() {
		// 仕入合計
		int sum = 0;
		// 商品ループ
		for (Items p : _list) {
			// 商品名
			String name = p.getName();
			// 仕入価格
			int purchasingPrice = p.getPurchasingPrice();
			// 仕入個数
			int purchasingNum = p.getPurchasingNum();
			System.out.println("商品名:" + name + " 仕入価格:"
				+ purchasingPrice + " 仕入個数:" + purchasingNum);
			System.out.println("");
			// 仕入合計に加算
			sum += p.purchasingSum();
		}
		System.out.println("仕入れ合計量は" + sum
			+ "円です。");
	}

	/**
	*売上合計を出力.
	*/
	public void printTotalEarningAmount() throws ParseException {
		// 売上合計
		int sum = 0;
		// 販売商品ループ
		for (SellItems e : _sellItemsList) {
			// 同じ通し番号の商品
			Items targetItem = findItem(e.getId());
			// 商品名
			String itemName = targetItem.getName();
			// 売上価格
			int earningPrice = e.getEarningPrice();
			// 売上個数
			int earningNum = e.getEarningNum();
			// 残りの在庫数
			int itemLeft = targetItem.getItemLeft(earningNum);
			sum += targetItem.earningSum(earningPrice, earningNum);
			System.out.println("商品名:" + itemName + " 販売価格:"
				+ earningPrice + " 販売個数:" + earningNum
				+ " 残り在庫数:" + itemLeft);
			System.out.println("");
		}
		System.out.println("売上合計は" + sum + "円です。");
	}

	/**
	*利益を出力.
	*/
	public void printTotalProfitAmount() throws ParseException {
		// 利益量
		int totalProfitAmount = 0;
		// 商品ループ
		for (SellItems e : _sellItemsList) {
			// 同じ通し番号の商品
			Items targetItem = findItem(e.getId());
			// 仕入価格
			int purchasingPrice = targetItem.getPurchasingPrice();
			// 売上価格
			int earningPrice = e.getEarningPrice();
			// 売上個数
			int earningNum = e.getEarningNum();
			// 仕入価格で販売した時の売上価格
			int sellPurchasingPrice = purchasingPrice * earningNum;
			// 売上合計
			int earningSum = targetItem.earningSum(earningPrice, earningNum);
			// 粗利
			int profit = earningSum - sellPurchasingPrice;
			totalProfitAmount += profit;
		}
		System.out.println("利益合計は" + totalProfitAmount
			+ "円です。");
	}

}
