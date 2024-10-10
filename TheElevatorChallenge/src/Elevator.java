import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Elevator class: contains methods for creating new elevator object, moving to the rider, moving to the
// requested location, and getting the elevators current floor
class Elevator {
    private int currFloor;
    private List<Integer> requests;

    // Method for creating new elevator object with current floor and requests list
    public Elevator() {
        currFloor = new Random().nextInt(6);
        requests= new ArrayList<>();
    }

    // Method for getting elevators current floor
    public int getCurrFloor() {
        return currFloor;
    }

    // Method for adding requested floors to the requests list
    public void setReqFloor(int floor) {
        // Verify that the requested floor is within the number of floors available
        if (floor < 0 || floor >  5) {
            System.out.println("Invalid floor request. Please choose a floor between 0 and 5");
            return;
        }

        // If requested floor is not in the request list add it
        if (requests.contains(floor)) {
            System.out.println("Attention! Requested floor: " + floor + " already in queue.");
        } else {
            requests.add(floor);
            System.out.println("Requested floor: " + floor + " added.");
        }
    }

    // Moves the elevator from its current floor to the riders current floor
    public void moveToRider(int riderLoc) {
        while (currFloor != riderLoc) {     // Checks if elevator and rider are on same floor
            if (currFloor < riderLoc) {     // If elevator is below rider, move elevator up
                currFloor++;
                System.out.println("Elevator going up...ding");
                try{
                    // The Thread.sleep blocks are to simulate the pauses between floors traveled, doors open, etc
                    Thread.sleep(1000);  // Thread.sleep pauses the current thread activity for a num of miliseconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else if (currFloor > riderLoc) {                        // Otherwise move elevator down
                currFloor--;
                System.out.println("Elevator going down...dong");
                try{
                    Thread.sleep(1000);  // Thread.sleep pauses the current thread activity for a num of miliseconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println("What luck! The elevator is already on your floor!");
                System.out.println("The doors open and you step inside...");
            }
        }
        // Block to tell the user that the elevator arrived at the riders floor
        // and the rider is entering the elevtor
        System.out.println("Arrived at floor: " + currFloor);
        System.out.println("Loading rider...");
        try {
            Thread.sleep(2000); // simulate time it takes to load new rider
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Restore interruption
        }
    }

    // Moves the rider to their requested floor
    public void moveElevator() {
        while (!requests.isEmpty()) {
            int nextFloor = requests.get(0);

            // While the elevator is not at the requested floor it travels up or down
            // as needed to reach the desired location
            while (currFloor != nextFloor) {
                if (currFloor < nextFloor) {
                    currFloor++;
                    System.out.println("Going up...ding");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    currFloor--;
                    System.out.println("Going down...dong");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            // This block is really just to suggest that the rider has arrived at their destination
            // and is exiting the elevator
            System.out.println("Arrived at floor " + currFloor);
            System.out.println("Unloading rider...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            requests.remove(0);  // Remove the request once floor is reached
            System.out.println(""); // Just a blank line between riders
        }
    }
}