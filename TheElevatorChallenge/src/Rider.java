import java.util.Random;

// Rider class: contains methods for creating new rider object, getting the riders current floor, and
// moving the rider object from its current location (floor) to the requested floor
public class Rider {
    private int currFloor;  // The users current floor
    private int reqFloor;  // Riders requested floor (destination)

    // Creates a new rider
    public Rider () {
        currFloor = new Random().nextInt(6); // Generate random starting floor for rider
    }

    // Method for getting the riders current floor
    public int getCurrFloor() {
        return currFloor;
    }

    public void setReqFloor(int reqFloor) {
        this.reqFloor = reqFloor;
    }

    public int getReqFloor() {
        return reqFloor;
    }

    public void setRandReqFloor() {
        reqFloor = new Random().nextInt(6);  // Sets a random requested floor, for NPC riders
    }
}
