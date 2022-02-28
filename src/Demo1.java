public class Demo1 {
    public static void main(String[] args) {
        int[] arr = new int[]{6,3,2,1,5,8,9};
        System.out.println(slove(arr,3));
    }
    static double slove(int[] arr,int k) {
        int left = k-1;
        int right = k;
        int n = arr.length;
        int pre = 0;
        for(int i = 0; i < n/2+1 && left >= 0 && right < n; i++){
            if (arr[left] > arr[right] && right < n){
                pre = right;
                right++;}
            else if (left >= 0){
                pre = left;
                left--;
            }
        }
        if (n %  2 == 1) return (double)arr[pre];
        else {

            int a = arr[pre];
            int b = 0;
            System.out.println(arr[pre]);
            if (pre >= k) {
                System.out.println(arr[pre-1]+""+arr[left+1]);
                b = Math.max(arr[pre-1],arr[left+1]);
            } else {
                b = Math.max(arr[right-1],arr[pre+1]);
            }
            System.out.println(a + "" +b);
            return (double) (a+b)/2;
        }
    }
}
