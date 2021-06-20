import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static ArrayList<User> userArrayList;
    static ArrayList<Series> seriesArrayList;

    public static void main(String[] args) {
        seriesArrayList = new ArrayList<>();
        ArrayList<Episode> episode = new ArrayList<>();
        episode.add(new Episode("a","ds"));
        episode.add(new Episode("bc","ddssdsdss"));
        episode.add(new Episode("d","dsds"));
        Series series= new Series("alita",episode);
        Series series1= new Series("letter",episode);
        Series series2= new Series("words",episode);

        seriesArrayList.add(series);
        seriesArrayList.add(series1);
        seriesArrayList.add(series2);
        scanner = new Scanner(System.in);
        userArrayList = new ArrayList<>();
        userChoice();
    }

    private static void loginIn() {
        System.out.println("please enter the user name");
        String userName = scanner.next();
        System.out.println("please enter the password");
        String password = scanner.next();
        for (User user : userArrayList) {
            if (user.getName().equals(userName)) {
                if (user.getPassword().equals(password)) {
                    connectToService(user);
                    break;
                }
            }
        }
        userChoice();
    }

    private static void connectToService(User user) {
        System.out.println("what you want to do?");
        System.out.println("\t1)View the list of all series");
        System.out.println("\t2)View the list of series you started watching");
        System.out.println("\t3)View subscription details");
        System.out.println("\t4)Select a series to watch");
        System.out.println("\t5)logOut");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> viewSeries();
            case 2 -> viewUserSeries(user);
            case 3 -> getDetails(user);
            case 4 -> watchSeries(user);
            case 5 -> userChoice();
            default -> connectToService(user);
        }
    }

    private static void watchSeries(User user) {
        System.out.println("which series do you want?");
        String seriesName = scanner.next();
        for (Series series : seriesArrayList) {
            if (series.getName().equals(seriesName)) {
                for (Episode episode : series.getEpisode()) {
                    System.out.println(episode);
                }
                if (user.getMap().containsKey(series)) {
                    System.out.println(series.getEpisode().get(user.getMap().get(series)));
                }
                System.out.println("which episode do you want to do?");
                String episode = scanner.next();
                for (Episode episode1 : series.getEpisode()) {
                    if (episode1.getName().equals(episode)) {
                        if (user.getMap().containsKey(series)) {
                            int i = user.getMap().get(series);
                            user.getMap().put(series, (i + 1));
                        } else {
                            user.getMap().put(series, 1);
                        }
                    }
                }
            }
        }
        System.out.println("there is no series by that name....");

        connectToService(user);
    }

    private static void getDetails(User user) {
        System.out.println(user.getInitDate());
        System.out.println(user.getExpressionDate());
        System.out.println(user.getSeriesWatched().size());
        int episode = 0;
        for (Series series : user.getSeriesWatched()) {
            episode += series.getEpisode().size();
        }
        System.out.println(episode);
    }

    private static void viewUserSeries(User user) {
        user.userSeries();
    }

    private static void viewSeries() {
        for (Series series : seriesArrayList) {
            System.out.println(series);
        }
    }

    static void createNewAccount() {
        System.out.println("please choose a name for the user:");
        String userName = scanner.next();
        for (User user : userArrayList) {
            if (user.getName().equals(userName)) {
                System.out.println("the user name is already been taken!");
                createNewAccount();
            }
        }
        String password = getPassword();
        userArrayList.add(new User(userName, password));
        userChoice();
    }

    private static String getPassword() {
        boolean number = false, letter = false;
        System.out.println("please choose a password for the user:");
        String password = scanner.next();
        if (password.length() < 6) {
            System.out.println("-*");
            getPassword();
        }
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (currentChar > 64 && currentChar < 91 ||
                    currentChar > 96 && currentChar < 123)
                letter = true;
            else if (currentChar > 47 && currentChar < 58)
                number = true;
        }
        if (!(letter && number)) {
            System.out.println(letter + " " + number);
            getPassword();
        }
        return password;
    }


    private static void userChoice() {
        System.out.println("Welcome to Netflix!");
        int userChoice;
        do {
            System.out.println("Chose the next options:");
            System.out.println("\t1.Create new account");
            System.out.println("\t2.Sign in");
            userChoice = scanner.nextInt();
        } while (userChoice != 1 && userChoice != 2);
        //clear the buffer
        scanner.nextLine();
        switch (userChoice) {
            case 1 -> createNewAccount();
            case 2 -> loginIn();
        }
    }
}