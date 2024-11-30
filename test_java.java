import org.junit.*;

public class test_java {
    int [] arr = {2, 4, 6, 8, 10};
    int search = 8;
    int test = search.binarySearch(arr, search);
    Assert.assertEquals(8, test);
}
