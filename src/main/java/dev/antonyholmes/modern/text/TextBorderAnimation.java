package dev.antonyholmes.modern.text;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.button.ButtonOutlineAnimation;

public class TextBorderAnimation extends ButtonOutlineAnimation {
  public TextBorderAnimation(ModernWidget widget) {
    super(widget);

    bindChildren();
  }
}
