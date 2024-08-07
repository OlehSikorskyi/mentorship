package tests.unit;

import extended.book.Book;
import extended.book.EBook;
import extended.book.Genre;
import extended.manager.AdvancedBookManager;
import extended.manager.BookNotFoundException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SimpleBookManager4Test {

    private AdvancedBookManager manager = new AdvancedBookManager();

    @DataProvider(name = "bookData", parallel = true)
    public Object[][] createBookData() {
        return new Object[][]{
                {"Java Programming", "John Doe", 29.99, Genre.SCIENCE, 5.5},
                {"History of Rome", "Jane Smith", 15.00, Genre.HISTORY, 300},
                {"Fantasy Adventures", "Alice Wonderland", 10.99, Genre.FANTASY, 2.0}
        };
    }

    @Test(dataProvider = "bookData")
    public void testAddAndGetBookDataDriven(String title, String author, double price, Genre genre, double fileSize) throws BookNotFoundException {
        System.out.println("Running test 'testAddAndGetBookDataDriven' in thread: " + Thread.currentThread().getName());
        Book book = new EBook(title, author, price, genre, fileSize);
        manager.addBook(book);
        Book retrievedBook = manager.getBookDetails(title);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(retrievedBook.getTitle().contains(title), "Check Title");
        softAssert.assertEquals(retrievedBook.getAuthor(), author, "Check Author");
        softAssert.assertEquals(retrievedBook.getPrice(), price, "Check Price");
        softAssert.assertEquals(retrievedBook.getGenre(), genre, "Check Genre");
        softAssert.assertAll();
    }
}
