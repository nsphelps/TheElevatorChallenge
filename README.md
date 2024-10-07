# TheElevatorChallenge
The is a coding challenge to simulate the function of an elevator

# v1.0
My initial design is simple. I didn't wan't to make assumptions about where the user or elevator would be within the building so I initialize the program with the elevator on a random floor between 0 and 5 (0 being the ground floor). The user also begins on a random floor, this is to account for a user taking the stairs or perhaps leaving the building after coming prior to the program running. I created three classes, the Rider class, the Elevator class, and TheElevatorChallenge class which contains the main function. 

The rider class is used to initialize new riders and their starting floor as well as provide a method of getting their current floor. 

The Elevator class initializes new elevator objects with a starting floor and a list used to store requests. The Elevator class also contains methods for validating that a requested floor is legitimate and adding it to the requests list as well as moving the elevator to the rider or requested floor as needed. Finally, 

TheElevatorChallenge class contains the main function which calls the functions to get the elevator's initial, random floor and create a new elevator object as well as begins the main while loop that will continuously generate new riders and move them to various floors until the user enters '-1' to exit the program. 

In future updates I want to add additional functionality. Specifically, I want to add checks to ensure that the doors are open or closed before the elevator moves, I want to add timing between the messages to more accurately simulate the time between outputs from an elevator (i.e. dings, doors open, etc). Finally, I would like to introduce the possibility of additional riders which would require the creation of a "floor" class that might generate a number of random users / requested floor requests. This will also require a way to track pending calls to the elevator and deconflict with calls in the current requests list. 
