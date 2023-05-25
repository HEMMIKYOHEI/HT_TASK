package task254;

/**
 * Itemクラス
 * 
 * @author Hemmi
 *         スーパークラス
 */

abstract class Item {
	/** 最大ヒットポイント */
	protected int _maxHitPoint;
	// 名称
	protected String _name;
	// 効果量
	protected int _value;
	// 通し番号
	protected int _id;
	// 道具が使えるか
	protected boolean _isUsable;

	/**
	 * コンストラクタ Item アイテム.
	 */
	public Item(int id, String name, int value, boolean isUsable) {
		_id = id;
		_name = name;
		_value = value;
		_isUsable = isUsable;
	}

	/**
	 * アイテム名を値として返す.
	 * 
	 * @return アイテム名
	 */
	public String toString() {
		return this._name;
	}

	/**
	 * idを値として渡す.
	 * 
	 * @return _id
	 */
	public int getId() {
		return _id;
	}

	/**
	 * 効果値を値として渡す.
	 * 
	 * @return _value
	 */
	public int getValue() {
		return _value;
	}

	/**
	 * アイテム使用.
	 * サブクラスごとに効果分岐
	 */
	abstract void use(Character character);
}
