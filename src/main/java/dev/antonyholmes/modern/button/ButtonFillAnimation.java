package dev.antonyholmes.modern.button;

import dev.antonyholmes.modern.button.ModernClickWidget;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.css.CSSHoverAnimation;

public class ButtonFillAnimation extends CSSHoverAnimation {
  private ModernClickWidget mButton;

  public ButtonFillAnimation(ModernWidget button) {
    super(button);

    mButton = (ModernClickWidget) button;
  }

  @Override
  public String getName() {
    return "button-fill";
  }

  public ModernClickWidget getButton() {
    return mButton;
  }
}
