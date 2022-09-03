import java.util.Arrays;

public class Book {
    private final String author;
    private final String title;
    private int editionNumber = 1;
    private String[] pages;

    public Book(String author, String title, String[] pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String[] getPages() {
        return pages;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void remasterBook(String[] pages) {
        this.pages = pages;
        editionNumber++;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", editionNumber=" + editionNumber +
                ", pages=" + Arrays.toString(pages) +
                '}';
    }
}
