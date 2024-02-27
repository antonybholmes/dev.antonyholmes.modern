package dev.antonyholmes.modern.collapsepane;

import java.awt.Dimension;
import java.awt.Graphics2D;

import org.jebtk.core.Props;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.animation.WidgetAnimation;
import dev.antonyholmes.modern.theme.MaterialUtils;

public class CollapsePaneCardAnimation extends WidgetAnimation {

  public CollapsePaneCardAnimation(ModernWidget widget) {
    super(widget);
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    Dimension s = mWidget.getPreferredSize();
    // Insets insets = widget.getInsets();

    MaterialUtils.drawCard(g2, mWidget, 0, 0, mWidget.getWidth(), s.height - MaterialUtils.SHADOW_HEIGHT);
  }

}
