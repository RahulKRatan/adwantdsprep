package InterviewPractice.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Time Complexity: O(N), where N is the length of cpdomains, and assuming the length of cpdomains[i] is fixed.
 *
 * Space Complexity: O(N), the space used in our count.
 */
public class SubdomainVisitCount {

    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> values = new HashMap<>();

        for(String string : cpdomains){
            String[] cpinfo = string.split(",");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.parseInt(cpinfo[0]);
            String cur = "";

            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i == frags.length - 1 ? "" : ".") + cur;
                values.put(cur, values.getOrDefault(cur, 0) + count);
            }

        }
        List<String> result = new ArrayList<>();
        for (String dom: values.keySet()){
            result.add("" + values.get(dom) + " " + dom);
        }
        return result;

    }

    public static void main(String[] args) {
        String[] cpdomains = new String[]{"900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"};
        System.out.println(subdomainVisits(cpdomains));
    }
}
