import java.util.HashMap;

public class Mapper {

	// singleton hashmaps to convert from hexidecimal to decimal and vice-versa
    private static HashMap<Character,Integer> hex2dec = new HashMap<>();
    private static HashMap<Integer,Character> dec2hex = new HashMap<>();
    
    /** Conversion of a hexidecimal char to int
    * @param hex character 0 to f 
    * @return corresponding decimal value of c 
    */
    public static int hex2dec(char hex) {
        return hex2dec.get(hex);
    }

	/** Conversion of a decimal to hexidecimal digit
	* @param dec integer in range 0 to 15
	* @return char in range '0' to 'f'
	*/
    public static int dec2hex(int dec) {
        return dec2hex.get(dec);
    }
    
    // Creates the singleton hashmap/dictionaries
    private static Mapper mappers = new Mapper();

	// private constructor that is called exactly 1 time by the static
	// self-declaration of mappers
    private Mapper() {
    
    	// Conversion from hexidecimal char to equivalent integer
        hex2dec.put('0',0);
        hex2dec.put('1',1);
        hex2dec.put('2',2);
        hex2dec.put('3',3);
        hex2dec.put('4',4);
        hex2dec.put('5',5);
        hex2dec.put('6',6);
        hex2dec.put('7',7);
        hex2dec.put('8',8);
        hex2dec.put('9',9);
        hex2dec.put('a',10);
        hex2dec.put('b',11);
        hex2dec.put('c',12);
        hex2dec.put('d',13);
        hex2dec.put('e',14);
        hex2dec.put('f',15);

		// conversion from integer to equivalent hexidecimal char
        dec2hex.put(0,'0');
        dec2hex.put(1,'1');
        dec2hex.put(2,'2');
        dec2hex.put(3,'3');
        dec2hex.put(4,'4');
        dec2hex.put(5,'5');
        dec2hex.put(6,'6');
        dec2hex.put(7,'7');
        dec2hex.put(8,'8');
        dec2hex.put(9,'9');
        dec2hex.put(10,'a');
        dec2hex.put(11,'b');
        dec2hex.put(12,'c');
        dec2hex.put(13,'d');
        dec2hex.put(14,'e');
        dec2hex.put(15,'f');
    }
    

}
