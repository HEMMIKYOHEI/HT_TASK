package task260;

public class Sample {
    public void fizzBuzz(int num) {
        if (num == 0) {
            return;
        } else if (num % 3 == 0 && num % 5 == 0) {
            System.out.println(num + ":FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.println(num + ":Fizz");
        } else if (num % 5 == 0) {
            System.out.println(num + ":Buzz");
        }
    }

    public boolean isValidAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            if (age >= 20 && age <= 80) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("入力値:ageが数値ではありません.");
            return false;
        }
    }
}
