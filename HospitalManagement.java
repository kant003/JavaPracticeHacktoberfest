import java.util.*;

// -------------------- ENTITY CLASSES --------------------

// Patient class
class Patient {
    int id;
    String name;
    int age;

    Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient[ID=" + id + ", Name=" + name + ", Age=" + age + "]";
    }
}

// Doctor class
class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor[ID=" + id + ", Name=" + name + ", Specialization=" + specialization + "]";
    }
}

// Department class
class Department {
    int id;
    String name;

    Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department[ID=" + id + ", Name=" + name + "]";
    }
}

// Appointment class
class Appointment {
    int id;
    Patient patient;
    Doctor doctor;
    String date;

    Appointment(int id, Patient patient, Doctor doctor, String date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment[ID=" + id + ", " + patient.name + " with " + doctor.name + " on " + date + "]";
    }
}

// Bill class
class Bill {
    int id;
    Patient patient;
    double amount;

    Bill(int id, Patient patient, double amount) {
        this.id = id;
        this.patient = patient;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill[ID=" + id + ", Patient=" + patient.name + ", Amount=" + amount + "]";
    }
}

// -------------------- STORAGE --------------------
class Storage {
    List<Patient> patients = new ArrayList<>();
    List<Doctor> doctors = new ArrayList<>();
    List<Department> departments = new ArrayList<>();
    List<Appointment> appointments = new ArrayList<>();
    List<Bill> bills = new ArrayList<>();
}

// -------------------- SERVICE LAYER --------------------
class HospitalService {
    Storage storage;

    HospitalService(Storage storage) {
        this.storage = storage;
    }

    // Add patient
    void addPatient(Patient patient) {
        storage.patients.add(patient);
        System.out.println("✅ Patient added: " + patient);
    }

    // Add doctor
    void addDoctor(Doctor doctor) {
        storage.doctors.add(doctor);
        System.out.println("✅ Doctor added: " + doctor);
    }

    // Add department
    void addDepartment(Department department) {
        storage.departments.add(department);
        System.out.println("✅ Department added: " + department);
    }

    // Schedule appointment
    void scheduleAppointment(Appointment appointment) {
        storage.appointments.add(appointment);
        System.out.println("📅 Appointment scheduled: " + appointment);
    }

    // Generate bill
    void generateBill(Bill bill) {
        storage.bills.add(bill);
        System.out.println("💰 Bill generated: " + bill);
    }

    // Display all patients
    void listPatients() {
        System.out.println("\n--- Patients ---");
        for (Patient p : storage.patients) {
            System.out.println(p);
        }
    }

    // Display all doctors
    void listDoctors() {
        System.out.println("\n--- Doctors ---");
        for (Doctor d : storage.doctors) {
            System.out.println(d);
        }
    }

    // Display all appointments
    void listAppointments() {
        System.out.println("\n--- Appointments ---");
        for (Appointment a : storage.appointments) {
            System.out.println(a);
        }
    }

    // Display all bills
    void listBills() {
        System.out.println("\n--- Bills ---");
        for (Bill b : storage.bills) {
            System.out.println(b);
        }
    }
}

// -------------------- MAIN CLASS --------------------
public class HospitalManagement {
    public static void main(String[] args) {
        Storage storage = new Storage();
        HospitalService service = new HospitalService(storage);

        // Add Patients
        Patient p1 = new Patient(1, "Alice", 25);
        Patient p2 = new Patient(2, "Bob", 40);
        service.addPatient(p1);
        service.addPatient(p2);

        // Add Doctors
        Doctor d1 = new Doctor(1, "Dr. Smith", "Cardiology");
        Doctor d2 = new Doctor(2, "Dr. John", "Neurology");
        service.addDoctor(d1);
        service.addDoctor(d2);

        // Add Departments
        Department dep1 = new Department(1, "Cardiology");
        Department dep2 = new Department(2, "Neurology");
        service.addDepartment(dep1);
        service.addDepartment(dep2);

        // Schedule Appointments
        Appointment a1 = new Appointment(1, p1, d1, "2025-10-05");
        Appointment a2 = new Appointment(2, p2, d2, "2025-10-06");
        service.scheduleAppointment(a1);
        service.scheduleAppointment(a2);

        // Generate Bills
        Bill b1 = new Bill(1, p1, 5000.0);
        Bill b2 = new Bill(2, p2, 7500.0);
        service.generateBill(b1);
        service.generateBill(b2);

        // List All
        service.listPatients();
        service.listDoctors();
        service.listAppointments();
        service.listBills();
    }
}
