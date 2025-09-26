import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private ArrayList<Book> borrowedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void borrowBook(Book book) {
        if (!book.isIssued()) {
            book.issueBook();
            borrowedBooks.add(book);
            System.out.println(name + " successfully borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is already issued.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println(name + " did not borrow " + book.getTitle());
        }
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has no borrowed books.");
        } else {
            System.out.println(name + "'s Borrowed Books:");
            for (Book b : borrowedBooks) {
                System.out.println(b);
            }
        }
    }
}
