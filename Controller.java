package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    public ImageView imageDisplay = new ImageView();
    Image chickenimage = new Image("file:src/chicken.png");
    Image fishimage = new Image("file:src/fish.png");
    Image beefimage = new Image ("file:src/beef.png");

    private Stage stage1;
    private SecondWindow value;


    @FXML
    private Button displayOrders;
    @FXML
    private TextArea textarea_OC;


    @FXML
    private TextArea displayprice;

    @FXML
    private TextArea textarea_firstwindow;


    @FXML
    private ComboBox<String> combodrop;
    ObservableList<String> SandwichSelection = FXCollections.observableArrayList("Chicken", "Fish", "Beef");

    @FXML
    private ListView<Extra> listIngredients;
    ObservableList<Extra> putextra = FXCollections.observableArrayList(Extra.values());

    @FXML
    private ListView<Extra> addedIngredients;

    @FXML
    private TextField totalprice;

    @FXML
    private ListView<String> includedIngredients;
    ObservableList<String> chickenIngredients = FXCollections.observableArrayList("Fried Chicken", "Spicy Sauce", "Pickles");
    ObservableList<String> beefIngredients = FXCollections.observableArrayList("Roast Beef", "Provolone Cheese", "Mustard");
    ObservableList<String> fishIngredients = FXCollections.observableArrayList("Grilled Snapper", "Cilantro", "Lime");


    Order od = new Order();
    Sandwich chicken = new Chicken();
    Sandwich fish = new Fish();
    Sandwich beef = new Beef();


    @FXML
     void orderdisplaybutton(ActionEvent event) {
        try {
            stage1.show();
        } catch (Exception e) {
            System.out.println("error loading the new window");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        combodrop.setItems(SandwichSelection);
        combodrop.getSelectionModel().selectFirst();
        includedIngredients.setItems(chickenIngredients);
        includedIngredients.setDisable(true);
        listIngredients.setItems(putextra);
        imageDisplay.setImage(chickenimage);


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("second_window.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage1 = new Stage();
            stage1.setTitle("You're in the second window");
            stage1.setScene(new Scene(root1));
            value = fxmlLoader.getController();
            value.firstControl = this;


        } catch (Exception e) {
            System.out.println("error loading the new window");
        }

    }
    public void removethisobj(Object obj){
        od.remove(obj);
    }
    public void addthisobj(Object obj){
        od.add(obj);
    }


    @FXML
    void changeSandwiich(ActionEvent event) {
        if (combodrop.getSelectionModel().getSelectedItem().equals("Chicken")) {
            imageDisplay.setImage(chickenimage);
            includedIngredients.setItems(chickenIngredients);
            includedIngredients.setDisable(true);
        }
        if (combodrop.getSelectionModel().getSelectedItem().equals("Beef")) {
            imageDisplay.setImage(beefimage);
            includedIngredients.setItems(beefIngredients);
        }
        if (combodrop.getSelectionModel().getSelectedItem().equals("Fish")) {
            imageDisplay.setImage(fishimage);
            includedIngredients.setItems(fishIngredients);
        }
    }

    public Object getOrders() {
        return od.getallOrders();
    }






    @FXML
    void addtheorder(ActionEvent event) {
        if (combodrop.getSelectionModel().getSelectedItem().equals("Chicken")) {
//            Sandwich chicken = new Chicken();
            chicken.extras = new ArrayList<>();
            ObservableList<Extra> put = FXCollections.observableArrayList(addedIngredients.getItems());
            ObservableList<Object> test = FXCollections.observableArrayList(put);
            for (int i = 0; i < test.size(); i++) {
                if(chicken.add(test.get(i))){
                    System.out.println("extra added successfully");

                }
                else {
                    System.out.println("error : more than 6 ingredients");
                }
            }
            OrderLine ol = new OrderLine(chicken);
            od.add(ol);


            ObservableList<Object> label = FXCollections.observableArrayList(ol);
            for (int i = 0; i < label.size() ; i++) {
                value.populateOrders(label.get(i));
            }
            textarea_firstwindow.appendText(chicken.toString() + "\n");

        }
        if (combodrop.getSelectionModel().getSelectedItem().equals("Beef")) {
//            Sandwich beef = new Beef();
            beef.extras = new ArrayList<>();
            ObservableList<Extra> put = FXCollections.observableArrayList(addedIngredients.getItems());
            ObservableList<Object> test = FXCollections.observableArrayList(put);
            for (int i = 0; i < test.size(); i++) {
                if(beef.add(test.get(i))){
                    System.out.println("extra added successfully");

                }
                else {
                    System.out.println("error : more than 6 ingredients");
                }
            }
            OrderLine ol = new OrderLine(beef);
            od.add(ol);
            ObservableList<Object> label = FXCollections.observableArrayList(ol);
            for (int i = 0; i < label.size() ; i++) {
                value.populateOrders(label.get(i));
            }
            textarea_firstwindow.appendText(beef.toString() + "\n");

        }
        if (combodrop.getSelectionModel().getSelectedItem().equals("Fish")) {
//            Sandwich fish = new Fish();
            fish.extras = new ArrayList<>();
            ObservableList<Extra> put = FXCollections.observableArrayList(addedIngredients.getItems());
            ObservableList<Object> test = FXCollections.observableArrayList(put);
            for (int i = 0; i < test.size(); i++) {
                if(fish.add(test.get(i))){
                    System.out.println("extra added successfully");
                }
                else {
                    System.out.println("error : more than 6 ingredients");
                }
            }
            OrderLine ol = new OrderLine(fish);
            od.add(ol);

            ObservableList<Object> label = FXCollections.observableArrayList(ol);
            for (int i = 0; i < label.size() ; i++) {
                value.populateOrders(label.get(i));
            }
            textarea_firstwindow.appendText(fish.toString() + "\n");

        }

        ObservableList<Extra> put = addedIngredients.getItems();
        //adds all the ingredients back to the list ingredients after each ordered entered
        listIngredients.getItems().addAll(put);

        put.clear();
        displayprice.setText(String.valueOf(od.getAllPrices()));

    }



    @FXML
    void addingExtraIngredient(ActionEvent event) {

            try {
                if (!listIngredients.getSelectionModel().getSelectedItem().equals(null)) {
                    ObservableList<Extra> put = FXCollections.observableArrayList(listIngredients.getSelectionModel().getSelectedItem());
                    final int selectedIdx = listIngredients.getSelectionModel().getSelectedIndex();
                                addedIngredients.getItems().addAll(put);
                                listIngredients.getItems().remove(selectedIdx);

                }

            } catch (NullPointerException e) {
                textarea_firstwindow.appendText("no ingredient was added \n");
            }

    }


    @FXML
    void removingExtraIngredient(ActionEvent event) {
        if (combodrop.getSelectionModel().getSelectedItem() == "Chicken"){
            System.out.println("yes chicken is selected");
            ObservableList<Extra> put = FXCollections.observableArrayList(addedIngredients.getSelectionModel().getSelectedItem());
            ObservableList<Object> test = FXCollections.observableArrayList(put);
            chicken.remove(test.get(0));
            if (chicken.remove(test.get(0))) {
                System.out.println("there is no ingredient to remove");
            } else {
                addedIngredients.getItems().remove(addedIngredients.getSelectionModel().getSelectedItem());
            }
        }


    }

    //this is Clear Selected button
    @FXML
    void backToDefault(ActionEvent event) {
        combodrop.getSelectionModel().selectFirst();
        //might have to remove added extra items too in case when first time it was
        //chicken selected and we do clear selected and then if we add an ingredient
        //it might get added to the ingredient we added first time doing a chicken sandwich.
        ObservableList<Extra> put = addedIngredients.getItems();
        //adds all the ingredients back to the list ingredients after each ordered entered
        listIngredients.getItems().addAll(put);

        put.clear();
    }


}
