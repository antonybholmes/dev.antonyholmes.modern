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
package dev.antonyholmes.modern.options;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

import org.jebtk.core.event.ChangeEvent;
import org.jebtk.core.path.Path;
import org.jebtk.core.settings.SettingsService;
import org.jebtk.core.tree.TreeNode;
import org.jebtk.core.tree.TreePath;

import dev.antonyholmes.modern.ModernComponent;
import dev.antonyholmes.modern.UI;
import dev.antonyholmes.modern.dataview.ModernDataGridCellEditor;
import dev.antonyholmes.modern.dialog.ModernDialogBorderPanel;
import dev.antonyholmes.modern.dialog.ModernDialogTaskWindow;
import dev.antonyholmes.modern.event.ModernClickEvent;
import dev.antonyholmes.modern.event.ModernSelectionListener;
import dev.antonyholmes.modern.help.GuiAppInfo;
import dev.antonyholmes.modern.panel.ModernPanel;
import dev.antonyholmes.modern.scrollpane.ModernScrollPane;
import dev.antonyholmes.modern.splitpane.HSplitPane;
import dev.antonyholmes.modern.splitpane.ModernHSplitPaneLine;
import dev.antonyholmes.modern.table.ModernRowTable;
import dev.antonyholmes.modern.text.ModernAutoSizeLabel;
import dev.antonyholmes.modern.tree.ModernTree;
import dev.antonyholmes.modern.tree.PathTree;
import dev.antonyholmes.modern.window.ModernWindow;

/**
 * Allow users to look at and modify program settings.
 * 
 * @author Antony Holmes
 *
 */
public class ModernOptionsDialog extends ModernDialogTaskWindow implements ModernSelectionListener {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The member table.
   */
  private ModernRowTable mTable;

  /**
   * The member tree.
   */
  private ModernTree<List<Path>> mTree = new ModernTree<List<Path>>();

  /**
   * The tree label.
   */
  private ModernAutoSizeLabel treeLabel = new ModernAutoSizeLabel("");

  /**
   * Instantiates a new modern options dialog.
   *
   * @param parent  the parent
   * @param details the details
   */
  public ModernOptionsDialog(ModernWindow parent, GuiAppInfo details) {
    super(parent);

    setTitle(details.getName() + " Options");

    // setResizable(false);

    setSize(800, 600);

    try {
      setup();
    } catch (IOException e) {
      e.printStackTrace();
    }

    createUi();
  }

  /**
   * Setup.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  private void setup() throws IOException {
    createUi();

    createTree();

    mTree.selectNode(0);
  }

  /**
   * Creates the ui.
   */
  private final void createUi() {
    ModernComponent content = new ModernComponent();

    ModernScrollPane scrollPane1 = new ModernScrollPane(mTree);

    mTable = new ModernRowTable();
    ModernScrollPane scrollPane2 = new ModernScrollPane(mTable);

    HSplitPane splitPane = new ModernHSplitPaneLine();
    splitPane.addComponent(scrollPane1, 0.2);
    splitPane.addComponent(scrollPane2, 0.8);

    // splitPane.setDividerLocation(200);

    content.add(new ModernDialogBorderPanel(splitPane), BorderLayout.CENTER);

    setBody(content);

    getButtonBar().addLeft(ModernPanel.createHGap());
    getButtonBar().addLeft(treeLabel);

  }

  /**
   * Creates the tree.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  private void createTree() throws IOException {
    List<Path> paths = new ArrayList<Path>();

    for (Path path : SettingsService.getInstance()) {
      paths.add(path);
    }

    mTree = new PathTree(paths, false);

    mTree.addSelectionListener(this);

    mTree.selectNode(0);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.abh.lib.ui.modern.event.ModernClickListener#clicked(org.abh.lib.ui.
   * modern .event.ModernClickEvent)
   */
  @Override
  public final void clicked(ModernClickEvent e) {
    if (e.getMessage().equals(UI.BUTTON_OK)) {
      save();
    }

    super.clicked(e);
  }

  /**
   * Save.
   */
  private void save() {
    SettingsService.getInstance().save();
  }

  /**
   * Sets the table model.
   *
   * @param node the new table model
   */
  private void setTableModel(TreeNode<List<Path>> node) {
    ModernSettingsTableModel tableModel = new ModernSettingsTableModel(node);

    mTable.setModel(tableModel);
    mTable.getEditorModel().setCol(1, new ModernDataGridCellEditor(true));
    mTable.getColumnModel().setWidth(0, 200);
    mTable.getColumnModel().setWidth(1, 200);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.abh.lib.ui.modern.event.ModernSelectionListener#selectionChanged(org.
   * abh. lib.event.ChangeEvent)
   */
  @Override
  public void selectionAdded(ChangeEvent e) {
    selectionRemoved(e);
  }

  @Override
  public void selectionRemoved(ChangeEvent e) {
    if (mTree.getSelectedNode() == null) {
      return;
    }

    TreeNode<List<Path>> node = mTree.getSelectedNode();

    TreePath treePath = node.getPath();

    Path path = mTree.convertToPath(treePath);

    treeLabel.setText(path.toString());

    if (mTree.getSelectedNode().getValue() != null) {
      setTableModel(node);
    } else {
      setTableModel(new TreeNode<List<Path>>(""));
    }
  }

  /**
   * Sets the visible.
   *
   * @param parent  the parent
   * @param details the details
   */
  public static void setVisible(ModernWindow parent, GuiAppInfo details) {
    JDialog dialog = new ModernOptionsDialog(parent, details);

    UI.centerWindowToScreen(dialog);

    dialog.setVisible(true);
  }
}
