package InterviewPractice.String;

// the logic by making the two version number same length.
// For example, if version1 = "1.0.2", and version2 = "1.0", the I will convert the version2 to "1.0.0".
public class CompareVersion {
    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        for(int i=0;i<Math.max(s1.length,s2.length);i++){
            int num1 = i<s1.length? Integer.parseInt(s1[i]) : 0;
            int num2 = i<s2.length? Integer.parseInt(s2[i]) : 0;
            if(num1 < num2){
                return -1;
            }
            else if(num1 > num2){
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String version1 = "0.1";
        String version2 = "1.1";
        System.out.println(compareVersion(version1,version2));
    }

}
