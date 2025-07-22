import java.util.Scanner;


public class UserInfo {
    private String name;
    private   int age;
    private  String email;
    private boolean isActive;

    public UserInfo(String n,int Age,String Email,boolean isAct)
    {
        name=n;
        age=Age;
        email=Email;
        isActive=isAct;

    }


        public String getName() { return name; }
        public int getAge() { return age;}
        public String getEmail(){return email;}
        public boolean IsActive(){return isActive;}

        public void setName(String n)
        {
            name=n;
        }
        public void setAge(int Age)
        {
            age=Age;
        }
        public void setEmail(String Email)
        {
            email=Email;
        }
        public void setIsActive(boolean IsAct)
        {
            isActive=IsAct;
        }

    public void displayInfo() {
        System.out.println("Information for the user");
        System.out.println("The Name is:"+name);
        System.out.println("The Age is"+age);
        System.out.println("The Email is:"+email);
        System.out.println("The Active is:"+(isActive?"Yes" : "No"));

    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Are you active? (true/false): ");
        boolean isActive = scanner.nextBoolean();

        UserInfo user = new UserInfo( name , age, email, isActive);
        user.displayInfo();//problem solved

        scanner.close();

        }


    }