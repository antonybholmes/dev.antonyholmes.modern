package dev.antonyholmes.modern.theme;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;

import dev.antonyholmes.modern.ModernComponent;

public class ContentUI extends DrawUI {
  @Override
  public String getName() {
    return "content";
  }

  @Override
  public void draw(ModernComponent c, Graphics2D g2, IntRect rect, Props props) {
    g2.setColor(Color.WHITE);
    fill(c, g2, rect);
  }
}
