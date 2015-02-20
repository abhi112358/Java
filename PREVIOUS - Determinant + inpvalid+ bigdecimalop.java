import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class determinant {
  public static void main(String[] args) throws Exception {
  
 Scanner in = new Scanner(System.in);
 String path = in.nextLine();
 //path = "thefile.txt";
  
    BufferedReader br = new BufferedReader(new FileReader(path));
    

	ArrayList<Integer> al =new ArrayList<Integer>(); //maintains the number of inputs in each line... in the end we will use this to validate wheter matrix is square or not 
	ArrayList<String[]> stringo = new ArrayList<String[]>();//maintains string array corresponding to each line of input
	
	String line =null;
	while((line=br.readLine())!=null){
	
	
	String[] s = line.trim().split("\\s+");
	al.add(s.length);
	
	
	
	stringo.add(s);
	
	}
	//line.replaceAll("\\s+","");
	/*
	for (String[] p : stringo){
    System.out.println(Arrays.deepToString(p));
	System.out.println();
	}
	*/
	
	//below three lines check if al.size == each element of array// if this is so, then matrix is square
	int flag = 0;
	int prev = al.get(0);
	for(int i=1;i<al.size();i++)if(al.get(i)!=prev){System.out.println("Invalid Input.");System.exit(0);}
	if (prev!=al.size()){System.out.println("Matrix Determinant can be calculated only for a square matrix");System.exit(0);}
	
	int n = prev;//size of matrix is any one element of al
	
	double[][] matrix = new double[n][n];
	for(int i=0;i<n;i++)
	{
	String[] soo = stringo.get(i);
	for(int j=0;j<n;j++)
	{
	
	
	
	
	

	String soup = soo[j];
	
	if(soup.charAt(soup.length()-1)=='f'
	||soup.charAt(soup.length()-1)=='d'
	||soup.charAt(soup.length()-1)=='F'
	||soup.charAt(soup.length()-1)=='D'){System.out.println("Invalid Input.");System.exit(0);}
	
	//flag 1 checks if s[i] is integer and flag 2 checks if s[i] is double
	
	int flag1 = 0;
	int flag2=0;
	try{
	int se = Integer.parseInt(soup);
	
	}catch(NumberFormatException e){flag1 = 1;}
	
	try{
	double sey = Double.parseDouble(soup);
	
	}catch(NumberFormatException e){flag2=1;}
	
	if(flag1==1&&flag2==1){System.out.println("Invalid Input.");System.exit(0);}//if s[i] is neither double nor integer we print invalid input
	
	
	
	
	
	
	
	matrix[i][j]=Double.parseDouble(soup);
	
	}
	}
	
	//System.out.println(Arrays.deepToString(matrix));
	
	double ans = det(n,matrix);//det function calculates the determinant // i am sure this function is correct

	System.out.println("Determinant is "+BigDecimal.valueOf(ans).setScale(3, RoundingMode.HALF_DOWN));//rounding up to 3 digits
	
	
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

 