import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class HotelReservationTest {
    @Test
    public void Test1toaddHoteldetails(){
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addweekdayRegular("Lakewood",110);
        hotelReservation.addweekdayRegular("Bridgewood",160);
        hotelReservation.addweekdayRegular("Ridgewood",220);
        hotelReservation.addweekendRegular("Lakewood",90);
        hotelReservation.addweekendRegular("Bridgewood",60);
        hotelReservation.addweekendRegular("Ridgewood",150);
        hotelReservation.printdetails();
    }

}
