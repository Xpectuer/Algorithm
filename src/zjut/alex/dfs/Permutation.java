package zjut.alex.dfs;

import java.util.*;

/*
深度优先算法(入门leetcode#46)
TODO:写markdown笔记
*/
public class Permutation {
    public static List<List<Integer>> permute(int[] nums){
        int len=nums.length;
        //result
        List<List<Integer>> res=new ArrayList<>();
        if(len==0){
            return res;
        }
        //***路线栈：记录已走过的节点***
        Deque<Integer> path=new ArrayDeque<>();

        //***已用栈：记录原数组已用的元素***
        //方法一：used数组，nums数组已选元素会被标为true
        //      记录已使用元素的经典方案（用空间换时间）
        boolean [] used=new boolean[len];
        //方法二：再开一个栈，每次都遍历
        //Deque<Integer> used1=new ArrayDeque<>();
        dfs(nums,len,0,path,used,res);
        return res;
    }

      private static void dfs(int []nums,
                              int len,int depth,
                              Deque<Integer> path,
                              boolean[] used,
                              List<List<Integer>> result)
      {
        if(depth==len){
            //一条路线结束
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<len;i++){
            //跳过已经使用的元素
            if(used[i]){
                continue;
            }
            //向下搜索一层，往历史记录里面压栈
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,len,depth+1,path,used,result);
            path.removeLast();
            used[i]=false;
        }

      }
}
