package FileReader;

import Converter.WordCounter;

import java.io.File;
import java.util.Scanner;

public class InfoReader {
    private InputData inputData;
    private WordCounter wordCounter;
    private String path;

    public void appStart() {
        inputPath();
        inputData = new InputData();
        wordCounter = new WordCounter(inputData.getStringList(path));
        System.out.println("Количество слов в тексте");
        System.out.println(wordCounter.getResult());
        System.out.println("Чаще всего встречается");
        System.out.println(wordCounter.getMaxLenght().toString());
        System.out.println("По алфавиту");
        System.out.println(wordCounter.alphabeticalOrder());


    }

    private void inputPath() {
        System.out.println("Введите полный путь или имя файлa");
        String resourcesPath = "src/main/resources/";


        Scanner in = new Scanner(System.in);
        String inputPath = in.nextLine();

        if (!inputPath.isEmpty()) {
            if (!inputPath.contains("/")) {
                inputPath = resourcesPath + inputPath;
                
            }
            if (new File(inputPath).exists()) {
                path = inputPath;

            } else {
                System.out.println("Имя файла не верно");
                inputPath();
            }
        } else {
            System.out.println("Введите имя файла или путь");
            inputPath();
        }
    }
}
