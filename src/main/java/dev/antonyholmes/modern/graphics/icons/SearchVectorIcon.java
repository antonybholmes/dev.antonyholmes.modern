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

import dev.antonyholmes.modern.graphics.ImageUtils;

/**
 * Search vector icon.
 * 
 * @author Antony Holmes
 *
 */
public class SearchVectorIcon extends ModernVectorIcon {

  /**
   * The constant COLOR.
   */
  private static final Color COLOR = Color.BLACK; // SettingsService.getInstance().getColor("theme.icons.search-icon.colors.foreground");

  /**
   * The constant SCALE.
   */
  private static final double SCALE = SettingsService.getInstance().getDouble("theme.icons.search-icon.width-scale");

  /**
   * The constant GLASS_SCALE.
   */
  private static final double GLASS_SCALE = SettingsService.getInstance()
      .getDouble("theme.icons.search-icon.glass-scale");

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.icons.ModernIcon#drawForeground(java.awt.Graphics2D,
   * java.awt.Rectangle)
   */
  @Override
  public void drawIcon(Graphics2D g2, int x, int y, int w, int h, Props props) {

    Graphics2D g2Temp = ImageUtils.createAAStrokeGraphics(g2);

    double wf = w * SCALE;

    double w2 = wf * GLASS_SCALE;

    double xf = x + (w - wf) / 2.0;
    double yf = y + (h - wf) / 2.0;

    try {
      // g2Temp.setStroke(ModernTheme.DOUBLE_LINE_STROKE);
      g2Temp.setColor(COLOR);

      double w3 = w2 / 2.0;

      g2Temp.drawLine((int) Math.round(xf + w3), (int) Math.round(yf + w3), (int) Math.round(xf + wf),
          (int) Math.round(yf + wf));

      g2Temp.setColor(Color.WHITE);
      g2Temp.fillOval((int) Math.round(xf), (int) Math.round(yf), (int) Math.round(w2), (int) Math.round(w2));
      g2Temp.setColor(COLOR);
      g2Temp.drawOval((int) Math.round(xf), (int) Math.round(yf), (int) Math.round(w2), (int) Math.round(w2));
    } finally {
      g2Temp.dispose();
    }
  }

}
