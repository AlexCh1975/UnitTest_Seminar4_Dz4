package fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class BookServiceTest {

    /**
     * DZ_5 Задание_2.
     * У вас есть класс BookService, который использует интерфейс BookRepository для получения
     * информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService, используя
     * Mockito для создания мок-объекта BookRepository.
     */
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp(){
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void testBookServiceFindBookById() {
        when(bookRepository.findById("1")).thenReturn(new Book("1", "Book1", "Author1"));

        Book result = bookService.findBookById("1");
        assertEquals(bookRepository.findById("1"), result);
    }

    @Test
    void testBookServiceFindAllBooks(){
        when(bookRepository.findAll())
                .thenReturn(Arrays.asList(new Book("1", "Book1", "Author1"), new Book("2", "Book2", "Author2")));

        List<Book>  result = bookService.findAllBooks();

        assertEquals(2, result.size());
        assertEquals(bookRepository.findAll(), result);
    }
}