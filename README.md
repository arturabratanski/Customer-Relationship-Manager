# Customer-Relationship-Manager

__Description__
* Main objective of this project was to programm a web application for client management, including features such as Add, Search, Update, Delete
* Spring MVC was used for above, Hibernate was used to integrate the Database
* The controller sends the user to the appropriate views programmed in JSP, stylized with CSS
* The application uses a structure in which the appropriate DAO and Service classes stand between the interface and the Database

## Important files

* CRMLoggingAspect.java -> AOP class used for logging  
    __
* CustomerController.java -> Main controller, mapps all http paths  
    __
* CustomerDAO.java.java -> It's a DAO class to communicate with database  
    __
* CustomerDAOImpl.java -> Implements all DAO methods, uses session factory for that  
    __
* Customer.java -> Entity class, all fields are mapped to DB columns  
    __
* CustomerService.java -> Service layer, to connect with DAO  
    __
* CustomerServiceImpl.java -> Service implementation, handles transactional side of app  
    __
* add-customer-style.css, style.css -> styles used for main page and "add customer" page  
    __
* customer-form.jsp -> JSP view for adding new customer  
    __
* list-customers.jsp -> JSP view for main page, customer table  
    __
* spring-mvc-crud-demo-servlet.xml -> XML config file for DB connection, AOP and other  
    __

### Other files are vendors data, supplied or found for this project purpose
