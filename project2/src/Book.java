import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int year;
    private final int pages;

    public Book(final String title, final String author, final int year, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && pages == book.pages && title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages, year);
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "{ " + title + ", " + author + ", " + year + " }";
    }
}