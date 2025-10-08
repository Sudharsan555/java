public class Missingno {
    public static  int missingnumber(int[]nums){
        int n=nums.length;
        int actualtotal=n*(n+1)/2;
        int sum=0;
        for(int val : nums){
            sum+=val;
        }
        return actualtotal-sum;
    }
    public static void main(String args[]){
        int[]nums={3,0,1};
        int number= missingnumber(nums);
        System.out.println(number);
        int[]nums1={9,6,4,2,3,5,7,0,1};
        int num= missingnumber(nums1);
        System.out.println(num);
    }    
}
