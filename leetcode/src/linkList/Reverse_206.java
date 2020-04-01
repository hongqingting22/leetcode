package linkList;

/**
 *反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reverse_206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur !=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归完成翻转链表
     * 思路：
     *  1.终止条件，链表最后一个元素，返回链表元素
     *  2.   如图：cur->next
     *          变形为：cur<-next
     *      后面所有元素翻转后，需要将当前元素next元素的next属性指向当前元素
     *      即：current.next.next = current;
     *          current.next = null;
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode listNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
}
