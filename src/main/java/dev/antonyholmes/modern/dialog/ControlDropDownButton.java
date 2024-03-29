/**
 * Copyright 2016 Antony Holmes
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
package dev.antonyholmes.modern.dialog;

import java.awt.Dimension;

import dev.antonyholmes.modern.UI;

/**
 * Generic control drop down button. Provides the basic button UI
 * 
 * @author Antony Holmes
 *
 */
public abstract class ControlDropDownButton extends ModernDialogFlatDropDownButton {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constant SIZE.
   */
  protected static final Dimension SIZE = new Dimension(48, WIDGET_HEIGHT);

  /**
   * Instantiates a new dashed line type button.
   *
   * @param text1 the text 1
   */
  public ControlDropDownButton(String text1) {
    super(text1);

    UI.setSize(this, SIZE);
  }
}
