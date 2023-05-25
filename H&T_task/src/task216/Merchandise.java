package task216;

import java.util.LinkedHashMap;
import java.util.Map;

/**
*Merchandiseクラス
*@author Hemmi
*/
public class Merchandise {
	// 商品名
	private String _name;
	// 仕入れ額と仕入れ量
	private LinkedHashMap<Integer, Integer> _sum;

	public Merchandise(String name, LinkedHashMap<Integer, Integer> sum) {
		/*
		 * コンストラクタ Merchandise
		 * @param _name 商品名
		 * @param _sum 各商品ごとの仕入れ合計
		 * 仕入れデータを登録
		 */
		_name = name;
		_sum = sum;
	}

	public int sum() {
		/*
		 * sumメソッド 各商品の合計値を
		 * 各商品の合計値を値として返す
		 */
		int result = 0;
		for (Map.Entry<Integer, Integer> s : _sum.entrySet()) {
			int amount = s.getKey();
			int num = s.getValue();
			int sum = amount * num;
			result += sum;
		}

		return result;
	}
}
