import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
    public void Test3ToCheck_CheapandBest_HotelforDateRange(){
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
                System.out.println("Cheapest hotel is LakeWood with rates "+lakewoodrate+" and has rating "+hotelReservation.lrate);
                cheaphotel = "Lakewood";
            }
            else if(bridgewoodrate<lakewoodrate && bridgewoodrate<ridgewoodrate){
                System.out.println("Cheapest hotel is BridgeWood with rates "+bridgewoodrate+" and has rating "+hotelReservation.brate);
                cheaphotel = "Bridgewood";
            }
            else if(ridgewoodrate<lakewoodrate && ridgewoodrate<bridgewoodrate){
                System.out.println("Cheapest hotel is RidgeWood with rates "+ridgewoodrate+" and has rating "+hotelReservation.rrate);
                cheaphotel = "Ridgewood";
            }
            else if(lakewoodrate==bridgewoodrate && lakewoodrate<ridgewoodrate){
                System.out.println("Cheapest hotel is LakeWood and BridgeWood with rates "+lakewoodrate+" and "+bridgewoodrate);
                System.out.println("Cheapest hotel with better rating is BridgeWood with rates "+bridgewoodrate+" and has rating "+hotelReservation.brate);
                cheaphotel = "Bridgewood";
            }
            else if(bridgewoodrate==lakewoodrate && bridgewoodrate<ridgewoodrate){
                System.out.println("Cheapest hotel is LakeWood and BridgeWood with rates "+lakewoodrate+" and "+bridgewoodrate);
                System.out.println("Cheapest hotel with better rating is BridgeWood with rates "+bridgewoodrate+" and has rating "+hotelReservation.brate);
                cheaphotel = "Bridgewood";
            }
            else if(ridgewoodrate==lakewoodrate && ridgewoodrate<bridgewoodrate){
                System.out.println("Cheapest hotel is LakeWood and RidgeWood with rates "+lakewoodrate+" and "+ridgewoodrate);
                System.out.println("Cheapest hotel with better rating is RidgeWood with rates "+ridgewoodrate+" and has rating "+hotelReservation.rrate);
                cheaphotel = "Ridgewood";
            }
            else if(ridgewoodrate<lakewoodrate && ridgewoodrate==bridgewoodrate){
                System.out.println("Cheapest hotel is BridgeWood and RidgeWood with rates "+ridgewoodrate+" and "+bridgewoodrate);
                System.out.println("Cheapest hotel with better rating is RidgeWood with rates "+ridgewoodrate+" and has rating "+hotelReservation.rrate);
                cheaphotel = "Ridgewood";
            }
            else{
                System.out.println("Cheapest hotel is LakeWood, BridgeWood and RidgeWood");
                System.out.println("Cheapest hotel with better rating is RidgeWood with rates "+ridgewoodrate+" and has rating "+hotelReservation.rrate);
                cheaphotel = "Ridgewood";
            }
        }
        catch (Exception e){
            System.out.println("Found Exception");
        }
        Assert.assertEquals("Lakewood",cheaphotel);
    }

    @Test
    public void TesttoAddRatingsforHotel(){
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addweekdayRegular("Lakewood",110);
        hotelReservation.addweekdayRegular("Bridgewood",160);
        hotelReservation.addweekdayRegular("Ridgewood",220);
        hotelReservation.addweekendRegular("Lakewood",90);
        hotelReservation.addweekendRegular("Bridgewood",60);
        hotelReservation.addweekendRegular("Ridgewood",150);
        hotelReservation.printdetails();
        Assert.assertEquals(3,hotelReservation.lrate);
    }

    @Test
    public void TesttofindBestRatedHotelforgivenDates() throws HotelReservationException {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addweekdayRegular("Lakewood",110);
        hotelReservation.addweekdayRegular("Bridgewood",160);
        hotelReservation.addweekdayRegular("Ridgewood",220);
        hotelReservation.addweekendRegular("Lakewood",90);
        hotelReservation.addweekendRegular("Bridgewood",60);
        hotelReservation.addweekendRegular("Ridgewood",150);
        hotelReservation.printdetails();
        ArrayList<Integer> dayvalue = hotelReservation.dayofweek("2 Dec 2020","4 Dec 2020");
        int ridgewoodrate=0;
        String bestratedhotel = "Ridgewood";
        try{
            for(int i=0;i<dayvalue.size();i++){
                if(dayvalue.get(i)>=1 && dayvalue.get(i)<=5){
                    ridgewoodrate+=220;
                }
                else{
                    ridgewoodrate+=150;
                }
            }
        }
        catch (Exception e){
            System.out.println("Found Exception");
        }
        System.out.println("Best rated hotel for given dates is Ridgewood with rates: "+ridgewoodrate+" and has rating "+hotelReservation.rrate);
        Assert.assertEquals("Ridgewood",bestratedhotel);
    }

    @Test
    public void TesttoaddHoteldetailsforRewardCustomers(){
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addweekdayReward("Lakewood",80);
        hotelReservation.addweekdayReward("Bridgewood",110);
        hotelReservation.addweekdayReward("Ridgewood",100);
        hotelReservation.addweekendReward("Lakewood",80);
        hotelReservation.addweekendReward("Bridgewood",50);
        hotelReservation.addweekendReward("Ridgewood",40);
        hotelReservation.printdetails();
        int value = 0;
        for (HashMap.Entry<String,Integer> entry : hotelReservation.Hotelweekdayreward.entrySet()){
            if(entry.getKey().equals("Lakewood")){
                value = entry.getValue();
            }
        }
        Assert.assertEquals(80,value);
    }

    @Test
    public void TestToCheck_CheapandBest_HotelforDateRange_forRegularCustomer(){
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
            String type = hotelReservation.Tyoe("Regular");
            if(type.equals("Regular")){
                final int[] lakewoodrate = {0};
                final int[] bridgewoodrate = {0};
                final int[] ridgewoodrate = {0};
                for(int i=0;i<dayvalue.size();i++){
                    if(dayvalue.get(i)>=1 && dayvalue.get(i)<=5){
                        hotelReservation.Hotelweekdayregular.entrySet().stream().forEach(e->{
                            if(e.getKey().equals("Lakewood")){
                                lakewoodrate[0] += e.getValue();
                            }
                            else if(e.getKey().equals("Bridgewood")){
                                bridgewoodrate[0] += e.getValue();
                            }
                            else{
                                ridgewoodrate[0] += e.getValue();
                            }
                        });
                    }
                    else{
                        hotelReservation.Hotelweekendregular.entrySet().stream().forEach(e->{
                            if(e.getKey().equals("Lakewood")){
                                lakewoodrate[0] += e.getValue();
                            }
                            else if(e.getKey().equals("Bridgewood")){
                                bridgewoodrate[0] += e.getValue();
                            }
                            else{
                                ridgewoodrate[0] += e.getValue();
                            }
                        });
                    }
                }
                if(lakewoodrate[0] < bridgewoodrate[0] && lakewoodrate[0] < ridgewoodrate[0]){
                    System.out.println("Cheapest hotel is LakeWood with rates "+ lakewoodrate[0] +" and has rating "+hotelReservation.lrate);
                    cheaphotel = "Lakewood";
                }
                else if(bridgewoodrate[0] < lakewoodrate[0] && bridgewoodrate[0] < ridgewoodrate[0]){
                    System.out.println("Cheapest hotel is BridgeWood with rates "+ bridgewoodrate[0] +" and has rating "+hotelReservation.brate);
                    cheaphotel = "Bridgewood";
                }
                else if(ridgewoodrate[0] < lakewoodrate[0] && ridgewoodrate[0] < bridgewoodrate[0]){
                    System.out.println("Cheapest hotel is RidgeWood with rates "+ ridgewoodrate[0] +" and has rating "+hotelReservation.rrate);
                    cheaphotel = "Ridgewood";
                }
                else if(lakewoodrate[0] == bridgewoodrate[0] && lakewoodrate[0] < ridgewoodrate[0]){
                    System.out.println("Cheapest hotel is LakeWood and BridgeWood with rates "+ lakewoodrate[0] +" and "+ bridgewoodrate[0]);
                    System.out.println("Cheapest hotel with better rating is BridgeWood with rates "+ bridgewoodrate[0] +" and has rating "+hotelReservation.brate);
                    cheaphotel = "Bridgewood";
                }
                else if(bridgewoodrate[0] == lakewoodrate[0] && bridgewoodrate[0] < ridgewoodrate[0]){
                    System.out.println("Cheapest hotel is LakeWood and BridgeWood with rates "+ lakewoodrate[0] +" and "+ bridgewoodrate[0]);
                    System.out.println("Cheapest hotel with better rating is BridgeWood with rates "+ bridgewoodrate[0] +" and has rating "+hotelReservation.brate);
                    cheaphotel = "Bridgewood";
                }
                else if(ridgewoodrate[0] == lakewoodrate[0] && ridgewoodrate[0] < bridgewoodrate[0]){
                    System.out.println("Cheapest hotel is LakeWood and RidgeWood with rates "+ lakewoodrate[0] +" and "+ ridgewoodrate[0]);
                    System.out.println("Cheapest hotel with better rating is RidgeWood with rates "+ ridgewoodrate[0] +" and has rating "+hotelReservation.rrate);
                    cheaphotel = "Ridgewood";
                }
                else if(ridgewoodrate[0] < lakewoodrate[0] && ridgewoodrate[0] == bridgewoodrate[0]){
                    System.out.println("Cheapest hotel is BridgeWood and RidgeWood with rates "+ ridgewoodrate[0] +" and "+ bridgewoodrate[0]);
                    System.out.println("Cheapest hotel with better rating is RidgeWood with rates "+ ridgewoodrate[0] +" and has rating "+hotelReservation.rrate);
                    cheaphotel = "Ridgewood";
                }
                else{
                    System.out.println("Cheapest hotel is LakeWood, BridgeWood and RidgeWood");
                    System.out.println("Cheapest hotel with better rating is RidgeWood with rates "+ ridgewoodrate[0] +" and has rating "+hotelReservation.rrate);
                    cheaphotel = "Ridgewood";
                }
            }
            else{
                System.out.println("Customer not Regular");
            }
        }
        catch (Exception e){
            //Assert.assertEquals(HotelReservationException.ExceptionType.ENTERED_INVALID,e.type);
            System.out.println("Found Exception");
        }
        Assert.assertEquals("Lakewood",cheaphotel);
    }

}
