import java.io.*;

public class Task_2 {
    public static void readFile(String filePath) throws FileNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    public static void copyFile(String sourceFilePath, String destinationFilePath) throws IOException {
        try (InputStream inputStream = new FileInputStream(sourceFilePath);
             OutputStream outputStream = new FileOutputStream(destinationFilePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {
        try {
            // Примеры использования методов
            String sourceFilePath = "source.txt";
            String destinationFilePath = "destination.txt";
            String content = "Hello, World!";

            writeFile(sourceFilePath, content);
            System.out.println("Файл записан успешно.");

            readFile(sourceFilePath);
            System.out.println("Файл прочитан успешно.");

            copyFile(sourceFilePath, destinationFilePath);
            System.out.println("Файл скопирован успешно.");
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден.");
        } catch (IOException e) {
            System.err.println("Ошибка: Возникла ошибка ввода/вывода.");
        }
    }
}
