package dev.antonyholmes.modern.dialog;

import java.awt.Graphics2D;

import org.jebtk.core.Props;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.animation.WidgetAnimation;
import dev.antonyholmes.modern.theme.DrawUIService;

public class DialogButtonAnimation extends WidgetAnimation {
  public DialogButtonAnimation(ModernWidget widget) {
    super(widget);
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    DrawUIService.getInstance().getRenderer("dialog.button").draw(g2, ((ModernWidget)mWidget).getInternalRect());
  }
}
