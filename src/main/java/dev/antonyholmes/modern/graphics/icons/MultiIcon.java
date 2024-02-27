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

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.jebtk.core.Props;
import dev.antonyholmes.modern.graphics.icons.ModernIcon;

/**
 * The class MultiIcon.
 */
public class MultiIcon extends ModernIcon {

  /**
   * The member icons.
   */
  private List<ModernIcon> mIcons = new ArrayList<ModernIcon>();

  /**
   * The member icon.
   */
  private ModernIcon mIcon;

  /**
   * Adds the icon.
   *
   * @param icon the icon
   */
  public void addIcon(ModernIcon icon) {
    mIcons.add(icon);

    setIcon(mIcons.size() - 1);
  }

  /**
   * Sets the icon.
   *
   * @param index the new icon
   */
  public void setIcon(int index) {
    mIcon = mIcons.get(index);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.icons.ModernIcon#drawForeground(java.awt.Graphics2D,
   * java.awt.Rectangle)
   */
  @Override
  public void drawIcon(Graphics2D g2, int x, int y, int w, int h, Props props) {
    mIcon.drawIcon(g2, x, y, w, h);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.icons.ModernIcon#getWidth()
   */
  @Override
  public int getWidth() {
    return mIcon.getWidth();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.icons.ModernIcon#getHeight()
   */
  @Override
  public int getHeight() {
    return mIcon.getHeight();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.icons.ModernIcon#getImage()
   */
  @Override
  public BufferedImage getImage(int w, Props props) {
    return mIcon.getImage(w, props);
  }

}