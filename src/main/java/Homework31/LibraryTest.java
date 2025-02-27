package Homework31;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Harry Potter", "J.K. Rowling");
        book2 = new Book("Lord of the Rings", "J.R.R. Tolkien");
    }


    @Test
    public void testAddBook() {
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book1));
    }

    @Test
    public void testAddNullBookThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(null);
        });
        assertEquals("Book cannot be null", exception.getMessage());
    }

    @Test
    public void testRemoveBook() {
        library.addBook(book1);
        assertTrue(library.removeBook(book1));
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void testRemoveNonExistentBook() {
        assertFalse(library.removeBook(book1));
    }

    @Test
    public void testRemoveNullBookThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.removeBook(null);
        });
        assertEquals("Book cannot be null", exception.getMessage());
    }

    @Test
    public void testGetBooksReturnsImmutableList() {
        library.addBook(book1);
        List<Book> books = library.getBooks();
        assertThrows(UnsupportedOperationException.class, () -> books.add(book2));
    }

    @Test
    public void testGetBookCount() {
        assertEquals(0, library.getBookCount());
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.getBookCount());
    }
}
