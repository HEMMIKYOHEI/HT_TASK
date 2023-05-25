package task254;

/**
 * Damageクラス
 * 
 * @author Hemmi
 *         サブクラス
 */

public class Damage extends Item {

	/**
	 * コンストラクタ Damage HPが1になるアイテム.
	 */
	public Damage(int id, String name, int value, Boolean isUsable) {
		super(id, name, value, isUsable);
	}

	/**
	 * アイテム使用.
	 */
	@Override
	public void use(Character character) {
		// 体力取得
		int _hitPoint = character.getHitPoint();
		// falseでなければ
		if (!_isUsable) {
			System.out.println("使用できないアイテムです。");
		} else {
			if (_hitPoint <= 0) {
				System.out.println("既に力尽きている");
				System.out.println();
			} else {
				// HP減少
				_hitPoint -= _value;
				System.out.println(character.getName()
						+ "は会心の一撃を受けた！");
				System.out.println();
				System.out.println(character.getName() + "HP:" + _hitPoint);
			}
		}
	}

}
