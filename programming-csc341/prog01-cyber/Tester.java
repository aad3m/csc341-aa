public class Tester {
	
    static String salt = "+_)(*&^%$#@!";
    static String key = "E827g4D;C^#4,nZ$m7]kq-s0Wj3R=CrX";
    
    static Hasher hasher = new Hasher(salt,key);
    
    public static void main(String[] args) {
    	
    	System.out.println(Integer.toHexString('a'));
    	System.out.println(Integer.toHexString('^'));
    	System.out.println(Integer.toHexString('z'));
    	//615e7a
    	System.out.println(Mapper.hex2dec('e'));
    }
}