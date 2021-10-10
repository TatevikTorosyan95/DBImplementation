import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {
    public static void createFolder(String path) {
        File f = new File(path);
        f.mkdir();
    }

    public static void createFile(String path, String name) {
        File file = new File(path + File.separator + name);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String path, String text) {
        try {
            Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Enter right file name");
        }
    }

    public static void readLines(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> read(String path) throws IOException {
        final List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        return lines;
    }

    public static void removeLine(String filePath, String lineContent) throws IOException
    {
        Path path = Paths.get(filePath);
        String lineCont = lineContent.replaceAll(",", "");
        List<String> out = Files.lines(path)
                .filter(line -> !line.contains(lineCont))
                .collect(Collectors.toList());
        Files.write(path, out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void replaceLine(String filePath, String originalLineText, String newLineText) throws IOException {
        String oldLine = originalLineText.replaceAll(",","");
        String newLine = newLineText.replaceAll(",","");
        Path path = Paths.get(filePath);
        List<String> fileContent = new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));
        for (int i = 0; i < fileContent.size(); i++) {
            System.out.println(fileContent.get(i));
            System.out.println(oldLine);
            if (fileContent.get(i).trim().equals(oldLine.trim())) {
                System.out.println(oldLine);
                fileContent.set(i, newLine);
                break;
            }
        }
        Files.write(path, fileContent, StandardCharsets.UTF_8);
    }
}
