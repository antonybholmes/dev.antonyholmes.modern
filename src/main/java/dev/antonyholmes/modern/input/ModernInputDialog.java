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
package dev.antonyholmes.modern.input;

import javax.swing.Box;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.dialog.ModernDialogTaskWindow;
import dev.antonyholmes.modern.panel.VBox;
import dev.antonyholmes.modern.text.ModernAutoSizeLabel;
import dev.antonyholmes.modern.text.ModernTextBorderPanel;
import dev.antonyholmes.modern.text.ModernTextField;
import dev.antonyholmes.modern.window.ModernWindow;

/**
 * User can enter an integer option value.
 * 
 * @author Antony Holmes
 *
 */
public class ModernInputDialog extends ModernDialogTaskWindow {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The member text.
   */
  private ModernTextField mText = new ModernTextField();

  /**
   * Instantiates a new modern input dialog.
   *
   * @param parent  the parent
   * @param title   the title
   * @param message the message
   * @param text    the text
   */
  public ModernInputDialog(ModernWindow parent, String title, String message, String text) {
    super(parent);

    setTitle(title);

    setup(text);

    createUi(message);

  }

  /**
   * Setup.
   *
   * @param text the new up
   */
  private void setup(String text) {
    mText.setText(text);

    setSize(360, 160);

    setResizable(true);

    UI.centerWindowToScreen(this);
  }

  /**
   * Creates the ui.
   *
   * @param message the message
   */
  private final void createUi(String message) {
    Box box = VBox.create();

    box.add(new ModernAutoSizeLabel(message));
    box.add(UI.createVGap(10));
    box.add(new ModernTextBorderPanel(mText, ModernWidget.VERY_LARGE_SIZE));

    setContent(box);
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String getText() {
    return mText.getText();
  }

}
