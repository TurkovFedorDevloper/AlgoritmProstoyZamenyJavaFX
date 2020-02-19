package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    private String alph = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя ,";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField massField;

    @FXML
    private PasswordField keyAlfField;

    @FXML
    private TextField shifrMassField;

    @FXML
    private Button shifrButton;

    @FXML
    private Button deShifrButton;

    @FXML
    private Button deletButton;

    @FXML
    void initialize() {
        deletButton.setOnAction(event -> {
            massField.setText(null);
            shifrMassField.setText(null);
            keyAlfField.setText(null);
        });

        shifrButton.setOnAction(event -> {

            char[] alphChar = alph.toCharArray();
            char[] keyAlfFieldCharr = keyAlfField.getText().toCharArray();
            char[] massFieldChar = massField.getText().toCharArray();
            String shifrMass = "";

            for (int i = 0; i < massFieldChar.length; i++) {
                for (int j = 0; j < alphChar.length; j++) {
                    if (massFieldChar[i] == alphChar[j]) {
                        shifrMass += keyAlfFieldCharr[j];
                    }
                }
            }
            shifrMassField.setText(shifrMass);
        });

        deShifrButton.setOnAction(event -> {
            if (keyAlfField.getText().trim().length() == 0) {
                keyAlfField.setText(alph);
            }
            char[] alphChar = alph.toCharArray();
            char[] keyAlfFieldCharr = keyAlfField.getText().toCharArray();
            char[] massFieldChar = massField.getText().toCharArray();
            String shifrMass = "";

            for (int i = 0; i < massFieldChar.length; i++) {
                for (int j = 0; j < keyAlfFieldCharr.length; j++) {
                    if (massFieldChar[i] == keyAlfFieldCharr[j]) {
                        shifrMass += alphChar[j];
                    }
                }
            }
            shifrMassField.setText(shifrMass);
        });
    }
}
