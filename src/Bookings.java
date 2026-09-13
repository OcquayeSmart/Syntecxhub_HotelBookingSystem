import java.util.UUID;

public class Bookings {
    String bookingID;
    String guestName;
    int roomNumber;
    String checkInDate;
    String checkOutDate;
    String filePath;

    public Bookings(String guestName, int roomNumber, String checkInDate, String checkOutDate) {
        this.bookingID = UUID.randomUUID().toString().substring(0,8);
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    public String toCSV(){
        return bookingID + guestName + "," + roomNumber + "," + checkInDate + "," + checkOutDate;
    }
    public static Bookings fromCSV(String line){
        String[] parts = line.split(",");
        String bookingID = parts[0];
        String guestName = parts[1];
        int roomNumber = Integer.parseInt(parts[3]);
        String checkInDate = parts[4];
        String checkOutDate = parts[5];
        return new Bookings(guestName, roomNumber, checkInDate, checkOutDate);
    }
    public String getBookingID() {
        return bookingID;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingID='" + bookingID + '\'' +
                ", guestName='" + guestName + '\'' +
                ", roomNumber=" + roomNumber +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                '}';
    }
}
