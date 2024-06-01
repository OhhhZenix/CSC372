import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

  private TextArea printLogTextArea;

  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane pane = new BorderPane();

    printLogTextArea = new TextArea();
    printLogTextArea.setEditable(false);
    pane.setCenter(printLogTextArea);

    MenuBar menuBar = new MenuBar();
    pane.setTop(menuBar);

    MenuItem printDateTimeMenuItem = new MenuItem("Print Date and Time");
    printDateTimeMenuItem.setOnAction(e -> printDateTime());

    MenuItem writeToFileMenuItem = new MenuItem("Write to file");
    writeToFileMenuItem.setOnAction(e -> writeToFile());

    MenuItem changeColorMenuItem = new MenuItem("Change Background Color");
    changeColorMenuItem.setOnAction(e -> changeBackgroundColor());

    MenuItem exitMenuItem = new MenuItem("Exit");
    exitMenuItem.setOnAction(e -> primaryStage.close());

    Menu menu = new Menu("Options");
    menuBar.getMenus().add(menu);
    menu.getItems()
        .addAll(printDateTimeMenuItem, writeToFileMenuItem, changeColorMenuItem, exitMenuItem);

    primaryStage.setTitle("Interaction Menu App");
    Scene scene = new Scene(pane, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void printDateTime() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
    printLogTextArea.appendText(String.format("%s\n", dateFormat.format(new Date())));
  }

  private void showAlert(AlertType alertType, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

  private void writeToFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))) {
      writer.println(printLogTextArea.getText());
      writer.flush();
      showAlert(Alert.AlertType.INFORMATION, "Success", "The output has been saved to log.txt!");
    } catch (IOException e) {
      showAlert(Alert.AlertType.ERROR, "Error", "Failed to write to log.txt: " + e.getMessage());
    }
  }

  private void changeBackgroundColor() {
    Random random = new Random();
    float hue = random.nextFloat();
    String style = String.format("-fx-background-color: hsb(%f, 80%%, 80%%)", (hue * 360));
    printLogTextArea.lookup(".content").setStyle(style);
    printLogTextArea.lookup(".text-area").setStyle(style);
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
