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

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import javax.swing.Box;

import org.jebtk.core.collections.CollectionUtils;
import org.jebtk.core.io.PathUtils;
import dev.antonyholmes.modern.io.FileDialog;
import dev.antonyholmes.modern.io.GuiFileExtFilter;
import dev.antonyholmes.modern.io.RecentFilesService;

import dev.antonyholmes.modern.AssetService;
import dev.antonyholmes.modern.ModernComponent;
import dev.antonyholmes.modern.ModernWidget;
import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.button.ModernButton;
import dev.antonyholmes.modern.button.ModernOutlineButton;
import dev.antonyholmes.modern.event.ModernClickEvent;
import dev.antonyholmes.modern.event.ModernClickListener;
import dev.antonyholmes.modern.graphics.icons.FolderVectorIcon;
import dev.antonyholmes.modern.panel.HBox;
import dev.antonyholmes.modern.text.ModernTextBorderPanel;
import dev.antonyholmes.modern.text.ModernTextField;
import dev.antonyholmes.modern.window.ModernWindow;

/**
 * The Class ChooseFilePanel.
 */
public class ChooseFilePanel extends ModernComponent {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  private static List<GuiFileExtFilter> EMPTY_FILTERS = Collections.emptyList();

  /** The m file field. */
  private ModernTextField mFileField = new ModernTextField();

  /** The m choose button. */
  private ModernButton mChooseButton = new ModernOutlineButton(
      AssetService.getInstance().loadIcon(FolderVectorIcon.class, 16));

  // private ModernButton mDeleteButton =
  // new ModernButton(UIService.getInstance().loadIcon(DeleteVectorIcon.class,
  // 16));

  /** The m parent. */
  private ModernWindow mParent;

  /** The m dir mode. */
  private boolean mDirMode;

  /** The m file. */
  private Path mFile;

  /** The m filters. */
  private List<GuiFileExtFilter> mFilters;

  /**
   * Instantiates a new choose file panel.
   *
   * @param parent  the parent
   * @param filters the filters
   */
  public ChooseFilePanel(ModernWindow parent, GuiFileExtFilter filter, GuiFileExtFilter... filters) {
    this(parent, false, filter, filters);
  }

  public ChooseFilePanel(ModernWindow parent, boolean dirMode, GuiFileExtFilter filter, GuiFileExtFilter... filters) {
    this(parent, dirMode, CollectionUtils.toList(filter, filters));
  }

  public ChooseFilePanel(ModernWindow parent, boolean dirMode) {
    this(parent, dirMode, EMPTY_FILTERS);
  }

  /**
   * Instantiates a new choose file panel.
   *
   * @param parent  the parent
   * @param dirMode the dir mode
   * @param filters the filters
   */
  public ChooseFilePanel(ModernWindow parent, boolean dirMode, List<GuiFileExtFilter> filters) {
    mParent = parent;
    mDirMode = dirMode;
    mFilters = filters;

    setBody(new ModernTextBorderPanel(mFileField));

    Box box = HBox.create();
    box.add(UI.createHGap(5));
    box.add(mChooseButton);
    // box.add(UI.createHGap(5));
    // box.add(mDeleteButton);

    setRight(box);

    mChooseButton.addClickListener(new ModernClickListener() {

      @Override
      public void clicked(ModernClickEvent e) {
        Path pwd = RecentFilesService.getInstance().getPwd();

        Path file = null;

        if (mDirMode) {
          file = FileDialog.open(mParent).dirs().getFile(pwd);
        } else {
          file = FileDialog.open(mParent).filter(mFilters).multiSelect(false).getFile(pwd);
        }

        if (file != null) {
          setFile(file);

          RecentFilesService.getInstance().setPwd(file.getParent());
        }
      }
    });

    /*
     * mDeleteButton.addClickListener(new ModernClickListener() {
     * 
     * @Override public void clicked(ModernClickEvent e) { mFile = null;
     * mFileField.setText(TextUtils.EMPTY_STRING); }});
     */

    mFileField.setEditable(false);

    UI.setSize(this, ModernWidget.MAX_SIZE);
  }

  /**
   * Instantiates a new choose file panel.
   *
   * @param parent  the parent
   * @param dirMode the dir mode
   * @param file    the file
   * @param filters the filters
   */
  public ChooseFilePanel(ModernWindow parent, boolean dirMode, Path file, GuiFileExtFilter filter,
      GuiFileExtFilter... filters) {
    this(parent, dirMode, filter, filters);

    setFile(file);
  }

  public ChooseFilePanel(ModernWindow parent, boolean dirMode, Path file, List<GuiFileExtFilter> filters) {
    this(parent, dirMode, filters);

    setFile(file);
  }

  /**
   * Gets the file.
   *
   * @return the file
   */
  public Path getFile() {
    return mFile;
  }

  /**
   * Sets the file.
   *
   * @param file the new file
   */
  public void setFile(Path file) {
    if (file != null) {
      mFile = file;

      mFileField.setText(PathUtils.toString(file));
    }
  }
}
