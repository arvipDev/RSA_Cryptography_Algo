package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.Communicator;
import model.KeyGenerator;
import model.KeyGeneratorImpl;

import java.math.BigInteger;
import java.util.List;

public class Controller {

    @FXML
    public TextArea input_textArea;

    @FXML
    public Label encrypt_label;

    @FXML
    public Label decrypt_label;

    private String text;
    private KeyGenerator keyGenerator;
    private Communicator sender;
    private KeyGenerator keyGenerator2;
    private Communicator receiver;
    private List<BigInteger> encryptedMessage;
    private String text2;

    {
        keyGenerator = new KeyGeneratorImpl();
        sender = new Communicator(keyGenerator);
        keyGenerator2 = new KeyGeneratorImpl();
        receiver = new Communicator(keyGenerator2);
        sender.setupLink(receiver.getMyPublicKey());
        receiver.setupLink(sender.getMyPublicKey());
    }

    @FXML
    public void onEncryptButtonClicked () {
        text = input_textArea.getText();
        List<BigInteger> encodedMessage = sender.encodeMessage(text);
        encryptedMessage = sender.getEncryptedMessage(encodedMessage);
        encrypt_label.setText(encryptedMessage.toString());
    }

    @FXML
    public void onDecryptButtonClicked () {
        decrypt_label.setText(text);
        List<BigInteger> decryptedMessage = receiver.getDecryptedMessage(encryptedMessage);
        text2 = receiver.decodeMessage(decryptedMessage);
    }
}
