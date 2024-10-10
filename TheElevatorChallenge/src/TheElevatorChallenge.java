import java.util.*;

// Rider class: contains methods for creating new rider object, getting the riders current floor, and
// moving the rider object from its current location (floor) to the requested floor
class Rider {
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

// Elevator class: contains methods for creating new elevator object, moving to the rider, moving to the
// requested location, and getting the elevators current floor
class Elevator {
    private int currFloor;
    private List<Integer> requests;

    // Method for creating new elevator object with current floor and requests list
    public Elevator(int startingFloor) {
        this.currFloor = startingFloor;
        this.requests= new ArrayList<>();
    }

    // Method for getting elevators current floor
    public int getCurrFloor() {
        return currFloor;
    }

    // Method for adding requested floors to the requests list
    public void requestFloor(int floor) {
        // Verify that the requested floor is within the number of floors available
        if (floor < 0 || floor >  5) {
            System.out.println("Invalid floor request. Please choose a floor between 0 and 5");
            return;
        }

        // If requested floor is not in the request list add it
        if (!requests.contains(floor)) {
            requests.add(floor);
            System.out.println("Requested floor: " + floor);
        }
    }

    // Moves the elevator from its current floor to the riders current floor
    public void moveToRider(int riderLoc) {
        while (currFloor != riderLoc) {     // Checks if elevator and rider are on same floor
            if (currFloor < riderLoc) {     // If elevator is below rider, move elevator up
                currFloor++;
                System.out.println("Elevator going up...ding");
            } else {                        // Otherwise move elevator down
                currFloor--;
                System.out.println("Elevator going down...dong");
            }
        }
        // Block to tell the user that the elevator arrived at the riders floor
        // and the rider is entering the elevtor
        System.out.println("Arrived at floor: " + currFloor);
        System.out.println("Loading rider...");
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
                } else {
                    currFloor--;
                    System.out.println("Going down...dong");
                }
            }
            // This block is really just to suggest that the rider has arrived at their destination
            // and is exiting the elevator
            System.out.println("Arrived at floor " + currFloor);
            System.out.println("Unloading rider...");
            System.out.println(""); // Just a blank line between riders
            requests.remove(0);  // Remove the request once floor is reached
        }
    }
}

public class TheElevatorChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                // Scanner to read in riders requested floor
        int elevatorFloor = new Random().nextInt(6);  // Generates random starting floor for elevator
        Elevator elevator = new Elevator(elevatorFloor);    // Instantiate a new elevator object

        // Program starting greeting and instructions
        System.out.println("Welcome to the Elevator Simulation");
        System.out.println("Available floors include: 0 = ground, 1, 2, 3, 4, 5, -1 to quit");

        // While loop that will continuously generate a new rider at random floors,
        // navigate to those floors, and take them to their destinations until user quits.
        while (true) {
            int riderFloor = new Random().nextInt(6);    // Generate random starting floor for rider
            Rider rider = new Rider(riderFloor);               // Instantiate a new rider object

            // Tell the rider what floor they are currently on and ask where they want to go
            System.out.print("Hello new rider! ");
            System.out.println("You are currently on floor " + rider.getCurrFloor() +
                    ", which floor would you like to go to?");

            // Read users request
            int requestedFloor = sc.nextInt();

            // If requested floor is -1 then quit program
            if (requestedFloor == -1) {
                System.out.println("Exiting...");
                break;
            }

            // Call the elevators requestFloor method to verify that it is a valid selection and add it to the
            // requests list
            elevator.requestFloor(requestedFloor);

            // Check if the elevator and the user are on the same floor
            // If not, move elevator to user
            if (elevator.getCurrFloor() != rider.getCurrFloor()) {
                System.out.println("Elevator is traveling to your location from floor " + elevator.getCurrFloor());
                int riderLoc = rider.getCurrFloor();
                elevator.moveToRider(riderLoc);
            }
            // Travel to the rider's requested floor
            elevator.moveElevator();
        }
        sc.close();
    }
}
