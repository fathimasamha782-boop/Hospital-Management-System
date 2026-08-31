package structures;

public class TreatmentStack {

    // Each node holds one completed treatment record + a link to the node below it
    private class StackNode {
        String treatmentRecord;
        StackNode next;

        StackNode(String treatmentRecord) {
            this.treatmentRecord = treatmentRecord;
            this.next = null;
        }
    }

    private StackNode top;

    public TreatmentStack() {
        top = null;
    }

    // Add a completed treatment record to the top of the stack
    public void push(String treatmentRecord) {
        StackNode newNode = new StackNode(treatmentRecord);
        newNode.next = top;
        top = newNode;

        System.out.println("Treatment record added: " + treatmentRecord);
    }

    // Remove and return the most recently completed treatment record
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No treatment records to remove.");
            return null;
        }

        String removedRecord = top.treatmentRecord;
        top = top.next;
        return removedRecord;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("No treatment records available.");
            return;
        }

        System.out.println("Treatment history (most recent first):");
        StackNode current = top;
        while (current != null) {
            System.out.println(current.treatmentRecord);
            current = current.next;
        }
    }
}