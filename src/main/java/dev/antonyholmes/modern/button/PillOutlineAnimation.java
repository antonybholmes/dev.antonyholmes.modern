package dev.antonyholmes.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.geom.IntRect;
import dev.antonyholmes.modern.button.ButtonOutlineAnimation;

import dev.antonyholmes.modern.ModernComponent;
import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.theme.DrawUIService;

public class PillOutlineAnimation extends ButtonOutlineAnimation {
  public PillOutlineAnimation(ModernWidget button) {
    super(button);
  }

  @Override
  public void outline(ModernComponent c, Graphics2D g2, IntRect rect) {
    // if (mode == RenderMode.NONE && !hasFocus) {
    // return;
    // }

    System.err.println("pill " + rect + " " + getFadeColor("outline"));

    DrawUIService.getInstance().getRenderer("pill-outline").draw(c, g2, rect, getFadeColor("outline"));

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
