package task251;

/**
*SingletonSampleクラス
*@author Hemmi
*/

public class SingletonSample {
	// インスタンスを作成
	private static SingletonSample singleton = new SingletonSample();

	private SingletonSample() {
	}

	/**
	 *Hello World出力.
	 */
	public void helloWorld() {
		System.out.println("Hello World!");
	}

	/**
	 *インスタンスを値として渡す.
	 */
	public static SingletonSample getInstance() {
		return singleton;
	}
}
