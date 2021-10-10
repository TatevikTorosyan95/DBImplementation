import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.LinkedHashMap;
import java.util.List;

public class Delete {
    public static void delete(String query) throws IOException {
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();

            String filename = query.split(" ")[2];
            List<String> lists = FileService.read("Database\\"+filename+".txt");
            for (String list : lists) {
                String[] aaa = list.split(" ");
                for (int i = 0; i < aaa.length; i++) {
                    String[] bbb = aaa[i].split("=");
                    for (int j = 0; j < bbb.length-1; j ++) {
                        linkedHashMap.put(bbb[j].trim(),bbb[j+1].trim());
                    }
                }

                if (linkedHashMap.containsValue(query.split(" ")[query.split(" ").length - 1]) == true) {
                    LinkedHashMap<String, String> deleteList = linkedHashMap;
                    FileService.removeLine("Database\\" + filename + ".txt",deleteList.toString().replaceAll("[\\[\\](){}]",""));
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Enter right command");
        } catch (NoSuchFileException e) {
            System.out.println("Enter right file name");
        }
    }
}
