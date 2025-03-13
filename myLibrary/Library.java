package myLibrary;

import mybook.Book;
import mymember.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books;
    private Map<String, Member> members;
    private List<String> transactions;

    public Library() {
        books = new ArrayList<>();
        members = new HashMap<>();
        transactions = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public void borrowBook(String memberId, String ISBN) {
        Member member = members.get(memberId);

        if (member != null) {
            Book book = findBookByISBN(ISBN);
            if (book != null) {
                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    transactions.add(ISBN + " borrowed");
                    System.out.println("Success");
                } else {
                    System.out.println("Book is already borrowed");
                }
            } else {
                System.out.println("Book not found");
            }
        } else {
            System.out.println("Member not found");
        }
    }

    public void returnBook(String memberId, String ISBN) {
        Member member = members.get(memberId);

        if (member != null) {
            Book book = findBookByISBN(ISBN);
            if (book != null) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    transactions.add(ISBN + " returned");
                    System.out.println("Success");
                } else {
                    System.out.println("Book was not borrowed");
                }
            } else {
                System.out.println("Book not found");
            }
        } else {
            System.out.println("Member not found");
        }
    }

    private Book findBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public void printTransactions() {
        System.out.println("Transactions:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        System.out.println("Library");
    }
}
