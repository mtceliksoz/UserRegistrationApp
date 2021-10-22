Build by Muhammed Talha Çeliksöz (mtceliksoz@gmail.com) 

# **UserRegistrationApp**

## **Introduction**

This a User Registration App. This App build has been developed using Spring Boot for backend API and Ionic-Angular for frontend App.
User has attributes such as id, name, email and password.
You could create an User account, login action, logout action, update and delete an existing User account.

## **Installition**

### **Requirements**

To run the project you should have 

-jdk (I have jdk-17),

-node.js

-npm 


### **Running the App**

After all the requirements satisfied you could run the project.

-Download the repository.

-Open terminal (I used windows command line)

-To run the Spring Boot Project inside the backendAPI file's directory

-And write this command `mvnw spring-boot:run`

-Tomcat server should be start on port 8080

-To run the Ionic Project inside the frontendApp file's directory

-And write this command `ionic serve`

-ionic app should be start on web browser (localhost:8100)


## **Testing the App**

At the beginning there is no user so you have to Register a User account.
After that you could login your account and on the user-home page you could update your infos, logout or delete your account.
You could also test the backendAPI using the Postman (use this url `http://localhost:8080/api/v1/user`)


## **backendAPI**

**User.java** : A model class for User account. Thera are some validations for user attributes.

**UserDb.java** : A class for database operations. For simplicity I used A User List to store accounts but in this class a connection to the sql databeses could be make.

**UserController.java** : This class is API for the frontendApp. API has 7 endpoints.

-addUser (POST request to http://localhost:8080/api/v1/user): Creates a new user and store. 

-getAllUser (GET http://localhost:8080/api/v1/user): returns all off the users.

-getUserById (GET http://localhost:8080/api/v1/user/{id}): returns the user has spesific id.

-LoginRequests (POST http://localhost:8080/api/v1/user/login): control the user's email and password and if they are correct change the user's isLoggedIn variable as true.

-deleteUserById (DELETE http://localhost:8080/api/v1/user/{id}): deletes the user.

-LogoutRequest (PUT http://localhost:8080/api/v1/user/logout/{id}): change the user's isLoggedIn variable as false.

-updateUserById (PUT http://localhost:8080/api/v1/user/{id}): updates the user's infos.


## **frontendApp**

Frontend App has 6 pages.

-Home page (http://localhost:8100/home) : You could go to the Register , Login page or List Users.

-Register page (http://localhost:8100/user-create): You could create a User account. You have to fill the places with valid inputs.

-Login page (http://localhost:8100/login): You could login to your User account.

-User-Home page (http://localhost:8100/user-home): You could go to the update page, delete your account or logout.

-Update page (http://localhost:8100/user-edit): You could update your infos.

-Users List page (http://localhost:8100/user-list): You could see all the user accounts.








 
