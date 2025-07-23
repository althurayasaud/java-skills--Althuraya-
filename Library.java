

class Book {
    private String title;
    private String author;
    private int pages;
    private boolean isAvailable;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " is borrowed.");
        } else {
            System.out.println(title + " not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + isAvailable);
    }
}

class Textbook extends Book {
    private String subject;
    private int edition;

    public Textbook(String title, String author, int pages, String subject, int edition) {
        super(title, author, pages);
        this.subject = subject;
        this.edition = edition;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
    }
}

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("The Days of Dust", "Hanna Mina", 230);
        Book book2 = new Book("The Thief and the Dogs", "Naguib Mahfouz", 170);
        Textbook textbook = new Textbook("Principles of Java Programming", "Dr. Abdullah Al-Ali", 450, "Programming", 3);

        book1.borrowBook();
        book1.borrowBook();
        book1.returnBook();
        book1.borrowBook();

        textbook.borrowBook();

        System.out.println("First book:");
        book1.displayInfo();

        System.out.println("Second book:");
        book2.displayInfo();

        System.out.println("Textbook Info:");
        textbook.displayInfo();
    }
}
