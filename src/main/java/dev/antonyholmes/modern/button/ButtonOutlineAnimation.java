package dev.antonyholmes.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;

import dev.antonyholmes.modern.ModernComponent;
import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.animation.HoverFadeAnimation;
import dev.antonyholmes.modern.theme.DrawUIService;

public class ButtonOutlineAnimation extends HoverFadeAnimation {
  public ButtonOutlineAnimation(ModernWidget button) {
    super(button);

    if (button.getFromKeyFrame().contains("border-color")) {
      setFadeColor("outline", button.getFromKeyFrame().getColor("border-color"),
          button.getToKeyFrame().getColor("border-color"));
    } else {
      setFadeColor("outline", button.getToKeyFrame().getColor("border-color"));
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
    if (c.isEnabled()) {
      c.getCSSProps().update("border-color", getFadeColor("outline"));

      // IntRect rect = widget.getRect(); // getInternalRect();

      // outline(g2, widget, rect.getX(), rect.getY(), rect.getW(),
      // rect.getH());
    }
  }

  public void outline(ModernComponent c, Graphics2D g2, IntRect rect) {
    // if (mode == RenderMode.NONE && !hasFocus) {
    // return;
    // }

    DrawUIService.getInstance().getRenderer("button-outline").draw(c, g2, rect, getFadeColor("outline"));

    // g2.setColor(getFadeColor("outline"));

    // outline(g2, x, y, w, h);
  }

  // public void outline(Graphics2D g2, int x, int y, int w, int h) {
  // getWidget().getWidgetRenderer().outline(g2, x, y, w, h);
  //
  // UIDrawService.getInstance().get("button-outline").draw(g2, x, y, w, h,
  // getFadeColor("outline"));
  // }
}
