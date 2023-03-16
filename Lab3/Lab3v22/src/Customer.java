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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getNumberCreditCard() {
        return numberCreditCard;
    }

    public void setNumberCreditCard(long numberCreditCard) {
        this.numberCreditCard = numberCreditCard;
    }

    public long getNumberBankCard() {
        return numberBankCard;
    }

    public void setNumberBankCard(long numberBankCard) {
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
