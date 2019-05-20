package at.nacs.morseencoderui.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Manager {
  private final EncoderUiClient encoderUiClient;

  public String post(String message) {
    return encoderUiClient.post(message);
  }
}
