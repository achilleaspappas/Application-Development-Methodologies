# Application Development Methodologies

The purpose of this project is to develop a Java application with a GUI that manages orders, which will be stored/read in files as described below. The development of the User Interface should be done using AWT and/or Swing technologies. This project was part of a course I did in my 4th semester.

## Specifications

### GUI Appearance

The application must include four separate windows:

1. Main window: This window will display the summary information of all orders. The summary information of the orders (whether newly created or read from a file) will be displayed in a region of the window, such as within a List or TextArea component of AWT or Swing. The appropriate buttons and menus for executing the various functions of the application as described below should also be included in the main window.

2. New Order window: In this window, the user will enter the information to register a new order.

3. Statistics window: In this window, statistics related to the current orders, as described in detail below, will be presented.

4. Information window: This window will display information about the application and its developer.

### Functionality

1. New: Creating a new order. After entering all the necessary information, the user can save the order by clicking on a button. After the new order is saved, the window should close and the new order should appear in the corresponding region of the main window of the application.

2. Open: Searching for and opening an order file (using JFileChooser). The orders in the file should be displayed in the list that exists in the main window of the application. After opening the order file, the full path of the file should be displayed in a special field that should be appropriately placed on the main window.

3. Save: Saving all orders to the current file (or to a new file if it is the first time records are being saved) using JFileChooser. The file should follow the formatting described in the introduction.

4. Save As: Saving the orders to a new file. This option allows the user to create a new order file and save the records that exist in the application at that time (using JFileChooser).

5. Statistics: This option will display statistics of all orders that exist at that time in the main window of the application. The statistics that should be displayed are: the total number of orders, the total cost of orders (net and gross), the code of the most expensive order (in terms of gross value), and the code of the cheapest order (in terms of gross value).

6. About: This option will display information about the developer of the application (full name, student ID, development period) in a new window. It should also include a screenshot of the full desktop of your computer during the development phase of the application.

7. Exit: Closing the application (with an appropriate confirmation message) and the ability to save unsaved records.

## Usage

- Run the application
- Use the buttons and menus provided in the main window of the application to create, open, save, or view orders and their statistics.
- Use the 'About' option to view information about the developer.

## Contributing

This is a university project so you can not contribute.

## Authors

* **[University of West Attica]** - *Provided the exersice*
* **[Achilleas Pappas]** - *Made the app*

## License

This project is licensed by University of West Attica as is a part of a university course. Do not redistribute.

## Acknowledgments

Thank you to **University of West Attica** and my professors for providing the resources and knowledge to complete this project.
