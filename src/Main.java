public class Main {
    public static void main(String[] args) {
        int []a={7,8,1,2,3,4,5,6};
        //int [] a={1,2,3,4,5,6};
        int target=4;
        System.out.println(search1(a,target));
    }

     private static int search(int[] nums, int target) {
        int division=0;

        int i=0;
        //处理 0-3 长度数组

        if(nums.length<4){
            if(nums.length==0)
                return -1;
            for(int j=0;j<nums.length;++j) {
                if (nums[j] == target)
                    return j;
            }
            return -1;
        }

        for(;i<nums.length-1&&nums[i]<nums[i+1];i++){
            division++;
        }
        division++;
        System.out.println("div:"+division);




        for(;i<nums.length;i++){
            nums[i]=nums[i];
        }

        //TODO:先在nums中二分查找
        if(division<3){
            for(int j=0;j<division;j++){
                if(nums[j]==target){
                    return j;
                }

            }

        }
        int low=0;
        int high=division-1;
        int mid;
        while(low<=high){
            mid=low+((high-low)>>1);
            if(nums[mid]>target)
                high=mid-1;
            else if(nums[mid]<target)
                low=mid+1;
            else {
                if(mid==0||nums[mid-1]!=target)
                    return mid;
                else
                    high=mid-1;
            }
        }
        //TODO:再在nums中二分查找
        if(nums.length-division<4){
            for(int j=division;j<nums.length;++j){
                if(nums[j]==target)
                    return j;
            }
            return -1;
        }
        low=division;
        high=nums.length-1;
        while(low<=high){
            mid=low+((high-low)>>1);
            System.out.println(mid);
            if(nums[mid]>target)
                high=mid-1;
            else if(nums[mid]<target)
                low=mid+1;
            else {
                if(mid==division||nums[mid-1]!=target)
                    return mid;
                else
                    high=mid-1;
            }

        }
        return -1;
    }
    //优化0ms：
    //TODO: optimize the algo
    //思路就是在寻找division时也采用二分查找
    private static int search1(int[] nums, int target) {
        int division=-1;

        int i=0;
        int n=nums.length;
        //处理 0-3 长度数组
//
//        if(nums.length<4){
//            if(nums.length==0)
//                return -1;
//            for(int j=0;j<nums.length;++j) {
//                if (nums[j] == target)
//                    return j;
//            }
//            return -1;
//        }
        if(n==0)
            return -1;
        if(n==1)
            return nums[0]==target?0:-1;

        //改进点搜div点：线性-》二分
        division=find_div(nums,n-1);
        if(nums[division]==target)
            return division;
        if (division==0)
            return search1(0,n-1,target,nums);
        if(target<nums[0])
            return search1(division,n-1,target,nums);
       // if(target>nums[0])
            return search1(0,division-1,target,nums);





    }
    private static int search1(int low,int high,int target,int[] nums){
        int mid;
        while(low<=high){
            mid=low+((high-low)>>1);
            //System.out.println(mid);
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                high=mid-1;
            else
                low=mid+1;
//            else {
//                if(mid==low||nums[mid-1]!=target)
//                    return mid;
//                else
//                    high=mid-1;
//            }

        }
        return -1;
    }
    private static int find_div(int[]nums,int high){
        int mid;
        int low=0;
        if(nums[low]<nums[high])
            return 0;
        while(low<=high){
            mid=low+((high-low)>>1);
            if(nums[mid]>nums[mid+1])
                return mid+1;
            else {
                if(nums[mid]<nums[low])
                    high=mid-1;
                else
                    low=mid+1;
            }
        }
        return -1;

    }
    
}
