# Restaurant

Early pseudo is included in UML/proposal
  NOTE THAT THE PurchaseManager is still work in progress, and I plan to develop it more when I go further into this project.

  - I've noticed my UML for Account does not feature a setBalance method, but it is supposed to, so I am writing that here.

  - Additionally, I think It will be easier to take Customer.java from the bank program, rather than having all of it as a part of User. So, despite not being part of the UML, this will be another key piece, and a new class.

  - For PurchaseManager, I think I will have a menu for the user, and they can add items onto their order, which will be a list. The items will have corresponding prices which will be added to their order sum. This sum will then be deducted from their account upon purchase, unless their balance is less than the order price, in which case the order will be cancelled.
    - To my knowledge, I think I can best accomplish this by using two arrays, one for food names and the other for food prices. This way, I can print the menu with a for loop, as well as the prices, and they can be easily accessed to add to the customer's order. Additionally, the total price will be a sum of the prices in the customer's order.
    - After doing some research,  I think using a StringBuilder class would be a good way to set up the menu, so that I can add the arrays' elements rather than wiriting out the entire menu. This allows the menu to be easily changed and repriced.
    - Additionally, a list will be used to kep track of the order, and to eventually show the order and total price at checkout.
    - Lastly, by using int variables, the other options in the menu for checkout and vew order will be using variables equal to the menu length + 1 and + 2, so these options will change dyanmically with the menu length, for ease of use.
