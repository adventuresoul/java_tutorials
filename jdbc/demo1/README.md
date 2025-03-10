# JDBC Operations

## Introduction
This project demonstrates basic JDBC (Java Database Connectivity) operations such as connecting to a database, executing queries, and handling results using PostgreSQL.

## Prerequisites
- Java Development Kit (JDK) installed
- PostgreSQL database installed and running
- PostgreSQL JDBC driver (download from [here](https://jdbc.postgresql.org/))
- An existing database with a table for testing

## Database Setup
1. Start PostgreSQL and create a database:
   ```sql
   CREATE DATABASE mydatabase;
   ```
2. Create a sample table:
   ```sql
   CREATE TABLE users (
       id SERIAL PRIMARY KEY,
       name VARCHAR(50) NOT NULL,
       email VARCHAR(100) UNIQUE NOT NULL
   );
   ```
3. Insert sample data:
   ```sql
   INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com');
   INSERT INTO users (name, email) VALUES ('Jane Doe', 'jane@example.com');
   ```

## JDBC Setup
### Adding PostgreSQL JDBC Driver
- If using **Maven**, add this dependency to `pom.xml`:
  ```xml
  <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.3.1</version>
  </dependency>
  ```
- If using **manual JAR**, download and add `postgresql-42.3.1.jar` to the classpath.

## JDBC Code Example
### Connecting to Database
```java
String jdbcURL = "jdbc:postgresql://localhost:5432/mydatabase";
String username = "postgres";
String password = "password";

try (Connection conn = DriverManager.getConnection(jdbcURL, username, password)) {
    System.out.println("Connected to PostgreSQL database!");
} catch (SQLException e) {
    e.printStackTrace();
}
```

### Performing a SELECT Query
```java
String sql = "SELECT * FROM users";
try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery(sql)) {
    
    while (rs.next()) {
        System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("email"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}
```

### Performing an INSERT Query with PreparedStatement
```java
String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
     PreparedStatement ps = conn.prepareStatement(sql)) {
    
    ps.setString(1, "Alice");
    ps.setString(2, "alice@example.com");
    int rowsInserted = ps.executeUpdate();
    System.out.println(rowsInserted + " row(s) inserted.");
} catch (SQLException e) {
    e.printStackTrace();
}
```



