package zjut.alex.LinkedList;
/*
*
* 逐一两两合并
* */
public class MergeList2 {
    static ListNode merge(ListNode[] lists){
        int n=lists.length;
        ListNode head=null;
        for(int i=0;i<n;++i){
            head=MergeTwoLists.merge(head,lists[i]);
        }
        return head;

    }
}

/*
*
*
* */
