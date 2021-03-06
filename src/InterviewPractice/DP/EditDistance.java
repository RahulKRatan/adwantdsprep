package InterviewPractice.DP;

//Levenshtein distance

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        return editDistance(word1,word2,word1.length(),word2.length());
    }

    static int min(int x,int y,int z)
    {
        if (x<=y && x<=z) return x;
        if (y<=x && y<=z) return y;
        else return z;
    }

    public static int editDistance(String s1, String s2, int i, int j){
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if(i==0){
            return j;
        }
        // If second string is empty, the only option is to
        // remove all characters of first string
        if(j==0){
            return i;
        }
        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return editDistance(s1,s2,i-1,j-1);
        }
        //If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        // i,j-i = addition ; i-1,j = deletion ; i-1,j-1 replacement ( cost = 2 if x!=y , cost = 0 if x = y )
        return 1 + min(editDistance(s1,s2,i-1,j),editDistance(s1,s2,i,j-1),editDistance(s1,s2,i-1,j-1));
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(minDistance(s1,s2));
    }
}


/*
// A Dynamic Programming based Java program to find minimum
// number operations to convert str1 to str2
class EDIST
{
	static int min(int x,int y,int z)
	{
		if (x <= y && x <= z) return x;
		if (y <= x && y <= z) return y;
		else return z;
	}

	static int editDistDP(String str1, String str2, int m, int n)
	{
		// Create a table to store results of subproblems
		int dp[][] = new int[m+1][n+1];

		// Fill d[][] in bottom up manner
		for (int i=0; i<=m; i++)
		{
			for (int j=0; j<=n; j++)
			{
				// If first string is empty, only option is to
				// insert all characters of second string
				if (i==0)
					dp[i][j] = j; // Min. operations = j

				// If second string is empty, only option is to
				// remove all characters of second string
				else if (j==0)
					dp[i][j] = i; // Min. operations = i

				// If last characters are same, ignore last char
				// and recur for remaining string
				else if (str1.charAt(i-1) == str2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];

				// If the last character is different, consider all
				// possibilities and find the minimum
				else
					dp[i][j] = 1 + min(dp[i][j-1], // Insert
									dp[i-1][j], // Remove
									dp[i-1][j-1]); // Replace
			}
		}

		return dp[m][n];
	}



	public static void main(String args[])
	{
		String str1 = "sunday";
		String str2 = "saturday";
		System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length()) );
	}
}/*This code is contributed by Rajat Mishra*/
