public class Rooms {
    int roomNumber;
    RoomType type;
    double roomPrice;
    boolean isAvailable;

    public Rooms(int roomNumber, RoomType type, double rooMPrice, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.roomPrice = rooMPrice;
        this.isAvailable = isAvailable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", type=" + type +
                ", rooMPrice=" + roomPrice +
                '}';
    }
}
