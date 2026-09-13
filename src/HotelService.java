import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private final List<Room> roomsList;
    private final RoomRepository repository;

    public HotelService(List<Room> roomsList, RoomRepository repository) {
        this.roomsList = repository.loadAll();
        this.repository = repository;
    }

    public void addRoom(Room room){
        for(Room singleroom:roomsList){
            if(singleroom.getRoomNumber() == room.getRoomNumber()){
                System.out.println("Room already exists");
                return;
            }
        }
        roomsList.add(room);
        repository.saveAll(roomsList);
        System.out.println("Your room has been added successfully");
    }
    public void removeRoom(int roomNumber){
        Room room = null;
        for(Room singleroom:roomsList){
            if(singleroom.getRoomNumber() == roomNumber){
                room = singleroom;
                break;
            }
        }
        if(room != null){
            roomsList.remove(room);
            repository.saveAll(roomsList);
            System.out.println("Your room has been removed");
        }
        else{
            System.out.println("Your room cannot be found");
        }
    }
    public void bookRoom(int roomNumber){
        Room roomBeenSearched = null;
        for(Room singleroom:roomsList){
            if(singleroom.getRoomNumber() == roomNumber){
                roomBeenSearched = singleroom;
                break;
            }
        }
        if(roomBeenSearched != null && roomBeenSearched.isAvailable()){
            roomBeenSearched.setAvailable(false);
            System.out.println("Room booked successfully, see details below");
            System.out.println(roomBeenSearched);
            repository.saveAll(roomsList);
        }
        else{
            System.out.println("Room is either unavailable or does not exist");
        }

    }
    public void cancelBooking(int roomNumber){
        Room roomBeenSearched = null;
        for(Room singleRoom:roomsList){
            if(singleRoom.getRoomNumber() == roomNumber){
                roomBeenSearched = singleRoom;
                break;
            }
        }
        if(roomBeenSearched != null && !roomBeenSearched.isAvailable()){
            roomBeenSearched.setAvailable(true);
            System.out.println("Booking cancelled successfully, see details below");
            System.out.println(roomBeenSearched);
            repository.saveAll(roomsList);
        }
        else{
            System.out.println("Room is not currently booked or does not exist");
        }

    }
    public void viewAvailableRooms(){
        for(Room singleroom:roomsList){
            if(singleroom.isAvailable()){
                System.out.println(singleroom);
            }
        }
    }
    public void viewAllBookings(){
        for(Room singleroom:roomsList){
            if(!singleroom.isAvailable()){
                System.out.println(singleroom);
            }
        }
    }
    public void viewAllRooms(){
        for(Room singleroom:roomsList){
            System.out.println(singleroom);
        }
    }
}
