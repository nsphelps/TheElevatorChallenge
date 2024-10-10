import java.util.*;
import java.lang.*;

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
