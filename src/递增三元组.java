public class 递增三元组 {
    //给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
    //
    //如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int num : nums){
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
