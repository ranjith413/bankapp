

Rest end points and their description:

Method: POST   path: /bank/createAcccount/
Description: creates an new account and new customer profile
Input:
takes below JSON props in RequestBody

{
    "customerName": "Ranjith",
    "customerMobileNo": "9123456789",
    "customerEmail": "ranjith@mail.com",
    "customerAddress": "1-73, Hyderabad",
    "accountType": "SAVINGS",
    "initialBalance": 1000
}

Returns: String with account number
---------------------------

Method: GET path: /bank/getAccountById/{accountNumber}
Description: takes accountNumber as PathVariable and returns account details along with customer profile
PathVariable: accountNumber

returns: Account details along with customer profile
---------------------------

Method: GET   path: /bank/getAllAccounts
Description: returns all account details along with customer details

---------------------------

Method: GET   path: /bank/getAllCustomers
Description: returns: all customer details along with accounts

---------------------------

Method: POST path: /bank/transferFunds?from=1&to=2&amount=500
Description: takes accountNumbers from & to which are sender & receiver accountNumbers respectively along with amount to be transferred. updates the account balances accordingly

RequestParams: from, to, amount

returns: SUCCESS or ID MISMATCH or INSUFFICIENT FUNDS
---------------

Method: GET path: /bank//getBalance/{accountNumber}
Description: takes accountNumber as PathVariable and returns account balance 
---------------

Method: PUT path: /bank/deposit?accountNumber=1&amount=500
Description: takes account number and amount as requestparams and adds the amount to balance of that account
----------------

Method: DELETE path: /bank/deleteCustomer/{customerId}
Description: takes customerId and deletes customer profile and account related to the customer
--------------------

Method: PUT path: /bank/updateCustomer/{customerId}
Description: takes custmerId as PathVariable and CustermerDto in RequestBody and updates the customer details

RequestBody:
{
    "customerName": "",
    "customerMobileNo": "",
    "customerEmail": "",
    "customerAddress": ""
}
---------------------

Method: 


