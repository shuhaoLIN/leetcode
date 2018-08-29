/**
 * Created by lenovo on 2018/8/29.
 */
public class leetcode24两两交换链表中的节点 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        //这样4ms
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode temp = head;
            ListNode temp2;
            ListNode pre = head;
            ListNode headNext = head.next;
            while(temp != null){
                if(temp.next != null){
                    temp2 = temp.next;
                    temp.next = temp2.next;
                    temp2.next = temp;

                    if(temp == head){
                        head = temp2;
                        pre = temp; //标记前一个结点
                        temp = temp.next;

                    }
                    else {
                        pre.next = temp2;
                        pre = temp; //标记前一个结点
                        temp = temp.next;
                    }

                }
                else{
                    break;
                }
            }
            return headNext;
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
        //这样8ms
        public ListNode swapPairs(ListNode head) {
            ListNode temp = head;
            ListNode temp2;
            ListNode pre = head;
            while(temp != null){
                if(temp.next != null){
                    temp2 = temp.next;
                    temp.next = temp2.next;
                    temp2.next = temp;

                    if(temp == head){
                        head = temp2;
                        pre = temp; //标记前一个结点
                        temp = temp.next;

                    }
                    else {
                        pre.next = temp2;
                        pre = temp; //标记前一个结点
                        temp = temp.next;
                    }

                }
                else{
                    break;
                }
            }
            return head;
        }
    }
}
