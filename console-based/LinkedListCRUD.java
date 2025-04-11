
import java.util.*;

class Book {
    String bookTitle, bookAuthor;
    int yearOfPublication;

    public Book(String bookTitle, String bookAuthor, int yearOfPublication) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.yearOfPublication = yearOfPublication;
    }

    public String toString() {
        return bookTitle + " by " + bookAuthor + " (" + yearOfPublication + ")";
    }

    // Method to update book details
    public void updateBookDetails(String newTitle, String newAuthor, int newYear) {
        this.bookTitle = newTitle;
        this.bookAuthor = newAuthor;
        this.yearOfPublication = newYear;
    }
}

public class LinkedListCRUD {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        LinkedList<Book> bookList = new LinkedList<>();

        String bookTitle, bookAuthor, choice;
        int yearOfPublication;

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("What would you like to do?");
            System.out.println("[A] Add a book");
            System.out.println("[R] Remove a book");
            System.out.println("[L] List all books");
            System.out.println("[U] Update a book");
            System.out.println("[Q] Quit");
            choice = scan.nextLine();

            switch (choice) {
                case "A":
                    System.out.println("Enter book title:");
                    bookTitle = scan.nextLine();
                    System.out.println("Enter book author:");
                    bookAuthor = scan.nextLine();
                    System.out.println("Enter year of publication:");
                    yearOfPublication = scan.nextInt();
                    scan.nextLine();
                    bookList.add(new Book(bookTitle, bookAuthor, yearOfPublication));
                    break;

                case "R":
                    System.out.println("Enter book title to remove:");
                    bookTitle = scan.nextLine();
                    boolean removed = false;
                    for (Book book : bookList) {
                        if (book.bookTitle.equals(bookTitle)) {
                            bookList.remove(book);
                            removed = true;
                            System.out.println("Book removed: " + book);
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Book not found.");
                    }
                    break;

                case "L":
                    if (bookList.isEmpty()) {
                        System.out.println("No books to display.");
                    } else {
                        System.out.println("Here are the books listed:");
                        for (Book book : bookList) {
                            System.out.println(book);
                        }
                    }
                    break;

                case "U":
                    System.out.println("Enter book title to update:");
                    bookTitle = scan.nextLine();
                    boolean foundForUpdate = false;
                    for (Book book : bookList) {
                        if (book.bookTitle.equals(bookTitle)) {
                            foundForUpdate = true;
                            System.out.println("Enter new book title:");
                            String newTitle = scan.nextLine();
                            System.out.println("Enter new book author:");
                            String newAuthor = scan.nextLine();
                            System.out.println("Enter new year of publication:");
                            int newYear = scan.nextInt();
                            scan.nextLine();  // Consume the newline
                            book.updateBookDetails(newTitle, newAuthor, newYear);
                            System.out.println("Book updated: " + book);
                            break;
                        }
                    }
                    if (!foundForUpdate) {
                        System.out.println("Book not found.");
                    }
                    break;

                case "Q":
                    isRunning = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        scan.close();
    }
}
