package at.nacs.morseencoderui.logic;

import at.nacs.morseencoderui.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("encoder")
public interface EncoderUiClient {
  @PostMapping("/encode")
  String post(String plaintext);
}
