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
import java.awt.geom.GeneralPath;

import org.jebtk.core.Props;
import org.jebtk.core.settings.SettingsService;

/**
 * Down arrow vector icon for combobox buttons etc.
 * 
 * @author Antony Holmes
 *
 */
public class ExpandVectorIcon extends ModernVectorIcon {

  /**
   * The constant COLOR.
   */
  private static final Color COLOR = SettingsService.getInstance()
      .getColor("theme.icons.expand-icon.colors.foreground");

  /**
   * The constant SCALE.
   */
  private static final double SCALE = SettingsService.getInstance().getDouble("theme.icons.expand-icon.width-scale");

  /**
   * The constant HEIGHT_SCALE.
   */
  private static final double HEIGHT_SCALE = SettingsService.getInstance()
      .getDouble("theme.icons.expand-icon.height-scale");

  /**
   * The constant OFFSET.
   */
  private static final double OFFSET = SettingsService.getInstance().getDouble("theme.icons.expand-icon.offset");

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.icons.ModernIcon#drawForeground(java.awt.Graphics2D,
   * java.awt.Rectangle)
   */
  @Override
  public void drawIcon(Graphics2D g2, int x, int y, int w, int h, Props props) {

    double wf = w * SCALE;
    double w2 = wf / 2.0;
    double offset = w * OFFSET;
    double hf = wf * HEIGHT_SCALE;
    double xf = x + (w - wf) / 2.0;
    double yf = h / 2.0;

    g2.setColor(COLOR);
    GeneralPath gp;

    // upper triangle

    gp = new GeneralPath();

    gp.moveTo(xf, yf - offset);
    gp.lineTo(xf + wf, yf - offset);
    gp.lineTo(xf + w2, yf - offset - h);
    gp.closePath();
    g2.fill(gp);

    // Lower triangle

    gp = new GeneralPath();

    gp.moveTo(xf, yf + offset);
    gp.lineTo(xf + wf, yf + offset);
    gp.lineTo(xf + w2, yf + offset + hf);
    gp.closePath();
    g2.fill(gp);
  }

}
