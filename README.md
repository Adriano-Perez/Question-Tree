# 20 Questions Game

A Java implementation of the classic 20 Questions guessing game using a binary question tree.
The program learns from each game and can save/load its knowledge to a file.

## Files

| File | Description |
|------|-------------|
| `QuestionMain.java` | Main class and text-based UI |
| `QuestionTree.java` | Game logic and binary question tree |
| `QuestionNode.java` | Node structure for the tree |
| `UserInterface.java` | Interface for UI interactions |

## Requirements

- Java JDK 8 or higher

## How to Run
```bash
javac QuestionMain.java
java QuestionMain
```

## How to Play

1. Think of an object
2. Answer the yes/no questions the program asks
3. If the program guesses wrong, teach it by entering:
   - Your object
   - A yes/no question to tell your object apart from its guess
   - Whether the answer is yes or no for your object
4. The program gets smarter each game!

## Save & Load

- On **startup**, you will be asked if you want to load a previous game file
- On **exit**, you will be asked if you want to save the current knowledge tree
- Enter any filename (e.g. `questions.txt`) when prompted
```
Shall I recall our previous games? yes
What is the file name? questions.txt
```

## Example Session
```
Welcome to the game of 20 Questions!
Shall I recall our previous games? no
Think of an item, and I will guess it.

Would your object happen to be jedi? no
I lose. What is your object? cat
Type a yes/no question to distinguish your object from jedi:
Is it a real animal?
And what is the answer for your object? yes

Challenge me again? no

Games played: 1
I won: 0
```

## Author
Adriano Perez
