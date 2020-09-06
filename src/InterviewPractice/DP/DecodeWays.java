package InterviewPractice.DP;

/**
 * I used a dp array of size n + 1 to save subproblem solutions. dp[0] means an empty string will have one way to decode,
 * dp[1] means the way to decode a string of size 1. I then check one digit and two digit combination and save the results along the way. In the end, dp[n] will be the end result.
 *
 * Time: should be O(n), where n is the length of String
 * Space: should be O(n), where n is the length of String
 *
 * Similar questions:
 * 62. Unique Paths
 * 70. Climbing Stairs
 * 509. Fibonacci Number
 *
 * Practice them in a row for better understanding
 */

public class DecodeWays {

    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
/*
public class EncodeDecode {


	public static int decode(String message)
	{

		int msgLen = message.length();
		if(msgLen == 0 || msgLen == 1)
			return 1;

		int count = 0;

		if(message.charAt(msgLen - 1) > '0')//last digit
			count = decode(message.substring(0, msgLen - 1));//trimmed message by decreasing length by 1


		if((message.charAt(msgLen - 2) < '2') || ( message.charAt(msgLen - 2) == '2' &&  message.charAt(msgLen - 1) < '7' ) )
			count += decode(message.substring(0, msgLen - 2));

		return count;
	}


	public static int decodeDp(String message)
	{
		int msgLen = message.length();
		int[] decodeCount = new int[msgLen + 1];

		decodeCount[0] =1;
		decodeCount[1] =1;


		for(int i=2; i< msgLen + 1; i++)
		{
			if(message.charAt(i - 1 ) > '0')
				decodeCount[i] = decodeCount[i-1];

			if((message.charAt(i - 2) < '2') || ( message.charAt(i - 2) == '2' &&  message.charAt(i - 1) < '7' ) )
				decodeCount[i] = decodeCount[i] + decodeCount[i-2];
		}

		return decodeCount[msgLen];
	}


	public static int countBinary(int N)
	{
		int C0 = 1;
		int C1 = 1;

		for(int i=1; i<N; i++)
		{
			int temp = C1;
			C1 = C0;
			C0 = C0 + temp;
		}

		return C0 + C1;
	}

	public  static int cutRod(int cost[])
	{
	   int n = cost.length;
	   int dp[] = new int[cost.length +1];
	   dp[0] = 0;
	   int i, j;

	   for (i = 1; i<=n; i++)
	   {
		   int max_val = Integer.MIN_VALUE;
	       for (j = 0; j < i; j++)
	       {
	         max_val = Math.max(max_val, cost[j] + dp[i-j-1]);
	       }
	       dp[i] = max_val;
	   }

	   return dp[n];
	}

	public static void main(String args[])
	{
	    int rodcosts[] = {1, 5, 8, 9, 10, 17, 17, 20};
	    System.out.println(cutRod(rodcosts));
	}




}
 */