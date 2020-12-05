import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
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
        int value = 0;
        for (HashMap.Entry<String,Integer> entry : hotelReservation.Hotelweekdayregular.entrySet()){
            if(entry.getKey().equals("Lakewood")){
                value = entry.getValue();
            }
        }
        Assert.assertEquals(110,value);
    }

    @Test
    public void Test2ToCheckCheapHotelforGivenDate(){
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addweekdayRegular("Lakewood",110);
        hotelReservation.addweekdayRegular("Bridgewood",160);
        hotelReservation.addweekdayRegular("Ridgewood",220);
        hotelReservation.addweekendRegular("Lakewood",90);
        hotelReservation.addweekendRegular("Bridgewood",60);
        hotelReservation.addweekendRegular("Ridgewood",150);
        hotelReservation.printdetails();
        String cheapesthotel = null;
        try{
            ArrayList<Integer> dayvalue = hotelReservation.dayofweek("16 Mar 2020","17 Mar 2020");
            if(dayvalue.get(0)>=1 && dayvalue.get(0)<=5){
                cheapesthotel = "Lakewood";
            }
            else{
                cheapesthotel = "Bridgewood";
            }
        }
        catch (Exception e){
            System.out.println("Found exception");
        }
        Assert.assertEquals("Lakewood",cheapesthotel);
    }

    @Test
    public void Test3ToCheckHotelforDateRange(){
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addweekdayRegular("Lakewood",110);
        hotelReservation.addweekdayRegular("Bridgewood",160);
        hotelReservation.addweekdayRegular("Ridgewood",220);
        hotelReservation.addweekendRegular("Lakewood",90);
        hotelReservation.addweekendRegular("Bridgewood",60);
        hotelReservation.addweekendRegular("Ridgewood",150);
        hotelReservation.printdetails();
        String cheaphotel = null;
        try{
            ArrayList<Integer> dayvalue = hotelReservation.dayofweek("2 Dec 2020","4 Dec 2020");
            int lakewoodrate=0,bridgewoodrate=0,ridgewoodrate=0;
            for(int i=0;i<dayvalue.size();i++){
                if(dayvalue.get(i)>=1 && dayvalue.get(i)<=5){
                    lakewoodrate+=110;
                    bridgewoodrate+=160;
                    ridgewoodrate+=220;
                }
                else{
                    lakewoodrate+=90;
                    bridgewoodrate+=60;
                    ridgewoodrate+=150;
                }
            }
            if(lakewoodrate<bridgewoodrate && lakewoodrate<ridgewoodrate){
                System.out.println("Cheapest hotel is LakeWood with rates "+lakewoodrate);
                cheaphotel = "Lakewood";
            }
            else if(bridgewoodrate<lakewoodrate && bridgewoodrate<ridgewoodrate){
                System.out.println("Cheapest hotel is BridgeWood with rates "+bridgewoodrate);
            }
            else if(ridgewoodrate<lakewoodrate && ridgewoodrate<bridgewoodrate){
                System.out.println("Cheapest hotel is RidgeWood with rates "+ridgewoodrate);
            }
            else if(lakewoodrate==bridgewoodrate && lakewoodrate<ridgewoodrate){
                System.out.println("Cheapest hotel is LakeWood and BridgeWood with rates "+lakewoodrate+" and "+bridgewoodrate);
            }
            else if(bridgewoodrate==lakewoodrate && bridgewoodrate<ridgewoodrate){
                System.out.println("Cheapest hotel is LakeWood and BridgeWood with rates "+lakewoodrate+" and "+bridgewoodrate);
            }
            else if(ridgewoodrate==lakewoodrate && ridgewoodrate<bridgewoodrate){
                System.out.println("Cheapest hotel is LakeWood and RidgeWood with rates "+lakewoodrate+" and "+ridgewoodrate);
            }
            else if(ridgewoodrate<lakewoodrate && ridgewoodrate==bridgewoodrate){
                System.out.println("Cheapest hotel is BridgeWood and RidgeWood with rates "+ridgewoodrate+" and "+bridgewoodrate);
            }
            else{
                System.out.println("Cheapest hotel is LakeWood, BridgeWood and RidgeWood");
            }
        }
        catch (Exception e){
            System.out.println("Found Exception");
        }
        Assert.assertEquals("Lakewood",cheaphotel);
    }

}
