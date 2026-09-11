public class ShuffleTheArray {
    public int[] shuffle1(int[] nums, int n) {
        int[] ans = new int[n * 2];
        
        for (int i = 0, j = 0; i < n; i++) {
            ans[j++] = nums[i];
            ans[j++] = nums[i + n];
        }

        return ans;
    }

    // Вариант без дополнительной переменной
    public int[] shuffle2(int[] nums, int n) {
        int[] res = new int[2 * n];

        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[n + i];
        }

        return res;
    }
}
