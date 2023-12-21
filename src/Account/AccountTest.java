package exercise1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000.0);

        ExecutorService execut = Executors.newCachedThreadPool();

        // Create a list of transactions
        Transaction[] transactions = {
            new Transaction(account, "deposit", 100),
            new Transaction(account, "withdraw", 500),
            new Transaction(account, "deposit", 600)
        };

        for (Transaction transaction : transactions) {
            execut.execute(transaction);
        }

        execut.shutdown();

        try {
            execut.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: $" + account.getBalance());
    }
}
