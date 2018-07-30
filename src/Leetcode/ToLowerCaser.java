package Leetcode;

public class ToLowerCaser {

    static String isLower(String str) {
        char[] a = str.toCharArray(), r = new char[a.length];
        for (int i = 0; i < a.length; i++)
            r[i] = a[i] >= 'A' && a[i] <= 'Z' ? (char) (a[i] - 'A' + 'a') : a[i];
        return new String(r);
    }

    public static void main(String args[]) {
        String str = "Hello";
        System.out.println(isLower(str));
    }

}
