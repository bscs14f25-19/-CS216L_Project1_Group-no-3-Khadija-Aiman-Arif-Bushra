 <h1 align="center">Task Manager Using Linked List and Stack</h1>

**2. Project Title**

Task Manager — CS216L Project 1

**3. Project Description**
Task Manager is a console-based Java application designed to manage tasks efficiently. It allows users to add, delete, search, sort, and view tasks. The application also provides an Undo feature to reverse the last Add or Delete action.
This project demonstrates the use of fundamental data structures and algorithms in Java.

**4. Data Structures Used:**

**Singly Linked List:**

A singly linked list is used to store tasks. Each task contains:

•	Task ID

•	Task title

•	Task priority

•	Reference to the next task

It supports adding, deleting, searching, sorting, and displaying tasks.

**Stack:**

A stack is used to store task actions for the Undo feature. It follows the LIFO (Last In, First Out) principle.

Stack operations include:

•	**Push**: Adds an action to the stack.

•	**Pop**: Removes and returns the latest action.

•	**Peek**: Views the latest action without removing it.

**5. Features**
1.	Add a new task.
2.	Delete a task using its ID.
3.	Search for a task by title using Linear Search.
4.	Sort tasks by priority using Bubble Sort.
5.	Display all active tasks.
6.	Undo the last Add or Delete action.
7.	View the most recent saved action using Peek.
8.	Validate numeric input and priority values.
9.	Prevent duplicate task IDs.
10.	Display task priorities as High, Medium, or Low.

**Priority Levels**
•	1 — High
•	2 — Medium
•	3 — Low

**6. Algorithms Used**

**Linear Search**

Linear Search checks tasks one by one until the required title is found or the list ends.

**Bubble Sort**

Bubble Sort compares adjacent tasks and swaps their task data when their priorities are in the wrong order. Tasks are arranged from High priority to Low priority.

**7. Time Complexity Analysis**
Let n represent the number of tasks.

Operation	Time Complexity

Insert a task	O(n)

Delete a task by ID	O(n)

Linear Search	O(n)

Bubble Sort — Best Case	O(n)

Bubble Sort — Average Case	O(n²)

Bubble Sort — Worst Case	O(n²)

Stack Push	O(1)

Stack Pop	O(1)

Stack Peek	O(1)

**Explanation:**

•	Insertion takes O(n) because the program traverses the list to reach its end.

•	Deletion takes O(n) because the program may need to search for the task.

•	Linear Search takes O(n) because tasks are checked one by one.

•	Bubble Sort takes O(n²) in the average and worst cases.

•	Push, Pop, and Peek take O(1) because they operate directly on the top of the stack.

**8. Java Source Files**
The project contains four Java source files:

•	**Task.java** — Defines the Task class and its attributes.

•	**Action.java** — Defines an action stored in the undo stack.

•	**TaskEngine.java** — Implements the linked list, stack, searching, sorting, and undo operations.

•	**TaskManager.java** — Contains the main method and interactive menu.

**9.Github repository link:**
https://github.com/bscs14f25-19/-CS216L_Project1_Group-no-3-Khadija-Aiman-Arif-Bushra

**10. Conclusion**
The Task Manager project demonstrates how linked lists, stacks, Linear Search, and Bubble Sort can be used in a practical Java application. It also provides experience with menu-driven programming, input validation, and basic data structure operations.
