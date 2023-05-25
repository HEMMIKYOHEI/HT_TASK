package task216remake;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

/**
*Appクラス
*@author Hemmi
*/

public class App {

	public static void main(String[] args) throws ParseException {
		// じゃがいもデータ作成
		Items potato = new Vegetable(1, "じゃがいも", 40, "2021/06/15", 150,
			30);
		// じゃがいも販売データ作成
		SellItems potatoSellData = new SellItems(1, 220, 1);
		// いちごデータ作成
		Items strawberry = new Fruits(2, "いちご", 20, "2021/06/15", 300, 14);
		// いちご販売データ作成
		SellItems strawberrySellData = new SellItems(2, 420, 2);
		// バナナデータ作成
		Items banana = new Fruits(3, "バナナ", 25, "2021/06/15", 80, 24);
		// バナナ販売データ作成
		SellItems bananaSellData = new SellItems(3, 128, 1);
		// リンゴデータ作成
		Items apple = new Fruits(4, "リンゴ", 30, "2021/06/15", 100, 20);
		// たまねぎデータ作成
		Items onion = new Vegetable(5, "たまねぎ", 30, "2021/06/22", 120, 20);
		// たまねぎ販売データ作成
		SellItems onionSellData = new SellItems(5, 160, 1);
		// にんじんデータ作成
		Items carrots = new Vegetable(6, "にんじん", 30, "2021/06/22", 90, 18);
		// にんじん販売データ作成
		SellItems carrotsSellData = new SellItems(6, 150, 1);
		// トマトデータ作成
		Items tomato = new Vegetable(7, "トマト", 10, "2021/06/22", 150, 7);
		// トマト販売データ作成
		SellItems tomatoSellData = new SellItems(7, 280, 1);
		// 作成したデータをひとつのリストに格納
		ArrayList<Items> items = new ArrayList<>(Arrays.asList(potato, strawberry, apple, banana,
			onion, carrots, tomato));
		// 作成した販売データをひとつのリストに格納
		ArrayList<SellItems> sellItems = new ArrayList<>(Arrays.asList(potatoSellData,
			strawberrySellData, bananaSellData, carrotsSellData, onionSellData, tomatoSellData));
		// Calculatorインスタンス作成
		Calculator c = new Calculator(items, sellItems);
		// 結果出力
		System.out.println("-----------------仕入れ-----------------");
		System.out.println("");
		c.printTotalPurchasingAmount();
		System.out.println("");
		System.out.println("-----------------売上-----------------");
		System.out.println("");
		c.printTotalEarningAmount();
		System.out.println("");
		System.out.println("-----------------利益-----------------");
		System.out.println("");
		c.printTotalProfitAmount();
		System.out.println("");
	}

}
