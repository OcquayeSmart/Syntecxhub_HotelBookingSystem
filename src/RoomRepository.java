import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private static final String filePath = "rooms.csv";

    public void saveAll(List<Room> listOfRooms){
        try(FileWriter fw = new FileWriter(filePath)){
            fw.write("Room Number, Room type, Room Price, Availability");
            for(Room singleRoom:listOfRooms){
                fw.write(singleRoom.toCSV());
                fw.write("\n");
            }
        }
        catch(IOException e){
            System.out.println("Could not read file");
        }
        catch(Exception e){
            System.out.println("An error occurred");
        }
    }

    public List<Room> loadAll(){
        List<Room> listOfRooms = new ArrayList<>(); //at the start if the file doesn't load, we use a new one
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine()) != null){
                if(!line.trim().isBlank()){
                    listOfRooms.add(Room.fromCSV(line));
                }
            }
        }
        catch(FileNotFoundException e){
            return new ArrayList<>();
        }
        catch(IOException e){
            System.out.println("Could not read file");
        }
        return listOfRooms;
    }
}
