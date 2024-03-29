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
package dev.antonyholmes.modern.text;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.clipboard.ClipboardSharedMenu;
import dev.antonyholmes.modern.event.ModernClickEvent;
import dev.antonyholmes.modern.event.ModernClickListener;
import dev.antonyholmes.modern.menu.ModernPopupMenu;

// TODO: Auto-generated Javadoc
/**
 * The class ModernClipboardPasswordField.
 */
public class ModernClipboardPasswordField extends ModernPasswordField implements MouseListener, ModernClickListener {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The popup.
   */
  private ModernPopupMenu popup;

  /**
   * The cut enabled.
   */
  private boolean cutEnabled = true;

  /**
   * The paste enabled.
   */
  // private boolean copyEnabled = true;
  private boolean pasteEnabled = true;

  /**
   * Instantiates a new modern clipboard password field.
   */
  public ModernClipboardPasswordField() {

  }

  /**
   * Instantiates a new modern clipboard password field.
   *
   * @param cutEnabled   the cut enabled
   * @param copyEnabled  the copy enabled
   * @param pasteEnabled the paste enabled
   */
  public ModernClipboardPasswordField(boolean cutEnabled, boolean copyEnabled, boolean pasteEnabled) {

    this.cutEnabled = cutEnabled;
    // this.copyEnabled = copyEnabled;
    this.pasteEnabled = pasteEnabled;
  }

  /**
   * Instantiates a new modern clipboard password field.
   *
   * @param text the text
   */
  public ModernClipboardPasswordField(String text) {

    super(text);
  }

  /**
   * Instantiates a new modern clipboard password field.
   *
   * @param text         the text
   * @param cutEnabled   the cut enabled
   * @param copyEnabled  the copy enabled
   * @param pasteEnabled the paste enabled
   */
  public ModernClipboardPasswordField(String text, boolean cutEnabled, boolean copyEnabled, boolean pasteEnabled) {

    super(text);

    this.cutEnabled = cutEnabled;
    // this.copyEnabled = copyEnabled;
    this.pasteEnabled = pasteEnabled;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
   */
  public final void mousePressed(MouseEvent e) {
    showPopup(e);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
   */
  public final void mouseReleased(MouseEvent e) {
    showPopup(e);
  }

  /**
   * Show popup.
   *
   * @param e the e
   */
  private void showPopup(MouseEvent e) {

    if (e.isPopupTrigger()) {
      // cutModernMenuItem.setEnabled(cutEnabled && this.isEditable());
      // copyModernMenuItem.setEnabled(copyEnabled);
      // pasteModernMenuItem.setEnabled(pasteEnabled && this.isEditable());

      popup = ClipboardSharedMenu.getInstance().getMenu(this, cutEnabled && this.isEditable(), true,
          pasteEnabled && this.isEditable());

      popup.showPopup(e.getComponent(), e.getX(), e.getY());
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
   */
  public final void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
   */
  public final void mouseEntered(MouseEvent e) {
    // setBorder(BorderFactory.createCompoundBorder(BorderService.getInstance().createLineBorder(HIGHLIGHT_COLOR),
    // Ui.SMALL_WIDGET_BORDER));
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
   */
  public final void mouseExited(MouseEvent e) {
    // setBorder(BorderFactory.createCompoundBorder(BorderService.getInstance().createLineBorder(NON_HIGHLIGHT_COLOR),
    // Ui.SMALL_WIDGET_BORDER));
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.event.ModernClickListener#clicked(org.abh.lib.ui.
   * modern .event.ModernClickEvent)
   */
  public final void clicked(ModernClickEvent e) {
    if (e.getMessage().equals(UI.MENU_SELECT_ALL)) {
      selectAll();
    } else if (e.getMessage().equals(UI.MENU_CUT)) {
      this.cut();
    } else if (e.getMessage().equals(UI.MENU_COPY)) {
      // setClipboardContents(getSelectedText());
      this.copy();
    } else if (e.getMessage().equals(UI.MENU_PASTE)) {
      // getClipboardContents();
      this.paste();
    } else {
      // do nothing
    }
  }
}
