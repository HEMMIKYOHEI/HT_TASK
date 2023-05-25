package task214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class App {
	// テストデータを作成
	// 田中太郎
	private static final LinkedHashMap<Student.Subject, Integer> TANAKA_TEST_RESULTS =
		new LinkedHashMap<>() {
			{
				put(Student.Subject.JAPANESE, 75);
				put(Student.Subject.MATH, 80);
				put(Student.Subject.SCIENCE, 85);
				put(Student.Subject.SOCIAL_STUDIES, 88);
				put(Student.Subject.ENGLISH, 92);
			}
		};
	// 鈴木一郎
	private static final LinkedHashMap<Student.Subject, Integer> SUZUKI_TEST_RESULTS =
		new LinkedHashMap<>() {
			{
				put(Student.Subject.JAPANESE, 85);
				put(Student.Subject.MATH, 72);
				put(Student.Subject.SCIENCE, 90);
				put(Student.Subject.SOCIAL_STUDIES, 95);
				put(Student.Subject.ENGLISH, 83);
			}
		};
	// 佐藤二郎
	private static final LinkedHashMap<Student.Subject, Integer> SATO_TEST_RESULTS =
		new LinkedHashMap<>() {
			{
				put(Student.Subject.JAPANESE, 78);
				put(Student.Subject.MATH, 90);
				put(Student.Subject.SCIENCE, 92);
				put(Student.Subject.SOCIAL_STUDIES, 75);
				put(Student.Subject.ENGLISH, 88);
			}
		};

	public static void main(String[] args) throws Exception {
		// Studentインスタンス作成
		Student tanaka = new Student("田中太郎", TANAKA_TEST_RESULTS);
		Student suzuki = new Student("鈴木一郎", SUZUKI_TEST_RESULTS);
		Student sato = new Student("佐藤二郎", SATO_TEST_RESULTS);

		// asList...引数を配列に入れる
		ArrayList<Student> students = new ArrayList<>(Arrays.asList(tanaka, suzuki, sato));

		// ScoreCalculatorインスタンス作成
		ScoreCalculator calculator = new ScoreCalculator(students);

		// 問1
		// 3人のうち、各教科別に1位の生徒を出力
		System.out.println("-------------- 問1 -----------------");
		calculator.printTopStudentNameOfEachSubject();

		// 問2
		// 各生徒の5教科の点数を合計し、合計点が一番高い人を出力
		System.out.println("-------------- 問2 -----------------");
		calculator.printTopStudentNameOfTotalResult();

		// 問3
		// 各生徒の5教科の平均点をそれぞれ計算し、それぞれ小数点以下第1位まで表示
		System.out.println("-------------- 問3 -----------------");
		calculator.printAverageScoreOfEachStudent();
	}
}
