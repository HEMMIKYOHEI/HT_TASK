package task216;

import java.util.LinkedHashMap;
import java.util.Map;

/**
*Appクラス
*@author Hemmi
*/
// 売上データを作成
public class Earnings {

	// 商品名
	private String _name;
	// 分類
	private String _classification;
	// 仕入れ額と仕入れ量
	private LinkedHashMap<Integer, Integer> _sum;
	// 仕入れ日、消費期限までの日数を登録
	private LinkedHashMap<Integer, Integer> _limit;

	// 商品名、分類(野菜、果物)、合計額(単価、個数)、日数(仕入れ日、消費期限)
	public Earnings(String name, String classification, LinkedHashMap<Integer, Integer> sum,
		LinkedHashMap<Integer, Integer> limit) {
		/*
		 * コンストラクタ Earnings
		 * @param _name 商品名
		 * @param _classificatio 分類
		 * @param _sum 各商品ごとの売上合計
		 * @param _limit 消費期限
		 * 生徒の科目ごとの得点を格納
		 */
		_name = name;
		_classification = classification;
		_sum = sum;
		_limit = limit;
	}

	private double classification(double sum) {
		/*
		 * classificationメソッド
		 * 野菜か果物かによって割り引き
		 *比率率を決める
		 */
		for (Map.Entry<Integer, Integer> l : _limit.entrySet()) {
			// 本日の日にち
			int today = 27;
			// 消費期限
			int syohikigen = l.getValue();
			// 仕入れ日
			int shire = l.getKey();
			// 本日までの経過日数
			int day = today - shire;
			// 消費期限までの日数
			int syohikigen_now = syohikigen - day;
			// 野菜だった場合
			if (_classification == "野菜") {
				// 残り3日以内
				if (syohikigen_now <= 3) {
					// 2割り引き
					sum = sum * 0.8;
				}
			}
			// 果物だった場合
			else if (_classification == "果物") {
				// 残り5日以内
				if (syohikigen_now <= 5) {
					// 3割り引き
					sum = sum * 0.7;
				}
			}
		}
		// 結果を値として返す
		return sum;
	}

	public double sum() {
		/*
		 * sumメソッド
		 * 各商品の合計値を値として返す
		 */
		int result = 0;
		for (Map.Entry<Integer, Integer> s : _sum.entrySet()) {
			// 金額
			int amount = s.getKey();
			// 個数
			int num = s.getValue();
			// 合計値
			double sum = amount * num;
			// 野菜か果物、消費期限が条件を満たしているか判断
			sum = classification(sum);

			result += sum;
		}
		return result;
	}

}
