package zjut.alex.LinkedList;


import java.util.ArrayDeque;
import java.util.Deque;
//leetcode#23
/*
* 输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
* */
public class MergeLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if(n==0){
            return null;
        }
        //创建一个新链表
        ListNode head=null;
        head.next=null;

        ListNode[] cur=new ListNode[n];
        //initiation
        for(int i=0;i<n;++i) {
            cur[i] = lists[i];
        }
        //创建一个记录数组
        boolean[] done=new boolean[n];
        for(boolean isDone:done){
            isDone=false;
        }

        //caparison and insertion
        //min
        int k;
        outer:
        while(true){
            k=min(cur,n,done);

            //引用数组前进一位
            if(!done[k]) {

                head.next=cur[k];
                cur[k] = cur[k].next;
            }
            if(cur[k].next==null){
                done[k]=true;
            }
            //出口
            for(boolean isDone:done){
                if(!isDone) {
                    continue outer;
                }
                }
            return head;
            }
        }



    static int min(ListNode[] cur,int n,boolean [] done){
        int min=0;
        for(int i=0;i<n;i++){
            if(done[i]){
                continue;
            }
            if(cur[i].val<cur[min].val) {
                min = i;
            }
        }
        return min;
    }
}
