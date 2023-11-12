package leetcode.structure.link;

/**
 * @author: cg
 * @date: 2023-05-11 15:57
 **/
public class LinkUtils {
    public static ListNode toNode(int[] arr) {
        ListNode dy = new ListNode(0);
        ListNode temp = dy;
        for (int j : arr) {
            temp.next = new ListNode(j);
            temp = temp.next;
        }
        return dy.next;
    }

    public static void toPrint(ListNode listNode) {
        System.out.println("-----------");
        ListNode temp = listNode;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();
    }
}
