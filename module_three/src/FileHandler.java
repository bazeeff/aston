import java.io.*;

public class FileHandler {
    public static void main(String[] args) {
        String filePath = "data.txt";
        String dataToWrite = "Привет, это некоторые примерные данные, записанные в файл.";

        try {
            writeToFile(filePath, dataToWrite);
            System.out.println("Данные успешно записаны.");

            String readData = readFromFile(filePath);
            System.out.println("Данные, прочитанные из файла: " + readData);
        } catch (FileOperationException e) {
            System.err.println("Ошибка операции с файлом: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filePath, String data) throws FileOperationException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            throw new FileOperationException("Произошла ошибка при записи в файл: " + filePath, e);
        }
    }

    public static String readFromFile(String filePath) throws FileOperationException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new FileOperationException("Произошла ошибка при чтении из файла: " + filePath, e);
        }
        return content.toString().trim();
    }
}

class FileOperationException extends Exception {
    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}