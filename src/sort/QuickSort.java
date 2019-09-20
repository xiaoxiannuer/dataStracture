package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={3,5,7,8,9,5,1,2,6};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[]arr,int start,int end){
        if (start<end){
            int stand=arr[start];
            int low=start;
            int high=end;
            while (low<high){
                while (low<high&&arr[high]>=stand){
                    high--;
                }
                arr[low]=arr[high];
                while (low<high&&arr[low]<=stand){
                    low++;
                }
                arr[high]=arr[low];
            }
            arr[low]=stand;
            quickSort(arr,start,low);
            quickSort(arr,low+1,end);
        }
    }
}
