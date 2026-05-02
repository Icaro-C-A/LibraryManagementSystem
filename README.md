# 📚 Library Management System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Status](https://img.shields.io/badge/Status-Work_in_Progress-blue?style=for-the-badge)

A robust, Object-Oriented Library Management System built purely in Java. This project simulates the core operations of a real-world library, including managing book collections, registering readers, and processing book loans. 

Currently under active development, this system features a custom-built, cross-OS compatible local file persistence engine, ensuring no data is lost when the program closes!

## ✨ Key Features (Currently Implemented)

* **Object-Oriented Architecture:** Clean separation of concerns using classes like `Book`, `Reader`, `Librarian`, and `Collection`.
* **Local Data Persistence:** A custom `FilesManager` class that automatically bridges the gap between fast RAM and permanent Hard Drive storage.
* **Cross-OS Compatibility:** Safely runs on Windows, Mac, and Linux by utilizing dynamic file pathing (`File.separator`).
* **Automated Environment Setup:** The system automatically generates its required `data/` directory and `.txt` database files (`collection.txt`, `readers.txt`, `loans.txt`) upon initialization if they do not exist.
* **English Codebase:** Fully refactored to use standard English naming conventions for classes, variables, and methods.

## 🏗️ Project Structure

The project is organized into logical packages:

* `src/LibraryManager/`: Contains the core domain entities (`Book`, `Reader`, `Loan`) and the system managers (`Collection`, `Librarian`).
* `src/Files/`: Contains the `FilesManager`, strictly responsible for reading, parsing, and saving state to the local text files.
* `data/`: An auto-generated directory that acts as the system's database, keeping the root project clean.

## 🚀 Getting Started

To run this project locally on your machine:

1. Clone the repository:
   ```bash
   git clone [https://github.com/Icaro-C-A/LibraryManagementSystem.git](https://github.com/Icaro-C-A/LibraryManagementSystem.git)
