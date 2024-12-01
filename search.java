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
    public static int findDeterminate(int[][] matrix, int N){
        int d = 0;
        if(N == 1){
            return matrix[0][0];
        }
        else if(N == 2){
            return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        }

        else{
            int[][] newMatrix = new int [N - 1][];
            d = 0;

            for (int i = 0; i < N; i++){
                for (int k = 0; k < (N - 1); k++){
                    newMatrix[k] = new int[N -1];
                }
                for(int j = 1; j < N; j++){
                    int skip = 0;
                    for(int l = 0; l < N; l++){
                        if(l == i)
                            continue;
                        newMatrix[j - 1][skip] = matrix[j][l];
                        skip++;
                    }
                }
                int neg;
                if(i % 2 == 0){
                    neg = 1;
                }
                else{
                    neg = -1;
                }

                d += neg * matrix[0][i] * findDeterminate(newMatrix, N - 1);
            }
        }
        return d;
    }
}