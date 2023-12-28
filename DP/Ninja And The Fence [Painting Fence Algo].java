import java.util.* ;
import java.io.*; 
//Recursion
//TC O(2^N)
//SC Recursion stack


public class Solution {
	static int MOD=1000000007;
	public static int numberOfWays(int n, int k) {
		// Write your code here.
		return Recurv(n,k);
	}

	public static int Recurv(int n,int k){
		if(n==0) return 0;
		if(n==1) return k;
		if(n==2) return add(k,Mul(k,k-1));

		//return Recurv(n-1,k)*(k-1)+Recurv(n-2,k)*(k-1);
		return add(Mul(Recurv(n-1,k),(k-1)),Mul(Recurv(n-2,k),(k-1)));
	}

	public static int add(int a,int b){
		a=a%MOD;
		b=b%MOD;
		return (a+b)%MOD;
	}

	public static int Mul(int a,int b){
		a=a%MOD;
		b=b%MOD;
		return (a*b)%MOD;
	}
}



//Memoization
//TC O(N)
//SC O(N)+ Recursion stack.
public class Solution {
    static int MOD = 1000000007;

    public static int numberOfWays(int n, int k) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Recurv(n, k, dp);
    }

    public static int Recurv(int n, int k, int[] dp) {
        if (n == 0) return 0;
        if (n == 1) return k;
        if (n == 2) return add(k, Mul(k, k - 1));

        if (dp[n] != -1) return dp[n];

        return dp[n] = add(Mul(Recurv(n - 1, k, dp), k - 1), Mul(Recurv(n - 2, k, dp), k - 1));
        
    }

    public static int add(int a, int b) {
        a = a % MOD;
        b = b % MOD;
        return (a + b) % MOD;
    }

    public static int Mul(int a, int b) {
        a = a % MOD;
        b = b % MOD;
        long res = (long) a * b;
        return (int) (res % MOD);
    }
}


//Tabulation
//TC O(N)
//SC O(N)
public class Solution {
    static int MOD = 1000000007;

    public static int numberOfWays(int n, int k) {
		
        int[] dp = new int[n + 2];
        dp[0]=0;
		dp[1]=k;
		dp[2]=add(k, Mul(k, k - 1));
		

		for(int i=3;i<=n;i++){
			dp[i]=add(Mul(dp[i-2],k-1),Mul(dp[i-1],k-1));
		}
		return dp[n];
    }


    public static int add(int a, int b) {
        a = a % MOD;
        b = b % MOD;
        return (a + b) % MOD;
    }

    public static int Mul(int a, int b) {
        a = a % MOD;
        b = b % MOD;
        long res = (long) a * b;
        return (int) (res % MOD);
    }
}


//space optimization.
//TC O(N)
//SC O(1)
public class Solution {
    static int MOD = 1000000007;

    public static int numberOfWays(int n, int k) {

        int prev2=k;
		int prev1=add(k, Mul(k, k - 1));
		if(n==1) return prev2;
		if(n==2) return prev1;

		for(int i=3;i<=n;i++){
			int ans=add(Mul(prev2,k-1),Mul(prev1,k-1));
			prev2=prev1;
			prev1=ans;
		}
		return prev1;
    }


    public static int add(int a, int b) {
        a = a % MOD;
        b = b % MOD;
        return (a + b) % MOD;
    }

    public static int Mul(int a, int b) {
        a = a % MOD;
        b = b % MOD;
        long res = (long) a * b;
        return (int) (res % MOD);
    }
}


