CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
); 

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));



-- Scenario 1: The bank needs to process monthly interest for all savings accounts.
-- oQuestion: Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE ACCOUNTS
    SET balance = balance + (balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;  
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;  
        RAISE;    
END;
/



-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
-- oQuestion: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
         Dept in employees.department%TYPE , 
         bonus in number
    ) IS
    BEGIN
        UPDATE Employees
            SET salary = salary + (salary*0.01*bonus)
            WHERE department = Dept; 
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;  
        RAISE; 
END;
/

-- Scenario 3: Customers should be able to transfer funds between their accounts.
-- oQuestion: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.


CREATE OR REPLACE PROCEDURE  TransferFunds(
    frmacc in accounts.AccountID%TYPE , 
    toacc in accounts.AccountID%TYPE , 
    amount in number
) IS
    frm_balance accounts.balance%TYPE;
    rowcnt number;

BEGIN

    for x in (select TransactionID from transactions) LOOP
        rowcnt := x.transactionID;
    END LOOP;

    SELECT balance into frm_balance from accounts where accountID = frmacc;
    if amount <= frm_balance then
        UPDATE accounts
        set balance = balance-amount
        where accountID = frmacc;

        UPDATE accounts 
        set balance = balance+amount
        where accountID = toacc;
        Insert into transactions values(rowcnt+1 ,frmacc , SYSDATE , amount , 'Withdrawal'); 
        Insert into transactions values(rowcnt+2,toacc , SYSDATE , amount , 'Deposit');
        COMMIT;
    else
        dbms_output.put_line('not sufficient balance');
    end if;
      
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;  
        RAISE;    
END;
/



