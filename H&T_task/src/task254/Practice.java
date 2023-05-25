package task254;

public class Practice {

	public static final int ITEM_ID_HERB = 1; // 薬草
	public static final int ITEM_ID_TRASH = 2; // ごみ
	public static final int ITEM_ID_CRITICAL = 3; // 爆弾フルーツ
	public static final int ITEM_ID_FAKE_HERB = 4; // 薬草もどき
	public static final int ITEM_ID_EVENTITEM = 5; // 宝

	public static void main(String[] args) {
		Hero hero = new Hero("ヨ○ヒコ");
		Priest priest = new Priest("つきそい");
		System.out.println(
				"理不尽にダメージを受けた！");
		hero.damage(50);
		priest.damage(10);
		hero.heal(30);
		System.out.println();
		// ---------------------------------------------------------------------
		// 次の抽象クラスを作成してください.
		// 0. アイテムを表現するクラス
		// 上記の抽象クラスを継承した、次の3種類のアイテムに対応する派生クラスを作成してください.
		// それぞれの派生クラスに同じような処理が登場しないように、
		// どこまでを基底クラスでカバーするかを考えながら実装してください.
		// 1.
		// 使うとヒットポイントが30回復するアイテム
		// 2.
		// 道具として使用できそうにないアイテム
		// 3.
		// 使うと致死量のダメージを受けてしまうアイテム
		// 続いて、それらのインスタンスを作成し、
		// それぞれに対して次の行動をとってください.
		// 4. 取得したアイテム名を出力
		// 5.
		// 道具として使えるアイテムかを確認
		// 6. 使える場合はすぐに使用する.
		// このとき、対象キャラクターを選択すること.
		// コンストラクタ作成 薬草
		Recovery yakuso = new Recovery(ITEM_ID_HERB, "薬草", 30, true);
		// 薬草を拾う
		hero.setItem(yakuso);
		// 付き人に薬草を使用
		hero.useItem(1, priest);
		// アイテムリストを出力
		hero.printPlayerItemList();
		// 薬草を使用
		hero.useItem(1);
		// 薬草を拾う
		hero.setItem(yakuso);
		// ヨシ〇コに薬草を使用
		hero.useItem(1);
		// コンストラクタ作成 爆弾フルーツ
		Damage bombFruit = new Damage(ITEM_ID_CRITICAL, "爆弾フルーツ", 80, true);
		// 爆弾フルーツを拾う
		hero.setItem(bombFruit);
		// 爆弾フルーツを使用
		hero.useItem(3);
		// コンストラクタ作成 薬草もどき 使用できない
		Recovery fakeYakuso = new Recovery(ITEM_ID_FAKE_HERB, "薬草もどき", 0, false);
		// 薬草もどきを拾う
		hero.setItem(fakeYakuso);
		// 薬草もどきを使用
		hero.useItem(4);
		// アイテムリストを表示
		hero.printPlayerItemList();
		// 薬草を拾う
		hero.setItem(yakuso);
		// 付き人に薬草を使用
		hero.useItem(1, priest);
		EventItem treasure = new EventItem(ITEM_ID_EVENTITEM, "宝");
		hero.setItem(treasure);
		hero.useItem(5, hero);
		hero.printPlayerItemList();
	}
}
