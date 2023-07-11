package com;

import java.util.ArrayList;
import java.util.List;

class Book {
    private int isbnno;
    private String bookName;
    private String author;
    public Book(int isbnno, String bookName, String author) {
        this.isbnno = isbnno;
        this.bookName = bookName;
        this.author = author;
    }
    public int getIsbnno() {
        return isbnno;
    }
    public void setIsbnno(int isbnno) {
        this.isbnno = isbnno;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}

class Library {
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public boolean isEmpty() {
        return bookList.isEmpty();
    }

    public List<Book> viewAllBooks() {
        return bookList;
    }

    public List<Book> viewBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public int countNoOfBooks(String bookName) {
        int count = 0;
        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                count++;
            }
        }
        return count;
    }
}

public class BookManipulation {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book(123456, "abc", "kilo"));
        library.addBook(new Book(789012, "xyz", "zesh"));

        // Checking if the library is empty
        System.out.println("Is library empty? " + library.isEmpty());

        // Displaying all books in the library
        List<Book> allBooks = library.viewAllBooks();
        System.out.println("All books in the library:");
        for (Book book : allBooks) {
            System.out.println("ISBN: " + book.getIsbnno());
            System.out.println("Name: " + book.getBookName());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("-----------------------");
        }

    }
}
