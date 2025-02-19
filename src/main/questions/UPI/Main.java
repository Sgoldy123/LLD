import java.util.*;
import java.util.concurrent.*;

class User {
    String name;
    String phoneNumber;
    boolean isActive;
    List<BankAccount> bankAccounts;
    BankAccount primaryAccount;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isActive = true;
        this.bankAccounts = new ArrayList<>();
    }

    public void linkBankAccount(BankAccount account, boolean isPrimary) {
        if (isPrimary) {
            this.primaryAccount = account;
        }
        bankAccounts.add(account);
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void activate() {
        this.isActive = true;
    }
}

class Bank {
    String name;
    boolean isServerUp;

    public Bank(String name) {
        this.name = name;
        this.isServerUp = true;
    }

    public void setServerStatus(boolean status) {
        this.isServerUp = status;
    }
}

class BankAccount {
    String accountNumber;
    Bank bank;
    double balance;

    public BankAccount(String accountNumber, Bank bank, double balance) {
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.balance = balance;
    }

    public synchronized void deductBalance(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new RuntimeException("Insufficient balance");
        }
    }

    public synchronized void addBalance(double amount) {
        balance += amount;
    }
}

class Transaction {
    String transactionId;
    String fromAccount;
    String toAccount;
    double amount;
    Date timestamp;
    String status;

    public Transaction(String fromAccount, String toAccount, double amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.timestamp = new Date();
        this.status = "Pending";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                '}';
    }
}

class UPIService {
    Map<String, User> users;
    Map<String, Bank> banks;
    List<Transaction> transactions;
    ScheduledExecutorService scheduler;

    public UPIService() {
        this.users = new HashMap<>();
        this.banks = new HashMap<>();
        this.transactions = new ArrayList<>();
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void registerBank(String bankName) {
        banks.put(bankName, new Bank(bankName));
    }

    public void setBankServerStatus(String bankName, boolean status) {
        Bank bank = banks.get(bankName);
        if (bank != null) {
            bank.setServerStatus(status);
        } else {
            throw new RuntimeException("Bank not found");
        }
    }

    public void registerUser(String name, String phoneNumber) {
        if (users.containsKey(phoneNumber)) {
            throw new RuntimeException("Phone number already registered");
        }
        users.put(phoneNumber, new User(name, phoneNumber));
    }

    public void linkBankAccount(String phoneNumber, String bankName, String accountNumber, double balance, boolean isPrimary) {
        User user = users.get(phoneNumber);
        Bank bank = banks.get(bankName);
        if (user != null && bank != null) {
            BankAccount account = new BankAccount(accountNumber, bank, balance);
            user.linkBankAccount(account, isPrimary);
        } else {
            throw new RuntimeException("User or Bank not found");
        }
    }

    public void makePayment(String fromPhoneNumber, String toPhoneNumber, double amount) {
        User fromUser = users.get(fromPhoneNumber);
        User toUser = users.get(toPhoneNumber);

        if (fromUser == null || toUser == null) {
            throw new RuntimeException("User not found");
        }

        if (!fromUser.isActive || !toUser.isActive) {
            throw new RuntimeException("User account is inactive");
        }

        BankAccount fromAccount = fromUser.primaryAccount;
        BankAccount toAccount = toUser.primaryAccount;

        if (!fromAccount.bank.isServerUp || !toAccount.bank.isServerUp) {
            throw new RuntimeException("Bank server is down");
        }

        Transaction transaction = new Transaction(fromAccount.accountNumber, toAccount.accountNumber, amount);
        transactions.add(transaction);

        try {
            Thread.sleep(3000); // Simulate PSP processing time
            fromAccount.deductBalance(amount);
            toAccount.addBalance(amount);
            transaction.setStatus("Completed");
        } catch (InterruptedException e) {
            transaction.setStatus("Failed");
            throw new RuntimeException("Payment failed", e);
        }
    }

    public List<Transaction> getTransactionHistory(String phoneNumber) {
        User user = users.get(phoneNumber);
        if (user != null) {
            List<Transaction> userTransactions = new ArrayList<>();
            for (Transaction transaction : transactions) {
                if (transaction.fromAccount.equals(user.primaryAccount.accountNumber) ||
                        transaction.toAccount.equals(user.primaryAccount.accountNumber)) {
                    userTransactions.add(transaction);
                }
            }
            return userTransactions;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void retryPendingTransactions() {
        scheduler.scheduleAtFixedRate(() -> {
            for (Transaction transaction : transactions) {
                if (transaction.status.equals("Pending")) {
                    try {
                        Thread.sleep(3000); // Simulate PSP processing time
                        transaction.setStatus("Completed");
                    } catch (InterruptedException e) {
                        transaction.setStatus("Failed");
                    }
                }
            }
        }, 0, 120, TimeUnit.SECONDS);
    }
}

public class Main {
    public static void main(String[] args) {
        UPIService upiService = new UPIService();

        // Register banks
        upiService.registerBank("BankA");
        upiService.registerBank("BankB");

        // Register users
        upiService.registerUser("Alice", "1234567890");
        upiService.registerUser("Bob", "9876543210");

        // Link bank accounts
        upiService.linkBankAccount("1234567890", "BankA", "ACC001", 1000.0, true);
        upiService.linkBankAccount("9876543210", "BankB", "ACC002", 500.0, true);

        // Make a payment
        upiService.makePayment("1234567890", "9876543210", 200.0);

        // View transaction history
        List<Transaction> aliceTransactions = upiService.getTransactionHistory("1234567890");
        for (Transaction transaction : aliceTransactions) {
            System.out.println(transaction);
        }

        // Retry pending transactions
        upiService.retryPendingTransactions();
    }
}