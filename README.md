# Stellar Burgers API Tests

## Описание проекта

Этот проект представляет собой набор автотестов для проверки API сервиса Stellar Burgers. Проект написан на Java с использованием библиотеки RestAssured для выполнения HTTP-запросов и JUnit для организации тестов. В тестах проверяется создание пользователей, обработка ошибок при регистрации, а также корректное удаление пользователей после выполнения тестов.

## Структура проекта
UserCreationTest.java: Класс, содержащий тесты на проверку различных сценариев регистрации пользователей.
User.java: Модель, представляющая пользователя, включающая поля email, password и name.
TokenResponse.java: Модель, представляющая ответ от API при регистрации, включающая поле с токеном доступа.

## Установка и настройка
### Требования
Java Development Kit (JDK) версии 11 или выше.
Maven для управления зависимостями.
Среда разработки, такая как IntelliJ IDEA.
### Шаги установки
Клонирование репозитория:
`git clone https://github.com/your-username/stellar-burgers-api-tests.git`

Переход в директорию проекта:
`cd stellar-burgers-api-tests`

Установка зависимостей:
Maven автоматически загрузит все необходимые зависимости при запуске тестов. 
Вы можете запустить следующую команду для их установки:
`mvn clean install`

## Запуск тестов
Для запуска тестов используйте следующую команду Maven:
`mvn test`

Тесты выполнятся автоматически, и вы увидите результат выполнения в консоли.

## Структура тестов
### Тесты на регистрацию пользователя
createUniqueUser: Проверяет успешную регистрацию уникального пользователя.
createExistingUser: Проверяет попытку повторной регистрации уже существующего пользователя, ожидается ошибка 403 с сообщением "User already exists".
createUserWithMissingField: Проверяет попытку регистрации пользователя с отсутствующим обязательным полем, ожидается ошибка 403 с соответствующим сообщением об ошибке.

### Удаление пользователя
Пользователь, созданный в каждом тесте, автоматически удаляется после завершения теста для поддержания чистоты данных.

## Используемые технологии
Java 11: Язык программирования для написания тестов.
JUnit 4: Фреймворк для написания и выполнения тестов.
RestAssured: Библиотека для выполнения и валидации HTTP-запросов в тестах.
Allure: Инструмент для генерации отчётов по тестам (используется в некоторых тестах для аннотирования).