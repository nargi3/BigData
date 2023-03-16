import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private Doctor attendingDoctor;
    private boolean isAdmitted;

    public Patient(String name, Doctor attendingDoctor) {
        this.name = name;
        this.attendingDoctor = attendingDoctor;
        this.isAdmitted = false;
    }

    public String getName() {
        return name;
    }

    public Doctor getAttendingDoctor() {
        return attendingDoctor;
    }

    public boolean isAdmitted() {
        return isAdmitted;
    }

    public void admit() {
        isAdmitted = true;
    }

    public void discharge() {
        isAdmitted = false;
    }
}

class Doctor {
    private String name;

    public Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeAppointment(Patient patient, String procedure) {
        // Perform some checks before making the appointment
        if (!patient.isAdmitted()) {
            System.out.println("Patient is not admitted to the hospital.");
            return;
        }

        if (!patient.getAttendingDoctor().equals(this)) {
            System.out.println("This doctor is not the patient's attending doctor.");
            return;
        }

        // Make the appointment
        System.out.println("Appointment made for " + patient.getName() + " for " + procedure);
    }
}

class Nurse {
    private String name;

    public Nurse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void performAppointment(Patient patient, String procedure) {
        // Perform some checks before performing the appointment
        if (!patient.isAdmitted()) {
            System.out.println("Patient is not admitted to the hospital.");
            return;
        }

        // Perform the appointment
        System.out.println("Performed " + procedure + " on " + patient.getName());
    }
}

class Hospital {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Nurse> nurses;

    public Hospital() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.nurses = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addNurse(Nurse nurse) {
        nurses.add(nurse);
    }

    public void dischargePatient(Patient patient) {
        // Perform some checks before discharging the patient
        if (!patient.isAdmitted()) {
            System.out.println("Patient is not admitted to the hospital.");
            return;
        }

        // Discharge the patient
        patient.discharge();
        System.out.println("Discharged " + patient.getName() + " from the hospital.");
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        // Create hospital
        Hospital hospital = new Hospital();

        // Create doctors
        Doctor doctor1 = new Doctor("Mary Doc");
        Doctor doctor2 = new Doctor("Bob Doc");

        // Add doctors to hospital
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        // Create nurses
        Nurse nurse1 = new Nurse("Mary Nurse");
        Nurse nurse2 = new Nurse("KAte Nurse");

        // Add nurses to hospital
        hospital.addNurse(nurse1);
        hospital.addNurse(nurse2);

        // Create patients
        Patient patient1 = new Patient("Bill Patient", doctor1);
        Patient patient2 = new Patient("Olov Patient", doctor2);

        // Add patients to hospital
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Admit patients to hospital
        patient1.admit();
        patient2.admit();

        // Make appointments
        doctor1.makeAppointment(patient1, "checkup");
        doctor2.makeAppointment(patient2, "surgery");

        // Perform appointments
        nurse1.performAppointment(patient1, "blood test");
        nurse2.performAppointment(patient2, "anesthesia");

        // Discharge patients
        hospital.dischargePatient(patient1);
        hospital.dischargePatient(patient2);
    }
}
