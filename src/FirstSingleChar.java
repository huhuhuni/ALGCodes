import java.util.HashMap;

public class FirstSingleChar {
    public int FirstNotRepeatingChar_m1(String str) {
        HashMap<Character,Integer> charCount=new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            charCount.put(str.charAt(i),charCount.get(str.charAt(i))==null?1:(charCount.get(str.charAt(i))+1));
        }

        for (int i = 0; i < str.length(); i++) {
            if (charCount.get(str.charAt(i))==1){
                return i;
            }
        }

        return -1;
    }
}
