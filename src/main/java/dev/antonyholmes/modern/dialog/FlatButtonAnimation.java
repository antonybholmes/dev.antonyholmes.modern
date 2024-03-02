package dev.antonyholmes.modern.dialog;

import java.awt.Graphics2D;

import org.jebtk.core.Props;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.button.ButtonFillAnimation;
import dev.antonyholmes.modern.theme.DrawUIService;

public class FlatButtonAnimation extends ButtonFillAnimation {
  public FlatButtonAnimation(ModernWidget button) {
    super(button);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    DrawUIService.getInstance().getRenderer("content-box").draw(g2, ((ModernWidget)mWidget).getInternalRect());

    super.draw((ModernWidget)mWidget, g2, props);
  }
}
