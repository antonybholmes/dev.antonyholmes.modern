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
package dev.antonyholmes.modern.status;

import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.button.ModernCheckButton;
import dev.antonyholmes.modern.graphics.icons.ModernIcon;

// TODO: Auto-generated Javadoc
/**
 * Low height button for small form factor toolbar buttons.
 *
 * @author Antony Holmes
 */
public class ModernStatusCheckButton extends ModernCheckButton {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new modern status check button.
   *
   * @param text1 the text1
   */
  public ModernStatusCheckButton(String text1) {
    super(text1);
  }

  /**
   * Instantiates a new modern status check button.
   *
   * @param icon the icon
   */
  public ModernStatusCheckButton(ModernIcon icon) {
    super(icon);

    UI.setWidth(this, 42);
  }

  /**
   * Instantiates a new modern status check button.
   *
   * @param text1 the text1
   * @param icon  the icon
   */
  public ModernStatusCheckButton(String text1, ModernIcon icon) {
    super(text1, icon);

    UI.setWidth(this, 72);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.button.ModernCheckButton#drawBackground(java.awt.
   * Graphics2D)
   */
  /*
   * @Override public void drawBackground(Graphics2D g2) { if (isSelected()) {
   * fill(g2, ThemeService.getInstance().getThemeColor(7), getRect()); } else if
   * (mHighlight) { fill(g2, ThemeService.getInstance().getThemeColor(4),
   * getRect()); } else { fill(g2, ThemeService.getInstance().getThemeColor(5),
   * getRect()); } }
   */
}
