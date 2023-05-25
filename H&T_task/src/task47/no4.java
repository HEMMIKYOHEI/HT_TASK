package task47;

// 配列を文字列として表示出来るようにする
import java.util.Arrays;

public class no4 {

	public static void main(String[] args) {
		// 配列を作成
		int[] data = {12, 50, 60, 30, 26};

		// data[0]とdata[最大値]を受け渡し
		quicksort(data, 0, data.length - 1);

		// dataを出力
		System.out.println(Arrays.toString(data));

	}

	private static void quicksort(int[] src, int left, int right) {
		// partition呼出
		int index = partition(src, left, right);

		if (left < index - 1) {
			quicksort(src, left, index - 1);
		}
		if (index < right) {
			quicksort(src, index, right);
		}
	}

	// 配列を基準値を中心に左、右に分ける
	private static int partition(int[] src, int left, int right) {
		// 基準値
		int pivot = src[(left + right) / 2];

		// インデックス
		// 最小値が最大値より小さい間
		while (left <= right) {
			// 基準値より小さい間
			while (src[left] < pivot) {
				left++;
			}
			// 基準値より大きい間
			while (src[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int tmp = src[left];
				src[left] = src[right];
				src[right] = tmp;

				left++;
				right--;
			}
		}
		return left;
	}

}
