package Bootcamp.StringManipulation;

public class RepeatedStringMatch {

    public static int repeatedStringMatch(String A, String B) {
        int i = 0;
        int j = 0;

        int result = 0;
        int k = 0;

        while (j < B.length()) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;

                if (i == A.length()) {
                    i = 0;
                    result++;
                }
            } else {
                k++;
                if (k == A.length()) {
                    return -1;
                }
                i = k;
                j = 0;
                result = 0;
            }
        }

        if (i > 0) {
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd","cdabcdab"));
    }
}

/*
 public int repeatedStringMatch(String A, String B) {

    int count = 0;
    StringBuilder sb = new StringBuilder();
    while (sb.length() < B.length()) {
        sb.append(A);
        count++;
    }
    if(sb.toString().contains(B)) return count;
    if(sb.append(A).toString().contains(B)) return ++count;
    return -1;
}
 */