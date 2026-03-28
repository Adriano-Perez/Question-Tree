import java.util.*;
import java.io.*;

public class QuestionTree
{
   private QuestionNode root;
   private UserInterface my;
   private int totalGames;
   private int gamesWon;
   /**
    * Constructs a new QuestionTree with root as the top node.
    * @param ui the UserInterface
    * @throws IllegalArgumentException if ui is null
    */
   public QuestionTree (UserInterface ui){
      if(ui == null) throw new IllegalArgumentException("UserInterface cannot be null");
      this.my = ui;
      this.root= new QuestionNode("jedi");
      this.totalGames=0;
      this.gamesWon=0;
   }
   /**
    * Starts the game by prompting the user and updating the game tree by calling private method and also adds to game count.
    */
   public void play(){
      my.println("Play Game here");
      totalGames++;
      root=playGame(root);
   }
     /**
    * using recursion it plays the game navigating through the question tree based on yes or no answers.
    * @param node the current node in the game tree
    * @return the modified node after the game is played if the game is lost
    */
   private QuestionNode playGame(QuestionNode node) {
      if (node.left == null && node.right == null) {//leaf of treenode
         my.print("Would your object happen to be " + node.data + "? ");
         if (my.nextBoolean()) {
            my.println("I win!");
            gamesWon++;
         } 
         else {
            my.println("I lose. What is your object?");
            String answer = my.nextLine();
            my.println("Type a yes/no question to distinguish your object from " + node.data + ":");
            String question = my.nextLine();
            my.println("And what is the answer for your object? (yes/no)");
            boolean yes = my.nextBoolean();// boolean yes if input is true
                
            if (yes) return new QuestionNode(question, new QuestionNode(answer), node);// if true (yes) new object goes into left sub tree(yes)
            else return new QuestionNode(question, node, new QuestionNode(answer));//if its false(no) object goes into right sub tree(no)
         }
      } 
      
      else {
         my.print(node.data + " ");
         if (my.nextBoolean()) node.left = playGame(node.left);
         else node.right = playGame(node.right);
         }
         
      return node;
   }  
   /**
    * calles saveTree private method to save the current state of the game tree to a file.
    * @param output the PrintStream to write the tree structure
    */
   public void save(PrintStream output) {
      saveTree(output, root);
   }
    /**
    * using recursion it saves the question tree to a file.
    * @param Print Stream output to write to
    * @param node which is the current node being saved
    */
   private void saveTree(PrintStream output, QuestionNode node) {
      if (node == null) return;// if node is empty return nothing and leave the method
      if (node.left == null && node.right == null) output.println("A:" + node.data);
      else {
         output.println("Q:" + node.data);
         saveTree(output, node.left);
         saveTree(output, node.right);
      }
   }  
  
    
   /**
    * Loads a saved game tree from a file.
    * @param input the scanner it uses to read from
    */
   public void load(Scanner input) {
      my.println("Save the current file here");
      root = loadTree(input);
      my.println("Here is the game summary");
   }
    /**
    * using recursion it loads a question tree from a file inputed by user.
    * @param input the Scanner used to read data from the file
    * @return the root node of the loaded tree from the file
    */
   private QuestionNode loadTree(Scanner input) {
      if (!input.hasNextLine()) return null;
      String line = input.nextLine();
      if (line.startsWith("A:")) return new QuestionNode(line.substring(2));
      else {
         QuestionNode node = new QuestionNode(line.substring(2));
         node.left = loadTree(input);
         node.right = loadTree(input);
         return node;
      }
   }
    /**
    * Returns the total number of games played which is added in previous methods.
    * @return the total games played
    */
   public int totalGames(){
      return totalGames;
   }
     /**
    * Returns the number of games won by the program which is added by in previous methods.
    * @return the total games won
    */
   public int gamesWon(){
      return gamesWon;
   }
  
}