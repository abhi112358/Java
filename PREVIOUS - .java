import java.io.*;
import java.util.*;
import java.lang.*;



public class para {
  public static void main(String[] args) throws Exception {
  
 Scanner in = new Scanner(System.in);
 String mm = in.nextLine();
 String nn = in.nextLine();
 String ll = in.nextLine();
 
 mm = mm.trim();
 nn = nn.trim();
 ll= ll.trim();
 //BELOW ARE 2 METHODS FOR INPUT VALIDATION 
 /*
     try{
	p= Integer.parseInt(s[0]);
	
	}catch(Exception e){{System.out.println("Invalid Input");System.exit(0);}}
	
	*/
	
//2
/*
	int flag1 = 0,flag2=0,flag3=0;
	
	try{
	int se1 = Integer.parseInt(mm);
	
	}catch(NumberFormatException e){flag1 = 1;}
	
	try{
	int se2 = Integer.parseInt(nn);
	
	}catch(NumberFormatException e){flag2 = 1;}
	
	try{
	int se3 = Integer.parseInt(ll);
	
	}catch(NumberFormatException e){flag3 = 1;}
	
	
	if(flag1==1||flag2==1||flag3==1){System.out.println("Invalid Input");System.exit(0);}//if s[i] is neither double nor integer we print invalid input
	*/
	
	if(mm.matches("[0-9]+")&&nn.matches("[0-9]+")&&ll.matches("[0-9]"));else {System.out.println("Invalid Input");System.exit(0);}
	int m,n,l;
	m=Integer.parseInt(mm);
	n=Integer.parseInt(nn);
	l=Integer.parseInt(ll);
	
	if(l==0||
	l==1||
	l==2||
	l==3||
	l==4||
	l==5||
	l==6||
	l==7||
	l==8||
	l==9); else {System.out.println("Invalid Input");System.exit(0);}//if s[i] is neither double nor integer we print invalid input
	
	if(m>n){System.out.println("Invalid Input");System.exit(0);}//if s[i] is neither double nor integer we print invalid input
	
	if(n>1500000||m<0||m>1500000||n<0){System.out.println("Invalid Input");System.exit(0);}//if s[i] is neither double nor integer we print invalid input
	int count = 0;
	
	for(int i=m;i<=n;i++)count+=foo(i,l);
	
	System.out.println("Count="+count);
  }
  
  static int foo(int n,int l)
  {
  
  String s = String.valueOf(n);
  int count = 0;
  for(int i=0; i<s.length();i++)if(s.charAt(i)==(char)(l+48))count++;
  return count;
  
  }

}

 