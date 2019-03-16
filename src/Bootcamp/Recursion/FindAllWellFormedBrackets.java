package Bootcamp.Recursion;

import java.util.ArrayList;

public class FindAllWellFormedBrackets {
    static String[] find_all_well_formed_brackets(int n) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Brackets("", 0, 0, i,arrayList,n);
        }
        return arrayList.toArray(new String[0]);
    }

    private static void Brackets(String output, int open, int close, int pairs,ArrayList<String> arrayList, int n) {
        if((open==pairs)&&(close==pairs)&&output.length()==n*2) {
            arrayList.add(output);
        } else {
            if(open<pairs)
                Brackets(output + "(", open+1, close, pairs,arrayList,n);
            if(close<open)
                Brackets(output + ")", open, close+1, pairs,arrayList,n);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(find_all_well_formed_brackets(n));
    }
}
