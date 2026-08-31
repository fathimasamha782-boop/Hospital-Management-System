package structures;

import model.Patient;

public class PatientBST {

    // Each node in the tree holds one Patient + links to left/right children
    private class Node {
        Patient patient;
        Node left, right;

        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public PatientBST() {
        root = null;
    }

    // Public method - user calls this
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    // Private helper - does the actual recursive work
    private Node insertRec(Node current, Patient patient) {
        if (current == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRec(current.left, patient);
        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRec(current.right, patient);
        } else {
            System.out.println("Patient ID " + patient.getPatientId() + " already exists!");
        }

        return current;
    }
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Node deleteRec(Node current, int patientId) {
        if (current == null) {
            return null; // not found, nothing to delete
        }

        if (patientId < current.patient.getPatientId()) {
            current.left = deleteRec(current.left, patientId);
        } else if (patientId > current.patient.getPatientId()) {
            current.right = deleteRec(current.right, patientId);
        } else {
            // Found the node to delete

            // Case 1: Leaf node (no children)
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: One child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // Case 3: Two children
            // Find the smallest value in the right subtree (in-order successor)
            Patient successor = findMin(current.right);
            current.patient = successor; // copy successor's data into current node
            current.right = deleteRec(current.right, successor.getPatientId()); // delete the duplicate
        }

        return current;
    }

    // Helper - finds the smallest patient in a subtree (leftmost node)
    private Patient findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.patient;
    }
    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(Node current) {
        if (current != null) {
            inOrderRec(current.left);
            System.out.println(current.patient);
            inOrderRec(current.right);
        }
    }
}
    
    