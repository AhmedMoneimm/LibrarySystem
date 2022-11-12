package Librarian;

import java.time.LocalDate;
import General.Database;

public class StudentBookDatabase extends Database
{
    
    public StudentBookDatabase(String filename) 
    {
        super(filename);
    }
    
    @Override
    public StudentBook createRecordFrom(String line)
    {
        StudentBook a;
        String[] tokens = line.split(",");
        a = new StudentBook(tokens[0], tokens[1], LocalDate.parse(tokens[2]));
        return a;
    }
}
    
   