import java.io.IOException;

public class Patient {
    int patientId;
    String name;
    String surname;
    String patronymic;
    String address;
    long telephon;
    long numberMedCard;
    String diagnosis;

    public Patient() throws IOException {

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

    public int getPatientId() throws IOException{
        return patientId;
    }

    public void setPatientId(int patientId) throws IOException{
        this.patientId = patientId;
    }

    public String getName() throws IOException{
        return name;
    }

    public void setName(String name) throws IOException{
        this.name = name;
    }

    public String getSurname() throws IOException{
        return surname;
    }

    public void setSurname(String surname) throws IOException{
        this.surname = surname;
    }

    public String getPatronymic() throws IOException{
        return patronymic;
    }

    public void setPatronymic(String patronymic) throws IOException{
        this.patronymic = patronymic;
    }

    public String getAddress() throws IOException{
        return address;
    }

    public void setAddress(String address) throws IOException{
        this.address = address;
    }

    public long getTelephon() throws IOException{
        return telephon;
    }

    public void setTelephon(long telephon) throws IOException{
        this.telephon = telephon;
    }

    public long getNumberMedCard() {
        return numberMedCard;
    }

    public void setNumberMedCard(long numberMedCard) throws IOException{
        this.numberMedCard = numberMedCard;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) throws IOException{
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
