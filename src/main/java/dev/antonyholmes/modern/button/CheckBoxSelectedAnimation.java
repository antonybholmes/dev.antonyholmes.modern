package dev.antonyholmes.modern.button;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;
import dev.antonyholmes.modern.button.ButtonFillAnimation;
import dev.antonyholmes.modern.button.ModernCheckBox;
import dev.antonyholmes.modern.button.ModernClickWidget;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.theme.DrawUIService;

public class CheckBoxSelectedAnimation extends ButtonFillAnimation {
  public CheckBoxSelectedAnimation(ModernWidget widget) {
    super((ModernClickWidget) widget);

    // setFadeColor("fill",
    // widget.getFromKeyFrame().getColor("background-color"));
  }

  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    if (mWidget.isEnabled() && ((ModernClickWidget) getWidget()).isSelected()) {
      int x = mWidget.getInsets().left;
      int y = (mWidget.getHeight() - ModernCheckBox.ICON_SIZE) / 2;

      // g2.setColor(ModernWidgetRenderer.SELECTED_FILL_COLOR); //
      // getFadeColor("fill"));
      // getWidget().getWidgetRenderer()
      // .fill(g2, x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE);

      DrawUIService.getInstance().getRenderer("button-fill").draw(mWidget, g2,
          new IntRect(x, y, ModernCheckBox.ICON_SIZE, ModernCheckBox.ICON_SIZE),
          mWidget.getToKeyFrame().getColor("background-color"));

      // fill(g2,
      // x,
      // y,
      // ModernCheckBox.ICON_SIZE,
      // ModernCheckBox.ICON_SIZE);
    }
  }
}
