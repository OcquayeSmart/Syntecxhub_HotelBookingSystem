import java.util.List;

public class Room {
    int roomNumber;
    RoomType type;
    double price;
    boolean isAvailable;

    public Room(int roomNumber, RoomType type, double price, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String toCSV(){
        return roomNumber + "," + type + "," + price + "," + isAvailable;
    }
    public static Room fromCSV(String line){
        String[] parts = line.split(",");
        int roomNumber = Integer.parseInt(parts[0]);
        String roomType = parts[1];
        double price = Double.parseDouble(parts[2]);
        boolean isAvailable = Boolean.parseBoolean(parts[3]);
        return new Room(roomNumber, RoomType.valueOf(roomType),price, isAvailable);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", type=" + type +
                ", rooMPrice=" + price +
                '}';
    }
}
