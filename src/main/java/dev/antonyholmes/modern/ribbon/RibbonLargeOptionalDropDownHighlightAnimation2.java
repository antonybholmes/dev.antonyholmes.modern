/**
 * Copyright 2017 Antony Holmes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.antonyholmes.modern.ribbon;

import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.geom.IntRect;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.button.DropDownButtonAnimation2;
import dev.antonyholmes.modern.button.ModernOptionalDropDownMenuButton2;
import dev.antonyholmes.modern.css.CSSBaseUI;

/**
 * The Class RibbonButtonAnimation.
 */
public class RibbonLargeOptionalDropDownHighlightAnimation2 extends DropDownButtonAnimation2 {

  /** The m button. */
  private ModernOptionalDropDownMenuButton2 mButton;

  /**
   * Instantiates a new ribbon button animation.
   *
   * @param button the button
   */
  public RibbonLargeOptionalDropDownHighlightAnimation2(ModernWidget button) {
    super((ModernOptionalDropDownMenuButton2) button);

    mButton = (ModernOptionalDropDownMenuButton2) button;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    if (!getWidget().isEnabled()) {
      return;
    }

    IntRect rect = ((ModernWidget)mWidget).getInternalRect();

    int x = 0;
    int w = 0;
    int y = rect.getY();
    int h = rect.getH();

    if (mButton.mPrimaryButton || mButton.mPopupShown) {
      x = rect.getX();
      w = mButton.mDividerLocation - rect.getX();
    } else {
      x = mButton.mDividerLocation;
      w = rect.getW() - mButton.mDividerLocation;
    }

    g2.setColor(getFadeColor("fill"));

    if (mButton.isSelected() || mButton.mPopupShown) {
      // paintHighlighted(g2, rect);

      // getWidget().getWidgetRenderer().fill(g2, rect);
      // DrawUIService.getInstance().getRenderer("button-fill").draw(g2, rect);

      CSSBaseUI.cssFill(c, g2, rect, props);

    } else if (mButton.getHightlighted()) {
      System.err.println("what " + g2.getColor() + " " + getStep());

      CSSBaseUI.cssFill(c, g2, new IntRect(x, y, w, h), props);

      // getWidget().getWidgetRenderer().outline(g2, rect);
      // getWidget().getWidgetRenderer().fill(g2, x, y, w, h);
      // DrawUIService.getInstance().getRenderer("button-fill")
      // .draw(g2, x, y, w, h, getFadeColor("fill"));

      // getWidgetRenderer().drawRibbonButtonOutline(g2, rect,
      // RenderMode.SELECTED);
      // getWidgetRenderer().drawRibbonButton(g2, x, y, w, h,
      // RenderMode.SELECTED);

      // paintHighlightedBorder(g2, rect);
      // paintHighlighted(g2, x, y, w, h);
    } else {
      // Do nothing
    }
  }
}
