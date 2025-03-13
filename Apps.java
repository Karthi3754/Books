import mybook.Book;
import mymember.Member;
import myLibrary.Library;
import java.util.Scanner;

public class Apps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Adding books to the library
        System.out.println("Enter the number of books you want to add: ");
        int numBooks = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < numBooks; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");
            System.out.print("Title: ");
            String title = scanner.nextLine().trim();
            System.out.print("Author: ");
            String author = scanner.nextLine().trim();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine().trim();

            library.addBook(new Book(title, author, isbn));
        }

        // Adding members to the library
        System.out.println("Enter the number of members you want to add: ");
        int numMembers = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < numMembers; i++) {
            System.out.println("Enter details for member " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Member ID: ");
            String memberId = scanner.nextLine().trim();

            library.addMember(new Member(name, memberId));
        }

        // User input and actions
        while (true) {
            System.out.println("Enter command (borrow/return/exit): ");
            String command = scanner.nextLine().trim();

            if (command.equals("exit")) {
                break;
            }

            System.out.print("Enter member ID: ");
            String memberId = scanner.nextLine().trim();

            System.out.print("Enter ISBN: ");
            String ISBN = scanner.nextLine().trim();

            switch (command) {
                case "borrow":
                    library.borrowBook(memberId, ISBN);
                    break;
                case "return":
                    library.returnBook(memberId, ISBN);
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }

            // Print transactions
            library.printTransactions();
        }

        scanner.close();
    }
}
