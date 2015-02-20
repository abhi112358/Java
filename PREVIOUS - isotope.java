import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.*;


public class isotope {
  public static void main(String[] args){
  
  
  
	//long l = 999999999999999;
	//System.out.println(l);
  
  //double d = 9.23971;
   //d= BigDecimal.valueOf(d).setScale(2, RoundingMode.HALF_UP).doubleValue();
	//System.out.println("d="+d);
  
 Scanner in = new Scanner(System.in);
 String strn = in.nextLine().trim();
 for(int j = 0;j<strn.length();j++)
{

if(strn.charAt(j)=='+'||strn.charAt(j)=='-'){System.out.println("INVALID INPUT");System.exit(0);}
}
 int n=0;
 try{
	n= Integer.parseInt(strn);
	
	}catch(Exception e){{System.out.println("INVALID INPUT");System.exit(0);}}
	
	
		if(1>=n){System.out.println("INVALID INPUT");System.exit(0);}
	if(n>=1000){System.out.println("INVALID INPUT");System.exit(0);}
	
String str = null;
while(1==1){str = in.nextLine().trim();
if(str.length()!=0)break;}


String[] s = str.split("\\s+");

for(int i = 0;i<s.length;i++)
{
for(int j = 0;j<s[i].length();j++)
{

if(s[i].charAt(j)=='+'||s[i].charAt(j)=='-'){System.out.println("INVALID INPUT");System.exit(0);}
}

}

 if(s.length!=n){System.out.println("INVALID INPUT");System.exit(0);}
 
 int[] array = new int[n];
 
 for(int i=0;i<n;i++){
	try{
	array[i]= Integer.parseInt(s[i]);
	
	}catch(Exception e){{System.out.println("INVALID INPUT");System.exit(0);}}
	}
	
	
	
	//cache barriers
	

	
	for(int i=0;i<n;i++){
	
	if(0>=array[i]){System.out.println("INVALID INPUT");System.exit(0);}
	if(array[i]>=199){System.out.println("INVALID INPUT");System.exit(0);}
	
	}
	
	
	BigInteger[][] power = new BigInteger[n][n];
	BigInteger[][] key = new BigInteger[n][n];
	
	for(int d=0;d<n;d++){
						    for(int i=0;i<n-d;i++){
												int j=d+i;
	
	if(i==j){power[i][j]= new BigInteger("0");BigInteger bii=new BigInteger(String.valueOf(array[i]));key[i][j]=bii;}
	else{
	
													BigInteger maxpower= new BigInteger("-1");
													for(int k = i;k<j;k++)
													{
													BigInteger temppower = new BigInteger("0");
													temppower=temppower.add(power[i][k]);
													temppower=temppower.add(power[k+1][j]);
													BigInteger prod = new BigInteger("0");
													prod = key[i][k].multiply(key[k+1][j]);
													temppower=temppower.add(prod);
													//	System.out.println("sdfasd"+temppower);
													int res = temppower.compareTo(maxpower);
													if(res==1)maxpower=temppower;
													
													}
													
													BigInteger onn = new BigInteger("199");
													key[i][j]=maxpower.mod(onn);
													//System.out.println("just executed");
													power[i][j]=maxpower;
	
	
	}
	
	}
	
	}
	
	
	//System.out.println(Arrays.deepToString(key));
	System.out.println(power[0][n-1]);
	

  }

}

 