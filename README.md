# Star Wars Fanbase

## 📖 About the Project
It was the major project for my Advanced Java class. It is a Wikipedia-like page about Star Wars, where users can search for information about the universe or films and create accounts to add their favorite character, 
planet, and film. The project uses the [Star Wars API](https://swapi.py4e.com/) as a data source. It is a multimodule project where each module is a separate Spring Boot application to meet the project requirements.

Currently, users can browse data about characters, planets, and films in the Star Wars universe. There is also the option to register an account and add favorite characters, planets, and films.

**Regrettably, I was unable to complete the project fully due to some unexpected challenges and a packed academic schedule.**

## 🛠️ Technologies Used:
- **Frontend**: HTML, CSS  
- **Backend**: Java 21, Spring Boot, Thymeleaf, MySQL  
- **Additional**: IntelliJ IDEA, Gradle, MySQL Workbench, Git

## 🧱 Build Instructions
1. Clone the Repository
2. Create a local MySQL database
3. Insert into Environmental Variables

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
This project was assigned at the last month of the third semester and it is currently incomplete.
Its main purpose was to assess our knowledge of Java, Spring and REST APIs — not full-stack development.
As a result, there are some unused endpoints, and the frontend is minimal since it wasn't graded.
I'm not going to complete this project, because I would rather learn new technologies by creating new projects from scratch.

### 🙏 Thank You for Your Time
