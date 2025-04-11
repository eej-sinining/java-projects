import java.util.*;

class Book {
    String bookTitle, bookAuthor;
    int yearOfPublication;

    public Book(String bookTitle, String bookAuthor, int yearOfPublication)
    {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.yearOfPublication = yearOfPublication;
    }

    public String toString()
    {
        return bookTitle + " by " + bookAuthor + " (" + yearOfPublication + ")";
    }
}
public class LinkedListCRUD {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        LinkedList<Book> bookList = new LinkedList<>();

        String bookTitle, bookAuthor, choice;
        int yearOfPublication;

        boolean isRunning = true;
        while (isRunning)
        { 
            System.out.println("What would you like to do?");
            System.out.println("[A] Add a book");
            System.out.println("[R] Remove a book");
            System.out.println("[L] List all books");
            System.out.println("[Q] Quit");
            choice = scan.nextLine();

            switch (choice)
            {
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
                    System.out.println("Enter book title:");
                    bookTitle = scan.nextLine();
                    for (Book book : bookList)
                    {
                        if (book.bookTitle.equals(bookTitle))
                        {
                            bookList.remove(book);
                            break;
                        }
                    }
                case "L":
                    for (Book book : bookList)
                    {
                        System.out.println("Here are the books listed:");
                        System.out.println(book);
                    }
                    break;
                case "Q":
                    isRunning = false;
                    break;
            }
        }
    }
}