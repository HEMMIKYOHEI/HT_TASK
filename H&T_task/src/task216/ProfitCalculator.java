package task216;

import java.util.ArrayList;

/**
*ProfitCalculatorクラス
*@author Hemmi
*/
public class ProfitCalculator {
	// 仕入れリスト
	private ArrayList<Merchandise> _purchasingList;
	// 売上リスト
	private ArrayList<Earnings> _earningsList;

	public ProfitCalculator(ArrayList<Merchandise> purchasingList,
		ArrayList<Earnings> earningsList) {
		/*
		 * コンストラクタ ProfitCalculator
		 * @param _purchasingList 仕入れリスト
		 * @param _earningsList 売上リスト
		 * 仕入れ量と売上量の差で利益を
		 * 出力
		 */
		_purchasingList = purchasingList;
		_earningsList = earningsList;
	}

	public int printTotalPurchasingAmount() {
		/**
		*printTotalPurchasingAmountメソッド
		*仕入れ合計出力
		*/
		int sum = 0;
		for (Merchandise m : _purchasingList) {
			sum += m.sum();
		}
		System.out.println("仕入れ合計量は" + sum
			+ "円です");
		return sum;
	}

	public int printTotalEarningsAmount() {
		/**
		*printTotalEarningsAmountメソッド
		*売上合計出力
		*/
		int sum = 0;
		for (Earnings e : _earningsList) {
			sum += e.sum();
		}
		System.out.println("売上合計は" + sum + "円です");
		return sum;
	}

	public void printProfit() {
		/**
		*printProfitメソッド
		*利益出力
		*/
		int purchasing = printTotalPurchasingAmount();
		int earnings = printTotalEarningsAmount();
		int sum = earnings - purchasing;
		System.out.println("利益は" + sum + "円です");
	}
}
