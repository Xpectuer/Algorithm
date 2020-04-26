package zjut.alex.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
*   逐一比较法
* 优先队列合并
*   优先队列详解
*https://www.cnblogs.com/Elliott-Su-Faith-change-our-life/p/7472265.html
* */
public class MergeList3 {
    static ListNode merge(ListNode[] lists){
        if(lists.length==0 ||lists==null){
            return null;
        }
       //维护一个优先队列：PriorityQueue
        PriorityQueue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for(int i=0;i<lists.length;++i){
            while(lists[i]!=null){
                queue.add(lists[i]);
                lists[i]=lists[i].next;
            }

        }
        //新链表
        ListNode head=new ListNode(0);
        ListNode curr=head;
        //插入
        while(!queue.isEmpty()){
            //返回队首元素，并出队
            ListNode temp=queue.poll();
            temp.next=null;
            //插入操作
            curr.next=temp;
            curr=curr.next;

        }
        return head.next;



    }
}
