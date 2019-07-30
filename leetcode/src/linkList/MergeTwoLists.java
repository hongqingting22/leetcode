package linkList;

public class MergeTwoLists {
    /**
     * 递归
     * 最小的值 + 其余两个链表合并
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1)return l2;
        else if(null == l2)return l1;
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
