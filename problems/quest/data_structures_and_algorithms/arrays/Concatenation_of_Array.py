from typing import List


class ConcatenationOfArray:
    # copy и extend долго исполняются (1ms) 
    def get_concatenation1(self, nums: List[int]) -> List[int]:
        ans = nums.copy()
        ans.extend(ans)

        return(ans)

    # Мое оптимальное (0ms)
    def get_concatenation2(self, nums: List[int]) -> List[int]:
        ans = nums.copy()

        for n in nums:
            ans.append(n)

        return(ans)

    # Лучшее найденное
    def get_concatenation3(self, nums: List[int]) -> List[int]:
            return nums * 2
