package dev.antonyholmes.modern.button;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.Props;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.animation.WidgetAnimation;

public class CheckSwitchAnimation extends WidgetAnimation {

  private static final int HEIGHT = ModernCheckSwitchButton.SLIDER_HEIGHT; // ModernCheckSwitchButton.SLIDER_HEIGHT;
  private ModernCheckSwitchButton mButton;
  private Color mColor;
  // private FadeAnimation mFade;

  // public CheckSwitchAnimation(ModernWidget widget) {
  // this(widget, widget.getFromKeyFrame().getColor("background-color"),
  // widget.getToKeyFrame().getColor("background-color"));
  // }

  public CheckSwitchAnimation(ModernWidget widget) {
    this(widget, widget.getToKeyFrame().getColor("background-color"));
  }

  public CheckSwitchAnimation(ModernWidget widget, Color color) {
    super(widget);

    mColor = color;

    mButton = (ModernCheckSwitchButton) widget;

    // mFade = new FadeAnimation(widget).setFadeColor("fill", color1, color2);
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    int y2 = (mWidget.getHeight() - HEIGHT) / 2;

    if (mButton.isSelected()) {
      g2.setColor(mColor); // mFade.getToColor("fill"));

      g2.fillRoundRect(mWidget.getInsets().left + ModernCheckSwitchButton.SWITCH_ICON_OFFSET, y2,
          ModernCheckSwitchButton.SLIDER_WIDTH - ModernCheckSwitchButton.SWITCH_ICON_OFFSET_2, HEIGHT, HEIGHT, HEIGHT);

    } else {
      // System.err.println("switch bg1 " +
      // widget.getFromKeyFrame().getStyles("background-color") + " " +
      // widget.getFromKeyFrame().getColor("background-color"));

      g2.setColor(((ModernWidget)mWidget).getFromKeyFrame().getColor("background-color")); // mFade.getFromColor("fill"));
      // //
      // Color.WHITE);

      g2.fillRoundRect(mWidget.getInsets().left + ModernCheckSwitchButton.SWITCH_ICON_OFFSET, y2,
          ModernCheckSwitchButton.SLIDER_WIDTH - ModernCheckSwitchButton.SWITCH_ICON_OFFSET_2, HEIGHT, HEIGHT, HEIGHT);

      g2.setColor(((ModernWidget)mWidget).getFromKeyFrame().getColor("border-color"));

      g2.drawRoundRect(mWidget.getInsets().left + ModernCheckSwitchButton.SWITCH_ICON_OFFSET, y2,
          ModernCheckSwitchButton.SLIDER_WIDTH - ModernCheckSwitchButton.SWITCH_ICON_OFFSET_2, HEIGHT, HEIGHT, HEIGHT);
    }

    /*
     * 
     * g2.setColor(ModernWidget.LINE_COLOR);
     * g2.drawRoundRect(ModernCheckSwitchButton.SLIDER_OFFSET, y2,
     * ModernCheckSwitchButton.SLIDER_WIDTH - 1, HEIGHT - 1, HEIGHT, HEIGHT);
     */
  }
}
