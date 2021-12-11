# Inventory_Management_System-TIMS-
ITP4507_Assignment
Task Specification
Imaginary
Toys Corporation is a toy trading company in Hong Kong The company purchases
various toy products from overseas and selling the products in Hong Kong The company plans to
develop a toy inventory management system TIMS) for maintaining inventory record s The
following is the simplified class diagram of existing data maintained by the company.
![image](https://user-images.githubusercontent.com/73983294/145671811-57dd0614-8a33-477e-a81b-59ad6f009f41.png)
As a system analyst of the Company, you are required to design and develop TIMS . You are reminded that the design of the existing classes: ToyProduct , Robot and Remote Control Car must be
kept unchanged.
TIMS should p rovide the following functions:
1. Create a ToyProduct record with zero quantity ( Robot or Remote Control Car or any new kind of ToyProduct in the coming future)
2. Display ToyProduct details (such as productID, name, qty, height/maximum speed) by a given productID (input code=* to display all records)
3. Purchase ToyProduct and update the qty and the cost of the inventory records
4. Sell ToyProduct and update the qty and the price of the inventory records
5. Undo last command
6. Redo the last undone command
7. Show undo/redo list
Your system design should conform to the Open Closed Principle so that your design should easily
be extended to support new functions (e.g. change of name of ToyProduct ) and toy products , for
example, creatio n of Doll rec ord which is a subclass of ToyProduct
You MUST apply the following design patterns for your new system
- Command pattern to provide the “create toy”, “display toy”, “purchase toy”, “sell toy”, “undo”, “redo” and “display undo/redo list” functions
- Factory pattern or Abstract Factory Pattern to create different Command objects and ToyProduct objects (e.g. Robot object, RemoteControlCar object, etc.)
- Memento pattern to provide “Undo” and “Redo” functions

Class diagram:
![Class diagram](https://user-images.githubusercontent.com/73983294/145671970-5e98e3f0-996d-4892-bb4a-b71febedf0b7.jpg)
