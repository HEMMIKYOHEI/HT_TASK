package task215;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.ArrayList;

/**
*Readerクラス
*@author Hemmi
*/
public class Reader {
	// ファイル名
	private String _fileName;
	// 一行
	private String line = "";
	// 一行を配列として格納
	private String[] data;

	public Reader(String fileName) {
		/*
		 * コンストラクタ Reader
		 * @param fileName ファイル名
		 * 生徒の科目ごとの得点を格納
		 */
		_fileName = fileName;
	}

	private BufferedReader readFile() throws Exception {
		/*
		 * readFileクラス ファイル読み取り
		 */
		FileReader file = new FileReader(_fileName);
		BufferedReader br = new BufferedReader(file);
		return br;
	}

	public ArrayList<Student> readLine() throws Exception {
		/**
		*readLineメソッド
		*ファイルに記述されている生徒のデータを値として渡す
		*/
		// 生徒のデータを登録
		ArrayList<Student> students = new ArrayList<>();
		BufferedReader br = null;
		try {
			// readFileを呼出
			// ファイルデータを取得
			br = readFile();
			while ((line = br.readLine()) != null) {
				// 科目名をキーとし、得点を格納
				LinkedHashMap<Student.Subject, Integer> map = new LinkedHashMap<>();
				// カンマで区切る
				data = line.split(",");
				// 生徒名
				String s = data[0];
				// 国語の得点
				String japanese = data[1];
				// 数学の得点
				String math = data[2];
				// 理科の得点
				String science = data[3];
				// 社会の得点
				String social_studies = data[4];
				// 英語の得点
				String english = data[5];
				// 得点を登録
				map.put(Student.Subject.JAPANESE, Integer.parseInt(japanese));
				map.put(Student.Subject.MATH, Integer.parseInt(math));
				map.put(Student.Subject.SCIENCE, Integer.parseInt(science));
				map.put(Student.Subject.SOCIAL_STUDIES, Integer.parseInt(social_studies));
				map.put(Student.Subject.ENGLISH, Integer.parseInt(english));
				/**
				*Studentインスタンスを作成
				*生徒名と科目ごとの得点を登録
				*/
				Student student = new Student(s, map);
				// studentsに登録
				students.add(student);
			}
			// studentsを値として渡す
			return students;
		}
		finally {
			br.close();
		}
	}

}
