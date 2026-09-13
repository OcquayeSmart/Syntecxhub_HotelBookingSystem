import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;
import java.util.UUID;

public class HotelMenu {
    private final Scanner scanner;
    private final InputValidation validation;
    private final HotelService hotelService;
    boolean isRunning = true;

    public HotelMenu(Scanner scanner, InputValidation validation, HotelService hotelService) {
        this.scanner = scanner;
        this.validation = validation;
        this.hotelService = hotelService;
    }

    public void show(){
        while(isRunning){
            System.out.println("""
HOTEL MANAGEMENT SYSTEM
1. VIEW AVAILABLE ROOMS
2. BOOK A ROOM
3. CANCEL BOOKING
4. VIEW ALL BOOKINGS
5. VIEW ALL ROOMS
0. EXIT
""");
        }
        System.out.println("Enter a choice(0-5): ");
        int userChoice = validation.checkRange(0,5);

        switch(userChoice){
            case 1 -> hotelService.viewAvailableRooms();
            case 2 -> bookroom();
            case 3 -> cancelBooking();
            case 4 -> viewAllBookings();
            case 5 -> hotelService.viewAllRooms();
            case 0 -> isRunning = false;
        }
    }

    private void bookroom(){
        System.out.print("Enter the room number to book: ");
        int roomNumber = validation.checkInt();
        hotelService.bookRoom(roomNumber);
    }

    private void cancelBooking(){
        System.out.print("Enter room number to cancel: ");
        int roomNumber = validation.checkInt();
        hotelService.removeRoom(roomNumber);
    }

    private void viewAllBookings(){
        hotelService.viewAllBookings();
    }

}
