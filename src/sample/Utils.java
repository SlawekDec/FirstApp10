package sample;

import javafx.scene.control.Alert;

import java.util.SplittableRandom;

/**
 * Created by Sławek on 17.07.2017.
 */
public class Utils {
    public static void createDialog(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(header);
        alert.show();

    }
}
