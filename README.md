# TheElevatorChallenge
## Overview
The Elevator Challenge is a coding exercise that simulates the functionality of an elevator within a multi-story building.

# v1.0
## Project Structure
The initial design approach is straightforward. Rather than make assumptions about the starting position of the user and the elevator, the program initializes both the elevator and the user on random floors between 0 and 5 (where 0 represents the ground floor). This accounts for scenarios where a user might take the stairs or had previously entered the building before the program runs. 

# Classes
1. Rider Class
      * Responsible for initializing new riders and their starting floors.
      * Provides a method to retrieve the current floor of the rider.
2. Elevator Class
      * Initializes new elevator objects with a starting floor and maintains a list to store floor requests.
      * Contains methods to:
          * Validate requested floors,
          * Add legitimate requests to the list (if not already there),
          * Move the elevator to the requested floor or to the rider's floor.
3. TheElevatorChallenge Class
     * Contains the main function that orchestrates the program flow.
     * Initializes the elevator's starting floor randomly and creates a new elevator object.
     * Initiates a continuous loop that generates new riders and moves them to their desired floors until the user enters "-1" as a requested floor, ending the program.
       
# Future Enhancements
* Add checks to ensure elevator doors are open / closed when loading / unloading riders.
* Add timing mechanism between messages to more accurately simulate the experience of using an elevator (i.e. pause between 'dings', doors opening, etc.).
* Add multiple riders by creating a method for generating new riders with random starting floors / floor requests.
* Add a system to track pending calls to the elevator.
* Add a 'nearest floor' tracking system for riders (i.e. if multiple users are getting off at a given floor, unload all).
* Add system for tracking number of riders currently in the elevator and give error message if too many riders are in at once.  
