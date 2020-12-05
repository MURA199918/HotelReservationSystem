import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HotelReservation {
    public static HashMap<String,Integer> Hotelweekdayregular = new HashMap<>();
    public static HashMap<String,Integer> Hotelweekendregular = new HashMap<>();
    public static void addweekdayRegular(String hotelname, int rate) {
        Hotelweekdayregular.put(hotelname,rate);
    }
    public static void addweekendRegular(String hotelname, int rate) {
        Hotelweekendregular.put(hotelname,rate);
    }
    public static void printdetails(){
        System.out.println("Weekday rates of hotel");
        for (HashMap.Entry<String,Integer> entry : Hotelweekdayregular.entrySet()){
               System.out.println("Hotel name: "+entry.getKey()+" Rates: "+entry.getValue());
        }
        System.out.println("Weekend rates of hotel");
        for(HashMap.Entry<String,Integer> entry : Hotelweekendregular.entrySet()){
            System.out.println("Hotel name: "+entry.getKey()+" Rates: "+entry.getValue());
        }
    }
    public static ArrayList<Integer> dayofweek(String startdate, String enddate)
    {
        ArrayList<Integer> day = new ArrayList<>();
        String[] startarr = startdate.toLowerCase().split(" ");
        String[] endarr = enddate.toLowerCase().split(" ");
        int date = Integer.parseInt(startarr[0]);
        int enddatevalue = Integer.parseInt(endarr[0]);
        for(int i=date;i<=enddatevalue;i++){
            String month = (startarr[1]);
            int m = 0;
            int year = Integer.parseInt(startarr[2]);
            if(month.equals("jan")){
                m = 1;
            }
            else if(month.equals("feb")){
                m = 2;
            }
            else if(month.equals("mar")){
                m = 3;
            }
            else if(month.equals("apr")){
                m = 4;
            }
            else if(month.equals("may")){
                m = 5;
            }
            else if(month.equals("june")){
                m = 6;
            }
            else if(month.equals("july")){
                m = 7;
            }
            else if(month.equals("aug")){
                m = 8;
            }
            else if(month.equals("sep")){
                m = 9;
            }
            else if(month.equals("oct")){
                m = 10;
            }
            else if(month.equals("nov")){
                m = 11;
            }
            else if(month.equals("dec")){
                m = 12;
            }
            int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
            year -= (m < 3) ? 1 : 0;
            day.add( ( year + year/4 - year/100 + year/400 + t[m-1] + i) % 7 );
        }
        return day;
    }
    public static void main(String[] args) {
        System.out.println("............Welcome to Hotel Reservation Program.............");
        Scanner sc = new Scanner(System.in);
        HotelReservation hotelReservation = new HotelReservation();
        Hotelweekdayregular.put("LakeWood",110);
        Hotelweekdayregular.put("BridgeWood",160);
        Hotelweekdayregular.put("RidgeWood",220);
        Hotelweekendregular.put("LakeWood",90);
        Hotelweekendregular.put("BridgeWood",60);
        Hotelweekendregular.put("RidgeWood",150);
        System.out.println("Weekday details "+Hotelweekdayregular);
        System.out.println("Weekend details "+Hotelweekendregular);
        System.out.println("Enter date of the Customer");
        int date = sc.nextInt();
        System.out.println("Enter month of the Customer");
        String month = sc.next();
    }



}
