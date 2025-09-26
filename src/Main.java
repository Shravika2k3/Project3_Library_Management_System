import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Available Books");
            System.out.println("6. Show User Borrowed Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bookId, title, author));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    library.addUser(new User(userId, name));
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int uIdIssue = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bIdIssue = sc.nextInt();
                    User userIssue = library.findUserById(uIdIssue);
                    Book bookIssue = library.findBookById(bIdIssue);
                    if (userIssue != null && bookIssue != null) {
                        userIssue.borrowBook(bookIssue);
                    } else {
                        System.out.println("Invalid User ID or Book ID.");
                    }
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int uIdReturn = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bIdReturn = sc.nextInt();
                    User userReturn = library.findUserById(uIdReturn);
                    Book bookReturn = library.findBookById(bIdReturn);
                    if (userReturn != null && bookReturn != null) {
                        userReturn.returnBook(bookReturn);
                    } else {
                        System.out.println("Invalid User ID or Book ID.");
                    }
                    break;

                case 5:
                    library.showAvailableBooks();
                    break;

                case 6:
                    System.out.print("Enter User ID: ");
                    int uIdShow = sc.nextInt();
                    User userShow = library.findUserById(uIdShow);
                    if (userShow != null) {
                        userShow.showBorrowedBooks();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
