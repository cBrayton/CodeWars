public class LoopInspector {

  public int loopSize(Node node) {
/*
Takes the starting node of a linked list with a loop.
Returns the size of the loop in the linked list.
*/
    int testSizePower = 1;
    int testSize = 0;
    Node testNode = node;
    Node currentNode = node;
    while(testNode != currentNode.getNext()) {
      if(testSize == Math.pow(2,testSizePower)) {
        testNode = currentNode;
        testSizePower++;
        testSize = 0;
      }
      currentNode = currentNode.getNext();
      testSize++;
    }
    testSize++;
    return testSize;
  }

}