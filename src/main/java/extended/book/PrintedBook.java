package extended.book;


public class PrintedBook extends Book {
    private int numPages;

    public PrintedBook(String title, String author, double price, Genre genre, int numPages) {
        super(title, author, price, genre);
        this.numPages = numPages;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public String getDetails() {
        return "PrintedBook [Title: " + getTitle() + ", Author: " + getAuthor() + ", Price: " + getPrice() +
                ", main.java.simple.book.Genre: " + getGenre() + ", Number of Pages: " + numPages + "]";
    }
}
