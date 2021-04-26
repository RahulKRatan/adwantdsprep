package InterviewPractice.String;

import java.util.HashSet;

public class UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
        HashSet<String> hashSet = new HashSet<>();
        for(int i=0;i<emails.length;i++){
            hashSet.add(stringCleanup(emails[i]));
        }
        return hashSet.size();
    }

    public static String stringCleanup(String string){
        String[] temp = string.split("@");
        String[] temp1 = temp[0].replaceAll("\\.","").split("\\+");
        String s = temp1[0]+"@"+temp[1];
        return s;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(strings));
    }
}
