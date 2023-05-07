package sample.offlinedictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    Dict dict=new Dict();
    private final String[] language = {"ENGLISH --> GERMAN", "GERMAN --> ENGLISH","ENGLISH --> TURKISH","TURKISH --> ENGLISH",
    "ENGLISH --> ITALIAN", "ITALIAN --> ENGLISH", "ENGLISH --> FRENCH","FRENCH --> ENGLISH","ENGLISH --> SWEDISH","SWEDISH --> ENGLISH",
    "ENGLISH --> GREEK","GREEK --> ENGLISH"};

    @FXML
    private ChoiceBox<String> addSecChoiceBox = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> delSecChoiceBox = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> editSecChoiceBox = new ChoiceBox<>();

    public String addChoice;
    public String deleteChoice;
    public String editChoice;

    public Button editSecEditButton;


    @FXML
    private Label helpMenu;
    @FXML
    private Label devsMenu;
    @FXML
    private TextArea translateArea;
    @FXML
    private TextField searchText;
    @FXML
    private TextField addSecTextField;
    @FXML
    private TextField delSecTextField;
    @FXML
    private TextField editSecTextField;
    @FXML
    private TextField editSecTextField2;
    @FXML
    private TextArea editSecTextArea;


    public String getLanguage() {
        addChoice = addSecChoiceBox.getValue();
        this.addChoice = addChoice;
        return addChoice;
    }

    public String getDeleteLanguage() {
        deleteChoice = delSecChoiceBox.getValue();
        this.deleteChoice = deleteChoice;
        return deleteChoice;
    }

    public String getEditLanguage() {
        editChoice = editSecChoiceBox.getValue();
        this.editChoice = editChoice;
        return editChoice;
    }

    @FXML
    public void closeApp(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void showHelpMenu(ActionEvent actionEvent) {
        if (helpMenu.getText().equals("")) {
            helpMenu.setText("1-Enter the text!\n" +
                    "2-Click translate button!\n" +
                    "3-Wait for the results...\n" +
                    "4-Go to settings section\n" +
                    "to add,delete and edit words!\n" +
                    "5-Each settings section has \n" +
                    "detailed info section");
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
        primaryStage.setResizable(false);
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
    public void editSection(ActionEvent actionEvent) throws IOException {
        Parent editRoot = FXMLLoader.load(getClass().getResource("editSection.fxml"));
        Scene editScene = new Scene(editRoot);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Settings");
        primaryStage.setResizable(false);
        primaryStage.setScene(editScene);

        primaryStage.show();
    }

    @FXML
    public void editToMain(ActionEvent actionEvent){
        Node backToMainNode = (Node) actionEvent.getSource();
        Stage editStage = (Stage) backToMainNode.getScene().getWindow();
        editStage.close();
    }
    @FXML
    public void addButton(ActionEvent actionEvent) throws IOException {
        Parent addRoot = FXMLLoader.load(getClass().getResource("edit-addSection.fxml"));
        Scene addScene = new Scene(addRoot);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Add");
        primaryStage.setResizable(false);
        primaryStage.setScene(addScene);

        editToMain(actionEvent);
        primaryStage.show();

    }

    @FXML
    public void addInfo() throws IOException {
        Parent addInfo = FXMLLoader.load(getClass().getResource("add-Info.fxml"));
        Scene addScene = new Scene(addInfo);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Add Info");
        primaryStage.setResizable(false);
        primaryStage.setScene(addScene);
        primaryStage.show();
    }

    @FXML
    public void InfoClose(ActionEvent actionEvent) throws IOException {
        Node backToMainNode = (Node) actionEvent.getSource();
        Stage infoStage = (Stage) backToMainNode.getScene().getWindow();
        infoStage.close();
    }

    @FXML
    public void successErrorClose(ActionEvent actionEvent) throws  IOException{

        Node closePopUp = (Node) actionEvent.getSource();
        Stage popUp = (Stage) closePopUp.getScene().getWindow();
        popUp.close();

    }

    @FXML
    public void deleteInfo() throws IOException {
        Parent deleteInfo = FXMLLoader.load(getClass().getResource("delete-Info.fxml"));
        Scene deleteScene = new Scene(deleteInfo);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Delete Info");
        primaryStage.setResizable(false);
        primaryStage.setScene(deleteScene);
        primaryStage.show();

    }

    @FXML
    public void editInfo() throws IOException {
        Parent editInfo = FXMLLoader.load(getClass().getResource("edit-Info.fxml"));
        Scene editScene = new Scene(editInfo);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Edit Info");
        primaryStage.setResizable(false);
        primaryStage.setScene(editScene);
        primaryStage.show();

    }

    @FXML
    public void addClose(ActionEvent actionEvent) throws IOException {
        Node backToMainNode = (Node) actionEvent.getSource();
        Stage addStage = (Stage) backToMainNode.getScene().getWindow();
        addStage.close();
        editSection(actionEvent);
    }
    @FXML
    public void deleteButton(ActionEvent actionEvent) throws IOException {
        Parent deleteRoot = FXMLLoader.load(getClass().getResource("edit-deleteSection.fxml"));
        Scene deleteScene = new Scene(deleteRoot);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Delete");
        primaryStage.setResizable(false);
        primaryStage.setScene(deleteScene);

        primaryStage.show();
        editToMain(actionEvent);
    }

    @FXML
    public void deleteClose(ActionEvent actionEvent) throws IOException {
        Node backToMainNode = (Node) actionEvent.getSource();
        Stage deleteStage = (Stage) backToMainNode.getScene().getWindow();
        deleteStage.close();
        editSection(actionEvent);
    }
    @FXML
    public void editButton(ActionEvent actionEvent) throws IOException {
        Parent editRoot = FXMLLoader.load(getClass().getResource("edit-editSection.fxml"));
        Scene editScene = new Scene(editRoot);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Edit");
        primaryStage.setResizable(false);
        primaryStage.setScene(editScene);

        primaryStage.show();
        editToMain(actionEvent);
    }

    @FXML
    public void editClose(ActionEvent actionEvent) throws IOException {
        Node backToMainNode = (Node) actionEvent.getSource();
        Stage editStage = (Stage) backToMainNode.getScene().getWindow();
        editStage.close();
        editSection(actionEvent);

    }

    @FXML
    public void addSuccess() throws IOException {
        Parent addRoot = FXMLLoader.load(getClass().getResource("addSuccess.fxml"));
        Scene addScene = new Scene(addRoot);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Warning!");
        primaryStage.setResizable(false);
        primaryStage.setScene(addScene);
        primaryStage.show();
    }
    @FXML
    public void addError() throws IOException{
        Parent addRoot = FXMLLoader.load(getClass().getResource("addError.fxml"));
        Scene addScene = new Scene(addRoot);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Warning!");
        primaryStage.setResizable(false);
        primaryStage.setScene(addScene);
        primaryStage.show();
    }



    @FXML
    public void addNewWord(ActionEvent actionEvent) throws Exception {
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

        String word = addSecTextField.getText();
        String language = getLanguage();



        switch (language) {
            case "ENGLISH --> GERMAN":
                if (word.contains(">")){
                    dict.engDeuAddWord(word);
                    addSuccess();
                }
                else {
                    addError();
                    break;
                }
                break;
            case "GERMAN --> ENGLISH":
                if (word.contains(">")){
                    dict.deuEngAddWord(word);
                    addSuccess();

                }
                else{
                    addError();
                    break;
                }
                break;
            case "ENGLISH --> TURKISH":
                if (word.contains(">")){
                    dict.engTurAddWord(word);
                    addSuccess();
                }
                else{
                    addError();
                    break;
                }
                break;
            case "TURKISH --> ENGLISH":
                if (word.contains(">")){
                    dict.turEngAddWord(word);
                    addSuccess();
                }
                else{
                    addError();
                    break;
                }
                break;
            case "ENGLISH --> ITALIAN":
                if (word.contains(">")){
                    dict.engItaAddWord(word);
                    addSuccess();
                }
                else{
                    addError();
                    break;
                }
                break;
            case "ITALIAN --> ENGLISH":
                if (word.contains(">")){
                    dict.itaEngAddWord(word);
                    addSuccess();
                }
                else{
                    addError();
                    break;
                }
                break;
            case "ENGLISH --> FRENCH":
                if (word.contains(">")){
                    dict.engFreAddWord(word);
                    addSuccess();
                }
                else{
                    addError();
                    break;
                }
                break;
            case "FRENCH --> ENGLISH":
                if (word.contains(">")){
                    dict.freEngAddWord(word);
                    addSuccess();
                }
                else{
                    addError();
                    break;
                }
                break;
            case "ENGLISH --> SWEDISH":
                if (word.contains(">")){
                    dict.engSweAddWord(word);
                    addSuccess();
                }
                else{
                    addError();
                    break;
                }
                break;
            case "SWEDISH --> ENGLISH":
                if (word.contains(">")){
                    dict.sweEngAddWord(word);
                    addSuccess();
                }
                else{
                    addError();
                    break;
                }
                break;
            case "ENGLISH --> GREEK":
                if (word.contains(">")){
                    dict.engGreAddWord(word);
                    addSuccess();
                }
                else{
                    addError();
                    break;
                }
                break;
            case "GREEK --> ENGLISH":
                if (word.contains(">")){
                    dict.greEngAddWord(word);
                    addSuccess();
                }
                else{
                    addError();
                    break;
                }                break;
            default:
                break;
        }

    }


    @FXML
    public void deleteWord(ActionEvent actionEvent) throws Exception {
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

        String word = delSecTextField.getText();
        String language = getDeleteLanguage();

        switch (language) {
            case "ENGLISH --> GERMAN":
                if (word.contains(">") || word=="" || dict.engDeuFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                dict.engDeuDeleteWord(word);
                deleteSuccess();
                }

                break;
            case "GERMAN --> ENGLISH":

                if (word.contains(">") || word=="" || dict.deuEngFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                    dict.deuEngDeleteWord(word);
                    deleteSuccess();
                }
                break;
            case "ENGLISH --> TURKISH":

                if (word.contains(">") || word=="" || dict.engTurFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                    dict.engTurDeleteWord(word);
                    deleteSuccess();
                }
                break;
            case "TURKISH --> ENGLISH":

                if (word.contains(">") || word=="" || dict.turEngFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                    dict.turEngDeleteWord(word);
                    deleteSuccess();
                }                break;
            case "ENGLISH --> ITALIAN":

                if (word.contains(">") || word=="" || dict.engItaFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                    dict.engItaDeleteWord(word);
                    deleteSuccess();
                }
                break;
            case "ITALIAN --> ENGLISH":

                if (word.contains(">") || word=="" || dict.itaEngFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                    dict.itaEngDeleteWord(word);
                    deleteSuccess();
                }
                break;
            case "ENGLISH --> FRENCH":
                if (word.contains(">") || word=="" || dict.engFreFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                    dict.engFreDeleteWord(word);
                    deleteSuccess();
                }
                break;
            case "FRENCH --> ENGLISH":
                if (word.contains(">") || word=="" || dict.freEngFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                    dict.freEngDeleteWord(word);
                    deleteSuccess();
                }
                break;
            case "ENGLISH --> SWEDISH":
                if (word.contains(">") || word=="" || dict.engSweFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                    dict.engSweDeleteWord(word);
                    deleteSuccess();
                }
                break;
            case "SWEDISH --> ENGLISH":
                if (word.contains(">") || word=="" || dict.sweEngFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                    dict.sweEngDeleteWord(word);
                    deleteSuccess();
                }
                break;
            case "ENGLISH --> GREEK":
                if (word.contains(">") || word=="" || dict.engGreFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                    dict.engGreDeleteWord(word);
                    deleteSuccess();
                }                break;
            case "GREEK --> ENGLISH":
                if (word.contains(">") || word=="" || dict.greEngFindWord(word)==null)
                {
                    deleteError();
                }
                else
                {
                    dict.greEngDeleteWord(word);
                    deleteSuccess();
                }
                break;
            default:

                break;
        }

    }
    @FXML
    public void deleteSuccess() throws IOException {

        Parent deleteRoot = FXMLLoader.load(getClass().getResource("deleteSuccess.fxml"));
        Scene deleteScene = new Scene(deleteRoot);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Warning!");
        primaryStage.setResizable(false);
        primaryStage.setScene(deleteScene);
        primaryStage.show();

    }
    @FXML
    public void deleteError()throws IOException{

        Parent addRoot = FXMLLoader.load(getClass().getResource("deleteError.fxml"));
        Scene addScene = new Scene(addRoot);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Warning!");
        primaryStage.setResizable(false);
        primaryStage.setScene(addScene);
        primaryStage.show();

    }

    @FXML
    public void editWord(ActionEvent event) throws Exception {
        String word=editSecTextField2.getText();
        String deleteWord= editSecTextField.getText();

        String language = getEditLanguage();

        switch (language) {
            case "ENGLISH --> GERMAN":
                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
            }
                else {
                dict.engDeuDeleteWord(deleteWord);
                dict.engDeuAddWord(word);
                editSuccess();
            }
                break;
            case "GERMAN --> ENGLISH":

                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
                }
                else {
                    dict.deuEngDeleteWord(deleteWord);
                    dict.deuEngAddWord(word);
                    editSuccess();
                }
                break;
            case "ENGLISH --> TURKISH":
                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
                }
                else {
                    dict.engTurDeleteWord(deleteWord);
                    dict.engTurAddWord(word);
                    editSuccess();
                }
                break;
            case "TURKISH --> ENGLISH":
                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
                }
                else {
                    dict.turEngDeleteWord(deleteWord);
                    dict.turEngAddWord(word);
                    editSuccess();
                }
                break;
            case "ENGLISH --> ITALIAN":
                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
                }
                else {
                    dict.engItaDeleteWord(deleteWord);
                    dict.engItaAddWord(word);
                    editSuccess();
                }
                break;
            case "ITALIAN --> ENGLISH":
                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
                }
                else {
                    dict.itaEngDeleteWord(deleteWord);
                    dict.itaEngAddWord(word);
                    editSuccess();
                }
                break;
            case "ENGLISH --> FRENCH":
                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
                }
                else {
                    dict.engFreDeleteWord(deleteWord);
                    dict.engFreAddWord(word);
                    editSuccess();
                }
                break;
            case "FRENCH --> ENGLISH":
                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
                }
                else {
                    dict.freEngDeleteWord(deleteWord);
                    dict.freEngAddWord(word);
                    editSuccess();
                }
                break;
            case "ENGLISH --> SWEDISH":
                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
                }
                else {
                    dict.engSweDeleteWord(deleteWord);
                    dict.engSweAddWord(word);
                    editSuccess();
                }
                break;
            case "SWEDISH --> ENGLISH":
                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
                }
                else {
                    dict.sweEngDeleteWord(deleteWord);
                    dict.sweEngAddWord(word);
                    editSuccess();
                }
                break;
            case "ENGLISH --> GREEK":
                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
                }
                else {
                    dict.engGreDeleteWord(deleteWord);
                    dict.engGreAddWord(word);
                    editSuccess();
                }
                break;
            case "GREEK --> ENGLISH":
                if (word==null || !word.contains(">") || word.length() <= 2){
                    editError();
                }
                else {
                    dict.greEngDeleteWord(deleteWord);
                    dict.greEngAddWord(word);
                    editSuccess();
                }
                break;
            default:

                break;

        }
    }

    @FXML
    public void editError() throws IOException {
        Parent editRoot = FXMLLoader.load(getClass().getResource("editError.fxml"));
        Scene editScene = new Scene(editRoot);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Warning!");
        primaryStage.setResizable(false);
        primaryStage.setScene(editScene);
        primaryStage.show();

    }
    @FXML
    public void editSuccess()throws IOException{
        Parent editRoot = FXMLLoader.load(getClass().getResource("editSuccess.fxml"));
        Scene editScene = new Scene(editRoot);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Warning!");
        primaryStage.setResizable(false);
        primaryStage.setScene(editScene);
        primaryStage.show();

    }

    @FXML
    private void editTranslate(ActionEvent event) throws  Exception {
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

        String enteredword = editSecTextField.getText();

        String language = getEditLanguage();



        switch (language) {
            case "ENGLISH --> GERMAN":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.engDeuFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else{
                    editSecTextArea.setText(enteredword+">" + dict.engDeuFindWord(enteredword));
                }
                break;

            case "GERMAN --> ENGLISH":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.deuEngFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else {
                    editSecTextArea.setText(enteredword + ">" + dict.deuEngFindWord(enteredword));
                }
                break;

            case "ENGLISH --> TURKISH":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.engTurFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else{
                    editSecTextArea.setText(enteredword + ">" + dict.engTurFindWord(enteredword));
                }
                break;

            case "TURKISH --> ENGLISH":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.turEngFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else{
                    editSecTextArea.setText(enteredword + ">" + dict.turEngFindWord(enteredword));
                }
                break;

            case "ENGLISH --> ITALIAN":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.engItaFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else{
                    editSecTextArea.setText(enteredword + ">" + dict.engItaFindWord(enteredword));
                }
                break;

            case "ITALIAN --> ENGLISH":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.itaEngFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else {
                    editSecTextArea.setText(enteredword + ">" + dict.itaEngFindWord(enteredword));
                }
                break;

            case "ENGLISH --> FRENCH":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.engFreFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else{
                    editSecTextArea.setText(enteredword + ">" + dict.engFreFindWord(enteredword));
                }
                break;

            case "FRENCH --> ENGLISH":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.freEngFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else{
                    editSecTextArea.setText(enteredword + ">" + dict.freEngFindWord(enteredword));
                }
                break;

            case "ENGLISH --> SWEDISH":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.engSweFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else{
                    editSecTextArea.setText(enteredword + ">" + dict.engSweFindWord(enteredword));
                }
                break;

            case "SWEDISH --> ENGLISH":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.sweEngFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else{
                    editSecTextArea.setText(enteredword + ">" + dict.sweEngFindWord(enteredword));
                }
                break;

            case "ENGLISH --> GREEK":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.engGreFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else{
                    editSecTextArea.setText(enteredword + ">" + dict.engGreFindWord(enteredword));
                }
                break;

            case "GREEK --> ENGLISH":
                if (enteredword==""){
                    editSecTextArea.setText("ENTER A WORD!");
                }else if (dict.greEngFindWord(enteredword)==null) {
                    editSecTextArea.setText("WORD NOT FOUND!");
                }else{
                    editSecTextArea.setText(enteredword + ">" + dict.greEngFindWord(enteredword));
                }
                break;

            default:

                break;
        }
    }

    @FXML
    private void translate(ActionEvent event) throws Exception {
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
                words[i] = " ";
            }
        }

        if (words[0]==" "){
            words[0]="WORD NOT FOUND!\n"+"YOU CAN ADD WORDS IN SETTINGS SECTION.";
        }


        translateArea.setText(
                        words[0]  + "\n" +
                        words[1]  + "\n" +
                        words[2]  + "\n" +
                        words[3]  + "\n" +
                        words[4]  + "\n" +
                        words[5]  + "\n" +
                        words[6]  + "\n" +
                        words[7]  + "\n" +
                        words[8]  + "\n" +
                        words[9]  + "\n" +
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
                        words[32] + "\n"+
                                words[33] + "\n" +
                                words[34] + "\n" +
                                words[35] + "\n" +
                                words[36] + "\n" +
                                words[37] + "\n" +
                                words[38] + "\n" +
                                words[40] + "\n" +
                                words[41] + "\n"


        );
        translateArea.setFont(new Font(16));

        for (int i = 0; i < wordlist.size(); i++) {
            words[i] = null;
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addSecChoiceBox.getItems().addAll(language);
        addSecChoiceBox.setValue("ENGLISH --> GERMAN");

        delSecChoiceBox.getItems().addAll(language);
        delSecChoiceBox.setValue("ENGLISH --> GERMAN");

        editSecChoiceBox.getItems().addAll(language);
        editSecChoiceBox.setValue("ENGLISH --> GERMAN");
    }
}
