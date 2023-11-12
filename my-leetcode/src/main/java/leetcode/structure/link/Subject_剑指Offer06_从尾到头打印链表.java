package leetcode.structure.link;

import java.util.Arrays;
import java.util.Stack;

import static leetcode.structure.link.LinkUtils.toNode;
import static leetcode.structure.link.LinkUtils.toPrint;

/**
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_剑指Offer06_从尾到头打印链表 {

    public static void main(String[] args) {
        int[] ints1 = {1, 2, 4};
        ListNode listNode1 = toNode(ints1);
        toPrint(listNode1);
        System.out.println(Arrays.toString(reversePrint(listNode1)));
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cursor = head;

        while (cursor != null) {
            stack.push(cursor);
            cursor = cursor.next;
        }
        int[] ints = new int[stack.size()];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = stack.pop().val;
        }
        return ints;
    }


}




