import java.util.Scanner;
import java.util.*; 
class lcs
{
   public static void main(String args[])
   {
   
   /*  int a;
      float b;
      String s;
 
      Scanner in = new Scanner(System.in);
 
      System.out.println("Enter a string");
      s = in.nextLine();
      System.out.println("You entered string "+s);
 
      System.out.println("Enter an integer");
      a = in.nextInt();
      System.out.println("You entered integer "+a);
 
      System.out.println("Enter a float");
      b = in.nextFloat();
      System.out.println("You entered float "+b);  
    */  
      
	Scanner in = new Scanner(System.in);
	String x1,y1;
	
	x1 = in.nextLine();
	y1 = in.nextLine();
	x1=x1.replaceAll("\\s","");// Remove all whitespaces from string x
	y1=y1.replaceAll("\\s","");// Remove all whitespaces from string x
    //System.out.println("st1 is  "+x1);
	
	int lx=x1.length();
	int ly=y1.length();
	System.out.println("lengths are "+lx+" "+ly);
    

	char[] x = new char[lx+1];
	for(int i=1;i<=lx;i++)x[i]=Character.valueOf(x1.charAt(i-1));
	for(int i=1;i<=lx;i++)System.out.printf(" "+x[i]);
	System.out.println("\t");
	char[] y = new char[ly+1];
	for(int i=1;i<=ly;i++)y[i]=Character.valueOf(y1.charAt(i-1));
	for(int i=1;i<=ly;i++)System.out.printf(" "+y[i]);
	
	
	
	int[][] table = new int[lx+1][ly+1];
	//int[][] arrow = new int[lx+1][ly+1];
	for(int i=0;i<=lx;i++){
		for(int j=0;j<=ly;j++){
			if(i==0||j==0)table[i][j]=0;
			else{
				if(x[i]==y[j]){table[i][j]=table[i-1][j-1]+1;}
				else if(table[i][j-1]>table[i-1][j]) {table[i][j]=table[i][j-1];}
					else {table[i][j]=table[i-1][j];}
				}
			}
		}
	
	
	
	
	//PRINT TABLE
	System.out.printf("\n\n\n\n \t    ");
	for(int i=1;i<=ly;i++)System.out.printf(""+y[i]+"  ");
	System.out.println("\n\n");
	for(int i=0;i<=lx;i++){
							System.out.printf(""+x[i]+"\t");
		for(int j=0;j<=ly;j++){
								if(table[i][j]<10)System.out.printf(" "+table[i][j]+" ");
								else System.out.printf(""+table[i][j]+" ");
								}
							System.out.printf("\n\n");
							}
   
   
   
   

   
   
   
    int sizelcs = table[lx][ly];
	System.out.println("size of largest common substring is:\n" +sizelcs+"\n\n"+"largest common substrings are\n");
    char[] lcs = new char[sizelcs];
	ArrayList<String> al = new ArrayList<String>();
	rec(x,y,lx,ly,lcs,0,sizelcs,al);
	
	for (int i = 0; i < al.size(); i++){
    String item = al.get(i);
    System.out.println(""+ item+"\n");
    }




    
    
   
   
   
   }
   
   
   
   
   
   
public static int rec(char[]x, char[]y, int i,int j,char[] lcs,int d,int sizelcs , ArrayList<String> al) {


	if(d==sizelcs-1&&x[i]==y[j]){
					 
					 lcs[d]=x[i];
					 String ns = new String(lcs);
					 String z = new StringBuffer(ns).reverse().toString();
					 int indu=al.indexOf(z);
					 if(indu==-1)al.add(z);
					 return 0;
					}
	if(i==1&&j==1){
			return 0;
			}
	
	
	else if(i!=1&&j!=1){
	if(x[i]==y[j]){
					
					lcs[d]=x[i];
					d++;
					rec(x,y,i-1,j-1,lcs,d,sizelcs,al);
					}
	else{
		 
				rec(x,y,i-1,j,lcs,d,sizelcs,al);
				rec(x,y,i,j-1,lcs,d,sizelcs,al);
				
		 }
	}
	
	
	else{
	if(i==1){
			if(x[i]!=y[j]) rec(x,y,i,j-1,lcs,d,sizelcs,al);
					
		}
		
	if(j==1){
			if(x[i]!=y[j])
			 rec(x,y,i-1,j,lcs,d,sizelcs,al);
					
		}
		
}

	return 0;
	
}
   
  }