package leetcode.structure.link;

import static leetcode.structure.link.LinkUtils.toNode;
import static leetcode.structure.link.LinkUtils.toPrint;

/**
 * https://leetcode.cn/problems/odd-even-linked-list/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_328_奇偶链表 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        ListNode listNode = toNode(ints);
        toPrint(listNode);
        toPrint(oddEvenList(listNode));
    }

    /**
     * 奇数节点生成一个链表
     * 偶数节点生成一个链表
     * 两个链表concat
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        //遍历整个列表
        //奇数节点指向next.next节点.
        //偶数节点指向next.next节点
        //考虑j,o为null
        ListNode j = head;
        ListNode o = head.next;
        ListNode oHead = o;
        while (j != null && o != null) {
            j.next = o.next;
            if (j.next == null) {
                //说明o已经是最后一个节点.
                j.next = oHead;
                break;
            }
            j = j.next;
            o.next = j.next;
            if (o.next == null) {
                //说明j已经是最后一个节点
                j.next = oHead;
                break;
            }
            o = o.next;
        }
        return head;
    }


}




