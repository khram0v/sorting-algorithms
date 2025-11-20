# Sorting Application

A simple, extensible Java console application that demonstrates sorting algorithms, list manipulation,
and clean menu‑driven UI architecture. The project is built with a strong focus on separation of concerns,
input handling, and generic programming using Java's `Comparable` interface.

---

## Features

### **List Management**

- Add elements
- Remove elements
- Replace values
- Shuffle list
- Reverse list
- Print list contents

### **Sorting Algorithms**

Implements the following algorithms through a unified `SortingAlgorithm` interface:

- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort
- Quick Sort

Each algorithm operates on a `List<E extends Comparable<E>>`.

### **Input Handling**

A dedicated `InputHandler` class:

- Safely reads integer values
- Validates ranges
- Reads values based on selected `DataType`
- Handles invalid input gracefully
- Clears console and waits for user input

### **Generic Sortable List**

`SortableList<E>` is a pure data container with:

- Internal `List<E>` storage
- Generic constraints (`E extends Comparable<E>`)
- Reversible and shuffle support
- Replace and remove with safety checks

### **Structured Console UI**

The application uses three UI components:

- `MainMenu`
- `ListMenu`
- `SortingMenu`

Each menu is responsible for its own logic and uses dependency‑injected `InputHandler`.

---

## How It Works

1. User selects a data type (`INTEGER`, `DOUBLE`, `STRING`).
2. `MainMenu` creates an appropriate `SortableList<?>`.
3. The user can choose to:

    - Manage the list
    - Sort the list
4. Each operation triggers the corresponding menu class.
5. Sorting algorithms work directly on the list returned by `getElements()`.

---

## Running the Application

Compile and run normally:

```bash
javac -d out $(find src -name "*.java")
java -cp out io.github.khram0v.app.SortingApp
```

Or run directly from IntelliJ.

---

## Contributing
### Working on Issues
If you see a new issue that has not been raised, create an issue first, and discuss the changes you want to make.

### Write Your First Pull Request
1. First you'll want to fork repo on GitHub
2. Create a branch for the issue you want to work on
3. When finished, push from your branch, then use the "Compare and Pull request" button on GitHub to create a pull request
4. Make sure to reference the issue your pull request addresses
