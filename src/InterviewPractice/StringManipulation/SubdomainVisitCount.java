package InterviewPractice.StringManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {

    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> values = new HashMap<>();
        for(String string : cpdomains){

            String[] cpinfo = string.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.parseInt(cpinfo[0]);
            String cur = "";

            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i == frags.length - 1 ? "" : ".") + cur;
                values.put(cur, values.getOrDefault(cur, 0) + count);
            }

        }
        List<String> ans = new ArrayList<>();
        for (String dom: values.keySet()){
            ans.add("" + values.get(dom) + " " + dom);
        }
        return ans;

    }

    public static void main(String[] args) {
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(cpdomains));
    }
}
