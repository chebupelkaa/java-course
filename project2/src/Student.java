import java.util.List;

public class Student {
    private final String name;
    private final List<Book> books;

    public Student(final String name, final List<Book> books){
        this.name = name;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Student name: "+name+", number of books: "+books.size();
//                ", books: "+books;
    }
}
