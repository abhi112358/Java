import java.io.*;
import java.util.*;

public class Main
{

public static void main(String[] args)throws IOException 
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String str = br.readLine();
//System.out.println(str);

if (str.matches("[-][0-9]*")==true||
	str.matches("[0-9]*")==true)
	
	arabictoroman(str);
	
else romantoarabic(str);



}

static void arabictoroman(String str)
{

int num = Integer.parseInt(str);
if(num<0)System.out.println("INVALID INPUT");
else if(num==0)System.out.println("R\nnulla");
else{
int number=num;
	System.out.println("R");
	
	int[] values = new int[] { 1000000,900000,500000,400000,100000,90000,50000,40000,10000,9000,5000,4000,1000, 900, 500, 400, 100,90, 50, 40, 10, 9, 5, 4, 1 };
	String[] numerals = new String[]{ "m","cm","d","cd","c","xc","l","xl","x","Mx","v","Mv","M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	StringBuilder result = new StringBuilder();
	
for (int i = 0; i < 25; i++)
{
    
    while (number >= values[i])
    {
        number -= values[i];
        result.append(numerals[i]);
    }
}
	System.out.println(result.toString());
	}


}



static void romantoarabic(String roman)
{

if (roman.equals("nulla")) {System.out.println("A\n0");System.exit(0);}
roman = roman.trim();


	
int Vflag = 0;
int Lflag = 0;
int Dflag = 0;
int vflag = 0;
int lflag = 0;
int dflag = 0;
char[] charArray = roman.toCharArray();
for(int i=0;i<charArray.length;i++)
{
if(charArray[i]=='V')Vflag++;
if(charArray[i]=='L')Lflag++;
if(charArray[i]=='D')Dflag++;
if(charArray[i]=='v')vflag++;
if(charArray[i]=='l')lflag++;
if(charArray[i]=='d')dflag++;
}

if(Vflag>1||
	Lflag>1||
	Dflag>1||
	vflag>1||
	lflag>1||
	dflag>1){System.out.println("INVALID INPUT");System.exit(0);}
	
	// Rule 1
int count = 1;
char last = 'Z';

for(char numeral : charArray)
{
    // Valid character?
    if ("IVXLCDMvxlcdm".indexOf(numeral) == -1)
        {System.out.println("INVALID INPUT");System.exit(0);}
     
    // Duplicate?
    if (numeral == last)
    {
        count++;
        if (count == 4) {System.out.println("INVALID INPUT");System.exit(0);}
		
    }
    else
    {
        count = 1;
        last = numeral;
    }
}
	




int ptr = 0;
ArrayList<Integer> values = new ArrayList<Integer>();
int maxDigit = 1000000;
//System.out.println("romanlen= "+roman.length());
while (ptr < roman.length())
{
    // Base value of digit
    char numeral = charArray[ptr];
    int digit=0 ;
	if(numeral=='I')digit=1;
	if(numeral=='V')digit=5;
	if(numeral=='X')digit=10;
	if(numeral=='L')digit=50;
	if(numeral=='C')digit=100;
	if(numeral=='D')digit=500;
	
	if(numeral=='M')digit=1000;
	if(numeral=='v')digit=5000;
	if(numeral=='x')digit=10000;
	if(numeral=='l')digit=50000;
	if(numeral=='c')digit=100000;
	if(numeral=='d')digit=500000;
	if(numeral=='m')digit=1000000;
 
    // Rule 3
    if (digit > maxDigit)
        {System.out.println("INVALID INPUT");System.exit(0);}
 
    // Next digit
    
    if (ptr < roman.length() - 1)
    {
        char nextNumeral = charArray[ptr + 1];
      int nextDigit = 0; 
	if(nextNumeral=='I')nextDigit=1;
	if(nextNumeral=='V')nextDigit=5;
	if(nextNumeral=='X')nextDigit=10;
	if(nextNumeral=='L')nextDigit=50;
	if(nextNumeral=='C')nextDigit=100;
	if(nextNumeral=='D')nextDigit=500;
	
	if(nextNumeral=='M')nextDigit=1000;
	if(nextNumeral=='v')nextDigit=5000;
	if(nextNumeral=='x')nextDigit=10000;
	if(nextNumeral=='l')nextDigit=50000;
	if(nextNumeral=='c')nextDigit=100000;
	if(nextNumeral=='d')nextDigit=500000;
	if(nextNumeral=='m')nextDigit=1000000;
 
// System.out.println("fuck you BUTCG "+digit+"   "+nextDigit);
        if (nextDigit > digit)
        {
	//	System.out.println("fuck you"+digit+"   "+nextDigit);
            if ("IXCMxc".indexOf(numeral) == -1 || nextDigit > (digit * 10)
                || roman.split(Character.toString(numeral)).length > 3)
                {System.out.println("INVALID INPUT");System.exit(0);}
             
            maxDigit = digit - 1;
            digit = nextDigit - digit;
            ptr++;
        }
    }
 
    values.add(digit);
    ptr++;
}

//System.out.println("Contents of al: " + values);
//for (int i = 0; i < values.size();i++)System.out.print(values.get(i)+"   ");


// Rule 5
for (int i = 0; i < values.size() - 1;i++)
{
    if (values.get(i) < values.get(i + 1))
        {System.out.println("INVALID INPUT");System.exit(0);}
}



// Rule 2
int total = 0;
for (int i = 0; i < values.size();i++)
{
    total+=values.get(i);
}

System.out.println("A\n"+total);	
	

}

}