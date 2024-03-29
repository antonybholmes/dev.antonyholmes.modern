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
package dev.antonyholmes.modern.graphics;

/**
 * For classes that generate ModernClickEvents.
 *
 * @author Antony Holmes
 */
public interface CanvasMouseEventProducer {

  /**
   * Add an action listener.
   *
   * @param l the l
   */
  public void addCanvasMouseListener(CanvasMouseListener l);

  /**
   * Remove an action listener.
   *
   * @param l the l
   */
  public void removeCanvasMouseListener(CanvasMouseListener l);

  /**
   * Fire canvas mouse moved.
   *
   * @param e the e
   */
  public void fireCanvasMouseMoved(CanvasMouseEvent e);

  /**
   * Fire canvas mouse dragged.
   *
   * @param e the e
   */
  public void fireCanvasMouseDragged(CanvasMouseEvent e);

  /**
   * Fire canvas mouse clicked.
   *
   * @param e the e
   */
  public void fireCanvasMouseClicked(CanvasMouseEvent e);

  /**
   * Fire canvas mouse pressed.
   *
   * @param e the e
   */
  public void fireCanvasMousePressed(CanvasMouseEvent e);

  /**
   * Fire canvas mouse released.
   *
   * @param e the e
   */
  public void fireCanvasMouseReleased(CanvasMouseEvent e);

  /**
   * Fire canvas mouse entered.
   *
   * @param e the e
   */
  public void fireCanvasMouseEntered(CanvasMouseEvent e);

  /**
   * Fire canvas mouse exited.
   *
   * @param e the e
   */
  public void fireCanvasMouseExited(CanvasMouseEvent e);
}
