package leetcode.structure.link;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_141_环形链表 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);

        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        n4.next = n2;
        System.out.println(hasCycle0(n1));
    }

    /**
     * hash法,记录已经遍历过的链表
     *
     * @param head
     * @return
     */
    public static boolean hasCycle0(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (listNodes.contains(head)) {
                return true;
            }
            listNodes.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针,龟兔赛跑
     * [1,2,3,4]
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        if (fast == null) {
            return false;
        }
        while (fast != null) {
            if (slow.equals(fast)) {
                return true;
            }
            //快指针
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            //慢指针
            slow = slow.next;
        }
        return false;
    }
}




