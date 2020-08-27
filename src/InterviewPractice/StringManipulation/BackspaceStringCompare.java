package InterviewPractice.StringManipulation;

/**
 *
 * The intuition and quick methode is to find the final text result.
 * You can just use a string if you don't care cost on string modification.
 * Or you can use a stack or string builder to do it in O(N).
 *
 * Use stack to avoid string modification.
 * Time O(N) and space O(N).
 *
 Can you do it in O(N) time and O(1) space?
 I believe you have one difficulty here:
 When we meet a char, we are not sure if it will be still there or be deleted.

 However, we can do a back string compare (just like the title of problem).
 If we do it backward, we meet a char and we can be sure this char won't be deleted.
 If we meet a '#', it tell us we need to skip next lowercase char.

 The idea is that, read next letter from end to start.
 If we meet #, we increase the number we need to step back, until back = 0
 */
public class BackspaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {
        int i=S.length()-1, j=T.length()-1, back;
        while(true){
            back = 0;
            while(i>=0 && (back > 0 || S.charAt(i) == '#')){
                back+= S.charAt(i) == '#'? 1 : -1;
                i--;
            }
            while(j>=0 && (back > 0 || T.charAt(j) == '#')){
                back+= T.charAt(j) == '#'? 1 : -1;
                j--;
            }
            if(i>=0 && j>=0 && S.charAt(i) == T.charAt(j)){
                i--;
                j--;
            }
            else{
                break;
            }
        }
        return i==-1 && j==-1;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c","ad#c"));
    }
}

/*
 public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
 */
