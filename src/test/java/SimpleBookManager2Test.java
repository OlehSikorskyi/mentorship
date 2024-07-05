import extended.book.Book;
import extended.book.EBook;
import extended.book.Genre;
import extended.book.PrintedBook;
import extended.manager.AdvancedBookManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleBookManager2Test {

    private AdvancedBookManager manager = new AdvancedBookManager();

    @Test
    public void testFindBooksByGenre() {
        System.out.println("Running test 'testFindBooksByGenre' in thread: " + Thread.currentThread().getName());
        Book book1 = new EBook("Fantasy Adventures", "Alice Wonderland", 10.99, Genre.FANTASY, 2.0);
        Book book2 = new PrintedBook("The Science of Cooking", "Gordon Ramsay", 20.50, Genre.NONFICTION, 150);
        manager.addBook(book1);
        manager.addBook(book2);
        Assert.assertEquals(manager.findBooksByGenre(Genre.FANTASY).size(), 1);
    }
}
