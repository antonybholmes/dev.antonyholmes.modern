package dev.antonyholmes.modern.button;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.css.CSSAltFillAnimation;

public class ButtonAltFillAnimation extends CSSAltFillAnimation {
  private ModernClickWidget mButton;

  public ButtonAltFillAnimation(ModernWidget button) {
    super(button);

    mButton = (ModernClickWidget) button;
  }

  @Override
  public String getName() {
    return "button-alt-fill";
  }

  public ModernClickWidget getButton() {
    return mButton;
  }
}
