import java.util.Scanner;
import model.Patient;
import model.Visit;
import structures.PatientBST;
import structures.EmergencyQueue;
import structures.TreatmentStack;
import structures.VisitLinkedList;
import java.util.HashMap;

public class Main {

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();
    static HashMap<Integer, VisitLinkedList> visitHistoryMap = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1: registerPatient(); break;
                case 2: callNextPatient(); break;
                case 3: viewWaitingQueue(); break;
                case 4: searchPatient(); break;
                case 5: deletePatient(); break;
                case 6: viewAllPatients(); break;
                case 7: completeTreatment(); break;
                case 8: viewTreatmentHistory(); break;
                case 9: addVisit(); break;
                case 10: viewVisitHistory(); break;
                case 0: System.out.println("Exiting system. Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n===== Hospital Emergency Management System =====");
        System.out.println("1. Register new patient");
        System.out.println("2. Call next patient for treatment");
        System.out.println("3. View waiting queue");
        System.out.println("4. Search patient by ID");
        System.out.println("5. Delete patient");
        System.out.println("6. View all patients (sorted by ID)");
        System.out.println("7. Complete treatment");
        System.out.println("8. View treatment history");
        System.out.println("9. Add visit to patient history");
        System.out.println("10. View patient visit history");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    static void registerPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);
        emergencyQueue.enqueue(patient);
        visitHistoryMap.put(id, new VisitLinkedList());

        System.out.println("Patient registered successfully.");
    }

    static void callNextPatient() {
        Patient next = emergencyQueue.dequeue();
        if (next != null) {
            System.out.println("Now treating: " + next);
        }
    }

    static void viewWaitingQueue() {
        emergencyQueue.displayQueue();
    }

    static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = scanner.nextInt();
        Patient found = patientBST.search(id);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Patient not found.");
        }
    }

    static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();
        patientBST.delete(id);
        System.out.println("Patient deleted (if existed).");
    }

    static void viewAllPatients() {
        patientBST.inOrderTraversal();
    }

    static void completeTreatment() {
        System.out.print("Enter Patient ID whose treatment is complete: ");
        int id = scanner.nextInt();
        Patient p = patientBST.search(id);
        if (p != null) {
            String record = "Patient " + p.getPatientName() + " (ID: " + id + ") - Condition: " + p.getMedicalCondition();
            treatmentStack.push(record);
        } else {
            System.out.println("Patient not found.");
        }
    }

    static void viewTreatmentHistory() {
        treatmentStack.displayStack();
    }

    static void addVisit() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        VisitLinkedList visitList = visitHistoryMap.get(id);
        if (visitList == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
        visitList.addVisit(visit);
    }

    static void viewVisitHistory() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();

        VisitLinkedList visitList = visitHistoryMap.get(id);
        if (visitList == null) {
            System.out.println("Patient not found.");
        } else {
            visitList.displayVisits();
        }
    }
}