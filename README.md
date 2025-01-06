# Comprehensive-Student-Account-Management-System
Integrated Java for the backend as well as Javascript for the front end and web design. Instilled a data base using SQL and linked each of these codes using apache net beans. The classes used were 
ClassDescription.java and ClassEntry.java:
Represent course details, including course code, description, and seat availability. These classes provide constructors and methods to manipulate and retrieve course data.
CourseEntry.java:
Stores individual course details and provides getter methods to access course codes and descriptions.
ClassQueries.java and CourseQueries.java:
Handle database operations related to courses. These include adding, retrieving, and updating course details using SQL queries.
DBConnection.java:
Establishes and manages database connections using credentials and JDBC. This is the core of database interactions for the project.
ScheduleEntry.java and ScheduleQueries.java:
Represent and manage scheduling data, such as semester, course codes, student IDs, and their status. SQL queries are used to retrieve and update scheduling information.
StudentEntry.java and StudentQueries.java:
Manage student details like student IDs, names, and database queries for retrieving and updating student records.
SemesterQueries.java:
Handles database interactions for semester-related data.
MultiTableQueries.java:
Likely combines data from multiple tables, supporting complex queries involving students, courses, and schedules.
MainFrame.java:
Implements the graphical user interface (GUI) for the application. It handles user inputs, displays course details, and integrates database operations with a Swing-based interface.


To integrate the various features of the course scheduling system, I employed a modular design approach that seamlessly connected the backend logic, database operations, and the graphical user interface (GUI). The backend classes, written in Java, served as the core functionality, handling student, course, and schedule management. These classes were linked to the database through JDBC, ensuring efficient and secure interactions.

The DBConnection.java class established the foundation by creating a persistent database connection. Classes like ClassQueries, ScheduleQueries, and StudentQueries utilized this connection to execute SQL commands for tasks such as inserting new courses, retrieving schedules, or updating student information. The data flow between the database and the application was smooth and reliable, thanks to clearly defined SQL queries.

The GUI, developed in MainFrame.java using Java Swing, acted as the user-facing portal. This interface allowed students to view available courses, register for classes, and check their schedules. To bridge the backend and the frontend, I integrated event listeners and action handlers that responded to user inputs. For instance, when a student clicked "Register," the frontend triggered the corresponding backend method, which updated the database in real-time.

The combination of modular code, synchronized database operations, and an intuitive interface ensured a cohesive system where each component worked seamlessly, providing a smooth user experience.







