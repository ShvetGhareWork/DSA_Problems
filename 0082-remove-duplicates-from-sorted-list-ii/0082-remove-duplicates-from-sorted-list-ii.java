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
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle cases where the head itself is a duplicate
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                int duplicateVal = curr.val;
                
                while (curr != null && curr.val == duplicateVal) {
                    curr = curr.next;
                }
                
                prev.next = curr;
            } else {
                // No duplicate, just move prev forward
                prev = prev.next;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}

/*
Using HashMaps
ListNode dummy = new ListNode(0);
        Map<Integer, Integer> m = new HashMap<>();
        ListNode temp = head;
        while(temp != null){
            m.put(temp.val, m.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        ListNode tail = dummy;
        temp = head;
        while(temp != null){
            if(m.get(temp.val) == 1){
                tail.next = temp;
                tail = tail.next;
            }

            temp = temp.next;
        }

        tail.next = null;
        
        return dummy.next;
 */