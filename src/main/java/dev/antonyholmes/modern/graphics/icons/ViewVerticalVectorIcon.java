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
package dev.antonyholmes.modern.graphics.icons;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jebtk.core.Props;
import org.jebtk.core.settings.SettingsService;

/**
 * The class ViewVerticalVectorIcon.
 */
public class ViewVerticalVectorIcon extends ModernVectorIcon {

  /**
   * The constant WIDTH_SCALE.
   */
  private static final double WIDTH_SCALE = SettingsService.getInstance()
      .getDouble("theme.icons.vertical-view-icon.width-scale");

  /**
   * The constant BOX_SCALE.
   */
  private static final double BOX_SCALE = SettingsService.getInstance()
      .getDouble("theme.icons.vertical-view-icon.box-scale");

  /**
   * The constant COLOR.
   */
  private static final Color COLOR = SettingsService.getInstance()
      .getColor("theme.icons.vertical-view-icon.colors.foreground");

  /**
   * The constant BACKGROUND.
   */
  private static final Color BACKGROUND = SettingsService.getInstance()
      .getColor("theme.icons.vertical-view-icon.colors.background");

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.icons.ModernIcon#drawForeground(java.awt.Graphics2D,
   * java.awt.Rectangle)
   */
  @Override
  public void drawIcon(Graphics2D g2, int x, int y, int w, int h, Props props) {
    double wf = w * WIDTH_SCALE;

    double bw = wf * BOX_SCALE;

    double xf = x + (w - wf) / 2.0;
    double yf = y + (h - wf) / 2.0;

    g2.setColor(BACKGROUND);

    g2.fillRect((int) Math.round(xf), (int) Math.round(yf), (int) Math.round(bw), (int) Math.round(wf));
    g2.fillRect((int) Math.round(xf + wf - bw), (int) Math.round(yf), (int) Math.round(bw), (int) Math.round(bw));
    g2.fillRect((int) Math.round(xf + wf - bw), (int) Math.round(yf + wf - bw), (int) Math.round(bw),
        (int) Math.round(bw));

    g2.setColor(COLOR);

    g2.drawRect((int) Math.round(xf), (int) Math.round(yf), (int) Math.round(bw), (int) Math.round(wf));
    g2.drawRect((int) Math.round(xf + wf - bw), (int) Math.round(yf), (int) Math.round(bw), (int) Math.round(bw));
    g2.drawRect((int) Math.round(xf + wf - bw), (int) Math.round(yf + wf - bw), (int) Math.round(bw),
        (int) Math.round(bw));

  }
}
