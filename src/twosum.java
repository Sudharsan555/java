import java.util.HashMap;
class twosum{
        public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> sum=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int repo=target-nums[i];
            if(sum.containsKey(repo)){
                return new int[] { sum.get(repo),i};
            }
            sum.put(nums[i],i);
        }
        return new int[]{};
    }
    public static void main(String args[]) {
        int[] nums={2,7,11,15};
        int target=9;
        int[] result=twoSum(nums,target);
        for(int i:result){
            System.out.print(i+" ");
    }
    }
}   