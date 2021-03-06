package code.sort.bubble;

/**
 * 冒泡排序
 * 
 * @author arvin
 */
public class Sort {

	public static void main(String args[]) {

		int[] list = { 1, 3, 23, 4, 23, 23, 232, 2, 22, 1 };

		boolean needNextPass = true;

		// 比较次数为 (list size - 1)
		for (int k = 1; k < list.length && needNextPass; k++) {

			needNextPass = false;

			//相邻的二个元素做比较
			for (int i = 0; i < list.length - k; i++) {
				// swap list[i] with list[i+1]
				if (list[i] > list[i + 1]) {
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					needNextPass = true;
				}
			}

		}

		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}

	}
}
