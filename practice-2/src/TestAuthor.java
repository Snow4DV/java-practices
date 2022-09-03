import static org.junit.jupiter.api.Assertions.*;

class TestAuthor {

    Author author;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        author = new Author("Ivanov I. I.", "old_guy_ivanov_2007@gmail.com", 'm');
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Ivanov I. I.", author.getName());
    }

    @org.junit.jupiter.api.Test
    void getEmail() {
        assertEquals("old_guy_ivanov_2007@gmail.com",author.getEmail());
    }

    @org.junit.jupiter.api.Test
    void getGender() {
        assertEquals(author.getGender(), 'm');
    }

    @org.junit.jupiter.api.Test
    void setEmail() {
        author.setEmail("anonymous_email@gmail.com");
        assertEquals(author.getEmail(), "anonymous_email@gmail.com");
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("Author{" +
                "name='" + author.getName() + '\'' +
                ", email='" + author.getEmail() + '\'' +
                ", gender=" + author.getGender() +
                '}', author.toString());
        System.out.println(author.toString());
    }
}