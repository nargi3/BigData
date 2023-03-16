public class Patient {
    int patientId;
    String name;
    String surname;
    String patronymic;
    String address;
    long telephon;
    long numberMedCard;
    String diagnosis;

    public Patient() {

    }

    public Patient(int patientId, String name, String surname, String patronymic, String address, long telephon, long numberMedCard, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.telephon = telephon;
        this.numberMedCard = numberMedCard;
        this.diagnosis = diagnosis;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public long getTelephon() {
        return telephon;
    }

    public void setTelephon(long telephon) {
        this.telephon = telephon;
    }

    public long getNumberMedCard() {
        return numberMedCard;
    }

    public void setNumberMedCard(long numberMedCard) {
        this.numberMedCard = numberMedCard;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Id пациента: " + patientId + ";  Имя: " + name + "Фамилия: " + surname +
                "Отчество: " + patronymic + "Адрес: " + address + "Телефон: " + telephon + ";  Номер мед карточки: " + numberMedCard +
                ";  Диагноз: " + diagnosis;
    }
    static void customer_check_med_card(Patient[] patients, int n, int b){
        for (Patient patient : patients) {
            if(patient.getNumberMedCard()>=n  &&  patient.getNumberMedCard()<=b)
                System.out.println(patient.toString());
        }
    }

    static void check_diagnosis(Patient[] patients,String diagnosis){
        for(Patient patient:patients){
            if(patient.getDiagnosis().equals(diagnosis)){
                System.out.println(patient.toString());
            }
        }
        System.out.println();
    }

}
