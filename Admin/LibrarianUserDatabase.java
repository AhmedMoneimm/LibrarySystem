package Admin;

import General.Database;

public class LibrarianUserDatabase extends Database
{
    public LibrarianUserDatabase(String filename)
    {
        super(filename);

    }
    @Override
    public LibrarianUser createRecordFrom(String line)
    {
        LibrarianUser a;
        String[] tokens = line.split(",");
        a = new LibrarianUser(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
        return a;
    }


}
