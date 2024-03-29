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
package dev.antonyholmes.modern.dataview;

import java.util.HashMap;
import java.util.Map;

import org.jebtk.core.event.ChangeEvent;

// TODO: Auto-generated Javadoc
/**
 * Generic model for storing objects associated with cells. Since we don't
 * actually want to associate objects with every cell to save memory, we lazily
 * assign objects as necessary and use a default for all cells that do not have
 * an assignment. We further allow row and column association so that individual
 * cells do not need an object.
 *
 * @author Antony Holmes
 * @param <T> the generic type
 */
public class ModernData1DModel<T> extends ModernDataViewListeners {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The member default object.
   */
  private T mDefaultObject;

  /**
   * The member row level map.
   */
  private Map<Integer, T> m1dMap = new HashMap<Integer, T>();

  /**
   * Instantiates a new modern data cell model.
   *
   * @param defaultObject the default object
   */
  public ModernData1DModel(T defaultObject) {
    setDefault(defaultObject);
  }

  /**
   * Sets the default.
   *
   * @param defaultObject the new default
   */
  public void setDefault(T defaultObject) {
    mDefaultObject = defaultObject;

    fireDataUpdated(new ChangeEvent(this));
  }

  /**
   * Gets the.
   *
   * @param index the row
   * @return the t
   */
  public T get(int index) {
    if (m1dMap.containsKey(index)) {
      return m1dMap.get(index);
    } else {
      return mDefaultObject;
    }
  }

  /**
   * Sets the row.
   *
   * @param index the row
   * @param o     the o
   */
  public void set(int index, T o) {
    if (!m1dMap.containsKey(index)) {
      m1dMap.put(index, o);
    }

    fireDataUpdated(new ChangeEvent(this));
  }
}
