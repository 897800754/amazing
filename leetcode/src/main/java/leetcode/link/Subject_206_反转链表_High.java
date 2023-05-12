package leetcode.link;

import static leetcode.link.LinkUtils.toNode;
import static leetcode.link.LinkUtils.toPrint;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_206_反转链表_High {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        ListNode listNode = toNode(ints);
        toPrint(listNode);
        toPrint(reverseList(listNode));
    }

    /**
     * 遍历节点,将节点转移至头结点
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cursor = head;
        ListNode pre = null;

        while (cursor != null) {
            ListNode next = cursor.next;

            cursor.next = pre;

            pre = cursor;

            cursor = next;

        }
        return pre;
    }


//    public static ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        //初始当前节点为头结点
//        ListNode cursor = head;
//        //当前节点不为空
//        while (cursor != null) {
//            //获取当前下一个节点
//            ListNode next = cursor.next;
//            //下一个节点 指向pre
//            cursor.next = prev;
//            //pre指向 当前节点
//            prev = cursor;
//            //当前节点指向下一个节点
//            cursor = next;
//        }
//        return prev;
//    }

}




