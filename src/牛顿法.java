public class 牛顿法 {
    public  static double sqrt(int n, int m){
        double x = 1;
        double y = m;
        while (Math.abs(y) > 0.000000001) {
            x = x - (Math.pow(x,n)-m)/(n*Math.pow(x,n-1));
            y = Math.pow(x,n) - m;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2,4));
    }
}
