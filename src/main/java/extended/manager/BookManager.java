package extended.manager;

import extended.book.Book;
import extended.book.Genre;

import java.util.List;

public interface BookManager<T extends Book> {
    void addBook(T book);
    T getBookDetails(String title) throws BookNotFoundException;
    List<T> findBooksByGenre(Genre genre);
    void removeBook(String title) throws BookNotFoundException;
}
