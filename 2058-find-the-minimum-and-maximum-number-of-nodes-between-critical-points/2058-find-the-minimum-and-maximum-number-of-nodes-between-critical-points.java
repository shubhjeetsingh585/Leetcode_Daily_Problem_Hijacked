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
class Solution{
    public int[] nodesBetweenCriticalPoints(ListNode head){
        int frist=-1, last=-1, min=Integer.MAX_VALUE, i=1;
        ListNode prev=head;
        head=head.next;
        while(head.next!=null){
            if((head.val>prev.val && head.val>head.next.val) || (head.val<prev.val && head.val<head.next.val)){
                if(frist==-1) frist=i;
                else min=Math.min(min,i-last);
                last=i;
            }
            prev=head;
            head=head.next;
            i++;
        }
        return frist==last ? new int[]{-1,-1} : new int[]{min,last-frist};
    }
}