package Admin;

import java.util.ArrayList;

import General.Record;

public class AdminRole 
{
    private LibrarianUserDatabase database=new LibrarianUserDatabase("Librarians.txt");

    public AdminRole(){}

    public void setDatabase(LibrarianUserDatabase database) {
        this.database = database;
    }
    
    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber)
    {
        LibrarianUser L1= new LibrarianUser(librarianId, name, email, address, phoneNumber);
        database.insertRecord(L1);
        database.saveToFile();
    }

    public ArrayList<Record> getListOfLibrarians()
    {
        return database.returnAllRecords();
    }

    public void removeLibrarian (String key)
    {
        database.deleteRecord(key);
        database.saveToFile();
    }

    public void logout()
    {
        database.saveToFile();
    }


}
