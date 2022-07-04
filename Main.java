/*
Java classes having suitable attributes for Library management system.
Use OOPs concepts in your design.Also try to use interfaces and abstract classes.
*/
import java.util.*;

interface Search{
    
}
class bookCase{
    static Map<String,Integer> storedBook = new HashMap<String,Integer>();
    bookCase(){
        storedBook.put("The Great Gastby",2);
        storedBook.put("Ikigai",3);
        storedBook.put("Java Basic",2);
        storedBook.put("Deep Work",1);
        storedBook.put("The Balloonist",0);

    }
    public void AvailableBooksInLibrary(){
    
        System.out.println("-".repeat(40)+"\n\t Books Available \n"+"-".repeat(40));
        storedBook.forEach((k,v)->{
            
           
            if (v>0) {
                System.out.println(" "+String.format("%-20s",k)+" Available");    
            } else {
                System.out.println(" "+ String.format("%-20s", k) +" Unavailable");   
            }
           
        });
    }
     boolean GetBook(String str){
        int v=storedBook.get(str);
        if(v>0){
            storedBook.put(str,v-1);
            return true;
         }
         return false;

     }
     void PutBook(String str){
        int v=storedBook.get(str);
        storedBook.put(str,v+1);
     }
}

interface Library{
    public String issueBook();
}
abstract class GetBookFromCase{
    abstract public String issueBook();
}

class Librarian extends GetBookFromCase implements Library{
    bookCase b = new bookCase();
    Scanner scanner= null;
    public void BookPresentInLibrary(){
        b.AvailableBooksInLibrary();
    }
    public String issueBook(){
       String result;
        System.out.println("Select the book from the following Selection");
        b.AvailableBooksInLibrary();
        System.out.print("\nEnter your Choice: ");
        try{
            scanner = new Scanner(System.in);
            result=scanner.nextLine();
            boolean flag = b.GetBook(result);
            if(flag==false){
                System.out.println(result+" is not avaiable in library");
                result= null;
            }
        }finally{
            if(scanner!=null)
            scanner.close();
        }
       return result; 
    }
    public  void returnBook(String str){
        b.PutBook(str);
    }

}
class student{
    String Book=null;
    Librarian l = new Librarian();
    void issueBookStudent(){
        Book=l.issueBook();
    }
    void returnBookStudent(){
        if(Book!=null){
            System.out.println(Book+"is returned");
            Book =null;
        }
        else
        System.out.println("You don't have book");
    }

}

public class Main {
    public static void main(String[] args) {
       student s = new student();
       s.issueBookStudent();
       s.returnBookStudent();
    }
}
