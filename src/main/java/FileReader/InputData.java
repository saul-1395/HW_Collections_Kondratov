package FileReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class InputData {
    private ArrayList<String> stringList;


    public ArrayList<String> getStringList(String path) {
        fileRider(path);
        return stringList;
    }

    /**
     * читаем файл построчно, каждую строку чистим методами ниже, на выходи лист(String) слов.
     */
    private ArrayList<String> fileRider(String path) {
        stringList = new ArrayList<>();
        stringList.clear();
        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            while (line != null) {
                stringList.addAll(lineRedactor(line));

                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println(" введён неправильный адрес");
            e.printStackTrace();
         //  new FileReader.InfoReader().inputPath();
        } catch (IOException e) {
            e.printStackTrace();

        }

        return stringList;
    }

    /**
     * здесь полученную строку "чистим" от заглавных букв, знаков, цифр(методом removePunct), удаляем пустые значения String
     * и разбиваем по пробелам на отдельные слова.
     */

    private ArrayList<String> lineRedactor(String s) {

        s = s.toLowerCase();
        s = removePunct(s);
        s = s.replaceAll("\\\\n", "");

        ArrayList<String> list = new ArrayList<>();
        String[] array = s.split(" ");
        list.addAll(Arrays.asList(array));
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            String temp = (String) iterator.next();

            if (temp.isEmpty()) {
                iterator.remove();
            }
        }


        return list;
    }

    /**
     * здесь чистим от цифр и знаков
     */
    private String removePunct(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isSpaceChar(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }


}
