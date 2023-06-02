package leetcode.structure.link;

import java.util.ArrayList;

import static leetcode.structure.link.LinkUtils.toNode;
import static leetcode.structure.link.LinkUtils.toPrint;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_234_回文链表 {

    public static void main(String[] args) {
        int[] ints1 = {1, 2, 4};
        ListNode listNode1 = toNode(ints1);
        toPrint(listNode1);


        System.out.println(isPalindrome(listNode1));
    }

    /**
     * @return 不做了
     * 思路1:反转链表,快慢指针
     * 思路2:转换为数组回文数问题
     */
    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static boolean isPalindrome0(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}




