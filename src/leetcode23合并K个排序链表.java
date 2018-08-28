import java.util.Arrays;

/**
 * Created by lenovo on 2018/8/23.
 */

public class leetcode23合并K个排序链表 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //运用堆排序
    public ListNode mergeKLists(ListNode[] lists,int ans1,int ans2) {

    }
    public static void main(String[] args) {
        leetcode23合并K个排序链表 lt  = new leetcode23合并K个排序链表();
        int[] a = {2,3,5,6};
        Arrays.sort(a);

    }
    //采用就是将两个链表合成一条，然后一直递归下去。
    public ListNode mergeKLists(ListNode[] lists,int ans1) {
        ListNode head = new ListNode(-1);
        ListNode[] cur = new ListNode[lists.length];
        int len;
        int min;
        ListNode minNode;
        //while()
        return new ListNode(1);
    }

}
