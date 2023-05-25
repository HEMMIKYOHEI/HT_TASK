package task251;

import java.util.Locale;

/**
*Appクラス
*@author Hemmi
*/

public class App {

	public static void main(String[] args) {
		// singletonインスタンス呼出
		SingletonSample singleton = SingletonSample.getInstance();
		// Hello World!出力
		singleton.helloWorld();
		// 日付、ローケールを設定
		String weekDay = DateUtil.getWeekName("2021/10/22", Locale.CHINA);
		if (weekDay != null) {
			// 曜日出力
			System.out.println(weekDay);
		}
	}

}
