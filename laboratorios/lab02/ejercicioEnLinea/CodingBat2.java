
/**
 * Write a description of class CodingBat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CodingBat2
{

    /*
     * Array 2
     */

    public int countEvens(int[] nums) {

        int cont = 0;

        for(int i = 0; i<nums.length; i++){

            if(nums[i]%2==0)
                cont++;
        }

        return cont;
    }

    
    public int bigDiff(int[] nums) {
        int a = nums[0];
        int b = nums[0];

        for(int i = 0; i<nums.length; i++){

            a = Math.max(a, nums[i]);
            b = Math.min(b, nums[i]);

        }
        return a-b;
    }

    
    public int centeredAverage(int[] nums) {
        int a = nums.length-2;
        int b = nums[0];
        int c = nums[0];

        int d = 0;

        for(int i =0; i<nums.length; i++){

            b = Math.max(b, nums[i]);
            c = Math.min(c, nums[i]);

            d+=nums[i];
        }

        return (d-b-c)/a;
    }

    
    public boolean sum28(int[] nums) {
        int x =0;
        for(int i= 0; i < nums.length; i++){
            if(nums[i]==2){
                x+=2;
            }
        }

        return x == 8; 
    }

    
    public int matchUp(int[] nums1, int[] nums2) {
        int cont =0;
        for (int i =0; i <nums1.length ;i++)
            if (Math.abs(nums1[i] - nums2[i]) == 1 || Math.abs(nums1[i] -nums2[i]) == 2 )
                cont++;
        return cont;
    }


    /*
     * Array 3
     */

    public int maxSpan(int[] nums) {
        int m = 0;
        int s = 0;

        for(int i = 0; i<nums.length; i++){
            for(int j = nums.length-1; j>=0; j--){

                if(nums[i]==nums[j])
                    s = j-i+1;
                if (s>m) m =s;
            }
        }
        return m;
    }

    
    public int[] fix45(int[] nums) {
        int [] a = new int[nums.length];
        int b = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=4 && nums[i]!=5)
                b = nums[i];

            if(nums[i]==4)
                a[i]=4; 

            if(a[i]==4)
                a[i+1]=5;

        }
        for(int i = 0; i<a.length; i++){
            if(a[i]!=4 && a[i]!=5)
                a[i]=b;

        }
        return a;
    }

    
    public boolean linearIn(int[] outer, int[] inner) {
        int a = 0;
        for(int i =0; i<inner.length; i++){
            for(int j =0; j<outer.length; j++){

                if(i<inner.length){
                    if(inner[i]==outer[j]){

                        a++;
                        i++;
                    }
                }
            }
        }
        return a==inner.length;
    }

    
    public int[] seriesUp(int n) {
        int [] a = new int [n*(n + 1)/2];
        int b = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=i; j++){

                a[b++]=j;
            }
        }

        return a;      
    }

    
    public int[] squareUp(int n) {
        int [] a = new int [n*n];
        int b = 0;
        for(int i =1; i<=n; i++){
            for(int j = n; j>=1; j--){

                a[b++]=j;

                if(i<j)
                    a[b-1] = 0; 

            }
        }

        return a;  

    }
}
