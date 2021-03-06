/***********************************************************
 * Lab #1 (CIS 181, Fall 2008)                             *
 * Submitted By: Your name here !!!                        *
 * SID: Your new SID starting with "00"                    *
 * Date: Your submission date                              *
 ***********************************************************/

/*
 * Created on September 16, 2006
 * @author Haiping Xu
 */

public class Date {
    private int month;
    private int day;
    private int year;

    public Date() {
        month = 1;
        day = 1;
        year =2006;
    }

    public Date (int m, int d, int y){
        month = m;
        day = d;
        year =y;
    }

    // -----------------------------------------------------------------------------
    // Check if a date is valid.
    // Preconditon: mon, day and year are integers.
    // Postcondtion: If the combination of mon, day and year represents a valid date,
    //       a true value is returned; otherwise, a false value is returned.
    // -----------------------------------------------------------------------------
    public static boolean isLegitimate(int mon, int day, int year){

    	if(!(mon >= 1 && mon <= 12)) // Check if month falls between the acceptable range and is greater than one 
    		return false;
    	
    	if(!(year > 0)) // Check if year is a positive integer 
    		return false;
    	
    
    	if((day > 0)){
    		if(mon == 2) {  // February need some special processing
				// February has 29 days in any year evenly divisible by four,
				// EXCEPT for centurial years which are not also divisible by 400.
    			if((((year % 4 == 0) && !(year %  100 == 0) || (year % 400 == 0)) && day >= 29)) { 
    				return false;
    			}
    		} else if((mon == 4 || mon == 6 || mon == 9 || mon == 11) && day != 30) {
    			// If its April, June, September, and November then it should be 30
    			return false;
    		} 
    	}
    	
    	
        return true;
    }
    
    public static boolean isLegitimate(Date aDate){ 
    	return isLegitimate(aDate.month, aDate.day, aDate.year);
    }
    

    // -----------------------------------------------------------------------------
    // Advance a given date by one day
    // Preconditon: aDate is a valid date
    // Postcondtion: aDate is a new valid date that is increased by one day
    // -----------------------------------------------------------------------------
    public static void advanceDate(Date aDate) {

    	if(isLegitimate(aDate.month, aDate.day, aDate.year)){ 
    		// Increase by one
    		if(aDate.day == 31 && aDate.month != 12){ 
    			aDate.day = 1;
    			aDate.month += 1;
    			return; 
    		}
    		
    		if(aDate.day == 31 && aDate.month == 12){
    			aDate.day = 1;
    			aDate.month = 1;
    			aDate.year++;
    			return;
    		}
    	    
    		if(aDate.day == 30 && (aDate.month == 4 || aDate.month == 6 || aDate.month == 9 || aDate.month == 11)){
    			aDate.day = 1;
    			aDate.month++;
    			return;
    		}
    		
    		
    		if((aDate.year % 4 == 0) && !(aDate.year %  100 == 0) || (aDate.year % 400 == 0) && aDate.day == 29) {
				aDate.day = 1;
				aDate.month++;
    			return;
    		}
    		
    		
    		aDate.day++;
    		return;
    		
    	} else {
    		System.out.println("Illegitimate date.");
    	}
        // TODO 2: Implement this method to advance aDate by one day.

    }

    public void display(String s){
        System.out.println(s + month + "/" + day + "/" + year);
    }
}
