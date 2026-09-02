# Hospital Emergency Management System

## Assignment
CIT300 - Data Structures and Algorithms - Individual Mid Assignment
Mini Hospital Emergency Management System Using Data Structures

## Overview
A console-based Java application that simulates the management of
patients arriving at a hospital emergency unit — patient registration,
emergency treatment requests, treatment completion, and patient visit
history — using core data structures implemented from scratch.

## Data Structures Used

### 1. Binary Search Tree (BST) — Patient Records
Stores patient records keyed by Patient ID. Supports insert, search,
delete (handling leaf, one-child, and two-children cases), and
in-order traversal to display patients sorted by ID.

### 2. Queue — Emergency Patient Queue
Manages patients waiting for treatment on a First-In-First-Out (FIFO)
basis, implemented using a linked structure. Supports enqueue,
dequeue, display, and empty-queue handling.

### 3. Stack — Treatment History
Stores completed treatment records on a Last-In-First-Out (LIFO)
basis, implemented using a linked structure. Supports push, pop,
display, and empty-stack handling.

### 4. Singly Linked List — Patient Visit History
Each patient has their own linked list of past visits. Supports
adding a visit, removing a visit by ID, searching for a visit by ID,
and displaying the full visit history.

## Project Structure
src/
- Main.java (menu-driven entry point)
- model/Patient.java
- model/Visit.java
- structures/PatientBST.java
- structures/EmergencyQueue.java
- structures/TreatmentStack.java
- structures/VisitLinkedList.java

## How to Run
1. Open the project in Eclipse.
2. Run Main.java as a Java Application.
3. Use the on-screen numbered menu to register patients, manage the
   queue, complete treatments, and manage visit history.

## Design Decisions
- Queue and Stack were implemented using custom linked nodes rather
  than arrays, so they can grow dynamically without a fixed size limit.
- Treatment records are stored as formatted Strings in the stack for
  simplicity, since the assignment only required storing a completed
  treatment record, not a full object.
- A HashMap<PatientID, VisitLinkedList> is used in Main.java purely
  as a lookup helper to find the correct patient's visit list quickly;
  it is not one of the four required data structures.

## Reflection
Building this project helped me understand how recursion drives
operations on a Binary Search Tree, especially handling the three
deletion cases (leaf, one child, two children) using the in-order
successor. I also saw clearly how linked structures like the Queue,
Stack, and Linked List manage dynamic data without the resizing
limitations of arrays. The most challenging part was correctly
threading the delete logic in the BST without breaking the rest of
the tree.