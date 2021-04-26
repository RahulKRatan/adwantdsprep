package InterviewPractice.String;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<rowIndex+1;i++) {
            res.add(1);
            for(int j=i-1;j>0;j--) {
                res.set(j, res.get(j-1)+res.get(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        getRow(3);
    }
}

/*
public List<Integer> getRow(int rowIndex) {
    List<Integer> ret = new LinkedList<Integer>();
    for (int row = 0; row <= rowIndex; row++) {
        ret.add(0, 1);
        for (int i = 1; i < row; i++)
            ret.set(i, ret.get(i) + ret.get(i + 1));
    }
    return ret;
}
 */
