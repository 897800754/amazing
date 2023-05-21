package leetcode.structure.link;

import static leetcode.structure.link.LinkUtils.toNode;
import static leetcode.structure.link.LinkUtils.toPrint;

/**
 * https://leetcode.cn/problems/reverse-linked-list/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_206_review {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        ListNode listNode = toNode(ints);
        toPrint(listNode);
        toPrint(reverseList(listNode));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode dy = new ListNode(0);
        reverseList(head, dy);
        return dy.next;
    }

    private static void reverseList(ListNode head, ListNode dy) {
        ListNode cursor = head;
        while (cursor != null) {
            //遍历链表,将链表中每个元素指向前一个元素
            ListNode temp = dy.next;

            dy.next = cursor;

            ListNode next = cursor.next;

            cursor.next = temp;

            cursor = next;
        }
    }


}




