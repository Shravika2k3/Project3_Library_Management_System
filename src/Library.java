import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " added to library.");
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println(user.getName() + " registered as a user.");
    }

    public Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public User findUserById(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    public void showAvailableBooks() {
        System.out.println("\nAvailable Books in Library:");
        boolean found = false;
        for (Book b : books) {
            if (!b.isIssued()) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books are available.");
        }
    }
}
