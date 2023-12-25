public class decodeWays {
    public static int numDecodings(String s) {
        int i=0;
        int dp[] = new int[s.length()+1];   // I've to store value from 0 to n
        return helper(i,s, dp);
    }
    public static int helper(int i,String s, int dp[]){
        // base case
        if(i>= s.length()){
            return 1;
        }
        // work
        // dp step
        if(dp[i] != 0){
            return dp[i];
        }
        // before calling I've to extract the integer value from string
        int f = s.charAt(i) - '0';
        int firstCall=0, secondCall =0;
        if(f>0){    // atleast 1 place I need from string to call the firstcall
             firstCall = helper(i+1, s, dp);
        }
        
        if(i< s.length()-1){  // atleast 2 place I need from string to call the secondcall
            int l = f*10 + s.charAt(i+1) - '0';     // calculating the value of 2nd position like : if f =1, l=1*10+0 => 10 ; taking 0 as the value of 2nd position
            if(f > 0 && l>0 && l <=26){         // as we can't allow the leading zero, that's why we have to check this condition
                 secondCall = helper(i+ 2, s, dp);
            }
        }
        dp[i] = firstCall + secondCall;     // total way
        return dp[i];
    }
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }
}
