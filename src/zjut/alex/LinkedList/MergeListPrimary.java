package zjut.alex.LinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*

    暴力求解 leetcode#23


*/
public class MergeListPrimary {
    public ListNode mergeKLists(ListNode[] lists) {
        //1.遍历链表将所有值放入数组中
        //2.排序
        //3.放入新链表
        int n=lists.length;
        List<Integer> val=new ArrayList<>();
        ListNode curr=null;
        ListNode head=new ListNode(-1);
        for(ListNode node:lists){
            while(node!=null){
                val.add(node.val);
                node=node.next;
            }
        }
        System.out.println(val);
        //quick sort
        Collections.sort(val);
        for(int i=val.size()-1;i>=0;i--){
            curr=new ListNode(val.get(i));
            curr.next=head.next;
            head.next=curr;
        }


        head=head.next;


        return head;


    }
    static void quicksort(List<Integer> val){
        Collections.sort(val);

    }

}
