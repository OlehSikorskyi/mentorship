package manager;

import book.Book;
import book.Genre;

interface BookManager {
    void addBook(Book book);
    String getBookDetails(String title);
    String findBooksByGenre(Genre genre);
}
