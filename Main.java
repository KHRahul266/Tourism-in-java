//package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class TravelAgency {
    static class Traveller {
        private int id;
        private String name;
        private int age;
        private char gender;
        private int cost;
        private int days;
        private String hotelName;
        private String destination;
        private String flightName;
        private float departureTime;
        private String shift;

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public char getGender() { return gender; }
        public void setGender(char gender) { this.gender = gender; }
        public int getCost() { return cost; }
        public void setCost(int cost) { this.cost = cost; }
        public int getDays() { return days; }
        public void setDays(int days) { this.days = days; }
        public String getHotelName() { return hotelName; }
        public void setHotelName(String hotelName) { this.hotelName = hotelName; }
        public String getDestination() { return destination; }
        public void setDestination(String destination) { this.destination = destination; }
        public String getFlightName() { return flightName; }
        public void setFlightName(String flightName) { this.flightName = flightName; }
        public float getDepartureTime() { return departureTime; }
        public void setDepartureTime(float departureTime) { this.departureTime = departureTime; }
        public String getShift() { return shift; }
        public void setShift(String shift) { this.shift = shift; }

        public void setFlight(String flightName, int cost, float departureTime, String shift) {
            this.flightName = flightName;
            this.cost += cost;
            this.departureTime = departureTime;
            this.shift = shift;
        }

        public void setHotel(int choice, int days) {
            this.days = days;
            switch (choice) {
                case 1: this.cost += days * 20000; this.hotelName = "PAN PACIFIC SONARGAON"; break;
                case 2: this.cost += days * 19500; this.hotelName = "INTERCONTINENTAL DHAKA"; break;
                case 3: this.cost += days * 17000; this.hotelName = "THE WESTIN DHAKA"; break;
                case 4: this.cost += days * 17500; this.hotelName = "RADISSON BLU WARTE GARDEN HOTEL"; break;
                case 5: this.cost += days * 18000; this.hotelName = "LE MERIDIEN"; break;
                case 6: this.cost += days * 16000; this.hotelName = "HOTEL SARINA"; break;
                case 7: this.cost += days * 16500; this.hotelName = "SEAGULL HOTEL LIMITED"; break;
                case 8: this.cost += days * 15000; this.hotelName = "SEA PEARL BEACH RESORT"; break;
                case 9: this.cost += days * 15500; this.hotelName = "DOREEN HOTELS & RESORTS"; break;
                case 10: this.cost += days * 18500; this.hotelName = "THE PALACE LUXURY RESORT"; break;
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Traveller> travellers = new ArrayList<>();
    static int d, m, y;
    static int d1, m1, y1;

    public static void main(String[] args) {
        welcomeMessage();
        menu();
    }

    public static void welcomeMessage() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t*****************************************************");
        System.out.println("\t\t\t\t\t\t*********                                  *********");
        System.out.println("\t\t\t\t\t\t********   Welcome to the Travel Agency   ********");
        System.out.println("\t\t\t\t\t\t*******                                  *******");
        System.out.println("\t\t\t\t\t\t******  We are here to assist you       ******");
        System.out.println("\t\t\t\t\t\t*****    with your travel plans.       *****");
        System.out.println("\t\t\t\t\t\t****                                  ****");
        System.out.println("\t\t\t\t\t\t***        Enjoy your journey!       ***");
        System.out.println("\t\t\t\t\t\t**                                  **");
        System.out.println("\t\t\t\t\t\t************************************");
        System.out.println("\n\n\n\t\t\t\t\t\t      ** Please Enter to Continue.....**     ");
        scanner.nextLine();
    }

    public static void menu() {
        while (true) {
            System.out.println("\n\tMENU :");
            System.out.println("\n\t1. CHOOSE DESTINATION \n\t2. GENERATE BILL\n\t3. EXIT\n\tENTER CHOICE : ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: chooseDestination(); break;
                case 2: printDetails(); break;
                case 3: System.exit(0); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void chooseDestination() {
        System.out.println("\n\t DESTINATION :");
        System.out.println("\n\t 1. Khagrasory");
        System.out.println("\n\t 2. Bandarban");
        System.out.println("\n\t 3. Rajshahi");
        System.out.println("\n\t 4. Chittagong");
        System.out.println("\n\t 5. Khulna");
        System.out.println("\n\t 6. Rangamati");
        System.out.println("\n\t 7. Bogura");
        System.out.print("\n\t ENTER CHOICE : ");
        int choice = scanner.nextInt();
        input(choice);
    }

    public static void input(int destinationChoice) {
        System.out.print("\n\t\t ENTER NO. OF PEOPLE: ");
        int cnt = scanner.nextInt();
        for (int x = 0; x < cnt; x++) {
            System.out.printf("\n\t\t ENTER %d PERSON DETAILS\n", x + 1);
            Traveller traveller = new Traveller();
            setTravellerDetails(traveller, destinationChoice);
            flights(traveller);
            hotels(traveller);
            travellers.add(traveller);
        }
        printTickets();
    }

    public static void setTravellerDetails(Traveller traveller, int destinationChoice) {
        traveller.setDestination(getDestinationName(destinationChoice));
        System.out.print("\n\t TRAVEL ID (1-100): ");
        int id = scanner.nextInt();
        while (check(id)) {
            System.out.print("\n\t ID ALREADY EXISTS! CHOOSE ANOTHER ID: ");
            id = scanner.nextInt();
        }
        traveller.setId(id);
        System.out.print("\n\t ENTER NAME, AGE, GENDER (M/F):\n");
        scanner.nextLine(); // Consume newline
        System.out.print("\t NAME: ");
        traveller.setName(scanner.nextLine());
        System.out.print("\t AGE: ");
        traveller.setAge(scanner.nextInt());
        System.out.print("\t GENDER: ");
        traveller.setGender(scanner.next().charAt(0));
    }

    public static String getDestinationName(int destinationChoice) {
        switch (destinationChoice) {
            case 1: return "Khagrasory";
            case 2: return "Bandarban";
            case 3: return "Rajshahi";
            case 4: return "Chittagong";
            case 5: return "Khulna";
            case 6: return "Rangamati";
            case 7: return "Bogura";
            default: return "Unknown";
        }
    }

    public static boolean check(int id) {
        for (Traveller traveller : travellers) {
            if (traveller.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void flights(Traveller traveller) {
        System.out.println("\n\n\t\t FLIGHTS AVAILABLE : ");
        System.out.println("\n    1. BIMAN AI:        DEPARTURE : 6.00 AM  PRICE : 14,000 TK");
        System.out.println("    2. US-BANGLA:       DEPARTURE : 9.00 AM  PRICE : 15,000 TK");
        System.out.println("    3. QATAR AIRWAYS :  DEPARTURE : 1.00 PM  PRICE : 14,500 TK");
        System.out.println("    4. NOVIAIR:         DEPARTURE : 5.00 PM  PRICE : 13,000 TK");
        System.out.println("    5. SAUDIA :         DEPARTURE : 9.00 PM  PRICE : 13,500 TK");
        System.out.print("\n\t ENTER CHOICE :  ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: traveller.setFlight("BIMAN AI", 14000, 6.00f, "AM"); break;
            case 2: traveller.setFlight("US-BANGLA", 15000, 9.00f, "AM"); break;
            case 3: traveller.setFlight("QATAR AIRWAYS", 14500, 1.00f, "PM"); break;
            case 4: traveller.setFlight("NOVIAIR", 13000, 5.00f, "PM"); break;
            case 5: traveller.setFlight("SAUDIA", 13500, 9.00f, "PM"); break;
            default: System.out.println("Invalid choice. Default flight selected."); traveller.setFlight("DEFAULT FLIGHT", 0, 0.00f, ""); break;
        }
    }

    public static void hotels(Traveller traveller) {
        System.out.println("\n\n\t\t HOTELS AVAILABLE : ");
        System.out.println("\n   1. PAN PACIFIC SONARGAON        COST : 20,000 TK/DAY");
        System.out.println("   2. INTERCONTINENTAL DHAKA       COST : 19,500 TK/DAY");
        System.out.println("   3. THE WESTIN DHAKA             COST : 17,000 TK/DAY");
        System.out.println("   4. RADISSON BLU WARTE GARDEN    COST : 17,500 TK/DAY");
        System.out.println("   5. LE MERIDIEN                  COST : 18,000 TK/DAY");
        System.out.println("   6. HOTEL SARINA                 COST : 16,000 TK/DAY");
        System.out.println("   7. SEAGULL HOTEL LIMITED        COST : 16,500 TK/DAY");
        System.out.println("   8. SEA PEARL BEACH RESORT       COST : 15,000 TK/DAY");
        System.out.println("   9. DOREEN HOTELS & RESORTS      COST : 15,500 TK/DAY");
        System.out.println("   10. THE PALACE LUXURY RESORT    COST : 18,500 TK/DAY");
        System.out.print("\n\t ENTER CHOICE : ");
        int choice = scanner.nextInt();
        System.out.print("\n\t ENTER NUMBER OF DAYS : ");
        int days = scanner.nextInt();
        traveller.setHotel(choice, days);
        System.out.println("\n\tENTER CHECK-IN DATE (DD MM YYYY): ");
        d = scanner.nextInt();
        m = scanner.nextInt();
        y = scanner.nextInt();
        System.out.println("\n\tENTER CHECK-OUT DATE (DD MM YYYY): ");
        d1 = scanner.nextInt();
        m1 = scanner.nextInt();
        y1 = scanner.nextInt();
    }

    public static void printDetails() {
        System.out.print("\n\tEnter your ID: ");
        int id = scanner.nextInt();
        Traveller foundTraveller = null;
        for (Traveller traveller : travellers) {
            if (traveller.getId() == id) {
                foundTraveller = traveller;
                break;
            }
        }
        if (foundTraveller != null) {
            System.out.println("\n\tYOUR DETAILS:");
            System.out.printf("\n\tID : %d", foundTraveller.getId());
            System.out.printf("\n\tNAME : %s\t\t HOTEL NAME : %s ", foundTraveller.getName(), foundTraveller.getHotelName());
            System.out.printf("\n\tAGE : \t%d\t\t CHECKIN : %d/%d/%d ", foundTraveller.getAge(), d, m, y);
            System.out.printf("\n\tGENDER : %c\t \t CHECKOUT : %d/%d/%d", foundTraveller.getGender(), d1, m1, y1);
            System.out.printf("\n\tDESTINATION : %s", foundTraveller.getDestination());
            System.out.printf("\n\tFLIGHT NAME : %s", foundTraveller.getFlightName());
            System.out.printf("\n\tDEPARTURE TIME : %.2f %s", foundTraveller.getDepartureTime(), foundTraveller.getShift());
            System.out.printf("\n\tTOTAL COST : %d\n", foundTraveller.getCost());
            System.out.println("\n\tPress enter to continue .....");
            scanner.nextLine();
            scanner.nextLine();
        } else {
            System.out.println("\nNo details found for the given ID.");
            System.out.println("\nPress enter to continue .....");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    public static void printTickets() {
        System.out.println("\n\n\t YOUR TICKET:");
        for (Traveller traveller : travellers) {
            System.out.printf("\n\n\tID : %d", traveller.getId());
            System.out.printf("\n\tNAME : %s\t\t HOTEL NAME : %s ", traveller.getName(), traveller.getHotelName());
            System.out.printf("\n\tAGE : \t%d\t\t CHECKIN : %d/%d/%d ", traveller.getAge(), d, m, y);
            System.out.printf("\n\tGENDER : %c\t \t CHECKOUT : %d/%d/%d", traveller.getGender(), d1, m1, y1);
            System.out.printf("\n\tDESTINATION : %s", traveller.getDestination());
            System.out.printf("\n\tFLIGHT NAME : %s", traveller.getFlightName());
            System.out.printf("\n\tDEPARTURE TIME : %.2f %s", traveller.getDepartureTime(), traveller.getShift());
        }
        int totalCost = travellers.stream().mapToInt(Traveller::getCost).sum();
        System.out.printf("\n\n\t\tTOTAL COST : %d", totalCost);
        System.out.println("\n\n\t\tBOOKING SUCCESSFUL");
        System.out.println("\n\n\t\t   Press enter to go to main menu .....");
        scanner.nextLine();
        scanner.nextLine();
    }
}
