//CHECKSTYLE:OFF
package VacationPackage;
//CHECKSTYLE:ON
import java.util.List;
import java.util.LinkedList;
public class VacationEstimator {
	


	
    private static final double DISCOUNT_PARIS = 500;
    private static final double DISCOUNT_NEW_YORK_CITY = 600;
    private static final double BASE_COST = 1000;
    private static final int MINIMUM_PASS = 0;
    private static final double MAXIMUM_PASS = 80;
    private static final double EXTRA = 200;
    private static final int WEEK = 7;
    private static final int MONTH = 30;
    private static final int AMOUNT_PASS_DISCOUNT = 2;
    private static final double DISCOUNT_GREATER_10 = 0.8;
    private static final double DISCOUNT_LOWER_10 = 0.9;
    private static final int AMOUNT_PASS_MIN = 2;
    private static final int AMOUNT_PASS_MAX = 10;
    
/**
 * Method for calculating the cost of the package according the parameters
 * @param dest the destination for the vacation
 * @param nTravel the number of travelers
 * @param time the duration of the vacation in days
 * @return the calculated cost of the vacation package
 */
    public static double calculateCost(String dest, int nTravel, int time) {
		
	
	double TOTAL_COST = BASE_COST;
    
	List<String> countriesAvaliable = new LinkedList<>();
	countriesAvaliable.add("Paris");
	countriesAvaliable.add("New York City");
	countriesAvaliable.add("London");
	//CHECKSTYLE:OFF
		if (!isValidInput(dest, nTravel, time)) {
            return -1;
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
        if (dest == null || dest.isEmpty()) {
            System.out.println("Invalid destination.");
            return false;
        }

        if (travel <= MINIMUM_PASS || travel > MAXIMUM_PASS) {
            System.out.println("The package is not for more than 80 persons.");
            return false;
        }
        return true;
    }
}
