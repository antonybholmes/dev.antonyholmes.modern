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
package dev.antonyholmes.modern.help;

import java.io.IOException;

import javax.swing.Box;

import org.jebtk.core.Resources;

import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.button.ModernButton;
import dev.antonyholmes.modern.dialog.ModernDialogMultiCardWindow;
import dev.antonyholmes.modern.dialog.ModernDialogTaskType;
import dev.antonyholmes.modern.dialog.ModernDialogWindow;
import dev.antonyholmes.modern.dialog.ModernTextDialog;
import dev.antonyholmes.modern.event.ModernClickEvent;
import dev.antonyholmes.modern.event.ModernClickListener;
import dev.antonyholmes.modern.panel.HBox;
import dev.antonyholmes.modern.panel.ModernImagePanel;
import dev.antonyholmes.modern.panel.VBox;
import dev.antonyholmes.modern.ribbon.RibbonButton;
import dev.antonyholmes.modern.scrollpane.ModernScrollPane;
import dev.antonyholmes.modern.scrollpane.ScrollBarPolicy;
import dev.antonyholmes.modern.text.ModernAutoSizeLabel;
import dev.antonyholmes.modern.text.ModernSubTitleLabel;
import dev.antonyholmes.modern.text.ModernTextArea;
import dev.antonyholmes.modern.text.ModernTitleLabel;
import dev.antonyholmes.modern.window.ModernWindow;

/**
 * The class ModernAboutDialog.
 */
public class ModernAboutDialog extends ModernDialogMultiCardWindow {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /** The m help button. */
  private ModernButton mHelpButton;

  /** The m license button. */
  private ModernButton mLicenseButton = new RibbonButton("License");

  /** The m changes button. */
  private ModernButton mChangesButton = new RibbonButton("Changes");

  /**
   * Instantiates a new modern about dialog.
   *
   * @param parent  the parent
   * @param product the product
   */
  public ModernAboutDialog(ModernWindow parent, final GuiAppInfo product) {
    super(parent, "About " + product.getName(), ModernDialogTaskType.CLOSE);

    // setBackground(ModernDialogWindow.DIALOG_BACKGROUND_1);

    // setTitle("About " + product.getName());

    // Box content = VBox.create();

    Box box = HBox.create();

    ModernImagePanel image = new ModernImagePanel(product.getIcon(), 128);

    image.setAlignmentY(TOP_ALIGNMENT);
    box.add(image);

    box.add(UI.createHGap(20));

    Box box2 = VBox.create();
    box2.setAlignmentY(TOP_ALIGNMENT);

    box2.add(new ModernTitleLabel(product.getName()));

    if (product.getDescription() != null) {
      box2.add(UI.createVGap(5));
      box2.add(new ModernSubTitleLabel(product.getDescription().replaceFirst("\\.$", "")));
    }

    box2.add(UI.createVGap(10));
    box2.add(new ModernAutoSizeLabel(product.getCopyright()));
    box2.add(UI.createVGap(10));
    box2.add(new ModernAutoSizeLabel("Version " + product.getVersion().toString()));
    box2.add(UI.createVGap(50));

    Box box3 = HBox.create();

    mHelpButton = new RibbonHelpLinkButton(product);

    box3.add(mHelpButton);
    // box3.add(UI.createHGap(5));
    // box3.add(mLicenseButton);
    // box3.add(UI.createHGap(5));
    // box3.add(mChangesButton);

    box2.add(box3);

    box.add(box2);

    // content.add(box);

    // content.setBorder(BorderService.getInstance().createBorder(20));

    // setContent(content);

    addTab(UI.MENU_ABOUT, box);

    try {
      String text = Resources.loadText("res/license.txt");

      ModernScrollPane scrollPane = new ModernScrollPane(new ModernTextArea(text));

      scrollPane.setVerticalScrollBarPolicy(ScrollBarPolicy.ALWAYS);

      addTab(UI.MENU_LICENSE, scrollPane);
    } catch (IOException e2) {
      e2.printStackTrace();
    }

    //
    // Buttons
    //

    mLicenseButton.addClickListener(new ModernClickListener() {

      @Override
      public void clicked(ModernClickEvent e) {

        try {
          ModernTextDialog dialog = new ModernTextDialog(mParent, "License", Resources.loadText("res/license.txt"));

          dialog.setVisible(true);

        } catch (IOException e1) {
          e1.printStackTrace();
        }

      }
    });

    mChangesButton.addClickListener(new ModernClickListener() {

      @Override
      public void clicked(ModernClickEvent e) {

        try {
          ModernTextDialog dialog = new ModernTextDialog(mParent, "Changes", Resources
              .loadText(new StringBuilder("res/").append(product.getHelpName()).append(".changes.txt").toString()));

          dialog.setVisible(true);

        } catch (IOException e1) {
          e1.printStackTrace();
        }

      }
    });

    getTabsModel().changeTab(0);

    setSize(800, 500);

    UI.centerWindowToScreen(this);
  }

  /**
   * Create a default centered about dialog.
   *
   * @param parent         the parent
   * @param productDetails the product details
   */
  public static void show(ModernWindow parent, GuiAppInfo productDetails) {
    ModernDialogWindow dialog = new ModernAboutDialog(parent, productDetails);

    UI.centerWindowToScreen(dialog);

    dialog.setVisible(true);
  }
}
