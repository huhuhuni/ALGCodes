public class DuplicateString {
    public static String isDuplicate(String s) {
        int n = s.length();
        if (n == 0) return null;
        for (int i = 1; i < n/2; i++){
            if (n % i != 0) continue;
            int j = 0;
            while(j < n) {
                if (!s.substring(0,i).equals(s.substring(j,j+i))) {
                    //System.out.println(s.substring(0,i)+ ":"+ s.substring(j,j+i));
                    break;
                }
                j = j + i;

            }
            if (j == n) return s.substring(0,i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(isDuplicate("ABCABCABCABC"));
    }
}
