package pl.bookjava.aop;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

        public List<Book> getAllBooks() {
                // TODO Auto-generated method stub
                Book book1 = new Book();
                book1.setId(1);
                book1.setBookTitle("Modern Java");
                Book book2 = new Book();
                book2.setId(2);
                book2.setBookTitle("Beginning Grovy");
                Book book3 = new Book();
                book3.setId(3);
                book3.setBookTitle("Beginning Scala");

                List<Book> bookList = new ArrayList<Book>();
                bookList.add(book1);
                bookList.add(book2);
                bookList.add(book3);

                for(Book book: bookList)
                        System.out.println(book.getBookTitle());

                return bookList;
        }

}

