import java.util.ArrayList;
import java.util.List;

public class Sample {
    public List<Integer> extractEvenNumber(int num) {
        if (num < 0) {
            System.out.println("引数numには整数値を入れてください。");
            return null;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
