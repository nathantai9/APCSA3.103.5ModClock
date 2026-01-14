import java.util.Scanner;
public class ModClock {
    
  public static String formatMinutes(int minutes) {
    // Adds a leading zero only when necessary. formatMinutes(9) -> "09" and formatMinutes(10) -> "10"
    // convert int minutes to double. For example, 9 -> 9.0
    double minutesDouble = minutes;
    // DONE multiply by 0.1 so there's a leading zero when needed. 9.0 -> 0.9
    minutesDouble *= 0.1;
    // DONE convert from double to String. 0.9 -> "0.9"
    String minutesString = Double.toString(minutesDouble);
    // use substring to extract only the two digits we need. "0.9" -> "09"
    return minutesString.substring(0,1) + minutesString.substring(2,3);
    // Credit to Conlan D. for the above awesome hack that adds a leading zero without if-statement!
  }

  public static String calculateFutureTime(int currentHour, int currentMinute, int hoursLater, int minutesLater) {
    // DONE convert everything to minutes, add all the minutes together, then convert back to hours and minutes using int division and modulus
    int totalMinutes = currentHour * 60 + currentMinute + hoursLater * 60 + minutesLater;
    int futureHour = (totalMinutes / 60) % 24;
    int futureMinute = totalMinutes % 60;
    // DONE use the formatMinutes method to make sure that the minutes has a leading zero, if needed
    return futureHour + ":" + formatMinutes(futureMinute);
  }

  
  public static void main(String[] args) {
    // Input current time
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please input current hour: ");
    // DONE get the user input
    int currentHour = scanner.nextInt();
    System.out.print("Please input current minute: ");
    // DONE get the user input
    int currentMinute = scanner.nextInt();
    // Input hours and minutes to add
    System.out.print("Please input number of hours later: ");
    // DONE get the user input
    int hoursLater = scanner.nextInt();
    System.out.print("Please input number of minutes later: ");
    // DONE get the user input
    int minutesLater = scanner.nextInt();
    // DONE Calculate future time using the methods above
    String futureTime = calculateFutureTime(currentHour, currentMinute, hoursLater, minutesLater);
    // DONE Display current and future time
    System.out.println("Current time = " + currentHour + ":" + formatMinutes(currentMinute)); 
    System.out.println("Future time = " + futureTime);
    scanner.close();
  }
}