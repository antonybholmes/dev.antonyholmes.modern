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
package dev.antonyholmes.modern.button;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.border.Border;

import dev.antonyholmes.modern.BorderService;
import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.panel.HBox;

// TODO: Auto-generated Javadoc
/**
 * Default layout for buttons in a dialog box.
 *
 * @author Antony Holmes
 */
public class ButtonsBox extends HBox {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /** The m left box. */
  private HBox mLeftBox = HBox.create();

  /** The m right box. */
  private HBox mRightBox = HBox.create();

  /** The Constant BORDER. */
  private static final Border BORDER = BorderService.getInstance().createBorder(ModernWidget.PADDING,
      ModernWidget.DOUBLE_PADDING, ModernWidget.DOUBLE_PADDING, ModernWidget.DOUBLE_PADDING); // ModernWidget.LARGE_BORDER

  /**
   * Instantiates a new buttons box2.
   */
  public ButtonsBox() {
    setBorder(BORDER);

    super.add(mLeftBox);
    super.add(Box.createHorizontalGlue());
    super.add(mRightBox);

    // this.setOpaque(false);
    // this.setBackground(Color.RED);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.Container#add(java.awt.Component)
   */
  @Override
  public Component add(Component c) {
    addRight(c);

    return c;
  }

  /**
   * Adds the left.
   *
   * @param c the c
   */
  public void addLeft(Component c) {
    mLeftBox.add(c);
  }

  /**
   * Adds the right.
   *
   * @param c the c
   */
  public void addRight(Component c) {
    mRightBox.add(c);
  }
}
