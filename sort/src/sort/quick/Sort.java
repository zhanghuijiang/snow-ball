package sort.quick;

/**
 * 快速排序
 * @author arvin
 */
public class Sort {

	public static int partition(int[] list,int first,int last){
		
		int pivot = list[first];
		
		int low = first + 1;
		int high = last;
		
		while(high > low){
			
			//由数组的左边向右边查找出第一个 > pivot 的数组值的下标
			while(low <=high && list[low] <= pivot){
				low ++ ;
			}
			
			//由数组的右边向左边查找出第一个 <= pivot 的数组值的下标
			while(low <=high && list[high] > pivot){
				high --;
			}
			
			//将查找出的两个数组值交换位置
			if(high > low){
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		//继续查找第一个 < pivot 的数组值
		while(high > first && list[high] >= pivot){
			high --;
		}
		
		//确定 pivot 在数组中的位置
		if(pivot > list[high]){
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}else{
			return first;
		}
		
	}
	
	
	public static void sort(int[] list,int first,int last){
		if(last>first){
			//在数组中的位置
			int pivotIndex = partition(list, first, last);
			//排序左边的数组
			sort(list, first, pivotIndex -1);
			//排序右边边的数组
			sort(list, pivotIndex + 1, last);
		}
	}
	
	
	public static void sort(int[] list){
		sort(list, 0, list.length - 1);
	}
	
	
	public static void main(String[] args){
		int[] list = {2,3,2,5};
		sort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
	
}
