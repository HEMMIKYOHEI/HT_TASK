package task254;

/**
 * Recoveryクラス
 * 
 * @author Hemmi
 *         サブクラス
 */

public class Recovery extends Item {
	/**
	 * コンストラクタ Recovery 回復アイテム.
	 */
	public Recovery(int id, String name, int value, boolean isUsable) {
		super(id, name, value, isUsable);
	}

	/**
	 * アイテム名を値として返す.
	 * 
	 * @return アイテム名
	 */
	public String getName() {
		return _name;
	}

	/**
	 * 回復量を値として返す.
	 * 
	 * @return 回復量
	 */
	public int getValue() {
		return _value;
	}

	/**
	 * アイテム使用.
	 */
	@Override
	public void use(Character character) {
		// 体力取得
		int _hitPoint = character.getHitPoint();
		// 最大体力取得
		int _maxHitPoint = character.getMaxHitPoint();
		// 最大体力を体力に設定
		_maxHitPoint = _hitPoint;
		// 体力にアイテムの効果値を加算
		_hitPoint += _value;
		// falseでなければ
		if (!_isUsable) {
			System.out.println("使用できないアイテムです。");
		} else {
			if (_hitPoint > _maxHitPoint) {
				// 最大値を超える回復はしない
				_hitPoint = _maxHitPoint;
				System.out.println(
						"体力が満タンになった!");
				System.out.println(character.getName() + "HP:" + _hitPoint);
			}
			// HPが0以下の場合
			else if (_hitPoint < 0) {
				// HPが0になる
				_hitPoint = 0;
				System.out.println(_name
						+ "は使用できない。既に力尽きている");
				System.out.println();
			}
			// HPが最大HPと同じ場合
			else if (_hitPoint == _maxHitPoint) {
				System.out.println("既に体力が満タンだ!");
			}
			// 回復量が0以下の場合
			else if (_value < 0) {
				System.out.println(character.getName() + "は" + _name
						+ "を使用した");
				System.out.println(character.getName()
						+ "は" + -(_value) + "ダメージ受けた！");
				System.out.println();
				System.out.println(character.getName() + "HP:" + _hitPoint);
			} else {
				System.out.println(character.getName() + "は" + _name
						+ "を使用した");
				System.out.println(character.getName()
						+ "はヒットポイントが30回復した！");
				System.out.println();
				System.out.println(character.getName() + "HP:" + _hitPoint);
			}
		}
	}
}
