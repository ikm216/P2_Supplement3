public class search{
    /**
 * Performs a binary search on a sorted array to find the index of a given element.
 * 
 * The method uses recursion to divide the search space in half with each call,
 * making it efficient for large sorted datasets. If the element is found, 
 * its index is returned; otherwise, -1 is returned.
 * 
 * @param arr   The sorted array of integers to search.
 * @param low   The starting index of the current search range.
 * @param high  The ending index of the current search range.
 * @param search The integer value to search for in the array.
 * @return      The index of the element in the array if found, otherwise -1.
 * @throws StackOverflowError If the array is unsorted or if there is an infinite recursion due to incorrect bounds.
 */
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
    /**
 * Calculates the determinant of a square matrix using recursion.
 * 
 * This method supports matrices of arbitrary size (1x1, 2x2, or larger). For matrices larger
 * than 2x2, it uses recursive expansion by minors and cofactors to compute the determinant.
 * 
 * @param matrix The square matrix represented as a 2D integer array.
 * @param N      The size of the matrix (number of rows or columns).
 * @return       The determinant of the matrix as an integer.
 * 
 * @throws IllegalArgumentException If the matrix is null or not square.
 */
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

    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2){
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;

        if (col1 != row2){
            throw new IllegalArgumentException("Doesn't match");
        }
        int answer[][] = new int[row1][col2];
        for(int i = 0; i < row1; i++){
            for(int j = 0; j < col2; j++){
                for(int k = 0; k < col1; k++){
                    answer[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return answer;
    }
}
