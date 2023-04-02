package CodeChef.Starters.Starters45;
//
//import java.io.*;
//import java.util.Arrays;
///**
// * GnTheory
// * Problem Statement: For each query, find the minimum possible cost to reach v from u
// * URL: https://www.codechef.com/submit/GN_THEORY
// * 	Example:
// * 
// * 		Test Case 1: 
// * 			Input Array: [[6,2], [3,6], [2,3]]
// * 			Output: [2, 5]
// */
//
///**
// * Time Complexity: O(log(U))+O(log(V)) for each test case and O(N*log(log(N))) for precomputation.
// * Space Complexity: O(1)
// */
//
//public class GnTheory {
//	static int testCaseSize, data[][], vertices[][][];
//
//    public static void main(String[] args) throws IOException  {
//        // Taking array Input from user
//        takeTestCaseInput();
//        for(int i=0; i<testCaseSize; ++i) 
//        	runTestCase(i);
//    }
//
//    private static void takeTestCaseInput() throws IOException  {
//        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//        final BufferedReader read = new BufferedReader(inputStreamReader);
//        // Taking a valid test Case Size - input
//        do{
//            try{
//            	// System.out.print("Enter no. Of test Cases: ");
//                testCaseSize = Integer.parseInt(read.readLine());
//            } catch (Exception err) {
//                System.out.println("Error: " + err);
//            }
//        } while(testCaseSize<=0);
//        data = new int[testCaseSize][2]; // no.of vertices and queries
//        vertices = new int[testCaseSize][][];
//        // Take input for all test cases
//        for(int i=0; i<testCaseSize; ++i) {
//            String[] arrInput = read.readLine().split("\\s");
//            // Initializing array with the user array input
//            data[i][0] = Integer.parseInt(arrInput[0]); // N of ith testcase
//            data[i][1] = Integer.parseInt(arrInput[1]); // Q of ith testcase
//            vertices[i] = new int[data[i][1]][2];
//            for(int j=0; j<data[i][1]; ++j) {
//                arrInput = read.readLine().split("\\s");
//            	vertices[i][j][0] = Integer.parseInt(arrInput[0]); // u of jth query of ith testcase
//            	vertices[i][j][1] = Integer.parseInt(arrInput[1]); // v of jth query of ith testcase
//        	}
//        }
//    }
//
//    public static void runTestCase(int testCase) throws IOException  {
//        // Get
//    	int n = data[testCase][0];
//    	int q = data[testCase][1];
//    	for(int i=0; i<q; ++i) {
//    		int u = vertices[testCase][i][0];
//    		int v = vertices[testCase][i][1];
//    		int gcd = getGCD(u, v);
//    		u /= gcd;
//    		v /= gcd;
//    		int ans = 0;
//    		for(int j=0; j<2; ++j) {
//    			int x = j==0 ? u : v;
//    			for(int k=2; k*k <= x; ++k) {
//    				while(x%k == 0) {
//    					ans+=1;
//    					x /= k;
//    				}
//    			}
//    			if(x>1)
//    				ans+=x;
//    		}
//            // Printing result
//            System.out.println(ans);
//    	}
//    }
//    
//    public static int getGCD(int a, int b)   
//    {   
//	    if (b == 0)   
//	    	return a;     
//	    return getGCD(b, a % b);   
//    } 
//
//}

import java.io.*;
import java.util.*;

public class GnTheory
{
    static PrintWriter out=new PrintWriter((System.out));
    public static void main(String args[])throws IOException
    {
        Reader sc = new Reader();
        int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(), q=sc.nextInt();
            while(q-- >0){
                int u=sc.nextInt(), v=sc.nextInt();
                int gcd=GCD(u, v);
                u=u/gcd;
                v=v/gcd;
                out.println(factorsSum(u) + factorsSum(v));   
            }
      }
          
    	out.close();
    	
    }
    
    static int factorsSum(int n){
        int sum=0;
        for(int i=2;i*i<=n;i++){
            while(n%i == 0){
                sum+=i;
                n/=i;
            }
        }
        if(n > 1) sum+=n;
        // System.out.println(n+" "+sum);
        return sum;
    }
    
    static int GCD(int a, int b){
        if(b==0) return a;
        return GCD(b, a%b);
    }
    
    
    public static long pow(long a,long b){
        if(b==0){
            return 1;
        }
        if(b%2==0){
            return pow(a*a,b/2);
        }else{
            return a*pow(a*a,b/2);
        }
    }
    
    static class Reader  { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        
        public String next() {
            while(!st.hasMoreTokens()) {
                try {
                    st=new StringTokenizer(br.readLine());
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        public String nextLine() {
            try {
                return br.readLine();
            }
            catch(Exception e)  {
                e.printStackTrace();
            }
            return null;
        }
        
        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public long nextLong() {
            return Long.parseLong(next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        
        public boolean hasNext() {
            String next=null;
            try {
                next=br.readLine();
            }
            catch(Exception e) {}
            if(next==null)
                return false;
            st=new StringTokenizer(next);
            return true;
        }
    } 
}
