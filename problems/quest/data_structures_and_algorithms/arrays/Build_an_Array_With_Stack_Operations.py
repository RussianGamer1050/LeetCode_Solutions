class BuildAnArrayWithStackOperations:
    def buildArray(self, target: list[int], n: int) -> list[str]:
        ans = []
        stack = [0] * len(target)

        idx = 0
        for num in range(1, n + 1):
            stack[idx] = num
            ans.append("Push")

            if num != target[idx]:
                ans.append("Pop")
            else:
                idx += 1
                if idx == len(target):
                    break

        return ans
