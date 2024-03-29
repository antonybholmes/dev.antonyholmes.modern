package dev.antonyholmes.modern.button;

import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.event.ChangeListener;

import dev.antonyholmes.modern.ModernWidget;

public class DropDownButtonAnimation extends ButtonFillAnimation implements ChangeListener {
  public DropDownButtonAnimation(ModernWidget button) {
    super(button);

    ((ModernDropDownWidget) button).addPopupClosedListener(this);
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

  @Override
  public void changed(ChangeEvent e) {
    pseudoMouseExited();
  }
}
