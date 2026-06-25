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
    public ListNode removeNodes(ListNode head) {
       head = reverse(head);
        
        ListNode curr = head;
        ListNode maxNode = head;

        while(curr != null && curr.next != null)
        {
            if(curr.next.val < maxNode.val)
            {
               curr.next = curr.next.next;
            }
            else 
            {
                curr = curr.next;
                maxNode = curr;
            }
        }
        return reverse(head);
    }
    public ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next ;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev ;

            prev = curr ;
            curr = next ;
        }
        return prev;
    }
}