import java.util.Arrays;

public class SetMismatch {
    // 14ms
    public int[] findErrorNums1(int[] nums) {
        Arrays.sort(nums);
        // Исключительные случаи [1,1] и [2,2]
        if (nums.length == 2) {
            if (nums[0] == 1) {
                return new int[] {1,2};
            } else {
                return new int[] {2,1};
            }
        }

        int[] ans = new int[2];
        // Ищем повторяющийся элемент и его индекс
        int last_num = 0;
        int last_num_idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == last_num) {
                ans[0] = nums[i];
                last_num_idx = i;
            }
            last_num = nums[i];
        }

        // Создаем "сет" уникальных элементов
        int[] set_nums = new int[nums.length - 1];
        for (int i = 0; i < last_num_idx; i++)
            set_nums[i] = nums[i];
        for (int i = last_num_idx; i < set_nums.length; i++)
            set_nums[i] = nums[i + 1];

        // Проходимся по сету в поисках отсутствующего элемента
        for (int j = 0; j < set_nums.length; j++) {
            if (set_nums[j] != j + 1) {
                ans[1] = j + 1;
                
                return ans;
            }
        }
        // Если отсутствующий элемент не был найден - это последний элемент массива
        ans[1] = nums.length;

        return ans;
    }
    // 2ms
    public int[] findErrorNums2(int[] nums) {
        int n = nums.length;
        int[] frequency = new int[n + 1];

        for (int num : nums)
            frequency[num]++;

        int duplicate = 0, missing = 0;
        for (int i = 1; i <= n; i++) {
            if (frequency[i] == 2)
                duplicate = i;
            if (frequency[i] == 0)
                missing = i;
        }

        return new int[] {duplicate, missing};
    }
}