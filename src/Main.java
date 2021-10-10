import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);

        boolean isActive = true;
        while (isActive) {
            String query = scanner.nextLine();

            int length = query.split(" ").length;

            switch (query.split(" ")[0].toLowerCase()) {
                case "create":
                    //create users
                    Create.create(query);
                    break;
                case "insert":
                    //insert into users (name, age) values (Tom , 85)
                    Insert.insert(query);
                    break;
                case "select":
                    //select * from users
                    //select name from users
                    Select.select(query);
                    break;
                case "update":
                    //update users set name = TomHanks where age  = 85
                    Update.update(query);
                    break;
                case "delete":
                    //delete from users where age = 85
                    Delete.delete(query);
                    break;
                case "":
                    isActive = false;
                    break;
                default:
                    System.out.println("Enter right command");
            }
        }
    }
}
