class Solution {
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode cur=head;
        for(int i=0;i<k;i++){
            if(cur==null) return head;
            cur=cur.next;
        }
        ListNode prev=reverseKGroup(cur,k);
        while(k-->0){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}