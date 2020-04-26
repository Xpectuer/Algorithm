package zjut.alex.LinkedList;
/*
*
* 分治思想合并
* 引用：mergeTwoLists
* */
public class MergeList4 {
    //@param:l:小组内最低位链表
    //r：小组内最高位链表
    private static ListNode merge(ListNode[] lists,int l,int r){
        //若组内只有一个链表
        if(l==r){
            return lists[l];
        }

        if(l>r){
            return null;
        }
        //找到l，r中间数
        int mid =(l+r)>>1;
        //递归合并 l-mid， mid+1-r链表
        return MergeTwoLists.merge(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    public static ListNode merge(ListNode[] lists){
        return merge(lists,0,lists.length-1);
    }
}
