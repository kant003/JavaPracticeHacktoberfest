import java.util.*;

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ListNode i : lists){
            while(i != null){
                pq.add(i.val);
                i = i.next;
            }
        }

        if(pq.isEmpty()) return null;

        ListNode head = new ListNode();
        ListNode temp = head;

        while(!pq.isEmpty()){
            temp.val = pq.poll();
            if(!pq.isEmpty()) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        return head;
    }
}