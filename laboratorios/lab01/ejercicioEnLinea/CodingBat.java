public class CodingBat
{

    /**
     * Recursion 1
     */

    public int bunnyEars(int bunnies) {

        if(bunnies == 0)

            return 0;  

        else

            return 2 + bunnyEars(bunnies-1); 
    }

    public int fibonacci(int n) {
        if (n <= 1) 

            return n;

        return fibonacci(n - 2) + fibonacci(n - 1);

    }

    public int triangle(int rows) {
        if (rows == 0) {
            return 0;
        }

        return rows + triangle(rows - 1);
    }

    public int sumDigits(int n) {
        if (n == 0) {

            return 0;   
        }

        return n % 10 + sumDigits(n / 10); 
    }

    public int powerN(int base, int n) {
        if(n == 1){
            return base;
        }

        return base*powerN(base, n - 1);
    }

    /**
     * Recursion 2
     */

    public boolean groupSum6(int start, int[] nums, int target) {
        if(start >= nums.length){
            return (target==0);
        }

        if(nums[start]==6){
            return (groupSum6(start+1, nums, target - nums[start]));
        }

        return groupSum6(start+1, nums, target - nums[start]) || groupSum6(start+1, nums, target);
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start >= nums.length){
            return (target==0);
        }

        return (groupNoAdj(start+2, nums, target - nums[start])) || (groupNoAdj(start+1, nums, target));

    }

    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length)
            return target == 0;

        if (nums[start] % 5 == 0) {

            if (start < nums.length - 1 && nums[start + 1] == 1)
                return groupSum5(start + 2, nums, target - nums[start]);

            return groupSum5(start + 1, nums, target - nums[start]) ;

        }
        return groupSum5(start + 1, nums, target - nums[start]) || groupSum5(start + 1, nums, target);
    }

    public boolean groupSumClump(int start, int[] nums, int target) {
        if(start >= nums.length){
            return (target==0);
        }

        if(start < nums.length-1 && nums[start]==nums[start+1]){

            return groupSumClump(start+2, nums, target - nums[start]-nums[start+1]) || groupSumClump(start+2, nums, target);
        }

        return groupSumClump(start+1, nums, target - nums[start]) || groupSumClump(start+1, nums, target);
    }

    
    public boolean splitArray(int[] nums) {
        return  split(0, nums, 0, 0);
    }
    public boolean split(int n, int [] nums, int n1, int n2){
        if(n==nums.length)
            return n1 == n2;

        return split(n+1, nums, n1-nums[n], n2) || split(n+1, nums, n1, n2-nums[n]);
    }

}
