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
package dev.antonyholmes.modern.event;

import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.event.EventProducer;

/**
 * The basis for model controls in a model view controller setup.
 * 
 * @author Antony Holmes
 *
 */
public class ModernSelectionListeners extends EventProducer<ModernSelectionListener>
    implements ModernSelectionEventProducer {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.event.ModernSelectionEventProducer#
   * addSelectionListener (org.abh.lib.ui.modern.event.ModernSelectionListener)
   */
  @Override
  public void addSelectionListener(ModernSelectionListener l) {
    mListeners.add(l);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.event.ModernSelectionEventProducer#
   * removeSelectionListener(org.abh.lib.ui.modern.event. ModernSelectionListener)
   */
  @Override
  public void removeSelectionListener(ModernSelectionListener l) {
    mListeners.remove(l);
  }

  /*
   * @Override public void fireSelectionChanged(ChangeEvent e) { for
   * (ModernSelectionListener l : mListeners) { l.selectionChanged(e); } }
   */

  @Override
  public void fireSelectionAdded(ChangeEvent e) {
    for (ModernSelectionListener l : mListeners) {
      l.selectionAdded(e);
    }
  }

  @Override
  public void fireSelectionRemoved(ChangeEvent e) {
    for (ModernSelectionListener l : mListeners) {
      l.selectionRemoved(e);
    }
  }
}