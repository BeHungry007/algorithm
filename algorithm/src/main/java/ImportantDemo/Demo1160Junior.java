package ImportantDemo;

import org.junit.Test;

public class Demo1160Junior {


    @Test
    public void test1() {
        String[] words = {"cat","bt","hat","tree"}  ;
        String chars = "attch";
        int i = coutCharacters(words, chars);
        System.out.println(i);
    }

    public int coutCharacters(String[] words, String chars) {
        int[] counts = count(chars);
        int a = 0;
        for (int i = 0; i < words.length; i++) {
            int[] word = count(words[i]);
            if (counts(counts, word)) {
                a += words[i].length();
            }
        }
        return a;
    }

    public boolean counts(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] < arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] count(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        return arr;
    }
}
