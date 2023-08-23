package unittest;

public class Book {
    Pages pages;
    public void getBookName(){
        System.out.println("book name");
    }
    public int getNoOfPages(){
        return pages.writtenPages();
    }
}
