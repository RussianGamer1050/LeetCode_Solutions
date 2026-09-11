from typing import List


class MaxConsecutiveOnes:
    def find_max_consecutive_ones(self, nums: List[int]) -> int:
        max_streak = 0
        cur_streak = 0

        for num in nums:
            if num == 1:
                cur_streak += 1
                if cur_streak > max_streak:
                    max_streak = cur_streak
            else:
                cur_streak = 0

        return max_streak
