package leetcode.List;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        add();
    }
    private void add(ListNode n1, ListNode n2,ListNode finalNode,ListNode tempNode){
        ListNode temp1 = null;
        ListNode temp2 = null;
        if (n1!=null&&n2!=null){
            tempNode.val = n1.val+n2.val;
        }
        if (n1.next!=null&&n2.next!=null){

        }
    }*/
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
