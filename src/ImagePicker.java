import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;

public class ImagePicker extends Application {
    // Use fields so values can be updated or used AFTER start() is done
    Image image1;
    Image image2;
    Image image3;
    Image image4;
    Image image5;
    ArrayList<Image> images;

    @Override
    public void start(Stage primaryStage) throws Exception {
        images = new ArrayList<Image>();
        // Load program's data
        FileInputStream input1 = new FileInputStream("src/Condorito.jpg");
        image1 = new Image(input1);
        images.add(image1);
        FileInputStream input2 = new FileInputStream("src/Cone.jpg");
        image2 = new Image(input2);
        images.add(image2);
        FileInputStream input3 = new FileInputStream("src/Huevoduro.jpg");
        image3 = new Image(input3);
        images.add(image3);

        // Construct and customize all of the Controls
        ImageView imageView1 = new ImageView();
        imageView1.setFitHeight(400);
        imageView1.setFitWidth(200);

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().add("Condorito 1");
        choiceBox.getItems().add("Cone 2");
        choiceBox.getItems().add("Huevoduro 3");

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().add("Condorito 1");
        comboBox.getItems().add("Cone 2");
        comboBox.getItems().add("Huevoduro 3");

        // Write setOnAction methods that are run when Controls are used
        choiceBox.setOnAction((event) -> {
            int selectedChoice = choiceBox.getSelectionModel().getSelectedIndex();
            imageView1.setImage(images.get(selectedChoice));
            comboBox.getSelectionModel().select(selectedChoice);
        });

        // Construct layouts to organize the Controls in the window
        HBox hbox1 = new HBox(choiceBox, comboBox);
        VBox vbox1 = new VBox(imageView1, hbox1);
        Scene myScene1 = new Scene(vbox1,400,450);

        // setup scene on the stage and show it
        primaryStage.setTitle("Image Picker");
        primaryStage.setScene(myScene1);
        primaryStage.show();
    }

}

