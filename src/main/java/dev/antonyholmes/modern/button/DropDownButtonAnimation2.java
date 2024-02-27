package dev.antonyholmes.modern.button;

import dev.antonyholmes.modern.ModernWidget;

public class DropDownButtonAnimation2 extends ButtonFillAnimation {
  public DropDownButtonAnimation2(ModernWidget button) {
    super(button);
  }

  @Override
  public void animateMouseExited() {
    // If the popup is show, force the animation to display the button
    // by making it opaque and stopping the timer
    if (getButton().getPopupShown()) {
      // stop();
      opaque();
    } else {
      super.animateMouseExited();
    }
  }
}
