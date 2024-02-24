import java.util.ArrayList;
import java.util.List;

public class BasicPermSolution {

    // brute force to calculate the prime numbers

    public boolean isPrime(int n) {
        if ( n <= 1) return false;
        for(int i =  2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    // bruteforce to calculate the permuatation

    public void permute(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
         List<Integer> singlePerm = new ArrayList<>();
         for (int num: nums) singlePerm.add(num);
         result.add(new ArrayList<>(singlePerm));
         return;
        }
        for(int i = start; i < nums.length; i++){
            swap(nums, i, start);
            permute(nums, start + 1, result);
            swap(nums, i, start);

        }
    }

    private void swap(int[] n, int i, int j ){
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;

    }
}
