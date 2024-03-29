package dev.antonyholmes.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.Props;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.theme.DrawUIService;

public class CircleOutlineAnimation extends ButtonFillAnimation {
  public CircleOutlineAnimation(ModernWidget button) {
    super(button);
  }

  @Override
  public String getName() {
    return "circle-outline";
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    if (getWidget().isEnabled()) {

      DrawUIService.getInstance().getRenderer("circle-outline").draw((ModernWidget)mWidget, g2, getFadeColor("fill"));

      /*
       * Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);
       * 
       * try { if (widget instanceof ModernClickWidget) { if (((ModernClickWidget)
       * widget).isSelected()) {
       * g2Temp.setColor(ModernWidgetRenderer.SELECTED_FILL_COLOR); } else {
       * g2Temp.setColor(getFadeColor("fill")); } } else {
       * g2Temp.setColor(getFadeColor("fill")); }
       * 
       * IntRect rect = getWidget().getInternalRect();
       * 
       * g2Temp.fillOval(rect.getX(), rect.getY(), rect.getW(), rect.getH()); }
       * finally { g2Temp.dispose(); }
       */
    }
  }
}
