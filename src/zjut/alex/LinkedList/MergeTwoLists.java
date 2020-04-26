package zjut.alex.LinkedList;

/*

        ***合并两个有序链表***


*/
public class MergeTwoLists {
    static ListNode merge(ListNode a,ListNode b){
        //处理空链表
        if(a==null||b==null){
            return a!=null?a:b;
        }
        ListNode head=new ListNode(-1);
        ListNode tail=head;
        ListNode aP=a,bP=b;
        while(aP!=null&&bP!=null){
            if(aP.val<bP.val){
                tail.next=aP;
                aP=aP.next;
            }
            else {
                tail.next=bP;
                bP=bP.next;
            }
            tail=tail.next;

        }
        tail.next=(aP!=null?aP:bP);
        return head.next;


    }
}
