public class Room {

    private int RoomNumber;
    private String RoomType;
    private boolean RoomState;

    public Room() {
    }

    public Room(int roomNumber, boolean roomState, String roomType) {
        RoomNumber = roomNumber;
        RoomState = roomState;
        RoomType = roomType;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public boolean isRoomState() {
        return RoomState;
    }

    public void setRoomState(boolean roomState) {
        RoomState = roomState;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }
}
