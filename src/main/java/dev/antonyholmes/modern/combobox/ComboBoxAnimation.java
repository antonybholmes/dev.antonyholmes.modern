package dev.antonyholmes.modern.combobox;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.animation.WidgetAnimation;
import dev.antonyholmes.modern.theme.DrawUIService;

public class ComboBoxAnimation extends WidgetAnimation {

  public ComboBoxAnimation(ModernWidget combo) {
    super(combo);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    IntRect rect = ((ModernWidget)mWidget).getInternalRect();

    DrawUIService.getInstance().getRenderer("content-box").draw((ModernWidget)mWidget, g2, rect);
  }
}
