package task251;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Locale;

/**
*DateUtilクラス
*@author Hemmi
*/
public class DateUtil {
	/**
	 *曜日を出力.
	 * @throws ParseException	 
	 */
	public static String getWeekName(String dateStr, Locale country) {
		// フォーマットを作成、形式を指定
		SimpleDateFormat FORMAT_YEAR_MONTH_DAY = new SimpleDateFormat("yyyy/MM/dd", country);
		try {
			// 日付を設定
			Date date = FORMAT_YEAR_MONTH_DAY.parse(dateStr);
			// フォーマットの形式を変更
			FORMAT_YEAR_MONTH_DAY.applyPattern("EEEE");
			// 結果を出力
			String strDate = FORMAT_YEAR_MONTH_DAY.format(date);
			return strDate;
		}
		catch (ParseException e) {
			// エラーメッセージをログ出力
			System.out.println(
				"フォーマットが正しくありません。 error = "
					+ e.getLocalizedMessage());
			// 呼び出し元にはnullを返して失敗したことを通知
			return null;
		}
	}

}
