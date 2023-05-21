package leetcode.structure.link;

import static leetcode.structure.link.LinkUtils.toNode;
import static leetcode.structure.link.LinkUtils.toPrint;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_203_移出链表元素 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        ListNode listNode = toNode(ints);
        toPrint(listNode);
        toPrint(removeElements(listNode, 2));
    }


    /**
     * 头结点前加上个虚拟节点
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dy = new ListNode(0);
        dy.next = head;
        ListNode temp = dy;
        while (temp.next != null) {

            if (temp.next.val == val) {
                //移出
                temp.next = temp.next.next;

            } else {
                //不相等
                temp = temp.next;
            }
        }
        return dy.next;
    }


}




