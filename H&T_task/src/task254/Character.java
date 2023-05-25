package task254;

import java.util.ArrayList;

// abstract修飾子を付けると「抽象クラス」という扱いになる.
// クラスが持つべき値、実行しうる振る舞いを定義するために用いられる.
// 抽象クラスで定義された枠組みに具体的な内容を付加するために、
// 「派生クラス」を作成する必要がある.
// → Heroクラス等を参照.
public abstract class Character {
	// フィールド.
	// キャラクターを構成する要素をフィールドとして定義する.
	// protected修飾子のついたフィールド・メソッドは、
	// privateと同様に外部から参照することはできず、
	// 当該クラスまたは派生クラス内で参照することができる.
	/** キャラクターの名前 */
	protected String _name;
	/** ヒットポイント */
	protected int _hitPoint;
	/** 最大ヒットポイント */
	protected final int _maxHitPoint;
	/** アイテムリスト */
	protected ArrayList<Item> itemList = new ArrayList<>();

	// ---------------------------------------------------------------------
	// コンストラクタ.
	/**
	 * キャラクターを作成します.
	 */
	public Character(String name, int hitPoint) {
		_name = name;
		_hitPoint = hitPoint;
		_maxHitPoint = _hitPoint;
	}

	// ---------------------------------------------------------------------
	// メソッド.
	// abstractなメソッドには処理を記述することはできない.
	// 派生クラスを作成した際、abstractメソッドの本体を実装する必要がある.
	/**
	 * キャラクター固有のスキルを発動します.
	 */
	public abstract void useSkill();

	/**
	 * キャラクターの名前を取得します.
	 * 
	 * @return キャラクターの名前
	 */
	public String getName() {
		return _name;
	}

	/**
	 * ヒットポイントを取得します.
	 * 
	 * @return 現在のヒットポイント.
	 */
	public int getHitPoint() {
		return _hitPoint;
	}

	public int getMaxHitPoint() {
		return _maxHitPoint;
	}

	/**
	 * ヒットポイントを回復させます.
	 * 
	 * @param value 回復量
	 */
	public void heal(int value) {
		// 回復後のヒットポイントを算出
		calculate(value);
		System.out.println(_name + "はヒットポイントが" + value
				+ "回復した！");
		System.out.println(_hitPoint);
	}

	/**
	 * ダメージを負います.
	 * 
	 * @param value ダメージ量の絶対値
	 */
	public void damage(int value) {
		// ダメージ後のヒットポイントを算出
		calculate(value * (-1));
		System.out.println(_name + "は" + value
				+ "のダメージを受けた！");
	}

	/**
	 * ヒットポイントを算出します.
	 * 
	 * @param delta 変化量
	 */
	private void calculate(int delta) {
		_hitPoint += delta;
		if (_hitPoint > _maxHitPoint) {
			// 最大値を超える回復はしない
			_hitPoint = _maxHitPoint;
		} else if (_hitPoint < 0) {
			// オーバーキルはさせない(慈悲)
			_hitPoint = 0;
		}
	}

	/**
	 * アイテムを拾う.
	 * アイテムリストに引数のアイテムを追加.
	 */
	public void setItem(Item item) {
		System.out.println(_name + "は" + item.toString() + "を拾った");
		// アイテムリストにアイテムを追加
		itemList.add(item);
		System.out.println(item.getId());
	}

	/**
	 * アイテムリストから引数のidと同じものを取得.
	 * 
	 * @return _item アイテムを値として返す
	 */
	public Item getItem(int id) {
		for (Item _item : itemList) {
			if (_item.getId() == id) {
				return _item;
			}
		}
		return null;
	}

	/**
	 * アイテムリストから引数のidと同じものを取得.
	 * 
	 * @return _item アイテムを値として返す
	 */
	public void useItem(int itemId) {
		useItem(itemId, null);
	}

	/**
	 * アイテム使用.
	 * サブクラスごとに効果分岐
	 */
	public void useItem(int id, Character character) {
		Item selectedItem = getItem(id);
		Item useItem = getItem(id);
		if (useItem == null) {
			System.out.println("指定されたアイテムは所持していない!");
		} else if (itemList.isEmpty()) {
			System.out.println("アイテムを所持していない!");
		} else {

			if (character == null) {
				selectedItem.use(this);
			} else {
				selectedItem.use(character);
			}

			// アイテムリストから削除
			itemList.remove(useItem);
		}

	}

	/**
	 * アイテムリストを表示.
	 */
	public void printPlayerItemList() {
		// アイテムリストが空の場合
		if (itemList.isEmpty()) {
			System.out.println(
					"アイテムを所持していません");
		} else {
			// アイテムリストでループを回す
			for (Item _item : itemList) {
				System.out.println(_item.getId() + ":" + _item.toString());
			}
		}
	}

}
