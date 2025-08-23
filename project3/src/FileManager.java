import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private final String filename;

    public FileManager(final String filename) {
        this.filename = filename;
    }

    public void writeToFile(final List<String> lines) throws CustomException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data is successfully saved to file: " + filename);
        } catch (IOException e) {
            throw new CustomException("Error writing to file: " + filename, e);
        }
    }

    public List<String> readFromFile() throws CustomException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            System.out.println("Data successfully read from file: " + filename);
            return lines;
        } catch (FileNotFoundException e) {
            throw new CustomException("File not found: " + filename, e);
        } catch (IOException e) {
            throw new CustomException("Error reading file: " + filename, e);
        }
    }

    public void appendToFile(final List<String> lines) throws CustomException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data successfully added to file: " + filename);
        } catch (IOException e) {
            throw new CustomException("Error adding data to file: " + filename, e);
        }
    }

    public void cleanFile() throws CustomException {
        try (FileOutputStream fos = new FileOutputStream(filename)) {

            System.out.println("File successfully cleared: " + filename);
        } catch (IOException e) {
            throw new CustomException("Error clearing file: " + filename, e);
        }
    }

}
