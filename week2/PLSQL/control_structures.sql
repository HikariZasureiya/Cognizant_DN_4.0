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



-- Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
-- Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, 
-- apply a 1% discount to their current loan interest rates.

SET SERVEROUTPUT ON
DECLARE 
curr DATE;
diff number(3);
BEGIN

SELECT SYSDATE INTO curr FROM dual;
FOR x in (SELECT * FROM CUSTOMERS) LOOP
    diff := TRUNC(MONTHS_BETWEEN(curr, x.DOB) / 12);
    IF diff > 20 THEN
        UPDATE Loans
        SET InterestRate = InterestRate -1
        WHERE CustomerID = x.CustomerID;
    END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: A customer can be promoted to VIP status based on their balance.
-- Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.


-- no IsVIP in there
ALTER TABLE Customers ADD IsVIP VARCHAR2(5) CHECK(IsVIP in ('TRUE' , 'FALSE')); 

-- making a balance more than 10,000
UPDATE Customers
    set Balance = 10001
    where CustomerID = 1;
    


BEGIN
    FOR x IN (SELECT CustomerID , Balance, IsVIP from Customers) LOOP
        IF x.Balance > 10000 THEN
           UPDATE Customers
                SET IsVIP = 'TRUE'
                WHERE CustomerID = x.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = x.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/                 


-- Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
-- Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.


INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (3, 1, 10000, 5, SYSDATE, SYSDATE+28);

DECLARE
daysbetween number;
cusname varchar2(100);
BEGIN
    FOR x in (SELECT CustomerID , EndDate from Loans) LOOP
        SELECT  x.EndDate - SYSDATE INTO daysbetween FROM dual;
        Select name into cusname from Customers where CustomerID = x.CustomerID;
        if daysbetween <= 30 THEN
            dbms_output.put_line('Customer ' || cusname || ' Has their Loan due in 30 days');
        end if;
    end loop;
end;
