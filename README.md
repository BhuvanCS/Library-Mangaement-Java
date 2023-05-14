# Library-Mangaement-Java
Library Management system using Java - OOPs and File Handling

Files Used:
UserLogin.txt - Username and Password of all active members
UserDetails.txt - To store General Details and current status' of all active users.
BookList.txt - To store details (Book name, Author name and Book ID) of all available books in the library
<UserName>.txt - File created for each user upon creation of account. Holds all actions performed by the user with that account.
  
Classes Used:
Book.java - Blueprint for a Book object and perform all Book related operations
User.java - Blueprint for a User object, and performs all user activities
LibraryManagement.java - Driver code for all operations, also performs Admin Operations
Datahandling.java - Contains functions to handle all data extracted from files. All functions are common to both User.java and Book.java and inherited by both.
Main.java - Contains the main() function
