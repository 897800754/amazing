package leetcode.structure.link;

import static leetcode.structure.link.LinkUtils.toNode;
import static leetcode.structure.link.LinkUtils.toPrint;

/**
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/9pdjbm/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_剑指Offer24_反转链表 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        ListNode listNode = toNode(ints);
        toPrint(listNode);
        toPrint(reverseList(listNode));
    }


    public static ListNode reverseList(ListNode head) {
        ListNode dm = new ListNode();
        ListNode temp = head;
        while (temp != null) {

            ListNode next = dm.next;

            dm.next = temp;

            temp = temp.next;

            dm.next.next = next;

        }
        return dm.next;
    }
}




