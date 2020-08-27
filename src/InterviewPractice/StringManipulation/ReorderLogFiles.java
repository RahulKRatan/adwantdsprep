package InterviewPractice.StringManipulation;

import java.util.ArrayList;
import java.util.List;

public class ReorderLogFiles {

    public static String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return logs;
        int len = logs.length;
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();
        for (String log : logs) {
            if (log.split(" ")[1].charAt(0) < 'a') {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        letterList.sort((o1, o2) -> {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            String id1 = s1[0];
            String id2 = s2[0];
            int len1 = s1.length;
            int len2 = s2.length;

            for (int i = 1; i < Math.min(len1, len2); i++) {
                if (!s1[i].equals(s2[i])) { // if strings are not equal.. return compareto
                    return s1[i].compareTo(s2[i]);
                } else if (i == Math.min(len1, len2) - 1 && s1[i].equals(s2[i])) {  // If everything is same.. compare key values.
                    return id1.compareTo(id2);
                }
            }
            return 0;
        });

        for (int i = 0; i < len; i++) {
            if (i < letterList.size())
                logs[i] = letterList.get(i);
            else logs[i] = digitList.get(i - letterList.size());
        }
        return logs;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        System.out.println(reorderLogFiles(strings));
    }
}
