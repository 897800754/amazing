package leetcode.structure.link;

/**
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_237_删除链表中的节点 {
    public static void main(String[] args) {

    }

    /**
     * 1->2(删除的目标节点)->3->4
     * 1->3->3->4
     * 1->3->4->null
     *
     * @param node
     */
    public void deleteNode0(ListNode node) {
        ListNode temp = node;
        ListNode pre = null;
        while (temp.next != null) {
            temp.val = temp.next.val;
            pre = temp;
            temp = temp.next;
        }
        if (pre != null) {
            pre.next = null;
        }
    }

    /**
     * 更优解,继承自己的儿子以及子孙后台
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
