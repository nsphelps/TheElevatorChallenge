# TheElevatorChallenge
## Overview
The Elevator Challenge is a coding exercise that simulates the functionality of an elevator within a multi-story building.

## Project Structure
The initial design approach is straightforward. Rather than make assumptions about the starting position of the user and the elevator, the program initializes both the elevator and the user on random floors between 0 and 5 (where 0 represents the ground floor). This accounts for scenarios where a user might take the stairs or had previously entered the building before the program runs. 

When the user's rider successfully moves from one floor to another, a new rider is generated for the user on a random floor and is prompted to select a new requested floor. 

## Directions
* Input a number between 0 - 5 to travel between floors.
* Enter -1 to exit the program.
* Entering an invalid input (i.e. char, string, etc) will result in the program exiting.
  
## Assumptions
* There is only a single rider (I am working to build out a method for generating new 'npc' riders at each floor that will have their own requested destinations to travel to. 
* The elevator can only move in a single direction at a time
* There is a limited number of floors in the building
* There are no basement / underground floors 

# v1.1
* Added some additional error handling
* Added some additional flavor to the beginning of the program
* Separated some functions our of the main function and created / modified some methods in the Rider and Elevator classes
* Added feature to simulate pauses when elevator travels between floors and when loading and unloading riders.
* Seperated out the different classes for readability

# v1.0
## Classes
1. Rider Class
      * Responsible for initializing new riders with a starting floor.
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
     * Initializes the rider's starting floor randomly and creates a new rider object.
     * Initiates a continuous loop that generates new riders and moves them to their desired floors until the user enters "-1" as a requested floor, ending the program.
       
## Future Enhancements
* Checks to ensure elevator doors are open / closed when loading / unloading riders.
* Timing mechanism between messages to more accurately simulate the experience of using an elevator (i.e. pause between 'dings', doors opening, etc.).
* Simulate multiple riders with random starting floors / floor requests.
* System to track pending calls to the elevator.
* A 'nearest floor' instead of FIFO for loading / unloading riders.
* System for tracking number of riders currently in the elevator and give error message if too many riders are in at once.
