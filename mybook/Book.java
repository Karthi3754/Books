package mybook;

public class Book {
    public String title, author, ISBN;
    private boolean isBorrowed;

    public Book(String t, String a, String i) {
        title = t;
        author = a;
        ISBN = i;
        isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
