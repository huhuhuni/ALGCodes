public class 数组奇数在前 {
    public static void reset(int[] a){
        int n = a.length;
        int j = n-1;
        int i = 0;
        while (i < j){
            while (a[i] % 2 == 1){
                i++;
            }
            while (a[j] % 2 == 0){
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }
    public static void reset2(int a[]){
        int n = a.length;
        int i = 0;
        int k = 0;
        while (i < n) {
            while (a[i] % 2 == 0){
                i++;
            }
            int temp = a[i];
            int j = i;
            while (j > k) {a[j] = a[j-1]; j--;}
            a[j] = temp;
            k++;
            i++;
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        reset2(a);
        for (int num : a){
            System.out.println(num);
        }
    }
}
