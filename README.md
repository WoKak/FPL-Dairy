# FPL-Dairy

this is a web platform for making notes from Premier League matches for Fantasy PL
purposes, in future it will be also little game connected to this app

## Technology stack

* Java 8
* Spring MVC 4.2.2
* Spring JDBC 4.2.2
* Spring Security 4.2.2
* Servlet API 3.1
* JavaScript
* AJAX
* Jackson 2.8.8
* JSON
* jQuery
* JSP
* CSS
* Maven 3.3.9
* MySQL

# Features

* Adding notes from Premier League matches
* Dynamically searching and viewing added notes
* User registration

# To run this project:
 
* MySQL and proper tables in database used by program
* Tomacat server
Make the war file then place the file in Tomcat's webapps directory, 
run Tomcat server and access application here: "http://localhost:8080/home"
 
* database.properties file, i.e:

```
    jdbc.drivers=com.mysql.Driver
    
    jdbc.url=jdbc:mysql://localhost:3306/game
    
    jdbc.username=verysecretuser
    
    jdbc.password=verysecretpassword
```

##### Note

I am not the owner of the images, I've found them in the Internet.