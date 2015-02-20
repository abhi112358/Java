import java.io.*;
import java.util.*;
import java.lang.*;

public class det {
  public static void main(String[] args) throws Exception {
  
 Scanner in = new Scanner(System.in);
 String path = in.nextLine();
 
  
    BufferedReader br = new BufferedReader(new FileReader(path));
    

	ArrayList<Integer> al =new ArrayList<Integer>();
	ArrayList<String[]> stringo = new ArrayList<String[]>();
	
	String line =null;
	
	while((line=br.readLine())!=null){
	
	
	String[] s = line.trim().split("\\s++");
	al.add(s.length);
	for(int i=0;i<s.length;i++)if(s[i].matches("[0-9]+")==true||s[i].matches("-[0-9]+")==true||s[i].matches("[0-9]+.[0-9]+")==true||s[i].matches("-[0-9]+.[0-9]+")==true);else{System.out.println("Invalid input.");System.exit(0);}
	stringo.add(s);
	
	}
	//line.replaceAll("\\s+","");
	
	//for (String[] p : stringo){
   // System.out.println(Arrays.deepToString(p));
	//System.out.println();
	//}
	
	int flag = 0;
	int prev = al.get(0);
	for(int i=1;i<al.size();i++)if(al.get(i)!=prev){System.out.println("Invalid input.");System.exit(0);}
	
	if (prev!=al.size()){System.out.println("Matrix Determinant can be calculated only for a square matrix");System.exit(0);}
	
	int n = prev;
	double[][] matrix = new double[n][n];
	
	for(int i=0;i<n;i++)
	{
	String[] soo = stringo.get(i);
	for(int j=0;j<n;j++)
	{
	String soup = soo[j];
	matrix[i][j]=Double.parseDouble(soup);
	}
	}
	
	//System.out.println(Arrays.deepToString(matrix));
	
	double ans = det(n,matrix);
	System.out.printf("%.3f\n",ans);
	
  }
  
  
  
  static double det(int n,double x[][])
{    
     if(n==1) {return(x[0][0]);}
 
     else{
     
     
     int c=0;
     double sum=0;
     while(c<n)
    { 
      double[][] xarray = new double[n-1][n-1];
      matrix(c,n,x,xarray);
      sum=sum-((Math.pow(-1,c-1))*(x[0][c])*(det(n-1,xarray)));
     c++;
     }
    return(sum);}
}

static void matrix(int c,int n ,double v[][],double b[][])
{
       int i=0, j=0;
       for(i=0;i<n-1;i++)
       for(j=0;j<n-1;j++)
       {if(j<c)b[i][j]=v[i+1][j];
        else b[i][j]=v[i+1][j+1];
        }
}
  
  
}

 