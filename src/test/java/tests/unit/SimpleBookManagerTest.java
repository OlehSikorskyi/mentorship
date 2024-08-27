package tests.unit;

import extended.book.Book;
import extended.book.EBook;
import extended.book.Genre;
import extended.manager.AdvancedBookManager;
import extended.manager.BookNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleBookManagerTest {
    private static final Logger logger = LogManager.getLogger(SimpleBookManagerTest.class);
    private AdvancedBookManager manager;
    Book book;

    @BeforeClass
    public void setUpClass() {
        System.out.println("BeforeClass: Setup resources for unit.SimpleBookManagerTest");
    }

    @BeforeMethod
    public void setUp() {
        manager = new AdvancedBookManager();
    }

    @Test
    public void testAddAndGetBook() throws BookNotFoundException {
        logger.info("Running test 'testSoftAddAndGetBook' in thread: " + Thread.currentThread().getName());
        book = new EBook("Java Programming", "John Doe", 29.99, Genre.SCIENCE, 5.5);
        manager.addBook(book);
        Book retrievedBook = manager.getBookDetails("Java Programming");
        Assert.assertTrue(retrievedBook.getTitle().contains("Java Programming"));
    }

    @Test(expectedExceptions = BookNotFoundException.class)
    public void testGetBookDetailsNotFound() throws BookNotFoundException {
        logger.info("Running test 'testSoftAddAndGetBook' in thread: " + Thread.currentThread().getName());
        manager.getBookDetails("Nonexistent Book");
    }

    @Test(enabled = false)
    public void testAddAndGetBookIgnored() throws BookNotFoundException {
        logger.info("Running test 'testSoftAddAndGetBook' in thread: " + Thread.currentThread().getName());
        book = new EBook("Java Programming", "John Doe", 29.99, Genre.SCIENCE, 5.5);
        manager.addBook(book);
        Book retrievedBook = manager.getBookDetails("Java Programming");
        Assert.assertTrue(retrievedBook.getTitle().contains("Java Programming"));
    }

    @Ignore
    @Test()
    public void testAddAndGetBookIgnored2() throws BookNotFoundException {
        logger.info("Running test 'testSoftAddAndGetBook' in thread: " + Thread.currentThread().getName());
        book = new EBook("Java Programming", "John Doe", 29.99, Genre.SCIENCE, 5.5);
        manager.addBook(book);
        Book retrievedBook = manager.getBookDetails("Java Programming");
        Assert.assertTrue(retrievedBook.getTitle().contains("Java Programming"));
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("AfterClass: Cleanup resources for unit.SimpleBookManagerTest");
    }

    @AfterMethod
    public void tearDown() {
        try {
            logger.info("AfterMethod: Removing book " + book.getTitle());
            manager.removeBook(book.getTitle());
        } catch (Exception exception) {
            logger.info("AfterMethod: Book was not found.");
        }
    }
}
