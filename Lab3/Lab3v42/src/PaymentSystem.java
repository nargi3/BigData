class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

class CreditCard {
    private String cardNumber;
    private double creditLimit;
    private double balance;
    private boolean isBlocked;

    public CreditCard(String cardNumber, double creditLimit) {
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
        this.balance = 0;
        this.isBlocked = false;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void makePurchase(double amount) {
        if (!isBlocked && balance + amount <= creditLimit) {
            balance += amount;
        }
    }

    public void makePayment(double amount) {
        if (!isBlocked) {
            balance -= amount;
        }
    }

    public void blockCard() {
        isBlocked = true;
    }

    public void unblockCard() {
        isBlocked = false;
    }
}

class Client {
    private String name;
    private BankAccount bankAccount;
    private CreditCard creditCard;

    public Client(String name, BankAccount bankAccount, CreditCard creditCard) {
        this.name = name;
        this.bankAccount = bankAccount;
        this.creditCard = creditCard;
    }

    public String getName() {
        return name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void payOrder(double amount) {
        if (bankAccount.getBalance() >= amount) {
            bankAccount.withdraw(amount);
        } else if (creditCard.getBalance() + bankAccount.getBalance() >= amount) {
            double remainingAmount = amount - bankAccount.getBalance();
            bankAccount.withdraw(bankAccount.getBalance());
            creditCard.makePurchase(remainingAmount);
        }
    }

    public void makePaymentToAnotherAccount(BankAccount recipient, double amount) {
        if (bankAccount.getBalance() >= amount) {
            bankAccount.withdraw(amount);
            recipient.deposit(amount);
        }
    }

    public void blockCreditCardByAdministrator() {
        if (creditCard.getBalance() > creditCard.getCreditLimit()) {
            creditCard.blockCard();
        }
    }

    public void cancelBankAccount() {
        bankAccount = null;
    }

    public void cancelCreditCard() {
        creditCard = null;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {

        BankAccount bankAccount1 = new BankAccount("12345678", 5000);
        CreditCard creditCard1 = new CreditCard("11111111", 5000);
        Client client1 = new Client("John", bankAccount1, creditCard1);

        BankAccount bankAccount2 = new BankAccount("87654321", 3000);
        CreditCard creditCard2 = new CreditCard("22222222", 3000);
        Client client2 = new Client("Mary", bankAccount2, creditCard2);

        // Paying for an order
        client1.payOrder(2000);
        System.out.println("Client 1 bank account balance: " + client1.getBankAccount().getBalance());
        System.out.println("Client 1 credit card balance: " + client1.getCreditCard().getBalance());
        System.out.println();
        // Making a payment to another account
        BankAccount recipient = new BankAccount("11112222", 0);
        client2.makePaymentToAnotherAccount(recipient, 1000);
        System.out.println("Client 2 bank account balance: " + client2.getBankAccount().getBalance());
        System.out.println("Recipient bank account balance: " + recipient.getBalance());
        System.out.println();

        // Blocking a credit card
        client1.getCreditCard().makePurchase(4000);
        client1.blockCreditCardByAdministrator();
        System.out.println("Client 1 credit card status: " + client1.getCreditCard().isBlocked());
        System.out.println();

        // Cancelling a bank account and credit card
        client2.cancelBankAccount();
        client2.cancelCreditCard();
        System.out.println("Client 2 bank account: " + client2.getBankAccount());
        System.out.println("Client 2 credit card: " + client2.getCreditCard());
    }
}
