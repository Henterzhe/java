public class LinkedListPratice {
    class ListNode {
      int val;
     ListNode next;
     ListNode(int x){
         val = x;
     }
    }
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int len=lists.length;
            if(len==0){
                return null;
            }
            while (len>1){
                for(int i=0;i<len/2;i++){
                    lists[i]=mergeTwoLists(lists[i],lists[len-1-i]);
                }
                len=(len+1)/2;
            }
            return lists[0];
        }
        public ListNode mergeTwoLists(ListNode l1,ListNode l2){
            ListNode head=new ListNode(-1);
            ListNode p=head;
            while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }else {
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
            }
            if(l1==null){
                p.next=l2;
            }
            if(l2==null){
                p.next=l1;
            }
            return head.next;
        }

    }
}



