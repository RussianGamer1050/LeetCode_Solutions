class HowManyNumbersAreSmallerThanTheCurrentNumber {
    // 7ms
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            int amount = 0;
            for (int i = 0; i < n; i++)
                if (nums[i] < nums[j]) amount++;
            ans[j] = amount;
        }

        return ans;
    }
    // Ограничения задачи позволяют нам сделать более быстрое решение (1ms)
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[] frequency = new int[101]; // 0 <= nums[i] <= 100
        for (int num : nums)
            frequency[num]++;

        // Находим сумму всех чисел до i элемента
        int[] less_array = new int[101];
        for (int i = 1; i < 101; i++)
            less_array[i] = frequency[i - 1] + less_array[i - 1];

        for (int j = 0; j < n; j++)
            ans[j] = nums[j] == 0 ? 0 : less_array[nums[j]];

        return ans;
    }
}