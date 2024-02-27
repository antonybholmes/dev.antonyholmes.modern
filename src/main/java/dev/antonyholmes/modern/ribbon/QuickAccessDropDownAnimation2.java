package dev.antonyholmes.modern.ribbon;

import dev.antonyholmes.modern.button.ButtonFillAnimation;
import dev.antonyholmes.modern.button.ModernDropDownWidget2;

public class QuickAccessDropDownAnimation2 extends ButtonFillAnimation {
  public QuickAccessDropDownAnimation2(ModernDropDownWidget2 button) {
    super(button);
  }

  @Override
  public void animateMouseExited() {
    // If the popup is show, force the animation to display the button
    // by making it opaque and stopping the timer
    if (getButton().getPopupShown()) {
      opaque();
      stop();
    } else {
      super.animateMouseExited();
    }
  }
}
