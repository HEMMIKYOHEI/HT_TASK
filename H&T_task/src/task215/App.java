package task215;

import java.util.ArrayList;

/**
*Appクラス
*@author Hemmi
*/
// 結果表示
public class App {

	// CSVファイルを読み込み1行ずつ出力
	public static void main(String[] args) throws Exception {
		/*
		 * mainメソッド 答えを出力
		 * @param students 生徒データ格納
		 */
		// 生徒データ格納
		ArrayList<Student> students = new ArrayList<>();
		// インスタンス作成
		// Aクラスのデータを読み込み
		Reader A = new Reader("\\C:\\pleiades\\workspace\\H&T_task\\src\\task215\\1-A.csv");
		// Bクラスのデータを読み込み
		Reader B = new Reader("\\C:\\pleiades\\workspace\\H&T_task\\src\\task215\\1-B.csv");
		// Cクラスのデータを読み込み
		Reader C = new Reader("\\C:\\pleiades\\workspace\\H&T_task\\src\\task215\\1-C.csv");
		// Dクラスのデータを読み込み
		Reader D = new Reader("\\C:\\pleiades\\workspace\\H&T_task\\src\\task215\\1-D.csv");
		// テキスト読み込み
		PrintResultToText text = new PrintResultToText(
			"\\C:\\pleiades\\workspace\\H&T_task\\src\\task215\\No3.txt");
		// studentsに各クラスのデータを格納
		students.addAll(A.readLine());
		students.addAll(B.readLine());
		students.addAll(C.readLine());
		students.addAll(D.readLine());
		// ScoreCalculatorクラス インスタンス作成
		ScoreCalculator calculator = new ScoreCalculator(students);
		// 問1出力
		System.out.println("問1解答");
		calculator.printTopStudentNameOfTotalResult();
		System.out.println();
		// 問2出力
		System.out.println("問2解答");
		calculator.printTargetStudentRank();
		System.out.println();
		// 問3出力
		System.out.println("問3解答");
		text.fileReader(students);
		System.out.println("No3.txt参照");
		System.out.println();
	}
}
