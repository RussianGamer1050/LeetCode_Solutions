   class MaxConsecutiveOnes {
    // за каждый проход по циклу выполняется проверка - не очень
    public int findMaxConsecutiveOnes1(int[] nums) {
        int max_consecution = 0;
        int cur_max_consecution = 0;

        for (int num : nums) {
            if (num == 0) cur_max_consecution = 0;
            else cur_max_consecution += 1;
            
            if (cur_max_consecution > max_consecution)
                max_consecution = cur_max_consecution;
        }
        return max_consecution;
    }

    // мое более оптимизированное решение
    public int findMaxConsecutiveOnes2(int[] nums) {
        int max_consecution = 0;
        int cur_max_consecution = 0;

        for (int num : nums) {
            if (num == 1) {
                cur_max_consecution++;
                
                if (cur_max_consecution > max_consecution)
                max_consecution = cur_max_consecution;
            }
            else cur_max_consecution = 0;
        }
        return max_consecution;
    }
}
