package leetcode.structure.link;

import static leetcode.structure.link.LinkUtils.toNode;
import static leetcode.structure.link.LinkUtils.toPrint;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_2_两数相加 {

    public static void main(String[] args) {
        int[] ints1 = {2, 4, 9};
        ListNode listNode1 = toNode(ints1);
        toPrint(listNode1);

        int[] ints2 = {5, 6, 4, 9};
        ListNode listNode2 = toNode(ints2);
        toPrint(listNode2);

        ListNode listNode = addTwoNumbers(listNode1, listNode2);

        toPrint(listNode);
    }

    /**
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dm = new ListNode();
        ListNode head = dm;
        boolean up = false;
        while (l1 != null || l2 != null) {

            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);

            if (up) {
                if (sum + 1 >= 10) {
                    head.next = new ListNode((sum + 1) % 10);
                    up = true;
                } else {
                    head.next = new ListNode(sum + 1);
                    up = false;
                }
            } else {
                if (sum >= 10) {
                    head.next = new ListNode((sum) % 10);
                    up = true;
                } else {
                    head.next = new ListNode(sum);
                    up = false;
                }
            }
            head = head.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (up) {
            head.next = new ListNode(1);
        }
        return dm.next;

    }


}




