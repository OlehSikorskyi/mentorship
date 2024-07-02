package extended.book;


public class EBook extends Book {
    private double fileSize; // in MB

    public EBook(String title, String author, double price, Genre genre, double fileSize) {
        super(title, author, price, genre);
        this.fileSize = fileSize;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String getDetails() {
        return "EBook [Title: " + getTitle() + ", Author: " + getAuthor() + ", Price: " + getPrice() +
                ", main.java.simple.book.Genre: " + getGenre() + ", File Size: " + fileSize + " MB]";
    }
}