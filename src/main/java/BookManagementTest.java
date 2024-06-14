import book.EBook;
import book.Genre;
import book.PrintedBook;
import manager.SimpleBookManager;

public class BookManagementTest {
    public static void main(String[] args) {
        SimpleBookManager manager = new SimpleBookManager();

        // Add books
        manager.addBook(new EBook("Java Programming", "John Doe", 29.99, Genre.SCIENCE, 5.5));
        manager.addBook(new PrintedBook("History of Rome", "Jane Smith", 15.00, Genre.HISTORY, 300));
        manager.addBook(new EBook("Fantasy Adventures", "Alice Wonderland", 10.99, Genre.FANTASY, 2.0));
        manager.addBook(new PrintedBook("The Science of Cooking", "Gordon Ramsay", 20.50, Genre.NONFICTION, 150));

        // Display book details by title
        System.out.println(manager.getBookDetails("Java Programming"));
        System.out.println(manager.getBookDetails("Unknown Title"));

        // Display books by genre
        System.out.println("\nBooks in Science genre:");
        System.out.println(manager.findBooksByGenre(Genre.SCIENCE));

        System.out.println("\nBooks in History genre:");
        System.out.println(manager.findBooksByGenre(Genre.HISTORY));
    }
}