/**
 * Copyright 2019 Antony Holmes
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

import javax.swing.JComponent;


/**
 * Base class for animations on widgets.
 *
 * @author Antony Holmes
 */
public abstract class WidgetAnimation extends Animation {

  /** The m widget. */
  public final JComponent mWidget;

  /**
   * Instantiates a new widget animation.
   *
   * @param widget the widget
   */
  public WidgetAnimation(JComponent widget) {
    mWidget = widget;
  }

  public void trigger(String trigger) {
    // Do nothing
  }

  /**
   * Gets the widget.
   *
   * @return the widget
   */
  public JComponent getWidget() {
    return mWidget;
  }

  @Override
  public String getName() {
    return "widget-animation";
  }

  public void bindChildren() {
    // Do nothing
  }

  public void repaint() {
    mWidget.repaint();
  }
}
