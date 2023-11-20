package fourth.message;


import org.junit.jupiter.api.Test;
import seminars.fourth.message.MessageService;
import seminars.fourth.message.NotificationService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    /**
     *  4.5 Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
     * Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
     * recipient), который отправляет сообщение получателю.
     * Вам необходимо проверить правильность работы класса NotificationService, который использует
     * MessageService для отправки уведомлений.
     */

    @Test
    void testNotificationService(){
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);

        notificationService.sendNotification("good", "Alex");
        verify(messageService).sendMessage("good", "Alex");
    }
}