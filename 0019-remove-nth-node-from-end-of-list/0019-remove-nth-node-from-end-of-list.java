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
    int count = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;

       solve(dummy , n);

       return dummy.next;
    }

    public void solve(ListNode node , int n)
    {
        if(node == null)
        {
            return ;
        }

        solve(node.next , n);
        count++;
        if(count == n+1)
        {
            node.next = node.next.next;
        }
    }
}