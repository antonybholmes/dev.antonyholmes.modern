package dev.antonyholmes.modern.combobox;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.event.ChangeListener;
import org.jebtk.core.geom.IntRect;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.button.ButtonAltFillAnimation;

public class ComboBoxHighlightAnimation2 extends ButtonAltFillAnimation implements ChangeListener {
  private ModernComboBox2 mCombo;

  public ComboBoxHighlightAnimation2(ModernWidget combo) {
    super(combo);

    mCombo = (ModernComboBox2) combo;

    // mCombo.addPopupClosedListener(this);

    // setFadeColor("fill",
    // MaterialService.getInstance().getColor("dialog.button.outline"));
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

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    if (getWidget().isEnabled()) {
      IntRect rect = ((ModernWidget)mWidget).getInternalRect();

      IntRect buttonRect = new IntRect(mCombo.mButtonX, mWidget.getInsets().top, ModernComboBox.BUTTON_WIDTH,
          rect.getH());

      fill((ModernWidget)mWidget, g2, buttonRect);
    }
  }

  @Override
  public void changed(ChangeEvent e) {
    pseudoMouseExited();
  }
}
