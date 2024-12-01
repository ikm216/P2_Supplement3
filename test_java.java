import org.junit.*;

public class test_java {
    @Test
    public void testBinarySearch(){
    int [] arr = {2, 4, 6, 8, 10};
    int low = 0;
    int high = arr.length - 1;
    int searchValue = 8;
    int test = search.binarySearch(arr, low, high, searchValue);
    Assert.assertEquals(3, test);
    }

    @Test
    public void test_should_negative_21_for_determinant(){
        int[][] matrix = {{3, 2, 3}, {4, 5, 4}, {9, 7, 5}};
        int N = matrix.length; 
        int answer = search.findDeterminate(matrix, N);
        Assert.assertEquals(-28, answer);
    }
}
