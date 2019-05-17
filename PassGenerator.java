//package passwordgenerator;

import java.util.Random;

/**
 * Class name: PassGenerator
 * Description: This class generates passwords of different lengths following
 * 		this criteria:
 * 		min length: 8 characters
 * 		must have at least 1: 
 *                  upper case letter
 *                  lower case letter
 *                  number
 *                  special character
 * 
 * @author Zakaria Bakkal
 * @date September 1, 2018
 * @version 1
 *
 */
public class PassGenerator {

	// used for the minimum password length
	private final int MIN = 8;
	// used for the number of criteria
	private final int CRITERIA_COUNT = 4;
	
	// represents the password length
	private int passLength;
	// represents the password criteria
	private char[] criteria;
	// represents the generated password
	private char[] password;
	
	/**
	 * Instantiate a new PassGenerator.
	 * 
	 * @param passLength
	 */
	public PassGenerator(int passLength) {
            // if the length provided is less than 8 exit
            if(passLength < MIN) {
		System.out.println("Password length must at least 8");
		System.exit(1);
            }
	
            // if the the length is at least 8 proceed
            this.passLength = passLength;
            this.password = new char[passLength];
            criteria = new char[CRITERIA_COUNT];
	}

	/**
	 * returns the random generated password.
	 * 
	 * @return char[]
	 */
	public String getPassword() {
        
            StringBuilder password = new StringBuilder(passLength);
            // change the password from char[] to string
            for(char c: this.password) {
                password.append(c);
            }
         
            return password.toString();
	}
	
	/**
	 * Generates the password with the given criteria.
	 */
	public void generatePassword() {
            // generate the must have criteria
            generateCriteria();
            // used for random choice of which criteria to use
            int random;
            // used to control the while loop to populate the
            // empty spots in the password
            int count;
            // used to populate random spots in the password
            int index;
		
            // fill the password with the criteria in random positions
            for(int i = 0; i < CRITERIA_COUNT; i++) {
            	do {
                    index = new Random().nextInt(passLength);
                } while((int) password[index] != 0);
                password[index] = criteria[i];
            }
		
            // fill the rest of the password with random characters
            count = passLength - CRITERIA_COUNT;
		
            while(count > 0) {
		random = new Random().nextInt(CRITERIA_COUNT);
		
		switch(random) {
                    case 0:
			do {
                    	index = new Random().nextInt(passLength);
			} while((int) password[index] != 0);
			password[index] = generateUpperCase();
		
                        count--;
			break;
					
                    case 1:
			do {
                            index = new Random().nextInt(passLength);
			} while((int) password[index] != 0);
			password[index] = generateLowerCase();
			
                        count--;
			break;
					
                    case 2:
			do {
                            index = new Random().nextInt(passLength);
			} while((int) password[index] != 0);
			password[index] = generateNumber();
			
                        count--;
			break;					
                    case 3:
			do {
                            index = new Random().nextInt(passLength);
			} while((int) password[index] != 0);
			password[index] = generateSpecialChar();
			
                        count--;
			break;
		}
            }
		
        }

	
	/**
	 * Generates the password criteria.
	 */
	public void generateCriteria() {
		// used for random spots in the criteria array
		int index;
		
		do {
                    index = new Random().nextInt(4);
		}
		while((int) criteria[index] != 0);	
		criteria[index] = generateUpperCase();
			
		
		do {
                    index = new Random().nextInt(4);
		}
		while((int) criteria[index] != 0);	
		criteria[index] = generateLowerCase();
			
		do {
                    index = new Random().nextInt(4);
		}
		while((int) criteria[index] != 0);	
		criteria[index] = generateNumber();
			
		do {
                    index = new Random().nextInt(4);
		}
		while((int) criteria[index] != 0);	
		criteria[index] = generateSpecialChar();
	}

	/**
	 * Generates a random upper case letter
	 * 
	 * @return char
	 */
	public char generateUpperCase() {
		
            char upperCase;
		
            int c = (new Random().nextInt(26) + 65);
            upperCase = (char) c;
            
            return upperCase;
	}
	
	/**
	 * Generates a random lower case letter
	 * 
	 * @return char
	 */
	public char generateLowerCase() {

            char lowerCase;
		
            int c = (new Random().nextInt(26) + 97);
            lowerCase = (char) c;
	
            return lowerCase;
	}
	
	/**
	 * Generates a random number between 0 and 9
	 * 
	 * @return integer
	 */
	public char generateNumber() {
            return new String("" + new Random().nextInt(10)).charAt(0);
	}
	
	/**
	 * Generates a random special character from:
	 * ('!', '"', '#', '$', '%', '&',''','(', ')', '*', '+', '-', '.', '/')
	 * 
	 * @return char
	 */
	public char generateSpecialChar() {
		
            char specialChar;
            
            int c = (new Random().nextInt(15) + 33);
            specialChar = (char) c;
            
            return specialChar;
	}
	
}
