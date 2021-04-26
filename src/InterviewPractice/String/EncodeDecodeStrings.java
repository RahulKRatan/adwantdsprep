package InterviewPractice.String;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            i = slash + size + 1;
            result.add(s.substring(slash + 1, i));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> values = new ArrayList<>();
        values.add("goutam");
        values.add("adwant");
        values.add("java");
        System.out.println(encode(values));
        List<String> result = decode(encode(values));
        result.forEach(s->System.out.println(s));
    }


}
