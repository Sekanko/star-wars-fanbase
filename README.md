# Star Wars Fanbase

## 📖 About the Project
It was the major project for my Advanced Java class. It is a Wikipedia-like page about Star Wars, where users can search for information about the universe or films and create accounts to add their favorite character, 
planet, and film. The project uses the [Star Wars API](https://swapi.py4e.com/) as a data source. It is a multimodule project where each module is a separate Spring Boot application to meet the project requirements.

Currently, users can browse data about characters, planets, and films in the Star Wars universe. There is also the option to register an account and add favorite characters, planets, and films.

**Regrettably, I was unable to complete the project fully due to misleading deadline information and other classes. However, I plan to complete this project in the future.**

## 🗒️ To-do list
- Complete CSS for all pages
- Update searching functionality (currently you have to write whole name)
- Make Spring Security responsible for logging users
- Create and handle exceptions
- Make the theme more Star Wars-like
- Create Selenium and Unit Tests

## 🛠️ Technologies Used:
- **Frontend**: HTML, CSS  
- **Backend**: Java, Spring Boot, Thymeleaf, MySQL  
- **Additional**: IntelliJ IDEA, Gradle, MySQL Workbench, Git

## 🧱 Build Instructions**
1. Clone the Repository
2. Create a local MySQL database
3. Insert into Environmental Variables

Set the following environment variables:

```
DATABASE_USER=your_username
DATABASE_PASSWORD=your_password
DATABASE_URL=your_database_url
```

> 💡 Example:
> ```
> DATABASE_USER=dataManager
> DATABASE_PASSWORD=123
> DATABASE_URL=mysql://localhost:3306/STFanDatabase
> ```

4. Run:
- FanbaseDataUpdaterApplication
- FanbaseWebApiApplication
- FanbaseClient

5. Update All Data

To trigger an update of the database, send a `POST` request to:

```
http://localhost:8082/update/all
```

This endpoint does not require a request body

### 🔗 Application Endpoint

The application should run at:
```
http://localhost:8080/fanbase/main
```

### ❗ Important ❗
- The current version does **NOT** handle exceptions, so create a user before you try to log in
- You have to write the whole name to successfully search

## 💬 My comment
This project was assigned at the last month of the third semester, so it is currently incomplete.
Its main purpose was to assess our knowledge of Java, Spring and REST APIs — not full-stack development.
As a result, there are some unused endpoints, and the frontend is minimal since it wasn't graded.
However, after reviewing the project myself, I've decided to complete it properly soon.  

### 🙏 Thank You for Your Time
