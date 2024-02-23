import java.util.Arrays;

public class ChildernGame {

    public static void main(String[] args) {
        int n = 5, k = 2;
        int[] arr= {1,2,3,4,5};
        System.out.println(Arrays.toString(rotateArray(n, k, arr)));
    }

    public static int[] rotateArray(int n, int k , int[] arr){
        int[] rotateArr = new int[n];
        for(int i = 0; i<n; i++){
            int newPosition = (i + k) % n;
            rotateArr[newPosition] = arr[i];
        }
        return null;
    }
}
