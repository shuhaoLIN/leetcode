import java.util.*;

/**
 * Created by lenovo on 2018/8/23.
 */

public class leetcode23合并K个排序链表 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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



    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution1 {
        //尝试一下就是一次循环将所有值都加入一个数组，然后进行排序
        public ListNode mergeKLists(ListNode[] lists) {
            List nums = new ArrayList();
            for (int i = 0; i < lists.length; i++) {
                while (lists[i] != null) {
                    nums.add(lists[i].val);
                    lists[i] = lists[i].next;
                }
            }
            if (nums.isEmpty()) {
                return null;
            }
            Collections.sort(nums, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return a - b;
                }
            });
            ListNode list = new ListNode(0);
            ListNode temp = list;
            for (int i = 0; i < nums.size(); i++) {
                temp.next = new ListNode((int) nums.get(i));
                temp = temp.next;
            }
            return list.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution2 {
        //答案里面9ms的做法
        public  ListNode mergeKLists(ListNode[] lists) {
            if (lists==null||lists.length==0){
                return null;
            }
            return work(lists,0,lists.length-1);
        }
        //利用归并排序的思想
        private ListNode work(ListNode[] lists, int left, int right) {
            int mid = (left+right)/2;
            if (left<right){
                ListNode l1 = work(lists, left, mid);
                ListNode l2 = work(lists, mid + 1, right);
                return mergeTwo(l1,l2);
            }
            return lists[left]; //如果left==right则直接返回左面的链表
        }

        private ListNode mergeTwo(ListNode l1, ListNode l2) {
            if(l1==null){
                return  l2;
            }
            if (l2==null){
                return l1;
            }

            if(l1.val < l2.val) {
                l1.next = mergeTwo(l1.next, l2);
                return l1;
            }else {
                l2.next = mergeTwo(l2.next, l1);
                return l2;
            }
        }
    }
}
