import java.util.LinkedHashMap;
import java.util.UUID;

public class Insert {
    public static void insert(String query) {
        LinkedHashMap<String, String> hash_map = new LinkedHashMap<String, String>();
        try {
            String fileName = query.split(" ")[2];
            String[] insertQuery = query.split("[\\(||\\)]");
            String[] insertKey = insertQuery[1].split(",");
            String[] insertValue = insertQuery[3].split(",");
            for (int i = 0; i < insertValue.length; i++) {
                hash_map.put(insertKey[i].trim(), insertValue[i].trim());
            }
            String id = "";
            String uniqueID = UUID.randomUUID().toString();
            id = "id=" + uniqueID + " ";
            for (String name : hash_map.keySet()) {
                String key = name;
                String value = hash_map.get(name);
                id += key + "=" + value + " ";
            }
            FileService.write("Database\\" + fileName + ".txt", id + "\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Enter right command");
        }
    }
}
