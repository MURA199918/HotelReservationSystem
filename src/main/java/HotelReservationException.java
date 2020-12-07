public class HotelReservationException extends Exception{
    public enum ExceptionType{
        ENTERED_INVALID
    }
    public ExceptionType type;
    public HotelReservationException(ExceptionType type, String message){
        super(message);
        this.type=type;
    }
}
