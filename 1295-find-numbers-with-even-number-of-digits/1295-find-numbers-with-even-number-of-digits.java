class Solution {
    public int findNumbers(int[] nums) {

        int count = 0;

        for(int i = 0; i < nums.length; i++){

            int a = nums[i];
            int b = 0;

            while(a > 0){
                b++;
                a = a / 10;
            }

            if(b % 2 == 0){
                count++;
            }
        }

        return count;
    }
}