import java.util.*;

// Doctor class
class Doctor {
    int doctorId;
    String doctorName;
    String specialization;

    Doctor(int doctorId, String doctorName, String specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    void displayDoctor() {
        System.out.println("ID: " + doctorId + 
                " | Name: " + doctorName + 
                " | Specialization: " + specialization);
    }
}

// Patient class
class Patient {
    int patientId;
    String patientName;

    Patient(int patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }

    void displayPatient() {
        System.out.println("ID: " + patientId + " | Name: " + patientName);
    }
}

// Appointment class
class Appointment {
    Doctor doctor;
    Patient patient;
    String time;

    Appointment(Doctor doctor, Patient patient, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.time = time;
    }

    void displayAppointment() {
        System.out.println("Doctor: " + doctor.doctorName +
                " | Patient: " + patient.patientName +
                " | Time: " + time);
    }
}

// Hospital System class
class HospitalSystem {

    HashMap<Integer, Doctor> doctors = new HashMap<>();
    HashMap<Integer, Patient> patients = new HashMap<>();
    List<Appointment> appointments = new ArrayList<>();

    // Add doctor
    void addDoctor(int id, String name, String specialization) {
        doctors.put(id, new Doctor(id, name, specialization));
        System.out.println("Doctor added successfully.");
    }

    // Register patient
    void addPatient(int id, String name) {
        patients.put(id, new Patient(id, name));
        System.out.println("Patient registered successfully.");
    }

    // Book appointment
    void bookAppointment(int doctorId, int patientId, String time) {

        Doctor doctor = doctors.get(doctorId);
        Patient patient = patients.get(patientId);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        Appointment appointment = new Appointment(doctor, patient, time);
        appointments.add(appointment);

        System.out.println("Appointment booked successfully.");
    }

    // Show doctors
    void showDoctors() {
        for (Doctor d : doctors.values()) {
            d.displayDoctor();
        }
    }

    // Show patients
    void showPatients() {
        for (Patient p : patients.values()) {
            p.displayPatient();
        }
    }

    // Show appointments
    void showAppointments() {

        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }

        for (Appointment a : appointments) {
            a.displayAppointment();
        }
    }
}

// Main class
public class HospitalAppointmentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalSystem system = new HospitalSystem();

        int choice;

        do {

            System.out.println("\n===== HOSPITAL APPOINTMENT SYSTEM =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Register Patient");
            System.out.println("3. Book Appointment");
            System.out.println("4. Show Doctors");
            System.out.println("5. Show Patients");
            System.out.println("6. Show Appointments");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Doctor ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String dname = sc.nextLine();

                    System.out.print("Enter Specialization: ");
                    String spec = sc.nextLine();

                    system.addDoctor(did, dname, spec);
                    break;

                case 2:
                    System.out.print("Enter Patient ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String pname = sc.nextLine();

                    system.addPatient(pid, pname);
                    break;

                case 3:
                    System.out.print("Enter Doctor ID: ");
                    int docId = sc.nextInt();

                    System.out.print("Enter Patient ID: ");
                    int patId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Appointment Time: ");
                    String time = sc.nextLine();

                    system.bookAppointment(docId, patId, time);
                    break;

                case 4:
                    system.showDoctors();
                    break;

                case 5:
                    system.showPatients();
                    break;

                case 6:
                    system.showAppointments();
                    break;

                case 7:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}