class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        second = head.next
        head.next = self.swapPairs(second.next)
        second.next = head
        return second