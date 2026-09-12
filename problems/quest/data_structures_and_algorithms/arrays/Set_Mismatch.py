from typing import List


class SetMismatch:
    # Очень долго допирал, что и как сделать (19ms)
    def findErrorNums1(self, nums: List[int]) -> List[int]:
        sorted_nums = sorted(nums)
        ans = []

        if len(nums) == 2:
            if nums[0] == 1:
                ans = [1, 2]
            else:
                ans = [2, 1]
            return ans

        last_num = 0
        for num in sorted_nums:
            if num == last_num:
                ans.append(num)
            last_num = num

        set_nums = sorted_nums.copy()
        set_nums.remove(ans[0])

        for i in range(len(set_nums)):
            if set_nums[i] != i + 1:
                ans.append(i + 1)
                return ans

        ans.append(len(nums))
        return ans

    # Лучшее и понятное решение через количество вхождений (11ms)
    def findErrorNums2(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # Нулевой элемент не используется и нужен для обращения по индексам с единицы
        frequency = [0] * (n + 1)

        for num in nums:
            frequency[num] += 1

        duplicate = 0
        missing = 0
        for i in range(1, n + 1):
            if frequency[i] == 2:
                duplicate = i
            if frequency[i] == 0:
                missing = i

        return [duplicate, missing]
