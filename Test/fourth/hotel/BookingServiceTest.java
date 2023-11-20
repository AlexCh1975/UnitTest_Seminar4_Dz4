package fourth.hotel;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.fourth.hotel.BookingService;
import seminars.fourth.hotel.HotelService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {
    /**
     *  Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
     * Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
     * который обычно проверяет, доступен ли номер в отеле.
     * Вам необходимо проверить правильность работы класса BookingService, который
     * использует HotelService для бронирования номера, если он доступен.
     */
    public HotelService hotelService;
    public BookingService bookingService;

    @BeforeEach
    void setUp(){
        hotelService = mock(HotelService.class);
        bookingService = new BookingService(hotelService);
    }
    @Test
    void testBookingServiceBookRoomTrue(){
        when(hotelService.isRoomAvailable(24)).thenReturn(true);
        Boolean result  = bookingService.bookRoom(24);
        assertEquals(true, result);
    }

    @Test
    void testBookingServiceBookRoomFalse(){
        Boolean result  = bookingService.bookRoom(1);
        assertFalse(result);
    }
}