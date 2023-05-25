package task254;

// 派生クラスに関する次の説明
// (クラス定義、フィールド、コンストラクタ、メソッド) は、
// Hero.java を参照してください.
public class Priest extends Character {
        /**
         * キャラクター(職業：僧侶)を作成します.
         * @param name キャラクターの名前
         */
        public Priest(String name) {
                super(name, 80);
        }
        /**
         * 僧侶のスキルを発動します.
         */
        @Override
        public void useSkill() {
                // 有能
                System.out.println(_name + "はスキルを発動した！");
                heal(20);
        }
        // ---------------------------------------------------------------------
        // 基底クラスに処理が実装済みであっても、
        // 派生クラスでその動作を変えることができる.
        // 基底クラスの処理を呼び出したい場合は、super.メソッド名(引数) と記述する.
        /**
         * ダメージを負います.
         * @param value ダメージ量の絶対値
         */
        @Override
        public void damage(int value) {
                // 後衛職は被ダメージにプラス補正(5%)
                int damageValue = (int) (value * 1.05);
                // ダメージ量を補正したら、後のダメージ計算処理は基底クラスと同じ
                // ここで、super.damage() とせず、damage() と記述してしまうと
                // このメソッドが何度も呼び出されて無限ループに陥ってしまうため注意.
                super.damage(damageValue);
        }
}
