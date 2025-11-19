# Copilot Instructions for Course Management System

## Project Overview
This is a Command-Line Interface (CLI) Course Management System built in Java. It demonstrates Object-Oriented Programming (OOP) principles and file-based data persistence.

## Core Requirements
- **Interface**: CLI (Command-Line Interface) only. No GUI.
- **Language**: Java.
- **Persistence**: Data (Users, Grades) must be stored in text files (`.txt`).
- **Roles**:
  - **Instructor**: Add students, assignments, record grades, view averages, export data.
  - **Student**: View own grades, averages, export own data.

## Architecture & Roles
The project is divided into two main areas of responsibility:

### 1. Frontend (User Interface) - `com.cms.ui`
**Responsibility**: Handling user input and displaying output.
- **Login Screen**: Prompt for username/password.
- **Menus**: Distinct menus for Students vs. Instructors.
- **Input Handling**: Validating user choices (1-5, etc.).
- **Display**: Formatting tables/lists for the console.

### 2. Backend (Logic & Data) - `com.cms.backend`
**Responsibility**: Data models, business logic, and file I/O.
- **Models**: `Student`, `Instructor`, `Assignment`, `Course`.
- **Services**: `AuthenticationService`, `GradeService`.
- **Data Access**: Reading/writing `users.txt` and `grades.txt`.

## Data Persistence Strategy
- **users.txt**: Stores `username,password,role`
- **grades.txt**: Stores `studentId,assignmentId,score`
- **Loading**: Data is loaded into memory (Lists/Maps) at startup.
- **Saving**: Data is written back to files immediately after changes or at exit.

## Development Guidelines
- **Entry Point**: `Main.java` should initialize the system and start the UI loop.
- **Error Handling**: Use `try-catch` for File I/O and invalid user input.
- **Separation of Concerns**: The UI classes should NOT contain business logic (e.g., calculating averages). They should call Backend methods.

## Testing
- Use JUnit for testing backend logic (grade calculations, file parsing).
- Manual testing for the CLI flow.