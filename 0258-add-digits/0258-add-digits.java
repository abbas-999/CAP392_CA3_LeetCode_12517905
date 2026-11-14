class Solution {
    public int addDigits(int num) {

        while(String.valueOf(num).length() > 1){

            int sum = 0;

            while(num > 0){

                int temp = num % 10;
                num = num / 10;
                sum += temp;

            }

            num = sum;
        }

        return num;
    }
}