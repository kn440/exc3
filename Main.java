import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (Фамилию Имя Отчество Номер_телефона):");
        String inputData = scanner.nextLine();

        String[] splitData = inputData.split(" ");

        if (splitData.length != 4) {
            System.out.println("Ошибка: Вы ввели неправильное количество данных");
            return;
        }

        String surname = splitData[0];
        String name = splitData[1];
        String patronymic = splitData[2];
        String phoneNumberStr = splitData[3];

        long phoneNumber = 0;

        try {
            phoneNumber = Long.parseUnsignedLong(phoneNumberStr);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Номер телефона не является допустимым целым числом без знака.");
            return;
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter(surname + ".txt", true);
            String text = "\n"+surname + " " + name + " " + patronymic + " " + phoneNumber ;
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Данные были успешно обработаны и сохранены в файле.");
    }
}
