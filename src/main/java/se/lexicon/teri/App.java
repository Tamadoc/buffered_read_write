package se.lexicon.teri;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        File url = new File("destination/example.com");
        List<String> content = Arrays.asList(
                "This", "is", "my","first", "IO", "operation"
        );
        write(url,content);

        for (String string : read(url)) {
            System.out.println(string);
        }

    }

    public static List<String> write(File destination, List<String> source){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String toWrite : source) {
                writer.write(toWrite);
                writer.write(' ');
            }
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return source;
    }

    public static List<String> read (File source) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))){
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
