import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.*;


public class tt {
  public static void main(String[] args){
  
  
  //double d = 9.23971;
   //d= BigDecimal.valueOf(d).setScale(2, RoundingMode.HALF_UP).doubleValue();
	//System.out.println("d="+d);
  
 Scanner in = new Scanner(System.in);
 String sb = in.nextLine();
 String sbp = in.nextLine();
 String ssp = in.nextLine();
 String sq = in.nextLine();
 
// sb=sb.trim();
 //sbp=sbp.trim();
 //ssp=ssp.trim();
 //sq=sq.trim();
 
 char[] charArray = sb.toCharArray();
 for(int i = 0;i<sb.length();i++)if(charArray[i]=='.'||charArray[i]=='1'||charArray[i]=='2'||charArray[i]=='3'||charArray[i]=='4'||charArray[i]=='5'||charArray[i]=='6'||charArray[i]=='7'||charArray[i]=='8'||charArray[i]=='9'||charArray[i]=='0');else {System.out.println("Invalid Input");System.exit(0);}
 
 charArray = sb.toCharArray();
 for(int i = 0;i<sb.length();i++)if(charArray[i]=='.'||charArray[i]=='1'||charArray[i]=='2'||charArray[i]=='3'||charArray[i]=='4'||charArray[i]=='5'||charArray[i]=='6'||charArray[i]=='7'||charArray[i]=='8'||charArray[i]=='9'||charArray[i]=='0');else {System.out.println("Invalid Input");System.exit(0);}
 charArray = sbp.toCharArray();
 for(int i = 0;i<sbp.length();i++)if(charArray[i]=='.'||charArray[i]=='1'||charArray[i]=='2'||charArray[i]=='3'||charArray[i]=='4'||charArray[i]=='5'||charArray[i]=='6'||charArray[i]=='7'||charArray[i]=='8'||charArray[i]=='9'||charArray[i]=='0');else {System.out.println("Invalid Input");System.exit(0);}
 charArray = ssp.toCharArray();
 for(int i = 0;i<ssp.length();i++)if(charArray[i]=='.'||charArray[i]=='1'||charArray[i]=='2'||charArray[i]=='3'||charArray[i]=='4'||charArray[i]=='5'||charArray[i]=='6'||charArray[i]=='7'||charArray[i]=='8'||charArray[i]=='9'||charArray[i]=='0');else {System.out.println("Invalid Input");System.exit(0);}
 charArray = sq.toCharArray();
 for(int i = 0;i<sq.length();i++)if(charArray[i]=='1'||charArray[i]=='2'||charArray[i]=='3'||charArray[i]=='4'||charArray[i]=='5'||charArray[i]=='6'||charArray[i]=='7'||charArray[i]=='8'||charArray[i]=='9'||charArray[i]=='0');else {System.out.println("Invalid Input");System.exit(0);}
 
 
	int flag1 = 0,flag2=0,flag3=0,flag4=0;
	double b=0,bp=0,sp=0;
	int q=0;
	
	try{
	 b= Double.parseDouble(sb);
	
	}catch(Exception e){flag1 = 1;}
	
	try{
	bp= Double.parseDouble(sbp);
	
	}catch(Exception e){flag2 = 1;}
	
	try{
	sp= Double.parseDouble(ssp);
	
	}catch(Exception e){flag3 = 1;}
	
	try{
	q= Integer.parseInt(sq);
	
	}catch(Exception e){flag4 = 1;}
	
	
	if(flag1==1||flag2==1||flag3==1||flag4==1){System.out.println("Invalid Input");System.exit(0);}
	
	if(b<0||bp<0||sp<0||q<0){System.out.println("Invalid Input");System.exit(0);}
	
	//if(b>0.03){System.out.println("Invalid Input");System.exit(0);}
	
	
	if(sb.indexOf( '.' )==sb.length()-1){System.out.println("Invalid Input");System.exit(0);}
	if(sbp.indexOf( '.' )==sbp.length()-1){System.out.println("Invalid Input");System.exit(0);}
	if(ssp.indexOf( '.' )==ssp.length()-1){System.out.println("Invalid Input");System.exit(0);}
	if(sq.indexOf( '.' )==sq.length()-1){System.out.println("Invalid Input");System.exit(0);}
	
	if(sb.indexOf( '.' )==0){System.out.println("Invalid Input");System.exit(0);}
	if(sbp.indexOf( '.' )==0){System.out.println("Invalid Input");System.exit(0);}
	if(ssp.indexOf( '.' )==0){System.out.println("Invalid Input");System.exit(0);}
	if(sq.indexOf( '.' )==0){System.out.println("Invalid Input");System.exit(0);}
	
	
	
	
	double bam = bp*q; //buying amount
	double bob = bam*b/100;
	//bob= BigDecimal.valueOf(bob).setScale(2, RoundingMode.HALF_UP).doubleValue();
	
	double stonbob = bob*0.1036;
//stonbob= BigDecimal.valueOf(stonbob).setScale(2, RoundingMode.HALF_UP).doubleValue();
	
	double totbam = bob+stonbob;
//totbam= BigDecimal.valueOf(totbam).setScale(2, RoundingMode.HALF_UP).doubleValue();
//System.out.println("total paid on buying amount"+"  "+totbam);
	
	double sam = sp*q;
	double bos = sam*b/100;
//bos= BigDecimal.valueOf(bos).setScale(2, RoundingMode.HALF_UP).doubleValue();
	
	double stonbos = bos*0.1036;
//stonbos= BigDecimal.valueOf(stonbos).setScale(2, RoundingMode.HALF_UP).doubleValue();
	double stl = 0.00025*sam;
//stl= BigDecimal.valueOf(stl).setScale(2, RoundingMode.HALF_UP).doubleValue();
	
	double totsam = bos+stonbos+stl;
//totsam= BigDecimal.valueOf(totsam).setScale(2, RoundingMode.HALF_UP).doubleValue();
//System.out.println("total paid on selling amount"+"  "+totsam+" "+bos+"  "+stonbos+" "+stl);
	
	double totpaid = totbam+totsam;
//totpaid= BigDecimal.valueOf(totpaid).setScale(2, RoundingMode.HALF_UP).doubleValue();
	
	double turnover = bam+sam;
	
	double pot = 0.00006*turnover;
//pot= BigDecimal.valueOf(pot).setScale(1, RoundingMode.HALF_UP).doubleValue();
//System.out.println("total paid on turnover"+"  "+pot);
	
	totpaid = totpaid+pot;
//totpaid= BigDecimal.valueOf(totpaid).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
//System.out.println("totpaid="+totpaid);


	double netprofit = sam-bam;
//netprofit= BigDecimal.valueOf(netprofit).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
//System.out.println("Profit"+"  "+netprofit);
	
	netprofit = netprofit - totpaid;

//netprofit= BigDecimal.valueOf(netprofit).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
	
	if(netprofit==0){System.out.println("Invalid Input");System.exit(0);}//System.out.println("Profit"+"\n"+"0");
	else{
	
	if(netprofit>0){System.out.println("Profit");
						System.out.printf("%.2f\n",netprofit);
						
						}//BigDecimal.valueOf(netprofit).setScale(2, RoundingMode.HALF_UP)
	else {System.out.println("Loss");
						System.out.printf("%.2f\n",(netprofit*(-1)));
						
						}
	
	
	}
	//System.out.println("success");
  
  }

}

 