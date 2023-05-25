package task215;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

/**
*PrintResultToTextクラス
*@author Hemmi
*/
public class PrintResultToText {
	// テキスト名
	private String _textName;

	public PrintResultToText(String textName) {
		/*
		 * コンストラクタ PrintResultToText
		 * @param textName テキスト名
		 */
		_textName = textName;
	}

	private FileWriter readPrintingFile() throws Exception {
		/*
		 * readPrintingFileクラス テキスト読み取り
		 */
		File answer = new File(_textName);
		FileWriter fileWriter = new FileWriter(answer);
		return fileWriter;
	}

	public void fileReader(ArrayList<Student> students) throws Exception {
		/*
		 * fileReaderクラス テキストに答えを出力
		 */
		// readPrintingFileを呼出
		// テキストを値として渡す
		FileWriter fileWriter = readPrintingFile();
		// ScoreCalculatorインスタンス作成
		ScoreCalculator calculator = new ScoreCalculator(students);
		// 教科ごとの平均点を配列に格納
		String[] result = calculator.printAverageScoreOfEachSubject();
		// resultをNo.txtに出力
		for (int i = 0; i < Student.Subject.values().length; i++) {
			// 問3出力
			fileWriter.write(result[i] + "\r\n");
		}
		fileWriter.close();
	}

}
