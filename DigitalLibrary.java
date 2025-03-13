//TASK 5::

import java.util.*;

class Book {
    String id, title, author;
    boolean isIssued;

    Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

class Admin {
    String adminId, password;
    Admin(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }
}

public class DigitalLibrary {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) { books.put(book.id, book); }
    public void removeBook(String id) { books.remove(id); }
    public void issueBook(String id) {
        if (books.containsKey(id) && !books.get(id).isIssued) {
            books.get(id).isIssued = true;
            System.out.println("Book issued.");
        } else { System.out.println("Unavailable."); }
    }
    public void returnBook(String id) {
        if (books.containsKey(id) && books.get(id).isIssued) {
            books.get(id).isIssued = false;
            System.out.println("Book returned.");
        }
    }
    public void viewBooks() {
        for (Book b : books.values()) {
            System.out.println(b.id + " | " + b.title + " by " + b.author + (b.isIssued ? " (Issued)" : ""));
        }
    }

    public static void main(String[] args) {
        DigitalLibrary dl = new DigitalLibrary();
        dl.addBook(new Book("101", "Java Basics", "Author A"));
        dl.addBook(new Book("102", "Data Structures", "Author B"));
        dl.viewBooks();
        dl.issueBook("101");
        dl.viewBooks();
    }
}

