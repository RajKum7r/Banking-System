
-- CREATE database banking_system;
USE banking_system;

CREATE TABLE Customers (
  CustomerID INT PRIMARY KEY,
  Name VARCHAR(255),
  Address VARCHAR(255),
  PhoneNumber VARCHAR(20),
  Email VARCHAR(255)
);

 CREATE TABLE Accounts (
  AccountID INT PRIMARY KEY,
  CustomerID INT,
   AccountType VARCHAR(20),
   AccountBalance DECIMAL(10, 2),
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

 CREATE TABLE Transactions (
  TransactionID INT PRIMARY KEY,
   AccountID INT,
   TransactionType VARCHAR(20),
   TransactionAmount DECIMAL(10, 2),
   TransactionDate DATE,
  FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

 INSERT INTO Customers (CustomerID, Name, Address, PhoneNumber, Email)
VALUES
  (1, 'John Doe', '123 Main St', '123-456-7890', 'john.doe@example.com'),
  (2, 'Jane Doe', '456 Elm St', '987-654-3210', 'jane.doe@example.com');

INSERT INTO Accounts (AccountID, CustomerID, AccountType, AccountBalance)
VALUES
  (1, 1, 'Checking', 1000.00),
  (2, 1, 'Savings', 500.00),
  (3, 2, 'Checking', 2000.00);

INSERT INTO Transactions (TransactionID, AccountID, TransactionType, TransactionAmount, TransactionDate)
VALUES
  (1, 1, 'Deposit', 100.00, '2022-01-01'),
  (2, 1, 'Withdrawal', 50.00, '2022-01-05'),
  (3, 2, 'Deposit', 200.00, '2022-01-10'),
  (4, 3, 'Withdrawal', 100.00, '2022-01-15');


CREATE VIEW CustomerAccounts AS
SELECT c.CustomerID, c.Name, a.AccountID, a.AccountType, a.AccountBalance
FROM Customers c
JOIN Accounts a ON c.CustomerID = a.CustomerID;


CREATE VIEW TransactionHistory AS
SELECT t.TransactionID, t.AccountID, t.TransactionType, t.TransactionAmount, t.TransactionDate
FROM Transactions t;



DELIMITER //
CREATE PROCEDURE DepositMoney(IN accountID INT, IN amount DECIMAL(10, 2))
BEGIN
  UPDATE Accounts
  SET AccountBalance = AccountBalance + amount
  WHERE AccountID = accountID;
END
 DELIMITER ;

DELIMITER //
CREATE PROCEDURE WithdrawMoney(IN accountID INT, IN amount DECIMAL(10, 2))
BEGIN
  UPDATE Accounts
  SET AccountBalance = AccountBalance - amount
  WHERE AccountID = accountID;
END
 DELIMITER ;









