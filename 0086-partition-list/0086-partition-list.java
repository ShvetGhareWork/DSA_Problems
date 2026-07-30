/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummySmall = new ListNode(0);
        ListNode smallTail = dummySmall;
        ListNode dummyLarge = new ListNode(0);
        ListNode bigTail = dummyLarge;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            if(curr.val < x){
                smallTail.next = curr;
                smallTail = smallTail.next;
            }else{
                bigTail.next = curr;
                bigTail = bigTail.next;
            }

            curr.next = null;
            curr = temp;
        }

        smallTail.next = dummyLarge.next;

        return dummySmall.next;
    }
}