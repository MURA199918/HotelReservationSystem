import org.junit.Test;

public class HotelReservationTest {
    @Test
    public void Test1toaddHoteldetails(){
        HotelReservation hotelReservation = new HotelReservation();
        HotelReservation.addweekdayRegular("Lakewood",110);
        HotelReservation.addweekdayRegular("Bridgewood",160);
        HotelReservation.addweekdayRegular("Ridgewood",220);
        HotelReservation.addweekendRegular("Lakewood",90);
        HotelReservation.addweekendRegular("Bridgewood",60);
        HotelReservation.addweekendRegular("Ridgewood",150);
    }

}
