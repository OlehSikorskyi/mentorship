package extended;

import extended.book.Book;
import extended.book.EBook;
import extended.book.Genre;
import extended.book.PrintedBook;
import extended.manager.AdvancedBookManager;
import extended.manager.BookManager;
import extended.manager.BookNotFoundException;
import extended.manager.SimpleBookManager;

public class BookManagementTest {
    public static void main(String[] args) {
        BookManager<Book> simpleManager = new SimpleBookManager();
        BookManager<Book> advancedManager = new AdvancedBookManager();

        // Add books
        simpleManager.addBook(new EBook("Java Programming", "John Doe", 29.99, Genre.SCIENCE, 5.5));
        simpleManager.addBook(new PrintedBook("History of Rome", "Jane Smith", 15.00, Genre.HISTORY, 300));
        advancedManager.addBook(new EBook("Fantasy Adventures", "Alice Wonderland", 10.99, Genre.FANTASY, 2.0));
        advancedManager.addBook(new PrintedBook("The Science of Cooking", "Gordon Ramsay", 20.50, Genre.NONFICTION, 150));

        try {
            // Display book details by title
            System.out.println(simpleManager.getBookDetails("Java Programming").getDetails());
            System.out.println(advancedManager.getBookDetails("Fantasy Adventures").getDetails());

            // Find books by genre
            System.out.println("\nBooks in Science genre:");
            simpleManager.findBooksByGenre(Genre.SCIENCE).forEach(book -> System.out.println(book.getDetails()));

            System.out.println("\nBooks in Fantasy genre:");
            advancedManager.findBooksByGenre(Genre.FANTASY).forEach(book -> System.out.println(book.getDetails()));

            // Remove books
            simpleManager.removeBook("Java Programming");
            advancedManager.removeBook("Fantasy Adventures");

            // Try to get details of removed books
            System.out.println(simpleManager.getBookDetails("Java Programming").getDetails());
        } catch (BookNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}