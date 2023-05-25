package task214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedHashMap;

public class practice {

	public static void main(String[] args) {
		List<String> students = new ArrayList<>();
		students.add("田中");
		students.add("鈴木");
		students.add("佐藤");

		System.out.println(students);

		students.remove("鈴木");

		System.out.println(students);

		System.out.println(students.size());

		LinkedHashMap<String, int[]> subject = new LinkedHashMap<>();

		int[] japanese = {10, 20, 30};
		int[] math = {20, 20, 20};
		int[] english = {30, 20, 10};

		subject.put("日本語", japanese);
		subject.put("数学", math);
		subject.put("英語", english);

		System.out.println(subject);
		System.out.println("キー" + "日本語"
			+ "に紐づくバリューは" + Arrays.toString(subject
				.get("日本語")) + "です。");
	}

}
