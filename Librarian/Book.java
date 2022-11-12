package Librarian;
import General.Record;

public class Book implements Record
{
    private String bookName;
    private int bookQuantity;
    private String bookPublisher; 
    private String bookAuthorName;
    private String bookid;
    
    public Book(String id, String title, String authorName, String publisherName, int quantity){
        this.bookid = id;
        this.bookName = title;
        this.bookAuthorName = authorName;
        this.bookPublisher = publisherName;
        this.bookQuantity = quantity;
    }
    public int getBookQuantity() {
        return bookQuantity;
    }
    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }
    public void QuantityDecrement(int decrement) {
        this.bookQuantity = bookQuantity-decrement;
    }
    public void QuantityIncrement(int increment) {
        this.bookQuantity = bookQuantity-increment;
    }
    @Override
    public String lineRepresentation()
    {
        return bookid+","+bookName+","+bookAuthorName+","+bookPublisher+","+bookQuantity;
    }
    @Override
    public String getSearchKey()
    {
        return bookid;
    }
}
