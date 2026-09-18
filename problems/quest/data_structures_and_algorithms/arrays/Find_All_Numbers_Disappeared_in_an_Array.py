class FindAllNumbersDisappearedInAnArray:
    # Time Limit Exceeded
    def findDisappearedNumbers1(self, nums: list[int]) -> list[int]:
        n = len(nums)

        ans = []
        for i in range(1, n + 1):
            if i not in nums:
                ans.append(i)

        return ans
    
    # Time Limit Exceeded
    def findDisappearedNumbers2(self, nums: list[int]) -> list[int]:
            n = len(nums)
    
            ans = []
            for i in range(1, n + 1):
                if nums.count(i) == 0:
                    ans.append(i)
    
            return ans

    # Быстро, но много по памяти (31,5 мб)
    def findDisappearedNumbers3(self, nums: list[int]) -> list[int]:
        n = len(nums)

        frequency = [0] * (n + 1)
        for num in nums:
            frequency[num] += 1

        ans = []
        for i in range(1, n + 1):
            if frequency[i] == 0:
                ans.append(i)

        return ans
    
    # Разница в памяти в пределах погрешности (31,1 мб)
    def findDisappearedNumbers4(self, nums: list[int]) -> list[int]:
            n = len(nums)
            unique_nums = set(nums)
    
            ans = []
            for i in range(1, n + 1):
                if i not in unique_nums:
                    ans.append(i)
    
            return ans  
