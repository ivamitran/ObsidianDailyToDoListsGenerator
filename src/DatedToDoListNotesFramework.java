import java.time.LocalDate;
import java.util.List;

public class DatedToDoListNotesFramework {

    static String datedToDoListsRootNoteName = "datedToDoListsRootNote";

    // this list will hold the LocalDate objects that correspond to each DatedToDoListNote object
    // is List and not LocalDate[] because the method used to generate the sequence of LocalDates returns a list
    List<LocalDate> localDates;
    DatedToDoListNote[] datedToDoListNotes; // this array will hold the individual DatedToDoListNote objects that will be part of the framework

    public DatedToDoListNotesFramework(LocalDate startDate, LocalDate endDate)
    {
        localDates = DateFunctions.generateSequentialDates(startDate, endDate);
        datedToDoListNotes = new DatedToDoListNote[localDates.size()];

        // instantiate the individual DatedToDoListNote objects
        for(int i = 0; i < datedToDoListNotes.length; i++)
        {
            // generate the file name of the markdown file
            String[] currentDateRelevantStrings = DateFunctions.returnLocalDateRelevantStrings(localDates.get(i));
            String dayOfMonth = currentDateRelevantStrings[0];
            String abbreviatedMonth = currentDateRelevantStrings[1];
            String year = currentDateRelevantStrings[2];
            String fileName = dayOfMonth + abbreviatedMonth + year;

            // generate the note content
            String[] specificNoteContent = DatedToDoListNote.returnSpecificNoteContent(localDates.get(i));

            // datedToDoListNotes[i] = new DatedToDoListNote(fileName, );
        }
    }

}
