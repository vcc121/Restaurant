# Restaurant

Early pseudo is included in UML/proposal
  NOTE THAT THE PurchaseManager is still work in progress, and I plan to develop it more when I go further into this project.

  - I've noticed my UML for Account does not feature a setBalance method, but it is supposed to, so I am writing that here.

  - Additionally, I think It will be easier to take Customer.java from the bank program, rather than having all of it as a part of User. So, despite not being part of the UML, this will be another key piece.

  - For PurchaseManager, I think I will have a menu for the user, and they can add items onto their order, which will be a list. The items will have corresponding prices which will be added to their order sum. This sum will then be deducted from their account upon purchase, unless their balance is less than the order price, in which case the order will be cancelled.
