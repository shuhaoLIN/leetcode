/**
 * Created by lenovo on 2018/8/15.
 */
public class leetcode21合并两个有序链表 {


//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //这种思维不行啊，会出现就是不一定刚刚好的状态啊。
//        ListNode mid2;
//        ListNode head1 = l1;
//        ListNode pre1=l1;
//       // ListNode pre2=l2;
//        while((l1 != null) && (l2 != null)){
//            mid2 = l2;
//            l2 = l2.next;
//            if(l1.val  > mid2.val){
//                if(l1 == head1){
//                    head1 = mid2;
//                    mid2.next = l1;
//                }
//                else {
//                    pre1.next = mid2;
//                    mid2.next =l1;
//                    pre1 = mid2; //l1不变
//                }
//            }
//            else{
//                mid2.next = l1.next;
//                l1.next = mid2;
//                pre1 = mid2;
//                l1 = mid2.next;
//            }
//        }
//        if(l1 != null){
//            return head1;
//        }
//        else {
//            l1 = l2;
//            return head1;
//        }
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode mid;
        ListNode pre1=l1,pre2=l2;
        ListNode head = new ListNode(0);
        ListNode cur = head; // 结果的当前项
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                //取出l2当前项加入
                mid = l2;
                l2 = l2.next; // l2移向下一个
                cur.next = mid;
                cur = mid;
            }
            else {
                mid = l1;
                l1 = l1.next;
                cur.next = mid;
                cur = mid;
            }
        }
        if(l1 != null){
            cur.next = l1;
        }
        else {
            cur.next = l2;
        }
        return head.next;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2,int an2) {

        ListNode mid;
        ListNode head = null;
        ListNode cur = head; // 结果的当前项
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                //取出l2当前项加入
                mid = l2;
                l2 = l2.next; // l2移向下一个
            }
            else {
                mid = l1;
                l1 = l1.next;
            }
            if(cur == head && cur == null){
                head = mid;
                cur = head;
            }
            else{
                cur.next = mid;
                cur = cur.next;
            }
        }
        if(l1 != null){
            cur.next = l1;
        }
        else {
            cur.next = l2;
        }
        return head;
    }
    public static void main(String[] args) {
        leetcode21合并两个有序链表 lt = new leetcode21合并两个有序链表();
        ListNode node1= new ListNode(5);

        ListNode node2= new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(4);
//           System.out.println(node1.val+""+node1.next.val);
        System.out.println(lt.mergeTwoLists(node1,node2,1));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}