from typing import List


class HowManyNumbersAreSmallerThanTheCurrentNumber:
    def smallerNumbersThanCurrent1(self, nums: List[int]) -> List[int]:
        sorted_nums = sorted(nums)
        ans = []

        for num in nums:
            ans.append(sorted_nums.index(num))

        return ans

    def smallerNumbersThanCurrent2(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [0] * n

        frequency = [0] * 101
        for num in nums:
            frequency[num] += 1

        less_array = [0] * 101
        for i in range(1, 101):
            less_array[i] = frequency[i - 1] + less_array[i - 1]

        for j in range(n):
            ans[j] = 0 if nums[j] == 0 else less_array[nums[j]]

        return ans
