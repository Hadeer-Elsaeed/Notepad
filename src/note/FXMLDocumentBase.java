package note;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
//import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLDocumentBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem newmenu;
    protected final MenuItem openl;
    protected final MenuItem openh;
    protected final MenuItem savel;
    protected final MenuItem saveh;
    protected final MenuItem exit;
    protected final Menu menu0;
    protected final MenuItem cut;
    protected final MenuItem copy;
    protected final MenuItem paste;
    protected final MenuItem select;
    protected final MenuItem delete;
    protected final Menu menu1;
    protected final MenuItem about;
    protected final TextArea textArea;

    public FXMLDocumentBase(Stage stage) {

        menuBar = new MenuBar();
        menu = new Menu();
        newmenu = new MenuItem();
        openl = new MenuItem();
        openh = new MenuItem();
        savel = new MenuItem();
        saveh = new MenuItem();
        exit = new MenuItem();
        menu0 = new Menu();
        cut = new MenuItem();
        copy = new MenuItem();
        paste = new MenuItem();
        select = new MenuItem();
        delete = new MenuItem();
        menu1 = new Menu();
        about = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        menu.setMnemonicParsing(false);
        menu.setText("File");

        newmenu.setMnemonicParsing(false);
        newmenu.setText("New");
        newmenu.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.ALT_DOWN));

        openl.setMnemonicParsing(false);
        openl.setText("Open-l");

        openh.setMnemonicParsing(false);
        openh.setText("Open-h");

        savel.setMnemonicParsing(false);
        savel.setText("Save-l");

        saveh.setMnemonicParsing(false);
        saveh.setText("Save-h");

        exit.setMnemonicParsing(false);
        exit.setText("Exit");
        exit.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_ANY));

        menu0.setMnemonicParsing(false);
        menu0.setText("Edit");

        cut.setMnemonicParsing(false);
        cut.setText("Cut");

        copy.setMnemonicParsing(false);
        copy.setText("Copy");

        paste.setMnemonicParsing(false);
        paste.setText("Paste");

        select.setMnemonicParsing(false);
        select.setText("Select All");

        delete.setMnemonicParsing(false);
        delete.setText("Delete");

        menu1.setMnemonicParsing(false);
        menu1.setText("Help");

        about.setMnemonicParsing(false);
        about.setText("About");
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        menu.getItems().add(newmenu);
        menu.getItems().add(openl);
        menu.getItems().add(openh);
        menu.getItems().add(savel);
        menu.getItems().add(saveh);
        menu.getItems().add(exit);
        menuBar.getMenus().add(menu);
        menu0.getItems().add(cut);
        menu0.getItems().add(copy);
        menu0.getItems().add(paste);
        menu0.getItems().add(select);
        menu0.getItems().add(delete);
        menuBar.getMenus().add(menu0);
        menu1.getItems().add(about);
        menuBar.getMenus().add(menu1);
        
//        
//        openl.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event){
//                FileInputStream fis = null;
//                try {
//                    FileChooser fileChooser = new FileChooser();
//                    fileChooser.setTitle("Open");
//                    fileChooser.getExtensionFilters().addAll(
//                            new FileChooser.ExtensionFilter("Text Files", "*.txt"));
//                    File selectedFile = fileChooser.showOpenDialog(stage);
//                    String path = selectedFile.getPath();
//                    fis = new FileInputStream(path);
//                    int size = fis.available();
//                    byte[] b = new byte[size];
//                    fis.read(b);
//                    textArea.setText(new String(b));
//                   
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
//                } finally {
//                    try {
//                        fis.close();
//                    } catch (IOException ex) {
//                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//            }
//        });
//        
        
              
        
          openh.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                FileInputStream fis = null;
                try {
                   
                    FileChooser fileChooser = new FileChooser();
                    File selectedFile = fileChooser.showOpenDialog(stage);
                    fis = new FileInputStream(selectedFile);
                    DataInputStream d = new DataInputStream(fis);
                    String path = d.readUTF();
                    textArea.setText(path);
              
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                   
                

            }
        });
        
            savel.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                FileOutputStream fis = null;
                try {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Open");
                    fileChooser.getExtensionFilters().addAll(
                            new FileChooser.ExtensionFilter("Text Files", "*.txt"));
                    File selectedFile = fileChooser.showSaveDialog(stage);
                    String path = selectedFile.getPath();
                    System.out.println(path);
                    fis = new FileOutputStream(path);
                   
                    byte[] b = textArea.getText().getBytes();
                    fis.write(b);
                    textArea.setText(new String(b));
                    fis.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        
         newmenu.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event){
                 textArea.setText(" ");
             }
             
         });
         
          exit.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event){
                 stage.close();
             }
             
         });
          
        copy.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event){
                 textArea.copy();
             }
             
         });
         
        cut.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event){
                 textArea.cut();
             }
             
         });
        
        paste.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event){
                 textArea.paste();
             }
             
         });
        
        select.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event){
                 textArea.selectAll();
             }

         });
        
         delete.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event){
                 textArea.deletePreviousChar();
             }

         });
         
          about.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event){
                 JOptionPane.showMessageDialog(null, "There is notepad to allow you to text in it and save files");
             }

         });
    }
}
