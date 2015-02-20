import java.util.Scanner;
 
class Loopy
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

    int N;
    System.out.println("Enter the number of matrices\n");
    N = in.nextInt();
    
    
    int[] p = new int[N+1];
    int x,i;
    System.out.println("\n\n\nEnter the dimensions of matrices in a serial order\n");
    for(i=0;i<N+1;i++)p[i] = in.nextInt();
    //for(i=0;i<N+1;i++)System.out.println(p[i]);
    
    int d,k,j;
	long[][] m = new long[N][N];
	int[][] moo= new int[N][N];
	for(i=0;i<N;i++)
	for(j=0;j<N;j++)
	{m[i][j]=-1;
	 moo[i][j]=-1;
	}
	

					 
	for(d=0;d<N;d++)
    for(i=1;i<=N-d;i++){
						j=d+i;
						m[i-1][j-1]=1000000000;
						if(i==j){m[i-1][j-1]=0;moo[i-1][j-1]=i;}
						else{
							 for(k=i;k<j;k++){
							 				  if((m[i-1][k-1]+m[k][j-1]+p[i-1]*p[k]*p[j])<m[i-1][j-1]){ m[i-1][j-1]=m[i-1][k-1]+m[k][j-1]+p[i-1]*p[k]*p[j];moo[i-1][j-1]=k;}
							 				  //printf("%q %d   %d      i,k=%d   k+1,j=%d   p*p*p=%d   sex=%d     m=%lld\n",i,j,m[i][k],m[k+1][j],p[0]*p[1]*p[2],p[0],m[i][j]);
											  }
						     }
					     }
						 
	System.out.printf("\n\n\n");
						 
	for(i=0;i<N;i++){
					 for(j=0;j<N;j++)
					 System.out.printf("\t"+m[i][j]);
					 System.out.println("\n");
					 }
					 
	System.out.printf("\n\n\n");
					 
	for(i=0;i<N;i++){
					 for(j=0;j<N;j++)
					 System.out.printf("\t"+moo[i][j]);
					 System.out.println("\n");
					 }
					 
	System.out.printf("\n\n\n");
	

	int[][] table= new int[N+1][2];	
	rec(1,N,table,N+1,moo);
    
  
	
	
	for(i=0;i<N+1;i++){
					 for(j=0;j<2;j++)
					 System.out.printf("\t"+table[i][j]);
					 System.out.println("\n");
					 }

     System.out.printf("\n\n\nOptimal Parenthisation is--\n\n");
    
	int foo=1;
	for(i=0;i<table[0][0];i++)System.out.printf("( ");
	System.out.printf("A"+foo+" ");
	foo++;
	
	for(i=1;i<=N-1;i++){
	for(j=1;j>=0;j--){
					  if(j==1)for(k=0;k<table[i][j];k++)System.out.printf(") ");
	                  if(j==0)for(k=0;k<table[i][j];k++)System.out.printf("( ");
					  }
					  System.out.printf("A"+foo+" ");
					  foo++;
					  }
	for(i=0;i<table[N][1];i++)System.out.printf(") ");
    

	System.out.printf("\n\n\n");
	
	
}





public static int rec(int x, int y, int[][] table, int NN,int[][] moo) {
	

					 
	if(x!=y){
	int k=moo[x-1][y-1];
	table[x-1][0]++;
	table[y][1]++;
	rec(x,k,table,NN,moo);
	rec(k+1,y,table,NN,moo);
	}
	return 0;

	}
	
	
	
}