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
package dev.antonyholmes.modern.dialog;

import dev.antonyholmes.modern.button.ModernDropDownButton;
import dev.antonyholmes.modern.graphics.icons.ModernIcon;
import dev.antonyholmes.modern.menu.ModernPopupMenu;

// TODO: Auto-generated Javadoc
/**
 * Flat button for dialogs.
 *
 * @author Antony Holmes
 *
 */
public class ModernOutlinedDialogButton extends ModernDropDownButton {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new modern dialog flat button.
   *
   * @param text1 the text1
   */
  public ModernOutlinedDialogButton(String text1) {
    super(text1);

    setup();
  }

  /**
   * Instantiates a new modern dialog flat button.
   *
   * @param icon the icon
   */
  public ModernOutlinedDialogButton(ModernIcon icon) {
    super(icon);

    setup();
  }

  /**
   * Instantiates a new modern dialog flat button.
   *
   * @param text1 the text1
   * @param icon  the icon
   */
  public ModernOutlinedDialogButton(String text1, ModernIcon icon) {
    super(text1, icon);

    setup();
  }

  /**
   * Instantiates a new modern dialog flat drop down button.
   *
   * @param icon the icon
   * @param menu the menu
   */
  public ModernOutlinedDialogButton(ModernIcon icon, ModernPopupMenu menu) {
    super(icon, menu);

    setup();
  }

  /**
   * Instantiates a new modern dialog flat drop down button.
   *
   * @param text1 the text 1
   * @param icon  the icon
   * @param menu  the menu
   */
  public ModernOutlinedDialogButton(String text1, ModernIcon icon, ModernPopupMenu menu) {
    super(text1, icon, menu);

    setup();
  }

  /**
   * Instantiates a new modern dialog flat drop down button.
   *
   * @param text1 the text 1
   * @param menu  the menu
   */
  public ModernOutlinedDialogButton(String text1, ModernPopupMenu menu) {
    super(text1, menu);

    setup();
  }

  private void setup() {
    addStyleClass("outlined-dialog-button");

    // setAnimations(new FlatDropDownButtonAnimation(this));
  }

  /*
   * @Override public void drawBackgroundAA(Graphics2D g2) { if (isEnabled()) { if
   * (isSelected() || mHighlight || mPopupShown) {
   * getWidgetRenderer().drawButton(g2, mInternalRect, RenderMode.SELECTED,
   * hasFocus()); } else { getWidgetRenderer().drawContentBox(g2, mInternalRect);
   * } } }
   */
}
