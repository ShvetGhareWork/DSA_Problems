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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        Integer[] integerArray = list.toArray(new Integer[0]);

        Arrays.sort(integerArray);    
        // ListNode dummyTemp = dummy.next;
        temp = head;
        for(int i = 0; i < integerArray.length; i++){
            temp.val = integerArray[i];
            temp = temp.next;
        }

        return head;    
    }
}