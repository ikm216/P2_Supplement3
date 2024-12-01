public class search{
    public static int binarySearch(int[] arr, int low, int high, int search){
        
        if(arr[low] <= arr[high]){
            int mid = (low + high) / 2;

            if (arr[mid] == search){
                return mid;
            }
            else if (arr[mid] < search){
                return binarySearch(arr, mid + 1, high, search);
            }
            else{
                return binarySearch(arr, mid - 1, high, search);
            }
        }
        else{
            return -1;
        }
    }
}