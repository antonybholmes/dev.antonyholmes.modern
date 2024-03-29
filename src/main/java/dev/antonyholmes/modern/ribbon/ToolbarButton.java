/**
 * Copyright (C) 2016, Antony Holmes
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. Neither the name of copyright holder nor the names of its contributors 
 *     may be used to endorse or promote products derived from this software 
 *     without specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
package dev.antonyholmes.modern.ribbon;

import java.awt.Dimension;

import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.button.ModernButton;
import dev.antonyholmes.modern.graphics.icons.ModernIcon;

// TODO: Auto-generated Javadoc
/**
 * Concrete implementation of a button which responds to click events.
 *
 * @author Antony Holmes
 */
public class ToolbarButton extends ModernButton {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constant HEIGHT.
   */
  private static final int HEIGHT = 30;

  /**
   * The constant ICON_SIZE.
   */
  private static final Dimension ICON_SIZE = new Dimension(HEIGHT, HEIGHT);

  /**
   * Instantiates a new toolbar button2.
   *
   * @param text the text
   */
  public ToolbarButton(String text) {
    super(text);

    UI.setSize(this, getButtonWidth(text), HEIGHT);
  }

  /**
   * Instantiates a new toolbar button2.
   *
   * @param icon the icon
   */
  public ToolbarButton(ModernIcon icon) {
    super(icon);

    UI.setSize(this, ICON_SIZE);
  }

  /*
   * @Override public void drawBackground(Graphics2D g2) { if (mHighlight) {
   * paintHighlightedOutlined(g2, getRect()); } else if(hasFocus()) {
   * paintOutlinedFocused(g2, getRect()); } else { paintOutlined(g2, getRect()); }
   * }
   */
}
