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
package dev.antonyholmes.modern.tree;

import java.util.EventListener;

import dev.antonyholmes.modern.tree.ModernTreeEvent;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving treeEvent events. The class that is
 * interested in processing a treeEvent event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addTreeEventListener<code> method. When the treeEvent event
 * occurs, that object's appropriate method is invoked.
 *
 * @see TreeEventEvent
 */
public interface TreeEventListener extends EventListener {

  /**
   * Tree node dragged.
   *
   * @param e the e
   */
  public void treeNodeDragged(ModernTreeEvent e);

  /**
   * Tree node clicked.
   *
   * @param e the e
   */
  public void treeNodeClicked(ModernTreeEvent e);

  /**
   * Tree node double clicked.
   *
   * @param e the e
   */
  public void treeNodeDoubleClicked(ModernTreeEvent e);
}