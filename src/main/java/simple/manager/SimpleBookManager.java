package simple.manager;


import simple.book.Book;
import simple.book.Genre;

public class SimpleBookManager implements BookManager {
    private Book[] books;
    private int count;

    public SimpleBookManager() {
        books = new Book[10];
        count = 0;
    }

    @Override
    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        } else {
            System.out.println("Book storage is full.");
        }
    }

    @Override
    public String getBookDetails(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i].getDetails();
            }
        }
        return "Book not found.";
    }

    @Override
    public String findBooksByGenre(Genre genre) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (books[i].getGenre() == genre) {
                result.append(books[i].getDetails()).append("\n");
            }
        }
        return result.length() > 0 ? result.toString() : "No books found in this genre.";
    }
}