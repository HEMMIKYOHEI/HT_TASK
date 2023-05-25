package task215;

import java.util.LinkedHashMap;
import java.util.Map;

/**
*Studentクラス
*@author Hemmi
*/
public class Student {

	// 生徒名
	private String _name;
	// 科目ごとの得点を格納
	private LinkedHashMap<Subject, Integer> _testResultMap = new LinkedHashMap<>();

	// 科目名
	public enum Subject {
							JAPANESE, MATH, SCIENCE, SOCIAL_STUDIES, ENGLISH;
	}

	// コンストラクタ
	public Student(String name, LinkedHashMap<Subject, Integer> results) {
		/*
		 * コンストラクタ Student
		 * @param name 生徒名
		 * @param results
		 * 生徒の科目ごとの得点を格納
		 */
		if (results == null || results.size() < Subject.values().length) {
			throw new IllegalArgumentException(
				"引数resultsのデータ数が不足しています。5教科のデータが格納された状態にしてください。");
		}
		_name = name;
		_testResultMap = results;
	}

	// 生徒名を取得
	public String getName() {
		/*
		 * getNameクラス 生徒名を値として返す
		 */
		return _name;
	}

	// 5教科の合計点を取得
	public int sum() {
		/*
		 * sumクラス
		 * 生徒ごとの5教科合計点を値としと
		 * して返す
		 * @param result 合計点を格納
		 * @param score 1教科ごとの得点を格納
		 */
		int result = 0;
		for (int score : _testResultMap.values()) {
			result += score;
		}
		return result;
	}

	// 指定した科目の得点を取得
	public int getTargetScore(Subject subject) {
		/*
		 * getTargetScoreクラス
		 * 指定された科目の得点を値として返す
		 */
		return _testResultMap.get(subject);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(_name + " : {");
		if (_testResultMap != null) {
			int mapSize = _testResultMap.size();
			int counter = 0;
			// 全科目の科目名と点数を出力する
			for (Map.Entry<Subject, Integer> entry : _testResultMap.entrySet()) {
				String subjectName = convertSubjectToName(entry.getKey());
				builder.append(subjectName + " : " + entry.getValue());
				counter++;
				// 最後の出力でない場合はカンマを出力
				if (counter != mapSize) {
					builder.append(", ");
				}
			}
		}
		builder.append("}");
		return builder.toString();
	}

	// 科目名(英語)を日本語として取得
	public static String convertSubjectToName(Subject subject) {
		switch (subject) {
			case JAPANESE:
				return "国語";
			case MATH:
				return "数学";
			case SCIENCE:
				return "理科";
			case SOCIAL_STUDIES:
				return "社会";
			case ENGLISH:
				return "英語";
			default:
				return "";
		}
	}

}
