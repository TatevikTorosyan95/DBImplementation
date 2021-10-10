import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class Update {
    public static void update(String query) {
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
            LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();

            String filename = query.split(" ")[1];

            String newQuery = query.substring(query.indexOf("set") + 4, query.indexOf("where"));
            String[] q = newQuery.split(",");

            for (int j = 0; j < q.length; j++) {
                String[] qq = q[j].split("=");
                for (int k = 0; k < qq.length - 1; k++) {
                    hashMap.put(qq[k].trim(), qq[k + 1].trim());
                }
            }
            List<String> lists = FileService.read("Database\\" + filename + ".txt");
            for (String list : lists) {
                String[] l = list.split(" ");
                for (int i = 0; i < l.length; i++) {
                    String[] ll = l[i].split("=");
                    for (int j = 0; j < ll.length - 1; j++) {
                        linkedHashMap.put(ll[j].trim(), ll[j + 1].trim());
                    }
                }
                String newMap = "";
                if (linkedHashMap.containsValue(query.split("=")[query.split("=").length - 1]) == true) {
                    LinkedHashMap<String, String> map = new LinkedHashMap<>();
                    map.putAll(linkedHashMap);
                    System.out.println(hashMap);
                    map.putAll(hashMap);
                    newMap = map.toString();
                    FileService.replaceLine("Database\\" + filename + ".txt", linkedHashMap.toString().replaceAll("[\\[\\](){}]", ""), newMap.replaceAll("[\\[\\](){}]", ""));
                }
            }

        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            System.out.println("Enter right command");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Enter right command");
        }
    }
}
