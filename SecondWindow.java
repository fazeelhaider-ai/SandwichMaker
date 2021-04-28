package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class SecondWindow implements Initializable {
    public Controller firstControl;


    @FXML
    private Button clearbutton;
    @FXML
    private Button closeButon;
    @FXML
    private ListView<Object> listingOrdersSecond ;
    private ArrayList<Object> export = new ArrayList<>();


    public void populateOrders(Object order) {
        ObservableList<Object> incomingOrder = FXCollections.observableArrayList(order);
        export.add(order);
        for (int i = 0; i < incomingOrder.size() ; i++) {
            listingOrdersSecond.getItems().addAll(order);
        }
    }

    @FXML
    void clearOrder(ActionEvent event) {
        try{
            ObservableList<Object> theseobjs = FXCollections.observableArrayList(listingOrdersSecond.getItems());
            for (int i = 0; i < theseobjs.size() ; i++) {
                firstControl.removethisobj(theseobjs.get(i));
                listingOrdersSecond.getItems().removeAll(theseobjs.get(i));
            }
        } catch (NullPointerException e){
            System.out.println("error removing");
        }


    }

    @FXML
    void closewindow(ActionEvent event) {
            Stage stage = (Stage) closeButon.getScene().getWindow();
            stage.close();
    }
    @FXML
    void duplicateOrder(ActionEvent event) {
//        ObservableList<Object> duplicate = FXCollections.observableArrayList(listingOrdersSecond.getSelectionModel().getSelectedItem());
        Object duplicate = listingOrdersSecond.getSelectionModel().getSelectedItem();
//        System.out.println("this is the selected item : " + duplicate);
//        System.out.println("this is the type : " + duplicate.getClass().getName());
//            duplicate.clone();
//        firstControl.clonethisobj(duplicate);
//        OrderLine oop = new OrderLine();
//        Object put = oop.getSandwich();
//        System.out.println("this is sandiwch : " + put);
        firstControl.addthisobj(duplicate);
        ObservableList<Object> newDisplay = FXCollections.observableArrayList(firstControl.od.getallOrders());
//        Object newDisplay = firstControl.od.getallOrders();
        for (int i = 0; i < newDisplay.size() ; i++) {
            listingOrdersSecond.getItems().add(duplicate);
        }

    }

    @FXML
    void removeOrderLine(ActionEvent event) {
        ObservableList<Object> theseobjs = FXCollections.observableArrayList(listingOrdersSecond.getSelectionModel().getSelectedItem());
        for (int i = 0; i < theseobjs.size() ; i++) {
            export.remove(theseobjs.get(i));
            firstControl.removethisobj(theseobjs.get(i));
            listingOrdersSecond.getItems().removeAll(theseobjs.get(i));
        }
    }
    @FXML
    void exportOrder(ActionEvent event) {

        try {

            System.out.println(listingOrdersSecond.getItems());
            listingOrdersSecond.getItems();

//            String[] result = ad.toExport();
            if (export.size() == 0) {
                throw new Exception();
            } else {
                FileChooser chooser = new FileChooser();
                chooser.setTitle("Open Target File for the Export");
                chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                Stage stage = new Stage();
                File targetFile = chooser.showSaveDialog(stage); //get the reference of the target file
                //write code to write to the file.
                BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));

                for (int i = 0; i < export.size(); i++) {
                    bw.write(export.get(i) + "\n");
                }
                bw.close();
            }
        } catch(Exception e){
            System.out.println("Export Failed, Database is Empty \n");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        firstControl = fxmlLoader.getController();
    }
}
