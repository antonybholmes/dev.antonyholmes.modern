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
package dev.antonyholmes.modern.menu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JMenu;

import dev.antonyholmes.modern.event.ModernClickEvent;
import dev.antonyholmes.modern.event.ModernClickEventProducer;
import dev.antonyholmes.modern.event.ModernClickListener;
import dev.antonyholmes.modern.event.ModernClickListeners;

// TODO: Auto-generated Javadoc
/**
 * A popup is a component that will appear in a popup window.
 * 
 * @author Antony Holmes
 *
 */
public class ModernMenu extends JMenu implements ModernClickEventProducer, ModernClickListener {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The member listeners.
   */
  private ModernClickListeners mListeners = new ModernClickListeners();

  /**
   * Instantiates a new modern menu.
   */
  public ModernMenu() {
    setup();
  }

  /**
   * Instantiates a new modern menu.
   *
   * @param text the text
   */
  public ModernMenu(String text) {
    super(text);

    setup();
  }

  /**
   * Adds the.
   *
   * @param item the item
   */
  public void add(ModernMenuItem item) {
    addMenuItem(item);
  }

  /**
   * Adds the menu item.
   *
   * @param item the item
   */
  public void addMenuItem(ModernMenuItem item) {
    super.add(item);

    item.addClickListener(this);
  }

  /**
   * Setup.
   */
  public void setup() {
    setBackground(Color.WHITE);
    setOpaque(true);
    setBorder(BorderFactory.createEmptyBorder());
    setAlignmentX(LEFT_ALIGNMENT);
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
   */
  @Override
  public void paintComponent(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, getWidth(), getHeight());
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.event.ModernClickEventProducer#addClickListener(org.
   * abh .lib.ui.modern.event.ModernClickListener)
   */
  @Override
  public void addClickListener(ModernClickListener l) {
    mListeners.addClickListener(l);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.event.ModernClickEventProducer#removeClickListener(
   * org. abh.lib.ui.modern.event.ModernClickListener)
   */
  @Override
  public void removeClickListener(ModernClickListener l) {
    mListeners.removeClickListener(l);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.event.ModernClickEventProducer#fireClicked(org.abh.
   * lib. ui.modern.event.ModernClickEvent)
   */
  @Override
  public void fireClicked(ModernClickEvent e) {
    mListeners.fireClicked(e); // new ModernClickEvent(this, e.getMessage()));
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.event.ModernClickListener#clicked(org.abh.lib.ui.
   * modern .event.ModernClickEvent)
   */
  @Override
  public void clicked(ModernClickEvent e) {
    fireClicked(e);
  }
}
