package Librarian;

import General.Database;

public class BookDatabase extends Database
{
    public BookDatabase(String filename) 
    {
        super(filename);
    }
    @Override
    public Book createRecordFrom(String line)
    {
        Book a;
        String[] tokens = line.split(",");
        a = new Book(tokens[0], tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]));
        return a;
    }  
}
