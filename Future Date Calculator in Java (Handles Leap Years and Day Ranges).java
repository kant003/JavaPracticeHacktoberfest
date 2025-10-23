import java.util.Scanner;

public class FutureDate {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Input: day number, year, and number of days to add
        System.out.print("DAY NUMBER: ");
        int dayNum = sc.nextInt();
        System.out.print("YEAR: ");
        int year = sc.nextInt();
        System.out.print("DATE AFTER (N DAYS): ");
        int n = sc.nextInt();

        // Validate day number range
        if (dayNum < 1 || dayNum > 366) {
            System.out.println("DAY NUMBER OUT OF RANGE");
            return;
        }

        // Validate 'N' (days to add) range
        if (n < 1 || n > 100) {
            System.out.println("DATE AFTER (N DAYS) OUT OF RANGE");
            return;
        }

        // Array storing days in each month
        int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // Array storing names of the months
        String monthNames[] = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};

        // Check if the given year is a leap year
        boolean leap = false;
        if (year % 400 == 0) leap = true;
        else if (year % 100 == 0) leap = false;
        else if (year % 4 == 0) leap = true;

        // Adjust February for leap years
        if (leap) monthDays[1] = 29;

        // Determine month and date from the given day number
        int i = 0;
        int daySum = 0;
        for (i = 0; i < monthDays.length; i++) {
            daySum += monthDays[i];
            if (daySum >= dayNum)
                break;
        }

        // Calculate actual date
        int date = dayNum + monthDays[i] - daySum;
        String dateStr = date + "TH " + monthNames[i] + ", " + year;

        // Calculate new date after adding N days
        int nDays = dayNum + n;
        int nYear = year;

        // Adjust year if total days exceed year length
        if (leap && nDays > 366) {
            nYear++;
            nDays -= 366;
        } else if (nDays > 365) {
            nYear++;
            nDays -= 365;
        }

        // Check if next year is leap year
        boolean nextLeap = false;
        if (nYear % 400 == 0) nextLeap = true;
        else if (nYear % 100 == 0) nextLeap = false;
        else if (nYear % 4 == 0) nextLeap = true;

        // Adjust February for the next year
        if (nextLeap) monthDays[1] = 29;
        else monthDays[1] = 28;

        // Find the new month and date after N days
        daySum = 0;
        for (i = 0; i < monthDays.length; i++) {
            daySum += monthDays[i];
            if (daySum >= nDays)
                break;
        }

        // Calculate final date
        date = nDays + monthDays[i] - daySum;
        String nDateStr = date + "TH " + monthNames[i] + ", " + nYear;

        // Output results
        System.out.println();
        System.out.println("DATE: " + dateStr);
        System.out.println("DATE AFTER " + n + " DAYS: " + nDateStr);
    }
}
