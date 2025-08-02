import java.util.*;

// Класс Book для представления книги
class Book implements Comparable<Book> {
    private String title;
    private int year;
    private int pages;

    public Book(String title, int year, int pages) {
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public int getYear() {

        return year;
    }

    public int getPages() {

        return pages;
    }

    @Override
    public String toString() {

        return "Book{title='" + title + "', year=" + year + ", pages=" + pages + "}";
    }

    // Реализация equals и hashCode для определения уникальности книг
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
               pages == book.pages &&
               title.equals(book.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, year, pages);
    }

    // Реализация Comparable для сортировки по количеству страниц
    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.pages, other.pages);
    }
}

// Класс Student для представления студента
class Student {
    private String name;
    private List<Book> books;

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public List<Book> getBooks() {

        return books;
    }

    @Override
    public String toString() {

        return "Student{name='" + name + "', books=" + books + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание коллекции студентов с минимум 5 книгами у каждого
        List<Student> students = Arrays.asList(
            new Student("Alice", Arrays.asList(
                new Book("Book A", 1995, 300),
                new Book("Book B", 2005, 250),
                new Book("Book C", 2010, 400),
                new Book("Book D", 2002, 350),
                new Book("Book E", 1998, 200)
            )),
            new Student("Bob", Arrays.asList(
                new Book("Book B", 2005, 250), // Дубликат
                new Book("Book F", 2015, 500),
                new Book("Book G", 2001, 320),
                new Book("Book H", 1999, 280),
                new Book("Book I", 2020, 450)
            )),
            new Student("Charlie", Arrays.asList(
                new Book("Book C", 2010, 400), // Дубликат
                new Book("Book J", 2003, 270),
                new Book("Book K", 2018, 310),
                new Book("Book L", 1997, 290),
                new Book("Book M", 2004, 360)
            ))
        );

        // Обработка с помощью одного стрима без промежуточных переменных
        students.stream()
                // Выводим каждого студента в консоль
                .peek(student -> System.out.println(student))
                // Получаем списки книг студентов
                .map(Student::getBooks)
                // Разворачиваем списки книг в единый стрим книг
                .flatMap(Collection::stream)
                // Сортируем книги по количеству страниц
                .sorted()
                // Убираем дубликаты книг (на основе equals и hashCode)
                .distinct()
                // Фильтруем книги, выпущенные после 2000 года
                .filter(book -> book.getYear() > 2000)
                // Ограничиваем стрим первыми 3 элементами
                .limit(3)
                // Получаем годы выпуска книг
                .map(Book::getYear)
                // Используем метод короткого замыкания для получения первого года
                .findFirst()
                // Обрабатываем Optional: выводим год или сообщение об отсутствии
                .ifPresentOrElse(
                    year -> System.out.println("Year of the first book: " + year),
                    () -> System.out.println("No book found matching the criteria")
                );
    }
}