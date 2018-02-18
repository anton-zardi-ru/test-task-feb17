# Задание

**Имеем**:

Хранилище клиентских контактов и их заявок на банковские продукты (сделать в in memory
db).

У контакта есть идентификатор CONTACT_ID.

У контакта может быть много заявок.

Заявки имеют идентификатор APPLICATION_ID, дату создания (дата подачи заявки в банк)
DT_CREATED и название продукта PRODUCT_NAME.

**Необходимо:**

спроектировать структуру БД

сделать standalone-приложение на Java с использованием Spring boot.

Приложение должно предоставлять REST-сервис, получающий методом GET на вход
идентификатор контакта. По данному контакту необходимо получить его последнюю заявку
(max(DT_CREATED)).

Ответ оформить в виде JSON с полями APPLICATION_ID, CONTACT_ID, DT_CREATED,
PRODUCT_NAME.

**Обязательные требования:**

- standalone приложение, собранное в fat-jar со всеми необходимыми библиотеками, внутри;
- обработка ошибок – БД недоступна и т.п.;
- unit-tests, написанные с использованием JUnit4;
- сборка приложения с помощью Maven.

**Дополнительные требования (желательно):**

- предоставить клиенту сервиса возможность выбора формата ответа – JSON/XML;
- обработка исключительных ситуаций – контакт с указанным идентификатором не
найден и т.п.;
- реализовать REST-сервис с помощью Apache CXF;
- сделать описание сервиса в swagger specifications (http://swagger.io/).