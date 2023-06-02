package leetcode.structure.link;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_160_相交链表 {

    public static void main(String[] args) {

    }

    /**
     * 其他方法
     * 1.hash表法
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        Stack<ListNode> stackB = new Stack<>();

        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        ListNode lastPop = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            //
            ListNode pop = stackA.pop();
            ListNode pop1 = stackB.pop();
            if (pop == pop1) {
                lastPop = pop1;
            } else {
                //跳出循环
                break;
            }
        }
        return lastPop;
    }

    /**
     * 快慢指针
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        ListNode headA1 = headA;
        ListNode headB1 = headB;

        while (headA != headB) {
            headA = headA == null ? headB1 : headA.next;
            headB = headB == null ? headA1 : headB.next;
        }
        return headA;
    }


}




