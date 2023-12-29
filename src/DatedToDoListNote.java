import java.util.Arrays;
import java.time.LocalDate;

public class DatedToDoListNote extends ObsidianNote{

    // first X: the date (e.g., 27)
    // second X: abbreviation of the month (e.g., dec for December)
    // third X: the year (e.g., 2023)
    static String generalToDoListNoteFileName = "XXX";

    static String[] generalNoteContent = {
            "- [ ] ", // this is for the very first checkbox
            "---",
            "Back to Root Note: [[X]]", // X: file name of dated to do list root note
            "Previous Dated To Do List: [[X]]", // X: file name of previous dated to do list note
            "Next Dated To Do List: [[X]]" // X: file name of next dated to do list note
    };

    String dayOfMonth;
    String month;
    String year;


    DatedToDoListNote(String fileName, String[] noteContent, String dayOfMonth, String month, String year) {
        super(fileName, noteContent);
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.year = year;
    }

    static String[] returnSpecificNoteContent(String dayOfMonth, String month, String year)
    {
        String[] specificNoteContent = Arrays.copyOf(generalNoteContent, generalNoteContent.length);

        int count = 0; // used to determine which X currently replacing in order to replace with the correct value
        for (int i = 0; i < specificNoteContent.length; i++) {
            if (specificNoteContent[i].contains("X")) {
                count++;
                if (count == 1) // this X is for the file name of the root note
                {
                    specificNoteContent[i] = specificNoteContent[i].replaceFirst("X", "placeholder");
                }
                else if (count == 2) // this X is for the file name of the previous note
                {
                    specificNoteContent[i] = specificNoteContent[i].replaceFirst("X", "placeholder");
                }
                else if (count == 3) // this X is for the file name of the next note
                {
                    specificNoteContent[i] = specificNoteContent[i].replaceFirst("X", "placeholder");
                    break;
                }
            }
        }

        return specificNoteContent;
    }
}
