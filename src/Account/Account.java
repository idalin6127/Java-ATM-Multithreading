package exercise1;


public class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount + "\t\tNew Balance: $" + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + "\t\tNew Balance: $" + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal: $" + amount);
        }
    }

	public double getBalance() {
		
		return balance;
	}
}