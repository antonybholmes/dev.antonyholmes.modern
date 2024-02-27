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
package dev.antonyholmes.modern.search;

import javax.swing.Box;

import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.button.ButtonsBox;
import dev.antonyholmes.modern.button.ModernButton;
import dev.antonyholmes.modern.dialog.ModernDialogButton;
import dev.antonyholmes.modern.dialog.ModernDialogStatus;
import dev.antonyholmes.modern.dialog.ModernDialogTaskWindow;
import dev.antonyholmes.modern.event.ModernClickEvent;
import dev.antonyholmes.modern.event.ModernClickListener;
import dev.antonyholmes.modern.panel.HBox;
import dev.antonyholmes.modern.panel.ModernPanel;
import dev.antonyholmes.modern.panel.VBox;
import dev.antonyholmes.modern.text.ModernAutoSizeLabel;
import dev.antonyholmes.modern.text.ModernTextBorderPanel;
import dev.antonyholmes.modern.text.ModernTextField;
import dev.antonyholmes.modern.window.ModernWindow;
import dev.antonyholmes.modern.window.WindowWidgetFocusEvents;

/**
 * User can enter an integer option value.
 * 
 * @author Antony Holmes
 *
 */
public class ModernFindDialog extends ModernDialogTaskWindow implements ModernClickListener {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The member find next.
   */
  private ModernButton mFindNext = new ModernDialogButton("Find Next");

  /**
   * The member text.
   */
  private ModernTextField mText = new ModernTextField();

  /**
   * Instantiates a new modern find dialog.
   *
   * @param parent the parent
   */
  public ModernFindDialog(ModernWindow parent) {
    super(parent, false);

    setTitle("Find");

    setup();

    createUi();

  }

  /**
   * Setup.
   */
  private void setup() {
    mFindNext.addClickListener(this);

    setSize(480, 240);

    setResizable(true);

    UI.centerWindowToScreen(this);

    addWindowFocusListener(new WindowWidgetFocusEvents(mText));
  }

  /**
   * Creates the ui.
   */
  public final void createUi() {
    Box box = VBox.create();

    Box box2 = HBox.create();

    box2.add(new ModernAutoSizeLabel("Find what:"));
    box2.add(UI.createHGap(20));

    ModernTextBorderPanel panel = new ModernTextBorderPanel(mText);

    panel.setMaximumSize(ModernWidget.MAX_SIZE);

    box2.add(panel);

    box.add(box2);

    // ModernComponent panel = new ModernComponent(new GridBagLayout());

    // panel.add(new ModernTextBorderPanel(mText,
    // ModernWidget.EXTRA_LARGE_SIZE));

    setContent(box);

    Box buttonPanel = new ButtonsBox();

    buttonPanel.add(mFindNext);
    buttonPanel.add(ModernPanel.createHGap());
    buttonPanel.add(mCancelButton);

    setButtons(buttonPanel);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.event.ModernClickListener#clicked(org.abh.lib.ui.
   * modern .event.ModernClickEvent)
   */
  public final void clicked(ModernClickEvent e) {
    if (e.getSource().equals(mFindNext)) {
      setStatus(ModernDialogStatus.OK);
    } else {

    }

    close();
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public String getText() {
    return mText.getText();
  }

  /**
   * Gets the case sensitive.
   *
   * @return the case sensitive
   */
  public boolean getCaseSensitive() {
    return false;
  }
}
