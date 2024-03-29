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
package dev.antonyholmes.modern;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;

/**
 * The Class LeftLineBorderComponent.
 */
public class LeftLineBorderComponent extends ModernComponent {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The m color. */
  private Color mColor;

  /**
   * Instantiates a new left line border component.
   */
  public LeftLineBorderComponent() {
    this(ModernWidget.LINE_COLOR);
  }

  /**
   * Instantiates a new left line border component.
   *
   * @param c the c
   */
  public LeftLineBorderComponent(Component c) {
    this();

    setBody(c);
  }

  /**
   * Instantiates a new left line border component.
   *
   * @param color the color
   */
  public LeftLineBorderComponent(Color color) {
    mColor = color;
  }

  /**
   * Instantiates a new left line border component.
   *
   * @param c     the c
   * @param color the color
   */
  public LeftLineBorderComponent(Component c, Color color) {
    this(color);

    setBody(c);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.ModernComponent#drawBackground(java.awt.Graphics2D)
   */
  @Override
  public void drawBackground(Graphics2D g2) {
    g2.setColor(mColor);

    g2.drawLine(0, 0, 0, getHeight());
  }
}
