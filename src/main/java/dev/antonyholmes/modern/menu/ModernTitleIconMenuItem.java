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
package dev.antonyholmes.modern.menu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import dev.antonyholmes.modern.theme.ThemeService;

// TODO: Auto-generated Javadoc
/**
 * Title menu item offset for icon.
 * 
 * @author Antony Holmes
 *
 */
public class ModernTitleIconMenuItem extends ModernMenuItem {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constant OFFSET.
   */
  private static final int OFFSET = DOUBLE_PADDING;

  /**
   * The constant BACKGROUND.
   */
  private static final Color BACKGROUND = ThemeService.getInstance().getColors().getGray(2);

  /**
   * Instantiates a new modern title icon menu item.
   *
   * @param text the text
   */
  public ModernTitleIconMenuItem(String text) {
    super(text);

    setEnabled(false);

    setFont(BOLD_FONT);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.button.ModernButtonWidget#drawBackground(java.awt.
   * Graphics2D)
   */
  @Override
  public void drawBackground(Graphics2D g2) {
    Rectangle rect = new Rectangle(getHeight(), 0, getWidth() - getHeight(), getHeight());

    fill(g2, BACKGROUND, rect);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.menu.ModernMenuItem#drawForegroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void drawForegroundAA(Graphics2D g2) {
    g2.setColor(TEXT_COLOR);
    g2.setFont(BOLD_FONT);

    g2.drawString(mDisplayText, OFFSET + getHeight(), getTextYPosCenter(g2, getHeight()));
  }
}