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
import dev.antonyholmes.modern.animation.TranslateAnimation;
import dev.antonyholmes.modern.button.ButtonPressedAnimation;
import dev.antonyholmes.modern.theme.DrawUIService;
import dev.antonyholmes.modern.theme.MaterialService;

/**
 * The Class RibbonMenuAnimation.
 */
public class RibbonSegmentPressedAnimation extends ButtonPressedAnimation {

  private RibbonSegmentVertTabs mTabs;
  private int mHighlight;

  /**
   * Instantiates a new ribbon menu animation.
   *
   * @param button the button
   */
  public RibbonSegmentPressedAnimation(ModernWidget w) {
    super(w, MaterialService.instance().getColor("ribbon-pressed"));

    mTabs = (RibbonSegmentVertTabs) w;
  }

  @Override
  public void start() {
    // We only want the tab highlighted at the time the mouse is pressed
    // to be animated.
    mHighlight = mTabs.mHighlight;

    super.start();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.widget.ModernClickWidget#drawBackgroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void draw(ModernWidget c, Graphics2D g2, Props props) {
    // System.err.println("hmm " + isRunning() + " " + isPressed());

    if (getStep() == -1) {
      return;
    }

    int x = mTabs.getInsets().left; // + widget.getWidth() -
    // SegmentChangeAnimation.HEIGHT;
    int y = mTabs.getInsets().top;
    int tabWidth = mTabs.getInternalRect().getW();

    if (mHighlight != -1) {

      g2.setColor(mColor);

      double r = TranslateAnimation.BEZ_T[getStep()]; // /
      // (double)TimerAnimation.AnimationTimer.STEPS;

      int d = (int) (tabWidth * r);

      x += (tabWidth - d) / 2;

      // g2.setColor(mColor);
      // g2.fillRect(x,
      // y + mHighlight * RibbonSegmentVertTabs.TAB_SIZE,
      /// d,
      // RibbonSegmentVertTabs.TAB_SIZE);

      DrawUIService.getInstance().getRenderer("button-fill").draw(g2,
          new IntRect(x, y + mHighlight * RibbonSegmentVertTabs.TAB_SIZE, d, RibbonSegmentVertTabs.TAB_SIZE), mColor);
    }
  }
}
