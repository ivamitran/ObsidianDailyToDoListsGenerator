import java.time.DateTimeException;
import java.time.LocalDate;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class SequentialDates {

    public static boolean dateValidAsLocalDate(int year, int month, int dayOfMonth)
    {
        boolean dateValid;
        try
        {
            LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
            dateValid = true;
        }
        catch(DateTimeException e)
        {
            System.out.println("The combination of year, month, and day of month does not form a valid date.");
            dateValid = false;
        }

        return dateValid;
    }

    // at the time of using this method, we assume that the year, month, and day of month are valid to generate a local date
    public static LocalDate initLocalDate(int year, int month, int dayOfMonth)
    {
        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        return localDate;
    }

    public static List<LocalDate> generateSequentialDates(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> sequentialDates = new ArrayList<>();
        LocalDate currentDate = startDate;

        // Generate sequential dates until the end date is reached =
        while(!currentDate.isAfter(endDate)) // as long as current date is not after end date (this means that the end date will be added to the list as well
        {
            sequentialDates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        return sequentialDates;
    }

    // [0]: Contains the dayOfMonth string
    // [1]: Contains the month string
    // [2]: Contains the year string
    public static String[] returnSequentialDateRelevantStrings(LocalDate date)
    {
        String[] dateStrings = new String[3];
        dateStrings[0] = Integer.toString(date.getDayOfMonth());
        dateStrings[1] = returnAbbreviatedStringOfMonth(date.getMonth());
        dateStrings[2] = Integer.toString(date.getYear());

        return dateStrings;
    }

    private static String returnAbbreviatedStringOfMonth(Month month)
    {
        String abbreviatedMonth;

        if(month == Month.JANUARY)
        {
            abbreviatedMonth = "jan";
        }
        else if(month == Month.FEBRUARY)
        {
            abbreviatedMonth = "feb";
        }
        else if(month == Month.MARCH)
        {
            abbreviatedMonth = "mar";
        }
        else if(month == Month.APRIL)
        {
            abbreviatedMonth = "apr";
        }
        else if(month == Month.MAY)
        {
            abbreviatedMonth = "may";
        }
        else if(month == Month.JUNE)
        {
            abbreviatedMonth = "jun";
        }
        else if(month == Month.JULY)
        {
            abbreviatedMonth = "jul";
        }
        else if(month == Month.AUGUST)
        {
            abbreviatedMonth = "aug";
        }
        else if(month == Month.SEPTEMBER)
        {
            abbreviatedMonth = "sep";
        }
        else if(month == Month.OCTOBER)
        {
            abbreviatedMonth = "oct";
        }
        else if(month == Month.NOVEMBER)
        {
            abbreviatedMonth = "nov";
        }
        else // this will be when month is Month.DECEMBER
        {
            abbreviatedMonth = "dec";
        }

        return abbreviatedMonth;
    }

    // this main method is simply for testing the methods of this class
    public static void main(String[] args) {
        List<LocalDate> sequentialDates = generateSequentialDates(LocalDate.of(2023, 12, 1), LocalDate.of(2024, 1, 20));
        for(LocalDate localDate : sequentialDates)
        {
            String[] dateStrings = returnSequentialDateRelevantStrings(localDate);
            System.out.printf("Day of Month: %s, Month: %s, Year: %s\n", dateStrings[0], dateStrings[1], dateStrings[2]);
        }
    }
}
