import java.io.IOException;

public class Customer {
    int customerId;
    String name;
    String surname;
    String patronymic;
    String address;
    long numberCreditCard;
    long numberBankCard;

    public Customer() {

    }

    public Customer(int customerId, String name, String surname, String patronymic, String address, long numberCreditCard, long numberBankCard) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.numberCreditCard = numberCreditCard;
        this.numberBankCard = numberBankCard;
    }

    public int getCustomerId() throws IOException {
        return customerId;
    }

    public void setCustomerId(int customerId) throws IOException {
        this.customerId = customerId;
    }

    public String getName() throws IOException {
        return name;
    }

    public void setName(String name) throws IOException {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() throws IOException {
        return patronymic;
    }

    public void setPatronymic(String patronymic) throws IOException {
        this.patronymic = patronymic;
    }

    public String getAddress() throws IOException {
        return address;
    }

    public void setAddress(String address) throws IOException {
        this.address = address;
    }

    public long getNumberCreditCard() {
        return numberCreditCard;
    }

    public void setNumberCreditCard(long numberCreditCard) throws IOException {
        this.numberCreditCard = numberCreditCard;
    }

    public long getNumberBankCard() throws IOException {
        return numberBankCard;
    }

    public void setNumberBankCard(long numberBankCard) throws IOException {
        this.numberBankCard = numberBankCard;
    }

    @Override
    public String toString() {
        return "Id покупателя: " + customerId + ";  Имя: " + name + "Фамилия: " + surname +
                "Отчество: " + patronymic + "Номер кредитной карточки: " + numberCreditCard +
                ";  Номер банковской карточки: " + numberBankCard;
    }
    static void customer_check_credit_card(Customer[] customers, int n, int b){
        for (Customer customer : customers) {
            if(customer.getNumberCreditCard()>=n  &&  customer.getNumberCreditCard()<=b)
                System.out.println(customer.toString());
        }
    }

}
