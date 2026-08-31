package structures;

import model.Visit;

public class VisitLinkedList {

    private Visit head;

    public VisitLinkedList() {
        head = null;
    }

    public void addVisit(Visit visit) {
        if (head == null) {
            head = visit;
        } else {
            Visit current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(visit);
        }

        System.out.println("Visit added: " + visit);
    }

    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        if (head.getVisitId() == visitId) {
            head = head.getNext();
            System.out.println("Visit ID " + visitId + " removed.");
            return;
        }

        Visit current = head;
        while (current.getNext() != null) {
            if (current.getNext().getVisitId() == visitId) {
                current.setNext(current.getNext().getNext());
                System.out.println("Visit ID " + visitId + " removed.");
                return;
            }
            current = current.getNext();
        }

        System.out.println("Visit ID " + visitId + " not found.");
    }

    public Visit searchVisit(int visitId) {
        Visit current = head;
        while (current != null) {
            if (current.getVisitId() == visitId) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        System.out.println("Visit history:");
        Visit current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }
}