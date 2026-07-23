class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        curr = set(nums)

        for _ in range(2):
            nxt = set()

            for num in nums:
                for xor in curr:
                    nxt.add(num ^ xor)

            curr = nxt

        return len(curr)