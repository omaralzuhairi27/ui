package at.nacs.morseencoderui.controller;

import at.nacs.morseencoderui.Message;
import at.nacs.morseencoderui.logic.Manager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class IndexController {


  private final Manager manager;

  private Message ciphertext = new Message();
  private Message message = new Message();

  @ModelAttribute("message")
  Message message() {
    return message;
  }

  @ModelAttribute("ciphertext")
  Message ciphertext() {
    return ciphertext;
  }

  @GetMapping
  String page() {
    return "index";
  }

  @PostMapping
  String post(@Valid Message message, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    if (message.getText() == null) {
      return "redirect:/";
    }
    String text = message.getText();
    ciphertext.setText(manager.post(text));
    message.setText(message.getText());
    return "redirect:/";
  }
}
