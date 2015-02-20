//NEW BIGINTEGER
 holla = new BigInteger("0");  

 //STRING TO BIGINTEGER
 BigInteger ft = new BigInteger(String.valueOf(p));
 
 //BIGINTEGER ADD
	BigInteger st = ft.add(one);
//BIGINTEGER MULTIPLY
	BigInteger tt = (ft.multiply(two)).add(one);
	
//BIGINTEGER SUBTRACTION
	ans = ans.mod(em);
	
//BIGINTEGER TO STRING
	String longans = ans.toString();
	
//compare bigintegers
res = bi1.compareTo(bi2);

        String str1 = "Both values are equal ";
	String str2 = "First Value is greater ";
	String str3 = "Second value is greater";

	if( res == 0 )
	System.out.println( str1 );
	else if( res == 1 )
	System.out.println( str2 );
	else if( res == -1 )
	System.out.println( str3 );
	
	
	
	