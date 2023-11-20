package search_sort;

class Book {
    protected String title;
    protected int ISBN;
    protected String[] chapters;
    protected int amountChapters;

    public Book(String title, int ISBN, String[] chapters, int amountChapters) {
        this.title = title;
        this.ISBN = ISBN;
        this.chapters = chapters;
        this.amountChapters = amountChapters;
    }
}

class Library {
    protected Book[] books; //already sorted

    public Library(Book[] books) {
        this.books = books;
    }

    public int findChapter(int isbn, String chapterName) {
        int posBook = findBook(isbn);
        if (posBook == -1) return -1;

        String[] chapters = books[posBook].chapters;

        for (int i = 0; i < chapters.length; i++)
            if (chapters[i].equals(chapterName)) return i + 1;

        return -1;
    }

    private int findBook(int isbn) {
        int lo = 0, hi = books.length - 1, m = -1;

        while (lo <= hi) {
            m = (lo + hi) / 2;
            if (books[m].ISBN == isbn) break;
            if (books[m].ISBN > isbn) hi = m - 1;
            else lo = m + 1;
        }

        return m;
    }
}

public class search_sort_ej3 {
    public static void main(String[] args) {
        Book b0 = new Book("a", 3, new String[]{"sexo1", "sexo2", "sexo"}, 3);
        Book b1 = new Book("b", 1, new String[]{"sex2", "sexo1", "sexo"}, 3);
        Book b2 = new Book("c", 2, new String[]{"sexo3", "sexo1", "sexo3"}, 3);

        Library library = new Library(new Book[]{b1, b0, b2});
        System.out.println(library.findChapter(1, "sexo1")); // 2
        System.out.println(library.findChapter(3, "sexo2")); // 2
        System.out.println(library.findChapter(2, "sexo100")); // -1
        System.out.println(library.findChapter(7, "sexo")); // -1
    }
}
