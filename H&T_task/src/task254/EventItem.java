package task254;

/**
 * EventItemクラス
 * 
 * @author Hemmi
 *         サブクラス
 */

public class EventItem extends Item {
	/**
	 * コンストラクタ EventItem イベントアイテム.
	 */
	public EventItem(int id, String name) {
		super(id, name, 0, false);
	}

	/**
	 * アイテム使用.
	 */
	@Override
	public void use(Character character) {
		System.out.println("このアイテムは使用できません");
		System.out.println();

	}
}
