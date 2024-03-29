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
package dev.antonyholmes.modern.animation;

import java.awt.Graphics2D;

import dev.antonyholmes.modern.ModernWidget;

/**
 * Allows for graphics to transition between two fixed points linearly.
 *
 * @author Antony Holmes
 */
public abstract class TranslateYAnimation extends TranslateAnimation {

  /**
   * Instantiates a new state animation.
   *
   * @param ribbon the ribbon
   */
  public TranslateYAnimation(ModernWidget widget) {
    super(widget);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.animation.Animation#draw(org.abh.common.ui.widget.
   * ModernWidget, java.awt.Graphics2D, java.lang.Object[])
   */
  @Override
  public void translate(Graphics2D g2) {
    g2.translate(getWidget().getInsets().left, getWidget().getInsets().top + getX());
  }
}
