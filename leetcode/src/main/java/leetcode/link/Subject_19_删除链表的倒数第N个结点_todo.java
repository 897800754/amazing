package leetcode.link;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode listNode = LinkUtils.toNode(new int[]{1, 2, 3, 4, 5});
        removeNthFromEnd(listNode, 2);
        LinkUtils.toPrint(listNode);
    }

    /**
     * 快慢指针
     * 快指针 = 慢指针+N
     * 快指针到达尾节点,慢指针即为要删除的元素
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dm = new ListNode();
        dm.next = head;
        ListNode lo = dm;
        ListNode hi = null;
        ListNode temp = dm;
        //找到高位指针所在位置
        //[dm,1] n=1;
        while (n-- > 0) {
            temp = temp.next;
            if (temp == null) {
                //无
                return head;
            }
        }
        //找到高位
        hi = temp;
        ListNode preLo = null;
        while (hi.next != null) {
            hi = hi.next;
            preLo = lo;
            lo = lo.next;
        }
        if (preLo == null) {
            //要删除节点刚好是头节点
            return head;
        } else {
            //lo即为要删除的节点
            preLo.next = lo.next;
        }
        return head;
    }

    /**
     * 使用栈
     * LeetCode 官方解法2 ,终于和官方步调一致一次
     * 解法1通过遍历数组
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode point = head;
        Stack<ListNode> stack = new Stack<>();
        while (point != null) {
            stack.push(point);
            point = point.next;
        }
        if (stack.size() < n) {
            return head;
        }
        ListNode target = null;
        while (n-- > 0) {
            target = stack.pop();
        }
        //不存在目标节点
        if (target == null) {
            return head;
        }
        if (stack.isEmpty()) {
            //说明是头节点,返回下一个节点即可,
            return target.next;
        } else {
            //非头结点,获取上一个节点
            ListNode pop = stack.pop();
            pop.next = target.next;
        }
        return head;
    }
}
