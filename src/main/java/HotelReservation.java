import java.util.HashMap;

public class HotelReservation {
    static HashMap<String,Integer> Hotelweekdayregular = new HashMap<>();
    static HashMap<String,Integer> Hotelweekendregular = new HashMap<>();
    public static void addweekdayRegular(String hotelname, int rate) {
        Hotelweekdayregular.put(hotelname,rate);
    }
    public static void addweekendRegular(String hotelname, int rate) {
        Hotelweekendregular.put(hotelname,rate);
    }
    public static void main(String[] args) {
        System.out.println("............Welcome to Hotel Reservation Program.............");
        Hotelweekdayregular.put("LakeWood",110);
        Hotelweekdayregular.put("BridgeWood",160);
        Hotelweekdayregular.put("RidgeWood",220);
        Hotelweekendregular.put("LakeWood",90);
        Hotelweekendregular.put("BridgeWood",60);
        Hotelweekendregular.put("RidgeWood",150);
        System.out.println("Weekday details "+Hotelweekdayregular);
        System.out.println("Weekend details "+Hotelweekendregular);
    }



}
