# todo-api
- todo-api depends on **reportgenerator** project for creating excel report.
- Make sure [reportgenerator](https://github.com/reshma-jo/report-generator) in the background before running this app.

## Building the app locally
mvn clean install -U

## Running the app locally
mvn spring-boot:run

## Endpoints exposed

1) **GET** `/todo/`

2) **POST** `/todo/`

3) **DELETE**  `/todo/{id}`

4) **PUT** `/todo/{id}`

5) **GET** `/todo/export`

### Sample POST request:
> **Endpoint** : localhost:8080/todo/
> 
> **Request Body**:
>`{
"title" : "Buy eggs",
"dueDate" : "14-07-2024",
"completed" : false
}`