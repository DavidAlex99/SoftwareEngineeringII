import java.util.LinkedList;
import java.util.List;

public class beforePMD {
	/*
     * Warnings resulted by PMD (RED): 
     * 1. Multiple markers at this line
     * 2. NoPackage: All classes, interfaces, enums and annotations must belong to a named package
     * 3. UseUtilityClass: This utility class has a non-private constructor
     * 4. CommentRequired: Class comments are required
     * 5. ClassNamingConventions: The class name 'prueba' doesn't match '[A-Z][a-zA-Z0-9]*'
     */

    private static final double DISCOUNT_PARIS = 500;
    /*
     * Warnings resulted by PMD (GREEN): 
     * 1. CommentRequired: Field comments are required
     */
    private static final double DISCOUNT_NEW_YORK_CITY = 600;
    /*
     * Warnings resulted by PMD (GREEN):
     * Multiple markers at this line
     * 1. LongVariable: Avoid excessively long variable names like DISCOUNT_NEW_YORK_CITY
     * 2. CommentRequired: Field comments are required 
     */
    private static final double BASE_COST = 1000;
    /*
     * Warnings resulted by PMD (GREEN): 
     * 1. CommentRequired: Field comments are required
     */
    private static final int MINIMUM_PASS = 0;
    /*
     * Warnings resulted by PMD (GREEN): 
     * 1. CommentRequired: Field comments are required
     */
    private static final double MAXIMUM_PASS = 80;
    /*
     * Warnings resulted by PMD (GREEN): 
     * 1. CommentRequired: Field comments are required
     */
    private static final double EXTRA = 200;
    /*
     * Warnings resulted by PMD (GREEN): 
     * 1. CommentRequired: Field comments are required
     */
    private static final int WEEK = 7;
    /*
     * Warnings resulted by PMD (GREEN): 
     * 1. CommentRequired: Field comments are required
     */
    private static final int MONTH = 30;
    /*
     * Warnings resulted by PMD (GREEN): 
     * 1. CommentRequired: Field comments are required
     */
    private static final int AMOUNT_PASS_DISCOUNT = 2;
    /*
     * Warnings resulted by PMD (GREEN): 
     * Multiple markers at this line
     * 1. LongVariable: Avoid excessively long variable names like DISCOUNT_NEW_YORK_CITY
     * 2. CommentRequired: Field comments are required 
     */
    private static final double DISCOUNT_GREATER_10 = 0.8;
    /*
     * Warnings resulted by PMD (GREEN): 
     * Multiple markers at this line
     * 1. LongVariable: Avoid excessively long variable names like DISCOUNT_NEW_YORK_CITY
     * 2. CommentRequired: Field comments are required 
     */
    private static final double DISCOUNT_LOWER_10 = 0.9;
    /*
     * Warnings resulted by PMD (GREEN): 
     * 1. CommentRequired: Field comments are required
     */
    private static final int AMOUNT_PASS_MIN = 2;
    /*
     * Warnings resulted by PMD (GREEN): 
     * 1. CommentRequired: Field comments are required
     */
    private static final int AMOUNT_PASS_MAX = 10;
    /*
     * Warnings resulted by PMD (GREEN): 
     * 1. CommentRequired: Field comments are required
     */
    
/**
 * Method for calculating the cost of the package according the parameters
 * @param dest the destination for the vacation
 * @param nTravel the number of travelers
 * @param time the duration of the vacation in days
 * @return the calculated cost of the vacation package
 */
    public static double calculateCost(String dest, int nTravel, int time) {
    	/*
    	 * Warnings resulted by PMD (GREEN): 
    	 * 1. Multiple markers at this line
    	 * 2. MethodArgumentCouldBeFinal: Parameter 'nTravel' is not assigned and could be declared final
    	 * 3. CyclomaticComplexity: The method 'calculateCost(String, int, int)' has a cyclomatic complexity of 10.
    	 * 4. MethodArgumentCouldBeFinal: Parameter 'dest' is not assigned and could be declared final
    	 * 5. MethodArgumentCouldBeFinal: Parameter 'time' is not assigned and could be declared final
    	 */
		
	
	double TOTAL_COST = BASE_COST;
	/*
	 * Warnings resulted by PMD (red): 
	 * 1. LocalVariableNamingConventions: The local variable name 'TOTAL_COST' doesn't match '[a-z][a-zA-Z0-9]*'
	 */
    
	List<String> countriesAvaliable = new LinkedList<>();
	/*
	 * Warnings resulted by PMD (GREEN): 
	 * 1. Multiple markers at this line
	 * 2. LongVariable: Avoid excessively long variable names like countriesAvaliable
	 * 3. LocalVariableCouldBeFinal: Local variable 'countriesAvaliable' could be declared final
	 */
	countriesAvaliable.add("Paris");
	countriesAvaliable.add("New York City");
	countriesAvaliable.add("London");
	//CHECKSTYLE:OFF
		if (!isValidInput(dest, nTravel, time)) {
            return -1;
            /*
             * Warnings resulted by PMD (GREEN): 
             * OnlyOneReturn: A method should have only one exit point, and that should be the last statement in the method
             */
        }
	//CHECKSTYLE:ON	
	

		
	switch (dest) {
	    case "Paris":
	    	TOTAL_COST += DISCOUNT_PARIS;	
	        break;
	    case "New York City":
	    	TOTAL_COST += DISCOUNT_NEW_YORK_CITY;
	        break;
	    default:
	        break;
	}
		
		//Application of discounts  travelers and time
		
	if (nTravel > AMOUNT_PASS_MIN && nTravel < AMOUNT_PASS_MAX) {
	    TOTAL_COST = TOTAL_COST * DISCOUNT_LOWER_10;
	} else if (nTravel > AMOUNT_PASS_MAX) {
            TOTAL_COST = TOTAL_COST * DISCOUNT_GREATER_10;
        }

        if (time < WEEK) {
            TOTAL_COST += EXTRA;
        } else if (time > MONTH || nTravel == AMOUNT_PASS_DISCOUNT) {
            TOTAL_COST -= EXTRA;
        }
		
	return TOTAL_COST;
		
    }
	
	//Resolving the waring "Too Much Arguments". 
	/*
	 * First argument: destiny
	 * Second Argument: number of travelers
	 * Third travelers: duration of the travel
	 */
    private static boolean isValidInput(String dest, int travel, int time) {
    	/*
    	 * Warnings resulted by PMD (GREEN): 
    	 * 1. UnusedFormalParameter: Avoid unused method parameters such as 'time'.
    	 * 2. MethodArgumentCouldBeFinal: Parameter 'travel' is not assigned and could be declared final
    	 * 3. MethodArgumentCouldBeFinal: Parameter 'dest' is not assigned and could be declared final
    	 * 
    	 * Another warning as result of previus comment:
    	 * 1. Comment is too large
    	 */
    	
        if (dest == null || dest.isEmpty()) {
            System.out.println("Invalid destination.");
            /*
             * Warnings resulted by PMD (BLUE): 
             * 1. SystemPrintln: Usage of System.out/err
             */
            return false;
            /*
             * Warnings resulted by PMD (GREEN): 
             * 1. OnlyOneReturn: A method should have only one exit point, and that should be the last statement in the method
             */
        }

        if (travel <= MINIMUM_PASS || travel > MAXIMUM_PASS) {
            System.out.println("The package is not for more than 80 persons.");
            /*
             * Warnings resulted by PMD (BLUE): 
             * 1. SystemPrintln: Usage of System.out/err
             */
            return false;
            /*
             * Warnings resulted by PMD (GREEN): 
             * 1. OnlyOneReturn: A method should have only one exit point, and that should be the last statement in the method
             */
        }
        return true;
    }
}
