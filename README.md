# A simple CRM system (Spring Framework, web MVC, JDBC, MySQL)

Run:
- JDK 1.8
- Maven
- MySQL 5.7

Development:
- Eclipse

1. You have to create MySQL database named 'crm_db'. Schema is in src/main/resources folder.

2. Add resource to context.xml file (Tomcat server configuration file), change username and password to your database (standard username: crmuser, password: crm).
```xml
<Resource name="jdbc/crm_db" auth="Container" type="javax.sql.DataSource"
               maxTotal="100" maxIdle="30" maxWaitMillis="10000"
               username="crmuser" password="crm" driverClassName="com.mysql.cj.jdbc.Driver"
               url="jdbc:mysql://localhost:3306/crm_db?useSSL=false"/>
 ```
 
3. Standard login to CRM system: user, password: user.
