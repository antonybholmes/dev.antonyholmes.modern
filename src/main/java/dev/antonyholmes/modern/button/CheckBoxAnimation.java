package dev.antonyholmes.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.animation.WidgetAnimation;
import dev.antonyholmes.modern.theme.DrawUIService;

public class CheckBoxAnimation extends WidgetAnimation {
  public CheckBoxAnimation(ModernWidget widget) {
    super(widget);
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    int x = mWidget.getInsets().left;
    int y = (mWidget.getHeight() - ModernCheckBox.ICON_SIZE) / 2;

    // if (((ModernClickWidget)widget).isSelected()) {
    // if (widget.isEnabled()) {
    // ModernCheckBox.CHECKED_ICON.drawIcon(g2, x, y, ModernCheckBox.ICON_SIZE);
    // } else {
    // ModernCheckBox.DISABLED_CHECKED_ICON.drawIcon(g2, x, y,
    // ModernCheckBox.ICON_SIZE);
    // }
    // } else {

    // If there is nothing to be done, draw the unselected version of the
    // checkbox
    // ModernCheckBox.UNCHECKED_ICON.drawIcon(g2, x, y,
    // ModernCheckBox.ICON_SIZE);

    DrawUIService.getInstance().getRenderer("content-box").draw((ModernWidget)mWidget, g2,
        new IntRect(x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE));
    // }
  }
}
