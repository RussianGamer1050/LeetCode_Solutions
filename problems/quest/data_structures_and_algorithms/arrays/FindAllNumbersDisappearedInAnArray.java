import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        
        int[] frequency = new int[n + 1];
        for (int num : nums) 
            frequency[num]++;

        var ans = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (frequency[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}
