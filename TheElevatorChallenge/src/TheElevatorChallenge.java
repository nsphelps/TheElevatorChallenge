import java.util.*;
import java.lang.*;

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
        } catch (InterruptedExcaption e) {
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

public class TheElevatorChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                // Scanner to read in riders requested floor
        Elevator elevator = new Elevator();
        int reqFloor = -1;

        // Program starting greeting and instructions
        System.out.println("Welcome to the Elevator Simulation");
        System.out.println("Available floors include: 0 = ground, 1, 2, 3, 4, 5, -1 to quit");
        System.out.println(" ");

        // Intro block, just a bit of flavor
        System.out.println("You find yourself standing in the beige hallway of a soul crushingly depressing office building.");
        System.out.println("Something isn't right...your mind rages against the bland expressions on the faces of the horribly animated NPCs streaming around you.");
        System.out.println(" ");

        System.out.println("This can't be the joyful, vibrant halls of your cherished Bluestaq!!");
        System.out.println("You scan the hallway and see the dull grey doors of an elevator at the end");
        System.out.println(" ");

        System.out.println("You rush forward not caring if this is an exit or the employee elevator the DBAs play russian roulette with each night.");
        System.out.println("Your fingers frantically hammer the call button, finally the doors slide open and you step inside...");

        // While loop that will continuously generate a new rider at random floors,
        // navigate to those floors, and take them to their destinations until user quits.
        while (true) {
            Rider rider = new Rider();               // Instantiate a new rider object

            // Tell the rider what floor they are currently on and ask where they want to go
            System.out.println("You are currently on floor " + rider.getCurrFloor() + ", which floor would you like to go to?");

            // Verify the user entered a number
            if (sc.hasNextInt()) {
                reqFloor = sc.nextInt();
            } else {
                System.out.println("ERROR: Invalid input");
                return;
            }

            // If requested floor is -1 then quit program
            if (reqFloor == -1) {
                System.out.println("Exiting...");
                break;
            }

            // Call the elevators requestFloor method to verify that it is a valid selection and add it to the
            // requests list
            elevator.setReqFloor(reqFloor);

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
