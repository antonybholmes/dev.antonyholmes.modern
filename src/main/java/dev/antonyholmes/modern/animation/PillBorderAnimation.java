package dev.antonyholmes.modern.animation;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.button.PillOutlineAnimation;

public class PillBorderAnimation extends PillOutlineAnimation {
  public PillBorderAnimation(ModernWidget widget) {
    super(widget);

    bindChildren();
  }
}
