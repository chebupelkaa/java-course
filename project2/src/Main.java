import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomHashSet<Integer> hashSet = new CustomHashSet<>();
        hashSet.add(3);
        hashSet.add(6);
        hashSet.add(1);
        hashSet.add(3);
        System.out.println("HashSet: " + hashSet);
        hashSet.remove(6);
        System.out.println("HashSet: " + hashSet);

        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        linkedList.add("apple");
        linkedList.add("banana");
        linkedList.add("orange");
        System.out.println("LinkedList: " + linkedList);
        linkedList.remove("banana");
        String[] arrStr = {"mango", "lemon", "kiwi"};
        linkedList.addAll(arrStr);
        System.out.println("list[1]=" + linkedList.get(1));
        System.out.println("LinkedList: " + linkedList+"\n");

        List<Student> students = List.of(
                new Student("Alice", List.of(
                        new Book("Book1", "Author1", 1999, 200),
                        new Book("Book2", "Author2", 2005, 150),
                        new Book("Book3", "Author3", 2010, 305),
                        new Book("Book4", "Author4", 2001, 250),
                        new Book("Book5", "Author5", 1998, 180)
                )),
                new Student("Alina", List.of(
                        new Book("Book6", "Author6", 2003, 220),
                        new Book("Book7", "Author7", 2007, 191),
                        new Book("Book3", "Author3", 2010, 300),
                        new Book("Book8", "Author8", 2002, 213),
                        new Book("Book9", "Author9", 1995, 170)
                )),
                new Student("Kate", List.of(
                        new Book("Book10", "Author10", 2004, 230),
                        new Book("Book11", "Author11", 2008, 243),
                        new Book("Book12", "Author12", 2012, 260),
                        new Book("Book13", "Author13", 2006, 274),
                        new Book("Book3", "Author3", 2010, 300)
                )),
                new Student("Elizabeth", List.of(
                        new Book("Book14", "Author14", 1991, 110),
                        new Book("Book15", "Author15", 2001, 240),
                        new Book("Book8", "Author8", 2002, 213),
                        new Book("Book16", "Author16", 2018, 135),
                        new Book("Book17", "Author17", 2025, 120)
                ))
        );

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .distinct()
                .sorted((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()))
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .map(year -> "Found book year: " + year)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No book found")
                );

    }
}