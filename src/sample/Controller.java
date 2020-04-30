package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    public TextArea input_textArea;

    @FXML
    public Label encrypt_label;

    @FXML
    public Label decrypt_label;

    private String text;

    @FXML
    public void onEncryptButtonClicked () {
        text = input_textArea.getText();
        encrypt_label.setText(text);
    }

    @FXML
    public void onDecryptButtonClicked () {
        decrypt_label.setText(text);
    }
}
