import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.*;
import java.lang.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


class InappropriateID extends Exception {
    @Override
    public String toString() {
        return "Inappropriate ID";

    }

    @Override
    public String getMessage() {
        return "if you don't have library ID, Creat first then retry";
    }
}


class InnerLibrary {
    HashMap<String, String> book = new HashMap<>();

    void addbooks(String bookname, String bookauthor) {
        book.put(bookname, bookauthor);
        // String data1=String.valueOf(data);  
    }

    void returnbook(String bookname, String bookauthor, Issuebooks issue) {
        if (issue.issuedBooksDeatils.contains(bookname)) {
            book.put(bookname, bookauthor);
            int removebookdeatil = issue.issuedBooksDeatils.indexOf(bookname);
            System.out.println(removebookdeatil);
            issue.issuedBooksDeatils.remove(removebookdeatil);
            issue.issuedBooksDeatils.remove(removebookdeatil);
            issue.issuedBooksDeatils.remove(removebookdeatil);
            issue.issuedBooksDeatils.remove(removebookdeatil);

        } else {
            System.out.println("This book is not issued");
        }
    }

    void printbooklist() {
        System.out.println("\n");
        Set<Map.Entry<String, String>> s = book.entrySet();
        for (Map.Entry<String, String> set : s) {
            System.out.println("Book name:" + set.getKey());
            System.out.println("Author's name:" + set.getValue() + "\n");
        }

    }

}


class Issuebooks {
    ArrayList<String> issuedBooksDeatils = new ArrayList<>();

    /*  Book issued detail is stored in Following pattern
     inedx     element
       0       bookname
       1       bookauthor
       2       issuedOn
       3       issuedBy */
    void printIssuedBookDetail() {
        System.out.println("\n");
        for (int i = 0; i < issuedBooksDeatils.size(); ) {
            System.out.println("Book Name:" + issuedBooksDeatils.get(i));
            i++;
            System.out.println("Author's Name:" + issuedBooksDeatils.get(i));
            i++;
            System.out.println(issuedBooksDeatils.get(i));
            i++;
            System.out.println("ID:" + issuedBooksDeatils.get(i));
            i++;
            System.out.println("");
        }
    }


    void issuebooks(String bookname, String bookauthor, CreatId.ID Id, InnerLibrary innerLibrary) {
        Scanner p = new Scanner(System.in);
        System.out.println("Enter your id:");
        String S = p.nextLine();
        if (Id.getId().contains(S)) {
            if (innerLibrary.book.containsKey(bookname)) {
                innerLibrary.book.remove(bookname);
                this.issuedBooksDeatils.add(bookname);
                this.issuedBooksDeatils.add(bookauthor);
                LocalDateTime dt = LocalDateTime.now();
                DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter df1 = DateTimeFormatter.ofPattern("h:m:s");
                String issuedday = dt.format(df);
                String issuedTime = dt.format(df1);
                String issuedOn = "Date-" + issuedday + "\nTime-" + issuedTime;
                this.issuedBooksDeatils.add(issuedOn);
                System.out.println(issuedOn);
                String issuedBy = Id.getId();
                this.issuedBooksDeatils.add(issuedBy);


            } else {
                System.out.print("Sorry we don't have " + bookname);
            }

        } else {
            System.out.print("you don't have libraryid");
        }

    }


}


class CreatId {


    class ID {
        private String name;
        private String Branch;
        private int admissionYear;
        private int RollNo;
        private String id;

        ID(String name, String Branch, int admissionYear, int RollNo) {
            this.name = name;
            this.Branch = Branch;
            this.admissionYear = admissionYear;
            this.RollNo = RollNo;
            String abbrebationOfBranch = " ";


            switch (Branch) {
                case "Automobile Engineering":
                    abbrebationOfBranch = "AE";
                    break;
                case "Mechanical Engineering":
                    abbrebationOfBranch = "ME";
                    break;
                case "Computer Engineering":
                    abbrebationOfBranch = "CS";
                    break;
                case "Civil Engineering":
                    abbrebationOfBranch = "CE";
                    break;

                default:
                    System.out.println("Insert Branch properly");
                    break;
            }


            this.id = abbrebationOfBranch + String.valueOf(admissionYear) + String.valueOf(RollNo);


        }

        String getId() {
            return id;
        }

        void getdeatils(String id) throws InappropriateID {
            System.out.println("Name:" + this.name);
            System.out.println("Branch:" + this.Branch);
            System.out.println("Admission Year:" + this.admissionYear);
            System.out.println("RollNo:" + this.RollNo);

        }

    }


    void getUserdetail(ID id) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your id:");
        String s1 = s.nextLine();
        // s.close();

        try {
            if (id.getId().contains(s1)) {
                id.getdeatils(s1);

            } else {
                throw new InappropriateID();

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }


    }


}
// class AddBook{

//     InnerLibrary newbook(String name,String author){
//          ArrayList<InnerLibrary> ListOfBooks=new ArrayList<InnerLibrary>();
//          InnerLibrary library=new InnerLibrary(name, author);
//          ListOfBooks.add(library);
//          return library;
//          // for(InnerLibrary a:ListOfBooks){
//          //     System.out.println(a.bookname);
//          //     System.out.println(a.bookauthor);

//          // }


//      }

//      void getListOfBooks(ArrayList ListOfBooks){
//        Iterator itr=ListOfBooks.iterator();
//        while(itr.hasnext()){
//            InnerLibrary il=itr.next();
//            System.out.println(il);
//        }

//      }
//  }

// class Bookchecking{
//     Bookchecking(String bookname,String bookauthor,ArrayList d){
//         int flag=0;
//         for(InnerLibrary a: d){
//             if(a.bookname.equalsIgnoreCase(bookname)&&a.bookauthor.equalsIgnoreCase(bookauthor)){
//            flag++;
//            break;
//             }
//            }
//             if(flag==1){
//                System.out.println("Your enterd Book is  available  ");
//             }
//             else{
//                System.out.println("Your enterd Book is not available  ");
//             }

//     }

// }


public class Library {

    public static void main(String[] args) {


        InnerLibrary library = new InnerLibrary();
        ArrayList<String> UsersStoredids = new ArrayList<>();


        // Scanner sc=new Scanner(System.in);
        // Scanner sc1=new Scanner(System.in);


        // System.out.println("Enter Book name:");
        // String bookname=sc1.nextLine();
        // System.out.println("Enter "+bookname+" Author's name:");
        // String bookauthor=sc.nextLine();


        //Adding books
        library.addbooks("Learn C", "Mahes karta");
        library.addbooks("Learn java", "Zakir");
        library.addbooks("History Of India", "rabindhnaat");
        library.addbooks("The Rebuplic", "plato");
        library.printbooklist();


        //creating Library users id and storing it in arraylist
        CreatId creatid = new CreatId();
        CreatId.ID id1 = creatid.new ID("zakir", "Automobile Engineering", 2016, 84);
        UsersStoredids.add(id1.getId());

        CreatId.ID id2 = creatid.new ID("anas", "Civil Engineering", 2016, 53);
        UsersStoredids.add(id2.getId());

        CreatId.ID id3 = creatid.new ID("nazeem", "Mechanical Engineering", 2016, 46);
        UsersStoredids.add(id3.getId());

        CreatId.ID id4 = creatid.new ID("rahul", "Automobile Engineering", 2016, 87);
        UsersStoredids.add(id4.getId());


        // Issuing Books
        Issuebooks issuebook = new Issuebooks();

        issuebook.issuebooks("Learn C", "Mahes karta", id1, library);
        issuebook.issuebooks("Learn java", "Zakir", id1, library);
        issuebook.printIssuedBookDetail();
        library.printbooklist();


        library.returnbook("Learn C", "Mahes karta", issuebook);
        library.printbooklist();
        issuebook.printIssuedBookDetail();


        //  System.out.println("Enter book name you want to check ");

        //  String checkbookname=sc.nextLine();
        //  String checkbookauthor=sc1.nextLine();

        //  Bookchecking b=new Bookchecking(checkbookname,checkbookauthor,d);


        //  for(InnerLibrary a: d){
        //  if(a.bookname.equalsIgnoreCase(checkbookname)&&a.bookauthor.equalsIgnoreCase(checkbookauthor)){
        // flag++;
        // break;
        //  }
        // }
        //  if(flag==1){
        //     System.out.println("Your enterd Book is  available  ");
        //  }
        //  else{
        //     System.out.println("Your enterd Book is not available  ");
        //  }


        //  InnerLibrary a2=d.get(0);


        //  System.out.println(a2.name+"  "+a2.data);


    }


}
