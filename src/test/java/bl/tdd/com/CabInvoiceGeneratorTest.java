package bl.tdd.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
	CabInvoiceGenerator invoiceGenerator = null;
	@BeforeEach
	void setUp() throws Exception {
		invoiceGenerator = new CabInvoiceGenerator();
	}

	 @Test
	    public void givenDistanceAndTime_ShouldReturnTotalFare(){

	        double distance =2.0;
	        int time = 5;
	        double fare = invoiceGenerator.calculateFare(distance,time, Ride.RideType.NORMAL);
	        Assertions.assertEquals(25,fare,0.0);

	    }

	    //For Minimum Fare
	    @Test
	    public void givenLessDistanceOrTime_ShouldReturnMinimumFare(){

	        double distance = 0.1;
	        int time = 1;
	        double fare = invoiceGenerator.calculateFare(distance,time, Ride.RideType.NORMAL);
	        Assertions.assertEquals(5,fare,0.0); //delta is for remove extra point values

	    }

	    //Step - 2

	    @Test
	    public void givenMultipleRide_ShouldReturnInvoiceSummary(){

	        Ride[] rides = { new Ride(2.0, 5),
	                         new Ride(0.1, 1),
	                         new Ride(3.0,3)};

	        double fare  = invoiceGenerator.calculateFare(rides, Ride.RideType.PREMIUM,"Hello");
	        double expected = 111.0;
	        Assertions.assertEquals(expected,fare);

	    }


}
