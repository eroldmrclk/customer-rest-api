# customer-rest-api
*This application is a Rest API for customer information. The main software language is `Java` and `spring-boot`, `jsonwebtoken`, `devtools`, `mssql-jdbc` have been used. On the database side, `MsSql` is preferred.*

## Purpose of Application
*The purpose of this application is to provide convenience for programs that need to connect with the database. Thanks to the Rest API, data can be easily managed using the same API in mobile or web-based applications.*

## How to run in Spring Tool Suite 4?
*First, you need to add a custom application.properties file under the src / main / resources file. You should definitely include the following in the application.properties file and fill in the --------- fields according to yourself.* <br>
`server.port=8090` <br>
`spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver` <br>
`spring.datasource.url=jdbc:sqlserver://localhost;databaseName=----------------------;integratedSecurity=true;portNumber=1433` <br>
`spring.datasource.username= ---------------` <br>
`spring.datasource.password= ----------------------` <br>
`spring.jpa.show-sql=true` <br>
`spring.jpa.hibernate.ddl-auto=update` <br>
`spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect` <br>
`jwt.secret=springbootapp` <br>
`spring.main.allow-bean-definition-overriding=true` <br>
File -> Import -> Maven -> Existing Maven Project -> "show the file path of the application you downloaded" <br>

## Suggestion
*I recommend using Postman for doing rest api trials. For download: [https://www.postman.com/downloads/](https://www.postman.com/downloads/)*
