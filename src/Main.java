import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        InputValidation validation = new InputValidation(scanner);
        RoomRepository repository = new RoomRepository();
        HotelService hotelService = new HotelService(new ArrayList<>(), repository);
        HotelMenu menu = new HotelMenu(scanner, validation, hotelService);
        menu.show();
    }
}
