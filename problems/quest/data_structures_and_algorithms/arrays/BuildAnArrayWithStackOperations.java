import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        var ans = new ArrayList<String>();
        int[] stack = new int[target.length];

        for (int num = 1, idx = 0; num <= n && idx < target.length; num++) {
            stack[idx] = num;
            ans.add("Push");

            if (num != target[idx])
                ans.add("Pop");
            else
                idx++;
        }

        return ans;
    }
}
