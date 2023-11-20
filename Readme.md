## DZ_4.  Задание 1.

1) Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван
   с определенными аргументами?
3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное
   значение или исключение в ответ на вызов метода?
4) Какой тип тестовой заглушки вы бы использовали для имитации взаимодействия с внешним API или
   базой данных? 


### Ответы:

1. Преимуществом использования **тестовых заглушек** является возможность получить согласованные 
   результаты, чтобы упростить написания тестов.
   Если модуль зависит от других модулей, функций или классов, которые еще не имеют реализации,
   создаются тесовые заглушки для замены этих зависимостей, что позволяет тестировать 
   модуль отдельно от внешних зависимостей сконцентрировавшись на проверке функциональности 
   модуля. 
   Скорость инадежность тестов при этом подходе увеличивается.

2. **Нужно использовать Spy или Mock.**
   Spy заглушки записывают информацию о вызовах метода, включая аргументы. Это позволяет 
   проверить метод на вызов с определенными аргументами, также шпионы могут возвращать реальные
   значения или использовать для контроля ответа заглушки.
   Mock заглушки предопределяют ожидаемые выводы методов и их возвращаемые значения. При их 
   использовании можно задать ожидаемые аргументы и проверить, что метод был вызван с аргументами.
   Также моки могут предоставлять специальные поведения для тестирования разных сценариев.

3. **Нужно использовать такие заглушки как Stubs и Fake.** 
   Stubs заглушки задают фиксированное возвращаемое значение для вызовов методов, не требуют 
   каких-либо проверок, а просто возвращают ожидаемое значение. Удобна при тестировании,
   когда требуется вернуть значение без сложной логики или внешних зависимостей.
   Fake заглушки реализуют упрощенную версию реального объекта или интерфейса. Они используются 
   для имитации внешних зависимостей таких как база данных или внешних API, а так же могут 
   предоставлять фиксированные данные, с помощью которых можно тестировать функционал зависящий 
   от этих ресурсов.

4. **Нужно использовать Fake заглушки.**
   Они могут воссоздать поведение внешних зависимостей и предоставлять фиксированные данные
   для тестируемого модуля, который использует эти зависимости.
   Например создается фейк базы данных, в которой хранятся данные предоставляемые для 
   тестирования.
   При использовании фейков модуль изолируется от реальных зависимостей и происходит 
   сосредоточение только на тестировании его логики. Тестирование происходит быстрее так как 
   не требуется подключение к реальным ресурсамю.
   