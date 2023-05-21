package leetcode.structure.link;

import static leetcode.structure.link.LinkUtils.toNode;
import static leetcode.structure.link.LinkUtils.toPrint;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_21_合并两个有序链表 {

    public static void main(String[] args) {
        int[] ints1 = {1, 2, 4};
        ListNode listNode1 = toNode(ints1);
        toPrint(listNode1);

        int[] ints2 = {1, 3, 4};
        ListNode listNode2 = toNode(ints2);
        toPrint(listNode2);

        toPrint(mergeTwoLists(listNode1, listNode2));
    }

    /**
     * 双指针
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dm = new ListNode(0);
        ListNode last = dm;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                while (list2 != null) {
                    last.next = list2;
                    list2 = list2.next;
                    last = last.next;

                }
                break;
            }
            if (list2 == null) {
                while (list1 != null) {
                    last.next = list1;
                    list1 = list1.next;
                    last = last.next;
                }
                break;
            }
            if (list1.val > list2.val) {
                //list2关联
                last.next = list2;
                list2 = list2.next;
                last = last.next;
            } else {
                last.next = list1;
                list1 = list1.next;
                last = last.next;
            }

        }
        return dm.next;
    }

}




