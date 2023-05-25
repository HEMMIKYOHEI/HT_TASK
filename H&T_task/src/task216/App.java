package task216;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Arrays;

/**
*Appクラス
*@author Hemmi
*/
// 結果表示

public class App {
	// じゃがいもの仕入れデータ登録
	private static final LinkedHashMap<Integer, Integer> POTATO_DATA = new LinkedHashMap<>() {
		{
			put(150, 40);
		}
	};
	// じゃがいもの売上データ登録
	private static final LinkedHashMap<Integer, Integer> POTATO_EARNINGS_DATA =
		new LinkedHashMap<>() {
			{
				put(220, 1);
			}
		};
	// じゃがいもの消費期限データ登録
	private static final LinkedHashMap<Integer, Integer> POTATO_EARNINGS_SYOHIKIGEN_DATA =
		new LinkedHashMap<>() {
			{
				put(8, 30);
			}
		};
	// いちごの仕入れデータ登録
	private static final LinkedHashMap<Integer, Integer> STRAWBERRY_DATA = new LinkedHashMap<>() {
		{
			put(300, 20);
		}
	};
	// いちごの売上データ登録
	private static final LinkedHashMap<Integer, Integer> STRAWBERRY_EARNINGS_DATA =
		new LinkedHashMap<>() {
			{
				put(420, 2);
			}
		};
	// いちごの消費期限データ登録
	private static final LinkedHashMap<Integer, Integer> STRAWBERRY_EARNINGS_SYOHIKIGEN_DATA =
		new LinkedHashMap<>() {
			{
				put(15, 14);
			}
		};
	// りんごの仕入れデータ登録
	private static final LinkedHashMap<Integer, Integer> APPLE_DATA = new LinkedHashMap<>() {
		{
			put(100, 30);
		}
	};
	// バナナの仕入れデータ登録
	private static final LinkedHashMap<Integer, Integer> BANANA_DATA = new LinkedHashMap<>() {
		{
			put(80, 25);
		}
	};
	// バナナの売上データ登録
	private static final LinkedHashMap<Integer, Integer> BANANA_EARNINGS_DATA =
		new LinkedHashMap<>() {
			{
				put(128, 1);
			}
		};
	// バナナの消費期限データ登録
	private static final LinkedHashMap<Integer, Integer> BANANA_EARNINGS_SYOHIKIGEN_DATA =
		new LinkedHashMap<>() {
			{
				put(15, 24);
			}
		};
	// たまねぎの仕入れデータ登録
	private static final LinkedHashMap<Integer, Integer> ONION_DATA = new LinkedHashMap<>() {
		{
			put(120, 30);
		}
	};
	// たまねぎの売上データ登録
	private static final LinkedHashMap<Integer, Integer> ONION_EARNINGS_DATA =
		new LinkedHashMap<>() {
			{
				put(160, 1);
			}
		};
	// じゃがいもの消費期限データ登録
	private static final LinkedHashMap<Integer, Integer> ONION_EARNINGS_SYOHIKIGEN_DATA =
		new LinkedHashMap<>() {
			{
				put(22, 20);
			}
		};
	// にんじんの仕入れデータ登録
	private static final LinkedHashMap<Integer, Integer> CARROTS_DATA = new LinkedHashMap<>() {
		{
			put(90, 30);
		}
	};
	// にんじんの売上データ登録
	private static final LinkedHashMap<Integer, Integer> CARROTS_EARNINGS_DATA =
		new LinkedHashMap<>() {
			{
				put(150, 1);
			}
		};
	// にんじんの消費期限データ登録
	private static final LinkedHashMap<Integer, Integer> CARROTS_EARNINGS_SYOHIKIGEN_DATA =
		new LinkedHashMap<>() {
			{
				put(22, 18);
			}
		};
	// トマトの仕入れデータ登録
	private static final LinkedHashMap<Integer, Integer> TOMATO_DATA = new LinkedHashMap<>() {
		{
			put(150, 10);
		}
	};
	// トマトの売上データ登録
	private static final LinkedHashMap<Integer, Integer> TOMATO_EARNINGS_DATA =
		new LinkedHashMap<>() {
			{
				put(280, 1);
			}
		};
	// トマトの消費期限データ登録
	private static final LinkedHashMap<Integer, Integer> TOMATO_EARNINGS_SYOHIKIGEN_DATA =
		new LinkedHashMap<>() {
			{
				put(22, 7);
			}
		};

	public static void main(String[] args) {
		// コンストラクタ Merchandise じゃがいも
		Merchandise potato = new Merchandise("じゃがいも", POTATO_DATA);
		// コンストラクタ Merchandise いちご
		Merchandise strawberry = new Merchandise("いちご", STRAWBERRY_DATA);
		// コンストラクタ Merchandise りんご
		Merchandise apple = new Merchandise("りんご", APPLE_DATA);
		// コンストラクタ Merchandise バナナ
		Merchandise banana_p = new Merchandise("バナナ", BANANA_DATA);
		// コンストラクタ Merchandise たまねぎ
		Merchandise onion = new Merchandise("たまねぎ", ONION_DATA);
		// コンストラクタ Merchandise にんじん
		Merchandise carrots = new Merchandise("にんじん", CARROTS_DATA);
		// コンストラクタ Merchandise トマト
		Merchandise tomato = new Merchandise("トマト", TOMATO_DATA);
		// コンストラクタ Earnings バナナ
		Earnings banana_e = new Earnings("バナナ", "果物", BANANA_EARNINGS_DATA,
			BANANA_EARNINGS_SYOHIKIGEN_DATA);
		// コンストラクタ Earnings いちご
		Earnings strawberry_e = new Earnings("いちご", "果物",
			STRAWBERRY_EARNINGS_DATA, STRAWBERRY_EARNINGS_SYOHIKIGEN_DATA);
		// コンストラクタ Earnings トマト
		Earnings tomato_e = new Earnings("トマト", "野菜", TOMATO_EARNINGS_DATA,
			TOMATO_EARNINGS_SYOHIKIGEN_DATA);
		// コンストラクタ Earnings たまねぎ
		Earnings onion_e = new Earnings("たまねぎ", "野菜",
			ONION_EARNINGS_DATA,
			ONION_EARNINGS_SYOHIKIGEN_DATA);
		// コンストラクタ Earnings にんじん
		Earnings carrots_e = new Earnings("にんじん", "野菜",
			CARROTS_EARNINGS_DATA,
			CARROTS_EARNINGS_SYOHIKIGEN_DATA);
		// コンストラクタ Earnings じゃがいも
		Earnings potato_e = new Earnings("じゃがいも", "野菜",
			POTATO_EARNINGS_DATA,
			POTATO_EARNINGS_SYOHIKIGEN_DATA);
		// 仕入れデータをひとつの配列に
		ArrayList<Merchandise> merchandise = new ArrayList<>(Arrays.asList(potato, strawberry,
			apple, banana_p, onion, carrots, tomato));
		// 売上データをひとつの配列に
		ArrayList<Earnings> earnings = new ArrayList<>(Arrays.asList(banana_e, strawberry_e,
			tomato_e, carrots_e, potato_e, onion_e));
		// コンストラクタ ProfitCalculator
		ProfitCalculator calculator = new ProfitCalculator(merchandise, earnings);
		// 利益を出力
		calculator.printProfit();
	}

}
