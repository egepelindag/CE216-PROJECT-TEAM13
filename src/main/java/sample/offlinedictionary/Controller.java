package sample.offlinedictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Controller {

    @FXML
    private Label helpMenu;
    @FXML
    private Label devsMenu;

    @FXML
    private TextArea translateArea;

    @FXML
    private TextField searchText;

    @FXML
    public void closeApp(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void showHelpMenu(ActionEvent actionEvent) {
        if (helpMenu.getText().equals("")) {
            helpMenu.setText("1-Enter the text!\n" +
                    "2-Click translate button!\n" +
                    "3-Wait for the results...");
        } else {
            helpMenu.setText("");
        }
    }

    @FXML
    public void showDevs(ActionEvent actionEvent) {
        if (devsMenu.getText().equals("")) {
            devsMenu.setText("Canberk Çoban\n" +
                    "Ege Pelindağ\n" +
                    "Hakan Uzun\n" +
                    "Ahmet Eren Sırcan");
        } else {
            devsMenu.setText("");
        }
    }
    @FXML
    public void infoSection(ActionEvent actionEvent) throws IOException {
        Parent helpRoot = FXMLLoader.load(getClass().getResource("infoSection.fxml"));
        Scene helpScene = new Scene(helpRoot);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Info");
        primaryStage.setScene(helpScene);

        primaryStage.show();
    }

    @FXML
    public void infoToMain(ActionEvent actionEvent){
        Node backToMainNode = (Node) actionEvent.getSource();
        Stage infoStage = (Stage) backToMainNode.getScene().getWindow();
        infoStage.close();


    }


    @FXML
    private void translate(ActionEvent event) throws Exception {
        Dict dict = new Dict();
        dict.turEng();
        dict.engTur();
        dict.engIta();
        dict.itaEng();
        dict.engFre();
        dict.freEng();
        dict.engSwe();
        dict.sweEng();
        dict.engGre();
        dict.greEng();
        dict.engDeu();
        dict.deuEng();


        String word = searchText.getText();//the word we search
        ArrayList<String> wordlist = new ArrayList<String>();// a list for the words which have meanings


        //ENGLISH
        String edWord = dict.engDeuFindWord(word);
        if (edWord == null) {
            edWord = " ";
        } else {
            wordlist.add("ENGLISH --> GERMAN: " + edWord);
        }

        String etWord = dict.engTurFindWord(word);
        if (etWord == null) {
            etWord = " ";
        } else {
            wordlist.add("ENGLISH --> TURKISH: " + etWord);
        }

        String esWord = dict.engSweFindWord(word);
        if (esWord == null) {
            esWord = " ";
        } else {
            wordlist.add("ENGLISH --> SWEDISH: " + esWord);
        }

        String eiWord = dict.engItaFindWord(word);
        if (eiWord == null) {
            eiWord = " ";
        } else {
            wordlist.add("ENGLISH --> ITALIAN: " + eiWord);
        }

        String efWord = dict.engFreFindWord(word);
        if (efWord == null) {
            efWord = " ";
        } else {
            wordlist.add("ENGLISH --> FRENCH: " + efWord);
        }

        String enggreWord = dict.engGreFindWord(word);
        if (enggreWord == null) {
            efWord = " ";
        } else {
            wordlist.add("ENGLISH --> GREEK: " + enggreWord);
        }


        //GERMAN
        String gerengWord = dict.deuEngFindWord(word);
        if (gerengWord == null) {
            gerengWord = " ";
        } else {
            wordlist.add("GERMAN --> ENGLISH: " + gerengWord);
        }

        String geritaWord = dict.engItaFindWord(gerengWord);
        if (geritaWord == null) {
            geritaWord = " ";
        } else {
            wordlist.add("GERMAN --> ITALIAN: " + geritaWord);
        }

        String gerfreWord = dict.engFreFindWord(gerengWord);
        if (gerfreWord == null) {
            gerfreWord = " ";
        } else {
            wordlist.add("GERMAN --> FRENCH: " + gerfreWord);
        }

        String gersweWord = dict.engSweFindWord(gerengWord);
        if (gersweWord == null) {
            gersweWord = " ";
        } else {
            wordlist.add("GERMAN --> SWEDISH: " + gersweWord);
        }

        String gerturWord = dict.engTurFindWord(gerengWord);
        if (gerturWord == null) {
            gerturWord = " ";
        } else {
            wordlist.add("GERMAN --> TURKISH: " + gerturWord);
        }

        String deugreWord = dict.engGreFindWord(gerengWord);
        if (deugreWord == null) {
            deugreWord = " ";
        } else {
            wordlist.add("GERMAN --> GREEK: " + deugreWord);
        }


        //TURKISH
        String teWord = dict.turEngFindWord(word);
        if (teWord == null) {
            teWord = " ";
        } else {
            wordlist.add("TURKISH --> ENGLISH: " + teWord);
        }

        String turitaWord = dict.engItaFindWord(teWord);
        if (turitaWord == null) {
            turitaWord = " ";
        } else {
            wordlist.add("TURKISH --> ITALIAN: " + turitaWord);
        }

        String turfreWord = dict.engFreFindWord(teWord);
        if (turfreWord == null) {
            turfreWord = " ";
        } else {
            wordlist.add("TURKISH --> FRENCH: " + turfreWord);
        }

        String tursweWord = dict.engSweFindWord(teWord);
        if (tursweWord == null) {
            tursweWord = " ";
        } else {
            wordlist.add("TURKISH --> SWEDISH: " + tursweWord);
        }

        String turgerWord = dict.engDeuFindWord(teWord);
        if (turgerWord == null) {
            turgerWord = " ";
        } else {
            wordlist.add("TURKISH --> GERMAN: " + turgerWord);
        }

        String turgreWord = dict.engGreFindWord(teWord);
        if (turgreWord == null) {
            turgreWord = " ";
        } else {
            wordlist.add("TURKISH --> GREEK: " + turgreWord);
        }


        //ITALIAN

        String ieWord = dict.itaEngFindWord(word);
        if (ieWord == null) {
            ieWord = " ";
        } else {
            wordlist.add("ITALIAN --> ENGLISH: " + ieWord);
        }

        String itagerWord = dict.engDeuFindWord(ieWord);
        if (itagerWord == null) {
            itagerWord = " ";
        } else {
            wordlist.add("ITALIAN --> GERMAN: " + itagerWord);
        }

        String itaturWord = dict.engTurFindWord(ieWord);
        if (itaturWord == null) {
            itaturWord = " ";
        } else {
            wordlist.add("ITALIAN --> TURKISH: " + itaturWord);
        }

        String itafreWord = dict.engFreFindWord(ieWord);
        if (itafreWord == null) {
            itafreWord = " ";
        } else {
            wordlist.add("ITALIAN --> FRENCH: " + itafreWord);
        }

        String itasweWord = dict.engSweFindWord(ieWord);
        if (itasweWord == null) {
            itasweWord = " ";
        } else {
            wordlist.add("ITALIAN --> SWEDISH: " + itasweWord);
        }

        String itagreWord = dict.engGreFindWord(ieWord);
        if (itagreWord == null) {
            itagreWord = " ";
        } else {
            wordlist.add("ITALIAN --> GREEK: " + itagreWord);
        }


        //FRENCH
        String feWord = dict.freEngFindWord(word);
        if (feWord == null) {
            feWord = " ";
        } else {
            wordlist.add("FRENCH --> ENGLISH: " + feWord);
        }

        String fregerWord = dict.engDeuFindWord(feWord);
        if (fregerWord == null) {
            fregerWord = " ";
        } else {
            wordlist.add("FRENCH --> GERMAN: " + fregerWord);
        }

        String freturWord = dict.engTurFindWord(feWord);
        if (freturWord == null) {
            freturWord = " ";
        } else {
            wordlist.add("FRENCH --> TURKISH: " + freturWord);
        }

        String freitaWord = dict.engItaFindWord(feWord);
        if (freitaWord == null) {
            freitaWord = " ";
        } else {
            wordlist.add("FRENCH --> TURKISH: " + freitaWord);
        }

        String fresweWord = dict.engSweFindWord(feWord);
        if (fresweWord == null) {
            fresweWord = " ";
        } else {
            wordlist.add("FRENCH --> SWEDISH: " + fresweWord);
        }

        String fregreWord = dict.engGreFindWord(feWord);
        if (fregreWord == null) {
            fregreWord = " ";
        } else {
            wordlist.add("FRENCH --> GREEK: " + fregreWord);
        }


        //SWEDISH
        String seWord = dict.sweEngFindWord(word);
        if (seWord == null) {
            seWord = " ";
        } else {
            wordlist.add("SWEDISH --> ENGLISH: " + seWord);
        }

        String swegerWord = dict.engDeuFindWord(seWord);
        if (swegerWord == null) {
            swegerWord = " ";
        } else {
            wordlist.add("SWEDISH --> GERMAN: " + swegerWord);
        }

        String sweturWord = dict.engTurFindWord(seWord);
        if (sweturWord == null) {
            sweturWord = " ";
        } else {
            wordlist.add("SWEDISH --> TURKISH: " + sweturWord);
        }

        String sweitaWord = dict.engItaFindWord(seWord);
        if (sweitaWord == null) {
            sweitaWord = " ";
        } else {
            wordlist.add("SWEDISH --> ITALIAN: " + sweitaWord);
        }

        String swefreWord = dict.engFreFindWord(seWord);
        if (swefreWord == null) {
            swefreWord = " ";
        } else {
            wordlist.add("SWEDISH --> FRENCH: " + swefreWord);
        }

        String swegreWord = dict.engGreFindWord(seWord);
        if (swegreWord == null) {
            swegreWord = " ";
        } else {
            wordlist.add("SWEDISH --> GREEK: " + swegreWord);
        }


        //GREEK
        String greengWord = dict.greEngFindWord(word);
        if (greengWord == null) {
            greengWord = " ";
        } else {
            wordlist.add("GREEK --> ENGLISH: " + greengWord);
        }

        String gredeuWord = dict.engDeuFindWord(greengWord);
        if (gredeuWord == null) {
            gredeuWord = " ";
        } else {
            wordlist.add("GREEK --> GERMAN: " + gredeuWord);
        }

        String greitaWord = dict.engItaFindWord(greengWord);
        if (greitaWord == null) {
            greitaWord = " ";
        } else {
            wordlist.add("GREEK --> ITALIAN: " + greitaWord);
        }

        String grefreWord = dict.engFreFindWord(greengWord);
        if (grefreWord == null) {
            grefreWord = " ";
        } else {
            wordlist.add("GREEK --> FRENCH: " + grefreWord);
        }

        String gresweWord = dict.engSweFindWord(greengWord);
        if (gresweWord == null) {
            gresweWord = " ";
        } else {
            wordlist.add("GREEK --> SWEDISH: " + gresweWord);
        }

        String greturWord = dict.engTurFindWord(greengWord);
        if (greturWord == null) {
            greturWord = " ";
        } else {
            wordlist.add("GREEK --> TURKISH: " + greturWord);
        }


        //array
        String[] words = new String[100];
        for (int i = 0; i < wordlist.size(); i++) {
            words[i] = wordlist.get(i);
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) {
                words[i] = "";
            }
        }


        translateArea.setText(
                        words[0] + "\n" +
                        words[1] + "\n" +
                        words[2] + "\n" +
                        words[3] + "\n" +
                        words[4] + "\n" +
                        words[5] + "\n" +
                        words[6] + "\n" +
                        words[7] + "\n" +
                        words[8] + "\n" +
                        words[9] + "\n" +
                        words[10] + "\n" +
                        words[11] + "\n" +
                        words[12] + "\n" +
                        words[13] + "\n" +
                        words[14] + "\n" +
                        words[15] + "\n" +
                        words[16] + "\n" +
                        words[17] + "\n" +
                        words[18] + "\n" +
                        words[19] + "\n" +
                        words[20] + "\n" +
                        words[21] + "\n" +
                        words[22] + "\n" +
                        words[23] + "\n" +
                        words[24] + "\n" +
                        words[25] + "\n" +
                        words[26] + "\n" +
                        words[27] + "\n" +
                        words[28] + "\n" +
                        words[29] + "\n" +
                        words[30] + "\n" +
                        words[31] + "\n" +
                        words[32] + "\n"


        );
        translateArea.setFont(new Font(16));

        for (int i = 0; i < wordlist.size(); i++) {
            words[i] = null;
        }


    }
}
