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
package dev.antonyholmes.modern.contentpane;

import java.awt.Component;

import javax.swing.Box;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.panel.HBox;
import dev.antonyholmes.modern.text.ModernAutoSizeLabel;
import dev.antonyholmes.modern.text.ModernSubHeadingLabel;

/**
 * The class HTabToolbar2.
 */
public class HTabToolbar extends HBox {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  // private Box mBox = HBox.create();

  /**
   * Instantiates a new h tab toolbar2.
   *
   * @param title the title
   */
  public HTabToolbar(String title) {
    this(title, null);
  }

  /**
   * Instantiates a new h tab toolbar2.
   *
   * @param title the title
   * @param c     the c
   */
  public HTabToolbar(String title, Component c) {
    ModernAutoSizeLabel label = new ModernSubHeadingLabel(title);

    add(label);

    add(Box.createHorizontalGlue());

    if (c != null) {
      add(c);
    }

    // setBody(mBox);

    setBorder(ModernWidget.BORDER);
  }

  // @Override
  // public void drawBackground(Graphics2D g2) {
  // g2.setColor(LINE_COLOR);

  // int y = getHeight() - 1;

  // g2.drawLine(0, y, getWidth(), y);

  // fill(g2, LINE_COLOR);
  // }
}
