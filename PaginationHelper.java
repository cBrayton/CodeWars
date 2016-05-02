import java.util.List;

public class PaginationHelper<I> {
  int numItems;
  int numPages;
  int numItemsPerPage;
  /**
   * The constructor takes in an array of items and a integer indicating how many
   * items fit within a single page
   */
  public PaginationHelper(List<I> collection, int itemsPerPage) {
    numItems = collection.size();
    numPages = (numItems%itemsPerPage == 0) ? numItems/itemsPerPage : (numItems/itemsPerPage)+1;
    numItemsPerPage = itemsPerPage;
  }
  
  /**
   * Returns the number of items within the entire collection
   */
  public int itemCount() {
    return numItems;
  }
  
  /**
   * Returns the number of pages
   */
  public int pageCount() {
    return numPages;
  }
  
  /**
   * Returns the number of items on the current page. Page_index is zero based.
   * This method should return -1 for pageIndex values that are out of range
   */
  public int pageItemCount(int pageIndex) {
    if (pageIndex < 0 || pageIndex > numPages-1) {return -1;} //numPages-1 because pages are zero indexed
    else if (pageIndex == numPages-1) {return (numItems%numItemsPerPage == 0) ? numItemsPerPage : numItems%numItemsPerPage;}
    return numItemsPerPage;
  }
  
  /**
   * Determines what page an item is on. Zero based indexes.
   * This method should return -1 for itemIndex values that are out of range
   */
  public int pageIndex(int itemIndex) {
    if (itemIndex < 0 || itemIndex > numItems-1) {return -1;} //numItems-1 because items are zero indexed
    else return itemIndex/numItemsPerPage;
  }
}