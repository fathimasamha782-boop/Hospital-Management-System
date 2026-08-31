package structures;

import model.Patient;

public class EmergencyQueue {

    private class QueueNode {
        Patient patient;
        QueueNode next;

        QueueNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;

    public EmergencyQueue() {
        front = null;
        rear = null;
    }

    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Patient " + patient.getPatientName() + " added to the queue.");
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No patients waiting.");
            return null;
        }

        Patient removedPatient = front.patient;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return removedPatient;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No patients currently waiting.");
            return;
        }

        System.out.println("Patients waiting in queue:");
        QueueNode current = front;
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }
}