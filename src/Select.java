import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class Select {

    public static void select(String query) throws IOException {
        try {
            if (query.split(" ")[1].equalsIgnoreCase("*") &&
                    query.split(" ")[2].equalsIgnoreCase("from")) {
                String fileName = query.split(" ")[3];
                FileService.readLines("Database\\" + fileName + ".txt");
            } else if (query.split(" ")[0].equalsIgnoreCase("select") &&
                    query.split(" ")[query.split(" ").length - 2].equalsIgnoreCase("from")) {

                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();

                String fileName = query.split(" ")[query.split(" ").length - 1];
                List<String> lists = FileService.read("Database\\" + fileName + ".txt");
                for (String list : lists) {
                    String[] aaa = list.split(" ");
                    for (int i = 0; i < aaa.length; i++) {
                        String[] bbb = aaa[i].split("=");
                        for (int j = 0; j < bbb.length - 1; j++) {
                            linkedHashMap.put(bbb[j].trim(), bbb[j + 1].trim());
                        }
                    }
                    int z = 1;
                    while (!query.split(" ")[z].equalsIgnoreCase("from")) {
                        System.out.println(query.split(" ")[z].replaceAll(",","") + " = " +
                                linkedHashMap.get(query.split(" ")[z].replaceAll(",","")));
                        z++;
                    }

                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Enter right command");
        }

    }
}

