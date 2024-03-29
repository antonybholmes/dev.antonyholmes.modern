/**
 * Copyright 2017 Antony Holmes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.antonyholmes.modern.io;

/**
 * The Class TsvCsvGuiFileFilter.
 */
public class TxtTsvCsvGuiFileFilter extends GuiFileExtFilter {

  /**
   * Instantiates a new tsv csv gui file filter.
   */
  public TxtTsvCsvGuiFileFilter() {
    super("txt", "tsv", "csv");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.common.ui.io.GuiFileExtFilter#getDescription()
   */
  @Override
  public String getDescription() {
    return "All Table Files (*.txt;*.tsv;*.csv)";
  }

}
