package at.nacs.morseencoderui.logic;

import at.nacs.morseencoderui.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class Manager {
  private final EncoderUiClient encoderUiClient;
  public String post(Message message) {
    String plaintext = message.getText();
    return encoderUiClient.post(plaintext);
  }
}
