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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)return;
            ListNode slow = head , fast = head ;
            while(fast !=null && fast.next !=null)
            {
                slow = slow.next;
                fast = fast.next.next ;

            }
        ListNode second = reverse(slow.next);
        slow.next = null;//pehle wala half cut gya 

        ListNode curr = head ;

        while(second != null)
        {
          ListNode t1 = curr.next ;
          ListNode t2 = second.next ;

          curr.next = second ;
          second.next = t1 ;

            curr = t1 ;
            second = t2 ;
        }
        
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null, curr = head ;

        while(curr != null)
        {
            ListNode newnode = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = newnode ;
        }
        return prev ;
    }
}