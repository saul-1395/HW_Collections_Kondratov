package FileReader;

import Converter.WordCounter;

import java.io.File;
import java.util.Scanner;

public class InfoReader {
    private InputData inputData;
    private WordCounter wordCounter;
    private String path;

    private void run(String path) {
        inputData = new InputData();
        wordCounter = new WordCounter(inputData.getStringList(path));
        System.out.println(wordCounter.getResult());
        System.out.println(wordCounter.getMaxLenght().toString());

    }

    public void inputPath() {
        System.out.println("Введите полный путь или имя файлa в папке по адресу "
                + System.getProperty("user.home") + "\\Documents\\Learn_IBS\\TestFiles\\" + ": ");

        Scanner in = new Scanner(System.in);
        String inputPath = in.nextLine();
        if (!inputPath.isEmpty()) {
            String firstSymbol = inputPath.substring(0, 2);
            if (firstSymbol.equals("C:")) {
                if (new File(inputPath).exists()) {
                    run(inputPath);
                } else {
                    System.out.println("Адрес не верен");
                    this.inputPath();
                }
            } else if (!inputPath.isEmpty()) {
                path = System.getProperty("user.home") + "\\Documents\\Learn_IBS\\TestFiles\\" + inputPath;
                if (new File(path).exists()) {
                    run(path);
                } else {
                    System.out.println("Имя файла не верно");
                    this.inputPath();
                }
            }
        } else {
            this.inputPath();
        }
    }
}
