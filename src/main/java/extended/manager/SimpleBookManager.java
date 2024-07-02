package extended.manager;


import extended.book.Book;
import extended.book.Genre;

import java.util.ArrayList;
import java.util.List;

public class SimpleBookManager implements BookManager<Book> {
    private List<Book> books;

    public SimpleBookManager() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book getBookDetails(String title) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found: " + title);
    }

    //TODO: Optional: try to use Java Stream API instead of for loop
//    @Override
//    public Book getBookDetails(String title) throws BookNotFoundException {
//        return books.stream()
//                .filter(book -> book.getTitle().equalsIgnoreCase(title))
//                .findFirst()
//                .orElseThrow(() -> new BookNotFoundException("Book not found: " + title));
//    }

    @Override
    public List<Book> findBooksByGenre(Genre genre) {
        List<Book> genreBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre() == genre) {
                genreBooks.add(book);
            }
        }
        return genreBooks;
    }

    @Override
    public void removeBook(String title) throws BookNotFoundException {
        Book book = getBookDetails(title);
        books.remove(book);
    }
}