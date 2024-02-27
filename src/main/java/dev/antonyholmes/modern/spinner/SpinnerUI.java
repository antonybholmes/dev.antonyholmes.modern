package dev.antonyholmes.modern.spinner;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;
import dev.antonyholmes.modern.spinner.ModernCompactSpinner;

import dev.antonyholmes.modern.AssetService;
import dev.antonyholmes.modern.ModernComponent;
import dev.antonyholmes.modern.graphics.icons.ModernIcon;
import dev.antonyholmes.modern.graphics.icons.TriangleDownVectorIcon;
import dev.antonyholmes.modern.graphics.icons.TriangleUpVectorIcon;
import dev.antonyholmes.modern.ribbon.Ribbon;
import dev.antonyholmes.modern.theme.DrawUI;

public class SpinnerUI extends DrawUI {
  private static final ModernIcon TRIANGLE_UP = AssetService.getInstance().loadIcon(TriangleUpVectorIcon.class, 16);

  private static final ModernIcon TRIANGLE_UP_HIGH = AssetService.getInstance().loadIcon(TriangleUpVectorIcon.class,
      Ribbon.BAR_BACKGROUND, 16);

  private static final ModernIcon TRIANGLE_DOWN = AssetService.getInstance().loadIcon(TriangleDownVectorIcon.class, 16);

  private static final ModernIcon TRIANGLE_DOWN_HIGH = AssetService.getInstance().loadIcon(TriangleDownVectorIcon.class,
      Ribbon.BAR_BACKGROUND, 16);

  @Override
  public void draw(ModernComponent c, Graphics2D g2, IntRect rect, Props props) {
    ModernCompactSpinner spinner = (ModernCompactSpinner) c;

    int x = spinner.getWidth() - 16;
    int y = (spinner.mButtonYDivider - 16) / 2;

    if (spinner.mButtonZone && spinner.mUpperButton) {
      TRIANGLE_UP_HIGH.drawIcon(g2, x, y, 16);
    } else {
      TRIANGLE_UP.drawIcon(g2, x, y, 16);
    }

    TRIANGLE_UP_HIGH.drawIcon(g2, x, y, 16);

    y += spinner.mButtonYDivider;

    if (spinner.mButtonZone && !spinner.mUpperButton) {
      TRIANGLE_DOWN_HIGH.drawIcon(g2, x, y, 16);
    } else {
      TRIANGLE_DOWN.drawIcon(g2, x, y, 16);
    }
  }

  @Override
  public String getName() {
    return "spinner";
  }
}
