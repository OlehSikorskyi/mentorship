package tests.unit;

import extended.book.Book;
import extended.book.EBook;
import extended.book.Genre;
import extended.manager.AdvancedBookManager;
import extended.manager.BookNotFoundException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SimpleBookManager3Test {

    private AdvancedBookManager manager = new AdvancedBookManager();

    @Test
    public void testHardAddAndGetBook () throws BookNotFoundException {
        System.out.println("Running test 'testHardAddAndGetBook' in thread: " + Thread.currentThread().getName());
        Book book = new EBook("Java Programming", "John Doe", 29.99, Genre.SCIENCE, 5.5);
        manager.addBook(book);
        Book retrievedBook = manager.getBookDetails("Java Programming");

        Assert.assertTrue(retrievedBook.getTitle().contains("Java Programming"), "Check Title");
        Assert.assertEquals(retrievedBook.getAuthor(), "John Doe", "Check Author");
        Assert.assertEquals(retrievedBook.getPrice(), 29.99, "Check Price");
    }

    @Test
    public void testSoftAddAndGetBook () throws BookNotFoundException {
        System.out.println("Running test 'testSoftAddAndGetBook' in thread: " + Thread.currentThread().getName());
        Book book = new EBook("Java Programming", "John Doe", 29.99, Genre.SCIENCE, 5.5);
        manager.addBook(book);
        Book retrievedBook = manager.getBookDetails("Java Programming");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(retrievedBook.getTitle().contains("Java Programming"), "Check Title");
        softAssert.assertEquals(retrievedBook.getAuthor(), "John Doe", "Check Author");
        softAssert.assertEquals(retrievedBook.getPrice(), 29.99, "Check Price");
        softAssert.assertAll();
    }
}
