package extended.manager;

import extended.book.Book;
import extended.book.Genre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedBookManager implements BookManager<Book> {
    private Map<String, Book> books;

    public AdvancedBookManager() {
        books = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
        books.put(book.getTitle().toLowerCase(), book);
    }

    @Override
    public Book getBookDetails(String title) throws BookNotFoundException {
        Book book = books.get(title.toLowerCase());
        if (book == null) {
            throw new BookNotFoundException("Book not found: " + title);
        }
        return book;
    }

    @Override
    public List<Book> findBooksByGenre(Genre genre) {
        List<Book> genreBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getGenre() == genre) {
                genreBooks.add(book);
            }
        }
        return genreBooks;
    }


    //TODO: Optional: try to use Java Stream API instead of for loop
//    @Override
//    public List<Book> findBooksByGenre(Genre genre) {
//        return books.values().stream()
//                .filter(book -> book.getGenre() == genre)
//                .collect(Collectors.toList());
//    }

    @Override
    public void removeBook(String title) throws BookNotFoundException {
        if (books.remove(title.toLowerCase()) == null) {
            throw new BookNotFoundException("Book not found: " + title);
        }
    }
}
