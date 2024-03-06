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
package dev.antonyholmes.modern.button;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.BoxLayout;
import javax.swing.border.Border;

import org.jebtk.core.text.TextUtils;

import dev.antonyholmes.modern.UI;

/**
 * The Class ModernCheckSwitch offers a sliding on/off switch similar to what
 * you might find in Android or iOS.
 */
public class ModernCheckSwitch extends CheckBox {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  private Color mTextColor;
  
  private ModernCheckSwitchButton mButton = new ModernCheckSwitchButton();

  public ModernCheckSwitch() {
    this(TextUtils.EMPTY_STRING);
  }

  /**
   * Instantiates a new modern check box.
   *
   * @param text the text
   */
  public ModernCheckSwitch(String text) {
    this(text, false);
  }

  public ModernCheckSwitch(String text, int width) {
    super(text);
    
    

    setSize(width);
    
    init();
  }
  
  private void init() {
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    add(mButton, BorderLayout.LINE_START);
  }

  /**
   * Instantiates a new modern check box.
   *
   * @param selected the selected
   */
  public ModernCheckSwitch(boolean selected) {
    this(TextUtils.EMPTY_STRING, selected);
  }

  /**
   * Instantiates a new modern check box.
   *
   * @param text the text
   * @param selected the selected
   */
  public ModernCheckSwitch(String text, boolean selected) {
    super(text);

    ///addStyleClass("content-outline", "check-switch");

    //setAnimations("check-switch");

    setSelected(selected);

    setSize();
    
    init();
  }

  public ModernCheckSwitch(String text, boolean selected, Color color) {
    this(text, selected, color, TEXT_COLOR);
  }

  public ModernCheckSwitch(String text, boolean selected, Color color,
      Color textColor) {
    this(text, selected);

    mTextColor = textColor;

    //getAnimations().set(new CheckSwitchAnimation(this, color),
    //    new CheckSwitchChangeAnimation(this));

    setSelected(selected);
    
    init();
  }
  
  @Override
  public void setSelected(boolean selected) {
    if (mButton != null) {
      mButton.setSelected(selected);
    }
    
    super.setSelected(selected);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.ModernWidget#setFont(java.awt.Font)
   */
  @Override
  public void setFont(Font font) {
    super.setFont(font);

    setSize();
  }

  /**
   * Sets the text.
   *
   * @param text the new text
   */
  public void setText(String text) {
    mText1 = text;

    setSize();

    setClickMessage(text);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.ModernComponent#setBorder(javax.swing.border.Border)
   */
  @Override
  public void setBorder(Border border) {
    super.setBorder(border);

    setSize();
  }

  /**
   * Sets the size.
   */
  private void setSize() {
    setSize(getInsets().left + ModernButton.getStringWidth(mText1)
        + ModernCheckSwitchButton.SLIDER_WIDTH + QUAD_PADDING);

  }

  private void setSize(int width) {
    UI.setSize(this, width, ModernButton.getButtonHeight());

  }

  /*
   * @Override public void drawBackgroundAA(Graphics2D g2) { drawSlider(g2); }
   */
  @Override
  public void drawBackgroundAA(Graphics2D g2) {

    System.err.println("sdfsdfsdfsdf" + this);
    super.drawBackgroundAA(g2);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.ui.button.ModernCheckBox#drawForegroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void drawForegroundAA(Graphics2D g2) {
    g2.setColor(mTextColor); // isSelected() ? TEXT_COLOR :
    // TEXT_DISABLED_COLOR);
    g2.drawString(mText1,
        getInsets().left + ModernCheckSwitchButton.SLIDER_WIDTH + PADDING,
        getTextYPosCenter(g2, getHeight()));
  }
}
