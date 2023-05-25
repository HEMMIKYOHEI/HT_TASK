package task214;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
	/*
	 * 科目名 enumクラス(列挙型)を使用
	 */
	public enum Subject {
		JAPANESE, MATH, SCIENCE, SOCIAL_STUDIES, ENGLISH;
	}

	// 生徒名
	private String _name;
	// LinkedHashMap<科目名,点数>
	// キーが科目、点数が値
	private LinkedHashMap<Subject, Integer> _testResultMap = new LinkedHashMap<>();

	// コンストラクタ 呼出時に処理開始
	public Student(String name, LinkedHashMap<Subject, Integer> results) {
		// バリデーションチェック
		// データが空、5教科文のデータがない場合はエラー表示
		if (results == null || results.size() < Subject.values().length) {
			throw new IllegalArgumentException(
				"引数resultsのデータ数が不足しています。5教科のデータが格納された状態にしてください。");
		}
		_name = name;
		_testResultMap = results;
	}

	// 合計点を計算する
	public int sum() {
		// 初期値0
		int result = 0;
		// 変数scoreに_testResultMapの値(点数)を返す
		for (int score : _testResultMap.values()) {
			// 値を加算
			result += score;
		}
		// 値を返す
		return result;
	}

	// 科目名をキーとし、点数を値として返す
	public int getTargetScore(Subject subject) {
		return _testResultMap.get(subject);
	}

	// 名前を値として返す
	public String getName() {
		return _name;
	}

	// 引数に応じて科目名(日本語)を値として返す
	public static String translateSubjectIntoJapanese(Subject subject) {
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
