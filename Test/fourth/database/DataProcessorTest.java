package fourth.database;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import seminars.fourth.database.DataProcessor;
import seminars.fourth.database.Database;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DataProcessorTest {

    /**
     * 4.6 Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
     * Условие: У вас есть класс Database с методом public List<String> query(String sql), который выполняет SQLзапрос и возвращает результат.
     * Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
     * выполнения запроса и обработки результатов.
     */

    @Test
    void testDataProcessor(){
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);
        when(database.query(anyString())).thenReturn(Arrays.asList("Data1", "Data2", "Data3"));

        List<String> result = dataProcessor.processData("Query");

        verify(database).query("Query");
        assertEquals(3, result.size());
    }

}