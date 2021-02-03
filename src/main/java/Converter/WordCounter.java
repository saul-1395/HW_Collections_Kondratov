package Converter;

import java.util.*;

public class WordCounter {
    private final LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
    private final ArrayList<String> maxLenWords = new ArrayList<>();
    private ArrayList<String> resultString = new ArrayList<>();
    private ArrayList<String> keylist = new ArrayList<>();


    private int maxLen = 0;
    /**
     * При создании объекта должны отдать коллекцию, для исключения проблемы с работой остальных методов.
     */
    public WordCounter(ArrayList<String> resultString) {
        counter(resultString);
        this.resultString = resultString;
    }

    /**
     * Если хотим воспользоваться ковертером ещё раз, используем передаём в экземпляр лист(String),
     * в результете затераем все коллекции объекта и перезаписываем с новыми данными.
     */
    public void setResultString(ArrayList<String> resultString) {

        result.clear();
        maxLenWords.clear();
        keylist.clear();
        maxLen = 0;
        counter(resultString);
        this.resultString = resultString;
    }

    public MaxLenWords getMaxLenght() {

        int temp = 0;
        keylist.addAll(result.keySet());
        // System.out.println(keylist);
        while (temp < result.size()) {
            String s = keylist.get(temp);
            int i = result.get(s);
            if (i > maxLen) {
                maxLenWords.clear();
                maxLen = i;
                maxLenWords.add(s);
            } else if (i == maxLen) {
                maxLenWords.add(s);

            }
            temp++;
        }
        MaxLenWords maxLenghtWords = new MaxLenWords(maxLen, maxLenWords);

        return maxLenghtWords;
    }

    public LinkedHashMap<String, Integer> getResult() {
        return result;
    }


    @Override
    public String toString() {
        return "Converter.WordCounter{" +
                "result=" + result +
                '}';
    }

    private LinkedHashMap<String, Integer> counter(ArrayList<String> list) {

        int temp = 0;
        String tempString;

        while (temp < list.size()) {
            tempString = list.get(temp);
            if (!result.containsKey(tempString)) {
                result.put(tempString, 1);
            } else {
                result.put(tempString, result.get(tempString) + 1);
            }

            temp++;
        }
        return sortedList(result);

    }

    private LinkedHashMap<String, Integer> sortedList(LinkedHashMap<String, Integer> list) {

        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(list.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue() - entry2.getValue();
            }

        });
        list.clear();

        for (Map.Entry<String, Integer> e : entries) {

            list.put(e.getKey(), e.getValue());
        }
        return list;

    }

    public ArrayList<String> alphabeticalOrder(){
        Collections.sort(resultString);

        return resultString;

    }


}
