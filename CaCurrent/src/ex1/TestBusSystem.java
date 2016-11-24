package ex1;

import Services.ServicesM;
import java.util.Scanner;

public class TestBusSystem {

    static ServicesM jpas = new ServicesM();

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Scanner in = new Scanner(System.in);

        boolean stayInLoop;
        stayInLoop = true;

        int userChoice = 0;

//        int userMenuChoice = 0;
//        
//        int adminMenuChoice = 0;
        /////START OF MENUS///
        while (stayInLoop == true) {

            System.out.println("Welcome to CC bus timetable System");
            System.out.println("Press 1 for User Log in");
            System.out.println("Press 2 for Admin Log in");
            System.out.println("Press 3 to exit");
            System.out.print("Please pick an option: ");
            userChoice = in.nextInt();

            switch (userChoice) {

                case 1:
                    userMenu();
                    stayInLoop = false;
                    break;

                case 2:
                    adminMenu();
                    stayInLoop = false;
                    break;
                case 3:
                    stayInLoop = false;
                    System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                    break;
                default:
                    stayInLoop = true;
                    System.out.println("Invalid option. Please try again.");
                    System.out.println("\n");
                    break;
            }
        }
    }

            //////START OF USER MENU//////
    public static void userMenu() {
        
        Scanner in = new Scanner(System.in);
        boolean userMenuLoop;
        userMenuLoop = true;
        while (userMenuLoop == true) {

            System.out.println("\n" + "User menu : ");
            System.out.println("Press 1 to view a route's details");
            System.out.println("Press 2 to view a route's timetables");
            System.out.println("Press 3 to view the different buses that operate on a route");
            System.out.println("Press 4 for");
            System.out.println("Press 5 to exit");
            int userMenuChoice = in.nextInt();

            switch (userMenuChoice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option please try again");
                    break;
            }
        }
    } 
    
           //////END OF USER MENU//////
      
    
    
    
    
           //////START OF ADMIN MENU//////
    public static void adminMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("\n" + "------Admin menu------");
        System.out.println("Press 1 for route options");
        System.out.println("Press 2 for Timetable options ");
        System.out.println("Press 3 for Bus options ");
        System.out.println("Press 4 for Fare options");
        System.out.println("Press 5 to exit");
        System.out.print(": ");

        int adminOption = in.nextInt();

        switch (adminOption) {
            case 1:
                /*Menu to chose admin option*/
                boolean stayInRouteLoop = true;
                while(stayInRouteLoop == true){
                System.out.println("\n" + "Admin Menu: ");
                System.out.println("------Route Options------");
                System.out.println("Press 1 to remove a route");
                System.out.println("Press 2 to add a route");
                System.out.println("Press 3 to update a route's journey time");
                System.out.println("Press 4 to return to last menu");
                System.out.println("Press 5 to exit");
                System.out.print(": ");
                int routeOption = in.nextInt();

                /*Route options*/
                switch (routeOption) {

                    case 1:
                        /*Delete Route*/
                        System.out.println("Please enter the id of the route you wish to delete: ");
                        int idDeleteR = in.nextInt();
                        in.nextLine();
                        if (!jpas.findRoute(idDeleteR)) {
                            System.out.println("Entity not found");
                        } else {
                            jpas.removeRoute(idDeleteR);
                            System.out.println("Route " + idDeleteR + " has been removed");
                        }
                        break;
                    case 2:
                        /*Add Route*/
                        System.out.println("Please enter the route number of the route you wish to add: ");
                        int routeNumAdd = in.nextInt();

                        System.out.println("Please enter the first stop of the route you wish to add: ");
                        in.nextLine();
                        String firstAdd = in.nextLine();

                        System.out.println("Please enter the last stop of the route you wish to add: ");
                        String lastAdd = in.nextLine();

                        System.out.println("Please enter the journey time of the route you wish to add: ");
                        String timeAdd = in.nextLine();

                        System.out.println("Please enter the number of stops of the route you wish to add: ");
                        int numStopsAdd = in.nextInt();

                        jpas.createRoute(routeNumAdd, firstAdd, lastAdd, timeAdd, numStopsAdd);
                        
                        System.out.println("\n" + "Your new route has now been created.");
                        break;
                    case 3:
                        /*Update Route*/
                        System.out.println("Please enter the id of the route you wish to update the journey time of:");
                        int rid = in.nextInt();
                        in.nextLine();
                        if (!jpas.findRoute(rid)) {
                            System.out.println("Entity not found");
                        } else {
                            System.out.println("Please enter the journey time for Route " + rid + ": ");
                            String newJtime = in.nextLine();
                            jpas.updateRouteJourneyTime(rid, newJtime);
                            System.out.println("Route " + rid + " has been updated");
                        }
                        break;
                    case 4:
                        adminMenu();
                        break;
                    case 5:
                        System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                        System.exit(0);
                        break;
                }
                }

                break;
            case 2:
                /*Timetable Options*/
                boolean stayInTimeLoop = true;
                while(stayInTimeLoop == true){
                System.out.println("\n" + "Admin Menu: ");
                System.out.println("----Timetable Options----");
                System.out.println("Press 1 to remove a timetable");
                System.out.println("Press 2 to add a timetable");
                System.out.println("Press 3 to update a timetable's frequency");
                System.out.println("Press 4 to return to last menu");
                System.out.println("Press 5 to exit");
                System.out.print(": ");
                int timetableOption = in.nextInt();

                switch (timetableOption) {

                    case 1:
                        /*Delete Timetable*/
                        System.out.println("Please enter the id of the timetable you wish to delete: ");
                        int idDeleteT = in.nextInt();
                        in.nextLine();
                        if (!jpas.findTimetable(idDeleteT)) {
                            System.out.println("Entity not found");
                        } else {
                            jpas.removeTimetable(idDeleteT);
                            System.out.println("Timetable " + idDeleteT + " has been removed");
                        }
                        break;
                    case 2:
                        /*Add Timetable*/
                        System.out.println("Please enter the timetable number of the timetable you wish to add: ");
                        int timetableNumAdd = in.nextInt();

                        System.out.println("Please enter the route number of the timetable you wish to add: ");
                        int routeNoAdd = in.nextInt();

                        System.out.println("Please enter the timetable type of the timetable you wish to add: ");
                        in.nextLine();
                        String tTypeAdd = in.nextLine();

                        System.out.println("Please enter the first journey time of the timetable you wish to add: ");
                        String firstJAdd = in.nextLine();

                        System.out.println("Please enter the last journey time of the timetable you wish to add: ");
                        String lastJAdd = in.nextLine();

                        System.out.println("Please enter the frequency of the timetable you wish to add: ");
                        String freqAdd = in.nextLine();

                        jpas.createTimetable(timetableNumAdd, routeNoAdd, tTypeAdd, firstJAdd, lastJAdd, freqAdd);

                        System.out.println("\n" + "Your new Timetable has now been created");
                        break;
                    case 3:
                        /*Update timetable*/
                        System.out.println("Please enter the id of the timetable you wish to update the frequency time of:");
                        int tid = in.nextInt();

                        in.nextLine();
                        if (!jpas.findTimetable(tid)) {
                            System.out.println("Entity not found");
                        } else {
                            System.out.println("Please enter the new frequency for timetable " + tid + ": ");
                            String newTfreq = in.nextLine();

                            jpas.updateTimetableFrequency(tid, newTfreq);

                            System.out.println("Timetable " + tid + " has been updated");
                        }
                        break;
                    case 4:
                        adminMenu();
                        break;
                    case 5:
                        System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                        System.exit(0);
                        break;
                }
                }

                break;
            case 3:
                boolean stayInBusLoop = true;
                while(stayInBusLoop == true){
                /*Bus Option*/
                System.out.println("\n" + "Admin Menu: ");
                System.out.println("------Bus Options------");
                System.out.println("Press 1 to remove a bus");
                System.out.println("Press 2 to add a bus");
                System.out.println("Press 3 to update a bus's type");
                System.out.println("Press 4 to return to last menu");
                System.out.println("Press 5 to exit");
                System.out.print(": ");
                int busOption = in.nextInt();

                switch (busOption) {

                    case 1:
                        /*Delete Bus*/
                        System.out.println("Please enter the id of the bus you wish to delete: ");
                        int idDeleteB = in.nextInt();

                        in.nextLine();

                        if (!jpas.findBus(idDeleteB)) {
                            System.out.println("Entity not found");
                        } else {
                            jpas.removeBus(idDeleteB);
                            System.out.println("Bus " + idDeleteB + " has been removed");
                        }
                        break;
                    case 2:
                        /*Add Bus*/
                        System.out.println("Please enter the bus number of the bus you wish to add: ");
                        int busIdAdd = in.nextInt();

                        System.out.println("Please enter the capacity of the bus you wish to add: ");
                        int capacityAdd = in.nextInt();

                        System.out.println("Please enter the bus type of the bus you wish to enter: ");
                        in.nextLine();
                        String bTypeAdd = in.nextLine();

                        jpas.createBus(busIdAdd, capacityAdd, bTypeAdd);
                        
                        System.out.println("\n" + "Your new bus has now been created");
                        break;
                    case 3:
                        /*Update Bus*/
                    System.out.println("Please enter the id of the bus you wish to update the type :");
                    int bid = in.nextInt();
                    
                    in.nextLine();
                    
                    if (!jpas.findBus(bid)) 
                    {
                        System.out.println("Entity not found");
                    } 
                    else 
                    {
                        System.out.println("Please enter the new type for bus " + bid + ": ");
                        String newBtype = in.nextLine();
                        
                        jpas.updateBusType(bid, newBtype);
                        
                         System.out.println("Bus " + bid +" has been updated");
                         
                    }
                     break;

                    case 4:
                        adminMenu();
                        break;
                    case 5:
                        System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                        System.exit(0);
                        break;

                }
                }

            case 4:
                /*Admin Option*/
                boolean stayInFareLoop = true;
                while(stayInFareLoop == true){
                System.out.println("\n" + "Admin menu: ");
                System.out.println("------Fare Options------");
                System.out.println("Press 1 to remove fares for a route");
                System.out.println("Press 2 to add fares for a route");
                System.out.println("Press 3 to update fares for a route");
                System.out.println("Press 4 to return to last menu");
                System.out.println("Press 5 to exit");
                System.out.print(": ");
                int fareOption = in.nextInt();

                switch (fareOption) {

                    case 1:
                        /*Delete Fare*/
                        
                        System.out.println("Please enter route number of the fares you wish to delete: ");
                        int idDeleteF = in.nextInt();

                        in.nextLine();
                        if (!jpas.findFare(idDeleteF)) {
                            System.out.println("Entity not found");
                        } else {
                            jpas.removeFare(idDeleteF);
                            System.out.println("Fares have been removed");
                        }
                        break;
                    case 2:
                        /*Add Fare*/
                        System.out.println("Please enter the route number of the fares you wish to add: ");
                        int route_numAdd = in.nextInt();
                        System.out.println("Please enter the child fare for route " + route_numAdd + ": ");
                        double childFare = in.nextDouble();
                        System.out.println("Please enter the student fare for route " + route_numAdd + ": ");
                        double studentFare = in.nextDouble();
                        System.out.println("Please enter the adult fare for route " + route_numAdd + ": ");
                        double adultFare = in.nextDouble();
                        System.out.println("Please enter the oap fare for route " + route_numAdd + ": ");
                        double oapFare = in.nextDouble();

                        jpas.createFare(route_numAdd, childFare, studentFare, adultFare, oapFare);

                        System.out.println("\n" + "Your new fares have now been created");
                        break;
                    case 3:
                        /*Update Fare*/
                        System.out.println("Please enter the id of the route you wish to update the fares for :");
                        int fid = in.nextInt();
                        in.nextLine();
                        if (!jpas.findBus(fid)) {
                            System.out.println("Entity not found");
                        } else {
                            System.out.println("If there is any fare you do not want to change just re-enter the existing value. \n");

                            System.out.println("Please enter the child fare for route " + fid + ": ");
                            double childFareNew = in.nextDouble();

                            System.out.println("Please enter the student fare for route " + fid + ": ");
                            double studentFareNew = in.nextDouble();

                            System.out.println("Please enter the adult fare for route " + fid + ": ");
                            double adultFareNew = in.nextDouble();

                            System.out.println("Please enter the oap fare for route " + fid + ": ");
                            double oapFareNew = in.nextDouble();

                            jpas.updateChildFare(fid, childFareNew);
                            jpas.updateStudentFare(fid, studentFareNew);
                            jpas.updateAdultFare(fid, adultFareNew);
                            jpas.updateOapFare(fid, oapFareNew);
                            
                            System.out.println("Fares for Route " + fid + " have now been updated");
                        }
                        break;
                    case 4:
                        adminMenu();
                        break;
                    case 5:
                        System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                        System.exit(0);
                        break;
                }
                }
                break;
            case 5: 
                       System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                       System.exit(0);
                       break;

        }            //////END OF USER MENU//////
    }
}
