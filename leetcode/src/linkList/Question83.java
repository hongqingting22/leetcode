package linkList;

public class Question83 {

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     *
     * 示例 1:
     *
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     *
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.next.val == head.val){
            head = head.next;
        }
        return head;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
