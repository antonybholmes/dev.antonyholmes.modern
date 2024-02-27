package dev.antonyholmes.modern.spinner;

import java.awt.Graphics2D;

import org.jebtk.core.Props;

import dev.antonyholmes.modern.AssetService;
import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.animation.WidgetAnimation;
import dev.antonyholmes.modern.graphics.icons.ModernIcon;
import dev.antonyholmes.modern.graphics.icons.TriangleDownVectorIcon;
import dev.antonyholmes.modern.graphics.icons.TriangleUpVectorIcon;
import dev.antonyholmes.modern.ribbon.Ribbon;

public class SpinnerAnimation extends WidgetAnimation {
  private ModernCompactSpinner mSpinner;

  private static final ModernIcon TRIANGLE_UP = AssetService.getInstance().loadIcon(TriangleUpVectorIcon.class, 16);

  private static final ModernIcon TRIANGLE_UP_HIGH = AssetService.getInstance().loadIcon(TriangleUpVectorIcon.class,
      Ribbon.BAR_BACKGROUND, 16);

  private static final ModernIcon TRIANGLE_DOWN = AssetService.getInstance().loadIcon(TriangleDownVectorIcon.class, 16);

  private static final ModernIcon TRIANGLE_DOWN_HIGH = AssetService.getInstance().loadIcon(TriangleDownVectorIcon.class,
      Ribbon.BAR_BACKGROUND, 16);

  public SpinnerAnimation(ModernWidget widget) {
    super(widget);

    mSpinner = (ModernCompactSpinner) widget;
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {

    int x = mSpinner.getWidth() - 16;
    int y = (mSpinner.mButtonYDivider - 16) / 2;

    if (mSpinner.mButtonZone && mSpinner.mUpperButton) {
      TRIANGLE_UP_HIGH.drawIcon(g2, x, y, 16);
    } else {
      TRIANGLE_UP.drawIcon(g2, x, y, 16);
    }

    System.err.println("spin " + x + " " + y);

    TRIANGLE_UP_HIGH.drawIcon(g2, x, y, 16);

    y += mSpinner.mButtonYDivider;

    if (mSpinner.mButtonZone && !mSpinner.mUpperButton) {
      TRIANGLE_DOWN_HIGH.drawIcon(g2, x, y, 16);
    } else {
      TRIANGLE_DOWN.drawIcon(g2, x, y, 16);
    }
  }
}
