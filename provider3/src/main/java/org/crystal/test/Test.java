package org.crystal.test;

public class Test {


        public int sequenceSearch( int[] nums, int target) {
            int size = nums.length;
            for(int i=0;i<size;i++){
                if(nums[i]==target){
                    return i;
                }
            }
         return -1;
        }

    public static void main(String[] args) {
   /*     int a = 5;
        int b = 7;
        System.out.println((a++)+(++b));

        int x = 1,y=2,z=3;
        System.out.println(y+=z--/++x);*/

        int nums[]= {1,3,5,6};
        int target =5;
        Test t = new Test();
        System.out.println(t.sequenceSearch(nums,target));
    }

}
