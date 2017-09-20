
import java.util.*;
import java.lang.*;

public class Adventure {
    public static void main(String[] args) {
        System.out.println("Welcome to the Adventure Game!\nPlease enter 'go' followed by a direction (north, south, east, or west) to move locations. " +
                "Enter 'inventory' to view inventory list, or 'quit' to quit the game.");
        String LOCATION = "You are at location %d,%d\n";
        int rowLoc = 0;
        int colLoc = 0;
        Scanner input = new Scanner(System.in);

        String command;
        //prompt user for input. only prompt the first time
        System.out.println("Please enter a valid command: ");


        do {
            //make input all lowercase
            command = input.nextLine().toLowerCase();
            //if command is go then there will be movement
            //first letter will be checked for each input
            if(command.startsWith("g"))
            {
                //string used to split command from direction
                String[] temp;
                //used as delimiter
                String space = " ";
                temp = command.split(space);
                String direction = " ";
                // Error checking. only split string if there is a space in the
                // user input, followed by another character. otherwise there
                // will be an exception because it will try to split the string,
                // but there isn't anything for the second part of the string.
                // This problem will only happen if the first letter is g
                if(temp.length > 1) {
                    //command will be first part of string (go, inventory, quit)
                    command = temp[0];
                    //direction is second part of split string
                    direction = temp[1];
                }
                else {
                    System.out.println("Invalid command. If entering 'go', " +
                            "please also enter a direction.");
                }
                //movement could include
                //north
                if(direction.startsWith("n")) {
                    //check row to see if inbounds
                    if (rowLoc == 0)
                        System.out.println("You can't go that far north.");
                    else {
                        //if inbounds subtract one from row
                        rowLoc--;
                        //print location statement along with coordinates
                        System.out.println("Moving north...");
                        System.out.printf(LOCATION, rowLoc, colLoc);
                    }
                }
                //south
                else if(direction.startsWith("s")) {
                    //check row to see if inbounds
                    if (rowLoc == 4)
                        System.out.println(("You can't go that far south."));
                    else {
                        rowLoc++;
                        System.out.println("Moving south...");
                        System.out.printf(LOCATION, rowLoc, colLoc);
                    }
                }
                //east
                else if(direction.startsWith("e")) {
                    //check col to see if inbounds
                    if(colLoc == 4)
                        System.out.println(("You can't go that far east."));
                    else {
                        colLoc++;
                        System.out.println("Moving east...");
                        System.out.printf(LOCATION, rowLoc, colLoc);
                    }
                }
                //west
                else if(direction.startsWith("w"))
                {
                    //check col to see if inbounds
                    if(colLoc == 0)
                        System.out.println("You can't go that far west.");
                    else {
                        colLoc--;
                        System.out.println("Moving west...");
                        System.out.printf(LOCATION, rowLoc, colLoc);
                    }
                }
                else if(direction != " "){
                    System.out.println("You can't go that way.");
                    System.out.printf(LOCATION, rowLoc, colLoc);
                }
            }
            //list inventory
            else if(command.startsWith("i"))
            {
                System.out.println("You are carrying:");
                System.out.println("brass lantern\nrope\nrations\nstaff");
                System.out.printf(LOCATION, rowLoc, colLoc);
            }
            //if q is first letter, print farewell statement and break
            else if(command.startsWith("q"))
            {
                System.out.println("Farewell");
                System.out.printf(LOCATION, rowLoc, colLoc);
                break;
            }

            //still need to fix
            //quit works if q is typed, but not if quit is typed


            else{
                System.out.println("Invalid command: " + command);
            }
        } while(!command.startsWith("q"));//loop until quit is input

    }
}
