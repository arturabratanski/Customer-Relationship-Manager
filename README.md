# Customer-Relationship-Manager

__Description__
* Main objective of this project was to programm a web application for client management, including features such as Add, Search, Update, Delete
* Spring MVC was used for above, Hibernate was used to integrate the Database
* The controller sends the user to the appropriate views programmed in JSP, stylized with CSS
* The application uses a structure in which the appropriate DAO and Service classes stand between the interface and the Database

## Important files

* CRMLoggingAspect.java -> AOP class used for logging  
    _src/com/luv2code/springdemo/aspect/CRMLoggingAspect.java_
* CustomerController.java -> Main controller, mapps all http paths  
    _src/com/luv2code/springdemo/controller/CustomerController.java_
* CustomerDAO.java.java -> It's a DAO class to communicate with database  
    _src/com/luv2code/springdemo/dao/CustomerDAO.java_
* CustomerDAOImpl.java -> Implements all DAO methods, uses session factory for that  
    _src/com/luv2code/springdemo/dao/CustomerDAOImpl.java_
* Customer.java -> Entity class, all fields are mapped to DB columns  
    _src/com/luv2code/springdemo/entity/Customer.java_
* CustomerService.java -> Service layer, to connect with DAO  
    _src/com/luv2code/springdemo/service/CustomerService.java_
* CustomerServiceImpl.java -> Service implementation, handles transactional side of app  
    _src/com/luv2code/springdemo/service/CustomerServiceImpl.java_
* add-customer-style.css, style.css -> styles used for main page and "add customer" page  
    _WebContent/resources/css/add-customer-style.css_
    _WebContent/resources/css/style.css_
* customer-form.jsp -> JSP view for adding new customer  
    _WebContent/WEB-INF/view/customer-form.jsp_
* list-customers.jsp -> JSP view for main page, customer table  
    _WebContent/WEB-INF/view/list-customers.jsp_
* spring-mvc-crud-demo-servlet.xml -> XML config file for DB connection, AOP and other  
    _WebContent/WEB-INF/spring-mvc-crud-demo-servlet.xml_

### Other files are vendors data, supplied or found for this project purpose
