package torne.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;


/**
 * This is a GUI class - so it needs to extend `Application`
 */
public class Main extends Application {

    // note that if you need to have a constructor with arguments, create an **overloaded** constructor with no args
    // that calls the original constructor. (Check tutorial pt 1)

    public Main() {
        Font.loadFont(getClass().getResourceAsStream("/fonts/CaskaydiaCoveNerdFont-SemiBold.ttf"), 18);
        Font.loadFont(getClass().getResourceAsStream("/fonts/CaskaydiaCoveNerdFont-Regular.ttf"), 18);
        Font.loadFont(getClass().getResourceAsStream("/fonts/Inter-Medium.ttf"), 18);
        Font.loadFont(getClass().getResourceAsStream("/fonts/Montserrat-SemiBold.ttf"), 18);
    }

    private final Torne torne = new Torne(); // Init Torne

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);

            stage.setTitle("Torne");
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setTorne(torne);  // inject the Torne instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}