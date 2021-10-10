public class Create {
    public static void create(String query) {
        try {
            if (query.split(" ")[1] != "" && query.split(" ").length == 2) {

                String fileName = query.split(" ")[1];
                FileService.createFolder("DataBase");
                FileService.createFile("DataBase", fileName + ".txt");
            } else {
                System.out.println("Enter right command");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Enter right command");
        }

    }
}
