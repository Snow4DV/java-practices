import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book;

    @BeforeEach
    void setUp() {
        book = new Book("Ivanov I. I.", "How to study Java in 30 seconds",
                new String[]{"Thank you for buying my successfull book", "There is no way to study java in 30 seconds",
                "It's over"});
    }

    @Test
    void getAuthor() {
        assertEquals("Ivanov I. I.", book.getAuthor());
    }

    @Test
    void getTitle() {
        assertEquals("How to study Java in 30 seconds", book.getTitle());
    }

    @Test
    void getPages() {
        assertTrue(Arrays.equals(book.getPages(),new String[]{"Thank you for buying my successfull book", "There is no way to study java in 30 seconds",
                "It's over"}));
    }

    @Test
    void getEditionNumber() {
        book.remasterBook(new String[]{});
        assertEquals(book.getEditionNumber(), 2);
    }

    @Test
    void remasterBook() {
        String[] newPages = new String[]{"Thank you for buying my successfull book", "You don't need to know Java.",
                "Just use others' code from SO",
                "It's over"};
        book.remasterBook(newPages);
        assertTrue(Arrays.equals(newPages, book.getPages()));
    }

    @Test
    void testToString() {
        assertEquals("Book{" +
                "author='" + book.getAuthor() + '\'' +
                ", title='" + book.getTitle() + '\'' +
                ", editionNumber=" + book.getEditionNumber() +
                ", pages=" + Arrays.toString(book.getPages()) +
                '}', book.toString());
    }
}