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
    ListNode findNthnode(ListNode temp,int k){
        int cnt=1;
        while(temp!=null){
            if(cnt==k) return temp;
            cnt++;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode tail = head;
        int len=1;
        while(tail.next!=null){
            tail=tail.next;
            len+=1;
        }
        if(k%len==0) return head;
        k=k%len;
        tail.next=head;
        ListNode newNode = findNthnode(head,len-k);
        head = newNode.next;
        newNode.next=null;
        
        return head;
    }
}