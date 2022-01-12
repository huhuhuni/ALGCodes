public class 只出现一次的数 {
    int singleNumber(int[] arr){
        int ans = 0;
        for (int i = 31; i>=0; i--){
            int count = 0;
            for (int num: arr){
                count += (num>>i) & 1;
            }
            if (count % 3 != 0) {
                ans |= 1 >> i;
            }
        }
        return ans;
    }
}
