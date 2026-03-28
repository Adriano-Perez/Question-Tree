public class QuestionNode {
   public String data; 
   public QuestionNode left;
   public QuestionNode right;
   
    /**
    * Constructs a leaf node with the given data.
    *
    * @param data The data to store in this node.
    */
   public QuestionNode (String data) {
      this (data, null, null);
   }
   
      /**
    * Constructs a node with the given data and child nodes.
    *
    * @param data The data to store in the node.
    * @param left The left subtree of the node.
    * @param right The right subtree of the node.
    */
   public QuestionNode (String data, QuestionNode left, QuestionNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
   
}