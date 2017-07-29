package misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class TestClass {
   public static void main(String args[] ) throws Exception {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String line = br.readLine();
       int N = Integer.parseInt(line);
       for (int i = 0; i < N; i++) {
           int n = Integer.parseInt(br.readLine());
         
         if(n>2)
         {
         	long totalVol = n*n*n;
           long innerVol = (long) Math.pow((n-2), 3);
         	long totalUnitSides = 6*(n*n);
         	long nonInnerSafe = totalUnitSides -n;
         	
         	long safe = totalVol-(innerVol+nonInnerSafe);
         	System.out.println(safe);
         
         }else
         {
         	System.out.println(""+n);
         }
       }
       
    }
}