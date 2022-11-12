package Admin;
import General.Record;
import java.util.*;

public class TestAdmin {

    public static void test1() {
        AdminRole admin = new AdminRole();
        ArrayList<Record> arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.size());
        admin.addLibrarian("L1100", "Mariam", "mariam@gmail.com", "Alexandria", "01011845684");
        arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.size());
        System.out.println(arrayOfLibrarianUsers.get(2).lineRepresentation());
        admin.removeLibrarian("L1400");
        arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.size());
        System.out.println(arrayOfLibrarianUsers.get(2).lineRepresentation());
        admin.removeLibrarian("L1600");
        arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.size());
        System.out.println(arrayOfLibrarianUsers.get(3).lineRepresentation());
        admin.logout();
    }

    public static void main(String[] args) 
    {
        System.out.println("--------------Test Admin--------------\n");
        test1();
        System.out.println("------------------------------------------------------------------\n");
    }
}