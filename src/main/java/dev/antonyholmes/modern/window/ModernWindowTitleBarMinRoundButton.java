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
package dev.antonyholmes.modern.window;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;

import org.jebtk.core.ColorUtils;

import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.event.ModernClickEvent;
import dev.antonyholmes.modern.event.ModernClickListener;

/**
 * The class ModernWindowTitleBarCloseButton.
 */
public class ModernWindowTitleBarMinRoundButton extends ModernWindowTitleBarRoundButton implements ModernClickListener {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /** The Constant COLOR. */
  private static final Color COLOR = ColorUtils.decodeHtmlColor("#ffdd55");

  /** The m window. */
  private ModernWindow mWindow;

  /**
   * Instantiates a new modern window title bar close button.
   *
   * @param window the window
   */
  public ModernWindowTitleBarMinRoundButton(ModernWindow window) {
    super(COLOR);

    mWindow = window;

    setClickMessage(UI.MENU_MINIMIZE);
    addClickListener(this);

    setToolTip("Minimize", "Minimize the window.");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.event.ModernClickListener#clicked(org.abh.common.ui.
   * event. ModernClickEvent)
   */
  @Override
  public void clicked(ModernClickEvent e) {
    mWindow.setState(Frame.ICONIFIED);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.button.ModernButton#drawForegroundAA(java.awt.
   * Graphics2D)
   */
  @Override
  public void drawForegroundAA(Graphics2D g2) {
    if (mHighlight) {
      g2.setColor(Color.BLACK);

      int x = (getWidth() - 6) / 2;
      int y = getHeight() / 2;

      g2.drawLine(x, y, x + 5, y);
    }
  }
}
