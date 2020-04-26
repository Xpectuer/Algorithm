package zjut.alex.dfs;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [] nums={1,2,3};
        List<List<Integer>> lists;
        lists=Permutation.permute(nums);
        System.out.println(lists);

    }
}
