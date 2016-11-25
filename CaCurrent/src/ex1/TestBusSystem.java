package ex1;

/**
 *
 * @author Shane Cotter X00131736 & Matthew Cleary X00130277
 */
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

        /////START OF MENUS///
        while (stayInLoop == true) {

            System.out.println("\n" + "Welcome to CC bus timetable System");
            System.out.println("Press 1 for User Menu");
            System.out.println("Press 2 for Admin Menu");
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
                    /*Message to be displayed when invalid Main menu option entered*/
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

            System.out.println();
            System.out.println("----------------User Menu----------------");
            System.out.println("Press 1 to view all Routes details");
            System.out.println("Press 2 to view a Route's details");
            System.out.println("Press 3 to view a Route's timetables");
            System.out.println("Press 4 to view the Buses operating on a particular Route");
            System.out.println("Press 5 to view a Route's fares");
            System.out.println("Press 6 to return to the main menu");
            System.out.println("Press 7 to Exit");
            System.out.print(": ");
            int userMenuChoice = in.nextInt();

            switch (userMenuChoice) {
                case 1:
                    jpas.printAllRouteDetails();
                    break;

                case 2:
                    System.out.print("Please enter the Route number you wish to view : ");
                    int id = in.nextInt();
                    jpas.printARoutesDetails(id);
                    break;
                case 3:
                    System.out.print("Please enter the Route number for the Timetable you wish to view : ");
                    int t = in.nextInt();
                    jpas.printTimetable(t);
                    break;
                case 4:
                    System.out.print("Please enter the Route number to view what Buses that operate that Route : ");
                    int brID = in.nextInt();
                    jpas.printBusesOnRoute(brID);
                    break;

                case 5:
                    System.out.print("Please enter the Route number for the Fares you wish to view : ");
                    int fID = in.nextInt();
                    jpas.printFares(fID);
                    break;

                case 6:
                    mainMenu();
                    break;
                case 7:
                    System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                    System.exit(0);
                    break;

                default:
                    /*Message to be displayed when invalid User menu option entered*/
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
        System.out.println("Press 5 to return to the main menu");
        System.out.println("Press 6 to exit");
        System.out.print(": ");

        int adminOption = in.nextInt();

        switch (adminOption) {
            case 1:
                /*Menu to chose admin option*/
                boolean stayInRouteLoop = true;
                while (stayInRouteLoop == true) {
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
                            /*Back to Previous Menu (Admin Menu)*/
                            adminMenu();
                            break;
                        case 5:
                            /*End programme - from Route Options*/
                            System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                            System.exit(0);
                            break;

                        default:
                            /*Message to be displayed when invalid Route menu choice entered*/
                            System.out.println("Invalid option please try again");
                            break;
                    }
                }

                break;
            case 2:
                /*Timetable Options*/
                boolean stayInTimeLoop = true;
                while (stayInTimeLoop == true) {
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

                            /*Test to make sure route number entered matches an existing route number*/
                            while (!jpas.findRoute(routeNoAdd)) {
                                System.out.println("The route number you have entered does not match an existing route");

                                System.out.println("Please enter re-enter a route number that matches an existing route number");
                                routeNoAdd = in.nextInt();
                            }
                            /*                                                                      */

                            System.out.println("Please enter the timetable type of the timetable you wish to add: ");
                            in.nextLine();
                            String tTypeAdd = in.nextLine();

                            System.out.println("Please enter the first journey time of the timetable you wish to add: ");
                            String firstJAdd = in.nextLine();

                            System.out.println("Please enter the last journey time of the timetable you wish to add: ");
                            String lastJAdd = in.nextLine();

                            System.out.println("Please enter the frequency of the timetable you wish to add: ");
                            String freqAdd = in.nextLine();

                            /*No addTimetableToRoute method is called as there is enough info to do this in createTimetable()*/
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
                            /*Back to Previous Menu (Admin Menu)*/
                            adminMenu();
                            break;
                        case 5:
                            /*End programme - from Timetable Options*/
                            System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                            System.exit(0);
                            break;

                        default:
                            /*Message to be displayed when invalid Timetable menu option entered*/
                            System.out.println("Invalid option please try again");
                            break;
                    }
                }

                break;

            case 3:

                /*Bus Options*/
                boolean stayInBusLoop = true;
                while (stayInBusLoop == true) {

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

                            /*Route number is read in from user in order to add a bus to a Route*/
                            System.out.println("Please pick a route number that your new bus will operate on");
                            int busRouteNum = in.nextInt();

                            while (!jpas.findRoute(busRouteNum)) {
                                System.out.println("The route number you have entered does not match an existing route");

                                System.out.println("Please enter re-enter a route number that matches an existing route number");
                                busRouteNum = in.nextInt();
                            }

                            Bus b = jpas.createBus(busIdAdd, capacityAdd, bTypeAdd);

                            /*Method being called to add the new bus to the route chosen by user*/
                            jpas.addBusToRoute(busRouteNum, b);

                            System.out.println("\n" + "Your new bus has now been created");
                            break;
                        case 3:
                            /*Update Bus*/
                            System.out.println("Please enter the id of the bus you wish to update the type :");
                            int bid = in.nextInt();

                            in.nextLine();

                            if (!jpas.findBus(bid)) {
                                System.out.println("Entity not found");
                            } else {
                                System.out.println("Please enter the new type for bus " + bid + ": ");
                                String newBtype = in.nextLine();

                                jpas.updateBusType(bid, newBtype);

                                System.out.println("Bus " + bid + " has been updated");

                            }
                            break;

                        case 4:
                            /*Back to Previous Menu (Admin Menu)*/
                            adminMenu();
                            break;
                        case 5:
                            /*End programme - from Bus options Menu*/
                            System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                            System.exit(0);
                            break;

                        default:
                            /*Message to be displayed when invalid Bus menu option entered*/
                            System.out.println("Invalid option please try again");
                            break;

                    }
                }

            case 4:
                /*Admin Option*/
                boolean stayInFareLoop = true;
                while (stayInFareLoop == true) {
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
                            /*INSIDE THIS ADD FARE METHOD THERE IS A LOT OF CHECKING TO MAKE SURE THE USER DOESNT ENTER A SECOND FARE FOR A ROUTE
                            THIS IS BECAUSE INSIDE THIS METHOD THE FARE CREATED IS ADDED TO TO THE ROUTE SPECIFIED AND ROUTE AND FARE HAVE A ONE TO ONE RELATIONSHIP*/
                            
                            /*Add Fare*/
                            System.out.println("If the route you are adding fares to already has fares created , please delete the existing fares before creating new ones.");
                            System.out.println("Press 1 to continue and add a new fare");
                            System.out.println("Press any other number to go back to the admin menu and delete exisiting fares first");
                            int addRouteChoice = in.nextInt();
                            
                            if(addRouteChoice == 1){
                            System.out.println("Please enter the route number of the fares you wish to add: ");
                            int route_numAdd = in.nextInt();

                            /*Test to make sure route number entered matches an existing route*/
                            while (!jpas.findRoute(route_numAdd)) {
                                System.out.println("The route you have entered does not match an existing route");

                                System.out.println("Please enter re-enter a route number that matches an existing route number");
                                route_numAdd = in.nextInt();
                            }

                            System.out.println("Please enter the child fare for route " + route_numAdd + ": ");
                            double childFare = in.nextDouble();
                            System.out.println("Please enter the student fare for route " + route_numAdd + ": ");
                            double studentFare = in.nextDouble();
                            System.out.println("Please enter the adult fare for route " + route_numAdd + ": ");
                            double adultFare = in.nextDouble();
                            System.out.println("Please enter the oap fare for route " + route_numAdd + ": ");
                            double oapFare = in.nextDouble();

                            Fare f = jpas.createFare(route_numAdd, childFare, studentFare, adultFare, oapFare);

                            /*addFareToRoute is called to set the fare create as the active fare on the route specified above*/
                            jpas.addFareToRoute(route_numAdd, f);

                            System.out.println("\n" + "Your new fares have now been created");
                            }
                            else{
                                
                                adminMenu();
                            }
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
                            /*Back to Previous Menu (Admin Menu)*/
                            adminMenu();
                            break;
                        case 5:
                            /*End programme - from Fare Options*/
                            System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                            System.exit(0);
                            break;

                        default:
                            /*Message to be displayed when invalid Fare menu option entered*/
                            System.out.println("Invalid option please try again");
                            break;
                    }
                }
                break;
            case 5:
                /*Back to main Menu - from Admin Menu*/
                mainMenu();
                break;
            case 6:
                /*End Programme - from Admin Menu*/
                System.out.println("\n" + "Thank you for using our bus timetable system" + "\n" + "Goodbye");
                System.exit(0);
                break;

            default:
                /*Message to be displayed when invalid Admin menu choice entered*/
                System.out.println("Invalid option please try again.");
                break;

        }            //////END OF ADMIN MENU//////
    }
}
