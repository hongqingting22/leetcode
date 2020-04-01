package linkList;
//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.List;
import java.util.Stack;

/**
 * 回文链表
 *
 * 1.利用栈
 *
 * 2.将链表的一半数据压入栈
 *      利用快慢指针找到中间
 *
 * 3.快慢指针找到中间，后面的链表逆序
 */
public class LinkPalindrome {

    /**
     * 所有元素压入栈
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.val != stack.pop()){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    /**
     * 后半部分入栈
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if(head == null)return true;
        ListNode n1 = head,n2 = head;
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        Stack<Integer> stack = new Stack<>();
        while (n2 != null){
            stack.push(n2.val);
            n2 = n2.next;
        }
        n1 = head;
        while (n1 != null && !stack.isEmpty()){
            if(n1.val != stack.pop()){
                return false;
            }
            n1 = n1.next;
        }
        return true;
    }

    /**
     * 后半部分旋转
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        if(head == null)return true;
        ListNode n1 = head,n2 = head;
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        ListNode n3 = null;
        //旋转链表
        while (n2 != null && n2.next != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n1 = head;
        while (n1 != null && n2 != null){
            if(n1.val != n2.val)return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }


}
