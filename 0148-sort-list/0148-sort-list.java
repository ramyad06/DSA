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
    ListNode findMiddleNode(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode merge(ListNode list1Head, ListNode list2Head) {
        ListNode dummyNode = new ListNode(-1); 
        ListNode temp = dummyNode;

        while (list1Head != null && list2Head != null) {
            if (list1Head.val <= list2Head.val) {
                temp.next = list1Head;
                temp = list1Head;
                list1Head = list1Head.next;
            } else {
                temp.next = list2Head;
                temp = list2Head;
                list2Head = list2Head.next;
            }
        }

        while (list1Head != null) {
            temp.next = list1Head;
            temp = list1Head;
            list1Head = list1Head.next;
        }

        while (list2Head != null) {
            temp.next = list2Head;
            temp = list2Head;
            list2Head = list2Head.next;
        }
        return dummyNode.next;
    }

    ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddleNode(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null; 

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return merge(leftHead, rightHead);
    }
}