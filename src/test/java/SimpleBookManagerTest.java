import extended.book.Book;
import extended.book.EBook;
import extended.book.Genre;
import extended.manager.AdvancedBookManager;
import extended.manager.BookNotFoundException;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleBookManagerTest {
    private AdvancedBookManager manager;
    Book book;

    @BeforeClass
    public void setUpClass() {
        System.out.println("BeforeClass: Setup resources for SimpleBookManagerTest");
    }

    @BeforeMethod
    public void setUp() {
        manager = new AdvancedBookManager();
    }

    @Test
    public void testAddAndGetBook() throws BookNotFoundException {
        System.out.println("Running test 'testSoftAddAndGetBook' in thread: " + Thread.currentThread().getName());
        book = new EBook("Java Programming", "John Doe", 29.99, Genre.SCIENCE, 5.5);
        manager.addBook(book);
        Book retrievedBook = manager.getBookDetails("Java Programming");
        Assert.assertTrue(retrievedBook.getTitle().contains("Java Programming"));
    }

    @Test(expectedExceptions = BookNotFoundException.class)
    public void testGetBookDetailsNotFound() throws BookNotFoundException {
        System.out.println("Running test 'testSoftAddAndGetBook' in thread: " + Thread.currentThread().getName());
        manager.getBookDetails("Nonexistent Book");
    }

    @Test(enabled = false)
    public void testAddAndGetBookIgnored() throws BookNotFoundException {
        System.out.println("Running test 'testSoftAddAndGetBook' in thread: " + Thread.currentThread().getName());
        book = new EBook("Java Programming", "John Doe", 29.99, Genre.SCIENCE, 5.5);
        manager.addBook(book);
        Book retrievedBook = manager.getBookDetails("Java Programming");
        Assert.assertTrue(retrievedBook.getTitle().contains("Java Programming"));
    }

    @Ignore
    @Test()
    public void testAddAndGetBookIgnored2() throws BookNotFoundException {
        System.out.println("Running test 'testSoftAddAndGetBook' in thread: " + Thread.currentThread().getName());
        book = new EBook("Java Programming", "John Doe", 29.99, Genre.SCIENCE, 5.5);
        manager.addBook(book);
        Book retrievedBook = manager.getBookDetails("Java Programming");
        Assert.assertTrue(retrievedBook.getTitle().contains("Java Programming"));
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("AfterClass: Cleanup resources for SimpleBookManagerTest");
    }

    @AfterMethod
    public void tearDown() {
        try {
            System.out.println("AfterMethod: Removing book " + book.getTitle());
            manager.removeBook(book.getTitle());
        } catch (Exception exception) {
            System.out.println("AfterMethod: Book was not found.");
        }
    }
}
