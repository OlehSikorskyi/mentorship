package simple.manager;

import simple.book.Book;
import simple.book.Genre;

interface BookManager {
    void addBook(Book book);
    String getBookDetails(String title);
    String findBooksByGenre(Genre genre);
}
