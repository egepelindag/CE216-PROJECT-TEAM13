package sample.offlinedictionary;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Dict {

    HashMap<String, Words> turEngMap = new HashMap<String, Words>();

    HashMap<String, Words> engTurMap = new HashMap<String, Words>();
    HashMap<String, Words> engItaMap = new HashMap<String, Words>();
    HashMap<String, Words> itaEngMap = new HashMap<String, Words>();
    HashMap<String, Words> engGreMap = new HashMap<String, Words>();
    HashMap<String, Words> greEngMap = new HashMap<String, Words>();
    HashMap<String, Words> engFreMap = new HashMap<String, Words>();
    HashMap<String, Words> freEngMap = new HashMap<String, Words>();
    HashMap<String, Words> engSweMap = new HashMap<String, Words>();
    HashMap<String, Words> sweEngMap = new HashMap<String, Words>();
    HashMap<String, Words> engDeuMap = new HashMap<String, Words>();
    HashMap<String, Words> deuEngMap = new HashMap<String, Words>();






    public void turEng() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("tur-eng.txt"), "UTF-8"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("tr", "TR"));
            String meaning = parsedLine[1].toLowerCase(new Locale("tr", "TR"));
            Words words = new Words(wordName, meaning);
            turEngMap.put(wordName, words);
        }
        br.close();
    }

    public String turEngFindWord(String word) {
        for (String i : turEngMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = turEngMap.get(i);
                return newWord.meaning;
            }
        }
        return null;
    }

    public void turEngSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : turEngMap.keySet()) {
            Words w = turEngMap.get(i);
            bw.write(w.wordName);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }

    //
    //
    //
    //
    //
    //
    public void engTur() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("eng-tur.txt"), "UTF-8"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("tr", "TR"));
            String meaning = parsedLine[1].toLowerCase(new Locale("tr", "TR"));
            Words words = new Words(wordName, meaning);
            engTurMap.put(wordName, words);
        }
        br.close();
    }

    public String engTurFindWord(String word) {
        for (String i : engTurMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = engTurMap.get(i);
                return newWord.meaning;
            }
        }
        return null;
    }

    public void engTurSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : engTurMap.keySet()) {
            Words w = engTurMap.get(i);
            bw.write(w.wordName);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }


    //
    //
    //
    //
    //
    //
    public void engIta() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("eng-ita.txt"), "UTF-8"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("tr", "TR"));
            String meaning = parsedLine[1].toLowerCase(new Locale("tr", "TR"));
            Words words = new Words(wordName, meaning);
            engItaMap.put(wordName, words);
        }
        br.close();
    }

    public String engItaFindWord(String word) {
        for (String i : engItaMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = engItaMap.get(i);
                return newWord.meaning;
            }
        }
        return null;
    }

    public void engItaSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : engItaMap.keySet()) {
            Words w = engItaMap.get(i);
            bw.write(w.wordName);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }

    //
    //
    //
    //
    //
    //
    public void itaEng() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ita-eng.txt"), "UTF-8"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("tr", "TR"));
            String meaning = parsedLine[1].toLowerCase(new Locale("tr", "TR"));
            Words words = new Words(wordName, meaning);
            itaEngMap.put(wordName, words);
        }
        br.close();
    }

    public String itaEngFindWord(String word) {
        for (String i : itaEngMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = itaEngMap.get(i);
                return newWord.meaning;
            }
        }
        return null;
    }

    public void itaEngSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : itaEngMap.keySet()) {
            Words w = itaEngMap.get(i);
            bw.write(w.wordName);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }

    //
    //
    //
    //
    //
    //
    public void engGre() throws Exception {

        BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream("eng-ell.txt"), StandardCharsets.UTF_8));
        String line;

        while ((line = br1.readLine()) != null) {
            String[] parsedLine = line.split(">");
            if (parsedLine.length >= 2) {
                String wordName = parsedLine[0].toLowerCase(new Locale("el", "GR"));
                String meaning = parsedLine[1].toLowerCase(new Locale("el", "GR"));
                Words words = new Words(wordName, meaning);
                engGreMap.put(wordName, words);
            }
        }
        br1.close();

    }

    public String engGreFindWord(String word) {
        for (String i : engGreMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = engGreMap.get(i);
                return newWord.meaning.toLowerCase(Locale.ROOT);
            }
        }
        return null;
    }

    public void engGreSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : engGreMap.keySet()) {
            Words w = engGreMap.get(i);
            bw.write(w.wordName);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }

    //
    //
    //
    //
    //
    //
    public void greEng() throws Exception {

        FileInputStream fis = new FileInputStream("ell-eng.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("el", "GR"));
            String meaning = parsedLine[1].toLowerCase(new Locale("el", "GR"));
            Words words = new Words(wordName, meaning);
            greEngMap.put(wordName, words);
        }
        br.close();
    }

    public String greEngFindWord(String word) {
        for (String i : greEngMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = greEngMap.get(i);
                return newWord.meaning.toLowerCase(Locale.ROOT);
            }
        }
        return null;
    }

    public void greEngSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : greEngMap.keySet()) {
            Words w = greEngMap.get(i);
            bw.write(w.wordName.toLowerCase(new Locale("el", "GR")));
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }


    //
    //
    //
    //
    //
    //
    public void engFre() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("eng-fra.txt"), "UTF-8"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("tr", "TR"));
            String meaning = parsedLine[1].toLowerCase(new Locale("tr", "TR"));
            Words words = new Words(wordName, meaning);
            engFreMap.put(wordName, words);
        }
        br.close();
    }

    public String engFreFindWord(String word) {
        for (String i : engFreMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = engFreMap.get(i);
                return newWord.meaning;
            }
        }
        return null;
    }

    public void engFraSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : engFreMap.keySet()) {
            Words w = engFreMap.get(i);
            bw.write(w.wordName);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }

    //
    //
    //
    //
    //
    //
    public void freEng() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("fra-eng.txt"), "UTF-8"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("tr", "TR"));
            String meaning = parsedLine[1].toLowerCase(new Locale("tr", "TR"));
            Words words = new Words(wordName, meaning);
            freEngMap.put(wordName, words);
        }
        br.close();
    }

    public String freEngFindWord(String word) {
        for (String i : freEngMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = freEngMap.get(i);
                return newWord.meaning;
            }
        }
        return null;
    }

    public void freEngSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : freEngMap.keySet()) {
            Words w = freEngMap.get(i);
            bw.write(w.wordName);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }

    //
    //
    //
    //
    //
    //
    public void engSwe() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("eng-swe.txt"), "UTF-8"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("tr", "TR"));
            String meaning = parsedLine[1].toLowerCase(new Locale("tr", "TR"));
            Words words = new Words(wordName, meaning);
            engSweMap.put(wordName, words);
        }
        br.close();
    }

    public String engSweFindWord(String word) {
        for (String i : engSweMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = engSweMap.get(i);
                return newWord.meaning;
            }
        }
        return null;
    }

    public void engSweSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : engSweMap.keySet()) {
            Words w = engSweMap.get(i);
            bw.write(w.wordName);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }

    //
    //
    //
    //
    //
    //
    public void sweEng() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("swe-eng.txt"), "UTF-8"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("tr", "TR"));
            String meaning = parsedLine[1].toLowerCase(new Locale("tr", "TR"));
            Words words = new Words(wordName, meaning);
            sweEngMap.put(wordName, words);
        }
        br.close();
    }

    public String sweEngFindWord(String word) {
        for (String i : sweEngMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = sweEngMap.get(i);
                return newWord.meaning;
            }
        }
        return null;
    }

    public void sweEngSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : sweEngMap.keySet()) {
            Words w = sweEngMap.get(i);
            bw.write(w.wordName);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }


    //
    //
    //
    //
    //
    //
    public void engDeu() throws Exception {
        Scanner scanner1 = new Scanner(Paths.get("eng-deu_1.txt"), "UTF-8");
        Scanner scanner2 = new Scanner(Paths.get("eng-deu_2.txt"), "UTF-8");
        Scanner scanner3 = new Scanner(Paths.get("eng-deu_3.txt"), "UTF-8");
        Scanner scanner4 = new Scanner(Paths.get("eng-deu_4.txt"), "UTF-8");
        Scanner scanner5 = new Scanner(Paths.get("eng-deu_5.txt"), "UTF-8");
        BufferedReader br6 = new BufferedReader(new InputStreamReader(new FileInputStream("eng-deu_6.txt"), StandardCharsets.UTF_8));


        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("de", "AT"));
            String meaning = parsedLine[parsedLine.length-2].toLowerCase(new Locale("de", "AT"));
            Words word = new Words(wordName, meaning);
            engDeuMap.put(wordName, word);
        }


        while (scanner2.hasNextLine()) {
            String line = scanner2.nextLine();
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("de", "AT"));
            String meaning = parsedLine[parsedLine.length-2].toLowerCase(new Locale("de", "AT"));
            Words word = new Words(wordName, meaning);
            engDeuMap.put(wordName, word);
        }


        while (scanner3.hasNextLine()) {
            String line = scanner3.nextLine();
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("de", "AT"));
            String meaning = parsedLine[parsedLine.length-2].toLowerCase(new Locale("de", "AT"));
            Words word = new Words(wordName, meaning);
            engDeuMap.put(wordName, word);
        }


        while (scanner4.hasNextLine()) {
            String line = scanner4.nextLine();
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("de", "AT"));
            String meaning = parsedLine[parsedLine.length-2].toLowerCase(new Locale("de", "AT"));
            Words word = new Words(wordName, meaning);
            engDeuMap.put(wordName, word);
        }


        while (scanner5.hasNextLine()) {
            String line = scanner5.nextLine();
            String[] parsedLine = line.split(">");
            String wordName = parsedLine[0].toLowerCase(new Locale("de", "AT"));
            String meaning = parsedLine[parsedLine.length-2].toLowerCase(new Locale("de", "AT"));
            Words word = new Words(wordName, meaning);
            engDeuMap.put(wordName, word);
        }


        String satir;
        while ((satir = br6.readLine()) != null) {
            int aIndeksi = satir.indexOf(">");
            String wordName = satir.substring(0, aIndeksi).toLowerCase(new Locale("de", "AT")); // 0. indeks'ten > karakterinin öncesini al
            String meaning = satir.substring(aIndeksi+1).toLowerCase(new Locale("de", "AT"));
            Words word = new Words(wordName, meaning);
            engDeuMap.put(wordName, word);
        }
        br6.close();


    }

    public String engDeuFindWord(String word) {
        for (String i : engDeuMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = engDeuMap.get(i);
                return newWord.meaning;
            }
        }
        return null;
    }

    public void engDeuSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : engDeuMap.keySet()) {
            Words w = engDeuMap.get(i);
            bw.write(w.wordName);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }

    //
    //
    //
    //
    //
    //
    public void deuEng() throws Exception {

        BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream("deu-eng_11.txt"), StandardCharsets.UTF_8));
        String satir;
        while ((satir = br1.readLine()) != null) {
            int aIndeksi = satir.indexOf(">");
            String wordName = satir.substring(0, aIndeksi).toLowerCase(new Locale("de", "AT")); // 0. indeks'ten > karakterinin öncesini al
            String meaning = satir.substring(aIndeksi+1).toLowerCase(new Locale("de", "AT"));
            Words word = new Words(wordName, meaning);
            deuEngMap.put(wordName, word);
        }
        br1.close();

        BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("deu-eng_22.txt"), StandardCharsets.UTF_8));
        String satir2;
        while ((satir2 = br2.readLine()) != null) {
            int aIndeksi = satir2.indexOf(">");
            String wordName = satir2.substring(0, aIndeksi).toLowerCase(new Locale("de", "AT")); // 0. indeks'ten > karakterinin öncesini al
            String meaning = satir2.substring(aIndeksi+1).toLowerCase(new Locale("de", "AT"));
            Words word = new Words(wordName, meaning);
            deuEngMap.put(wordName, word);
        }
        br2.close();

        BufferedReader br3 = new BufferedReader(new InputStreamReader(new FileInputStream("deu-eng_33.txt"), StandardCharsets.UTF_8));
        String satir3;
        while ((satir3 = br3.readLine()) != null) {
            int aIndeksi = satir3.indexOf(">");
            String wordName = satir3.substring(0, aIndeksi).toLowerCase(new Locale("de", "AT")); // 0. indeks'ten > karakterinin öncesini al
            String meaning = satir3.substring(aIndeksi+1).toLowerCase(new Locale("de", "AT"));
            Words word = new Words(wordName, meaning);
            deuEngMap.put(wordName, word);
        }
        br3.close();

        BufferedReader br4 = new BufferedReader(new InputStreamReader(new FileInputStream("deu-eng_44.txt"), StandardCharsets.UTF_8));
        String satir4;
        while ((satir4 = br4.readLine()) != null) {
            int aIndeksi = satir4.indexOf(">");
            String wordName = satir4.substring(0, aIndeksi).toLowerCase(new Locale("de", "AT")); // 0. indeks'ten > karakterinin öncesini al
            String meaning = satir4.substring(aIndeksi+1).toLowerCase(new Locale("de", "AT"));
            Words word = new Words(wordName, meaning);
            deuEngMap.put(wordName, word);
        }
        br4.close();

        BufferedReader br5 = new BufferedReader(new InputStreamReader(new FileInputStream("deu-eng_55.txt"), StandardCharsets.UTF_8));
        String satir5;
        while ((satir5 = br5.readLine()) != null) {
            int aIndeksi = satir5.indexOf(">");
            String wordName = satir5.substring(0, aIndeksi).toLowerCase(new Locale("de", "AT")); // 0. indeks'ten > karakterinin öncesini al
            String meaning = satir5.substring(aIndeksi+1).toLowerCase(new Locale("de", "AT"));
            Words word = new Words(wordName, meaning);
            deuEngMap.put(wordName, word);
        }
        br5.close();

    }

    public String deuEngFindWord(String word) {
        for (String i : deuEngMap.keySet()) {
            if (i.equals(word.toLowerCase(Locale.ROOT))) {
                Words newWord = deuEngMap.get(i);
                return newWord.meaning;
            }
        }
        return null;
    }

    public void deuEngSaveRecords() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("newDictionary.txt"));
        for (String i : deuEngMap.keySet()) {
            Words w = deuEngMap.get(i);
            bw.write(w.wordName);
            bw.write(",");
            bw.write(w.meaning);
            bw.write("\n");
        }
        bw.close();
    }
}


