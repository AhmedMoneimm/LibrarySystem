package Librarian;
import General.Record;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;


public class LibrarianRole
{
    private BookDatabase bookDatabase=new BookDatabase("Books.txt");
    private StudentBookDatabase sBDatabase=new StudentBookDatabase("StudentsBooks.txt");

    public LibrarianRole(){}

    public void addBook(String id, String title, String authorName, String publisherName, int quantity)
    {
        bookDatabase.insertRecord(new Book(id, title, authorName, publisherName, quantity));
        bookDatabase.saveToFile();
    }

    public ArrayList<Record> getListOfBooks()
    {
        return bookDatabase.returnAllRecords();
    }

    public ArrayList<Record> getListOfBorrowingOperations()
    {
        return sBDatabase.returnAllRecords();
    }

    public int borrowBook(String studentId, String bookId,LocalDate borrowDate)
    {
        if(bookDatabase.contains(bookId)==false||((Book) bookDatabase.getRecord(bookId)).getBookQuantity()==0)
        {return 0;}
        else 
        if(sBDatabase.contains(studentId+","+bookId)&&borrowDate.compareTo(LocalDate.now())<0)
        {return 1;}
        else
        {
            ((Book) bookDatabase.getRecord(bookId)).QuantityDecrement(1);
            sBDatabase.insertRecord(sBDatabase.createRecordFrom(studentId+","+bookId+","+borrowDate));
            logout();
            return 2;
        }
    }

    public double returnBook(String studentId, String bookId, LocalDate returnDate)
    {
        Book bookShrt=((Book)bookDatabase.getRecord(bookId));
        bookShrt.setBookQuantity(bookShrt.getBookQuantity()+1);

        StudentBook studBookShrt=((StudentBook) sBDatabase.getRecord(studentId+","+bookId));
        LocalDate borrowDate=studBookShrt.getBorrowDate();

        long diff = ChronoUnit.DAYS.between(borrowDate , returnDate);
        sBDatabase.deleteRecord(studentId+","+bookId);
        logout();

        if(diff<7){return 0;} else {return (diff-7)*0.5;}
    }

    public void logout()
    {
        sBDatabase.saveToFile();
        bookDatabase.saveToFile();
    }
}
