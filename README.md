# PoliFood
 Spring Boot API with connection to a PostgreSQL relational database, deployed in a Google Cloud VM for the reception and management of orders in a cafeteria

## Stack and libraries 
- Spring Boot
  - `org.springframework.boot`
  - `version 3.2.1`
- Java
  - `java`
  - `version 21`
- Maven
  - `mvn`
  - `version 4.0.0`
- SQL DataBase Connection
  - `postgresql`
  - `org.postgresql`
- Building tools
  - `org.projectlombok`

## How to Start
Verify that you have the required java version installed.
```shell
java -version
```

Verify that you have the required maven version installed.
```shell
mvn -version
```

In case you do not have any of the above mentioned, please make the process of indicated in their respective official pages.

It is also necessary that you have a DBMS, the project is configured to be used with `postgresql` but it can be modified. Run you database.

Open the application.properties file and edit the following according to the settings you already have.

Specify the port used to access from the browser
```shell
server.port=8080
```

Specify the dialect of the database that Spring Boot should use
```shell
spring.jpa.database=POSTGRESQL
```

Specify database platform
```shell
spring.datasource.platform=postgres
```

Specify the database port and database name
```shell
spring.datasource.url=jdbc:postgresql://localhost:dbport/name
```

Specify the database username and password
```shell
spring.datasource.username=username
spring.datasource.password=password
```

Specify the dialect that Hibernate will use to generate SQL compatible with your database
```shell
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect
```

Navigate to the root of the project via the command line and execute the command
```shell
mvn spring-boot:run
```

Open your browser and access the port you specified in the application.properties file.

## Endpoints 
Endpoint | Method | Description
| :---        |    :----:   |          :--- |
/usuario | POST | Returns a json with the registered user, requires to send a json with email and password.
/usuario/registro | POST | A json is sent with all the necessary data to register a user in the database.
/empleados | GET | Returns a json with all registered employees.
/empleado/{id} | GET | Returns a json with information of the employee according to his {id}.
/empleado/{id} | POST | A json is sent with the password entered to log in the employee {id}.
/empleado/tipo/{type} | GET | Returns a json with all employees according to the {type} entered.
/productos | GET | Returns a json with all the registered products.
/producto/{id} | GET | Returns a json with product information according to its {id}.
/productos/categoria/{category} | GET | Returns a json with all the products according to the {category} entered.
/pedidos | GET | Return a json with all the orders.
/pedido | POST | A json is sent with all the necessary data to register an order in the database.
/pedido/{id} | GET | Returns a json for the {id} request entered.
/usuario/pedidos/{id} | GET | Returns a json with all the registered orders of the user {id}.
/pedidos/estado/{state} | GET | Returns a json with all requests with a state of {state}.
/contenido | POST | A json is sent with the necessary data to add another element to an order.
/contenido/{id} | GET | Returns a json with the content of an order, requires the {id} of the order to be sent.
/contenido/{id}/total | GET | Returns the total of an order {id}.
/asignar | POST | Send a json with the order identifier, the order identifier and the date-time of assignment.
/asignados | GET | Returns a json the identifier of the orders that have    already been assigned along with the employee identifier and the date-time of assignment.
/empleado/asignados/{id} | GET | Returns a json with all the assignments of an employee {id}, it contains the order identifier, the employee identifier and the date-time of assignment.