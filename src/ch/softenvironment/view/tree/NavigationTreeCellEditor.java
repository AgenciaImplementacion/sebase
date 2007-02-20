package ch.softenvironment.view.tree;
/*
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

import java.awt.Component;

import javax.swing.JTree;

/**
 * TreeCellEditor for a navigation tree node.
 * 
 * @author Peter Hirzel <i>soft</i>Environment 
 * @version $Revision: 1.2 $ $Date: 2007-02-20 12:45:07 $
 */
public class NavigationTreeCellEditor extends javax.swing.tree.DefaultTreeCellEditor {
    public NavigationTreeCellEditor(AutoScrollingTree tree, NavigationTreeCellRenderer renderer) {
        super(tree, renderer);
    }
    /**
     * Overwrites.
     */
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row) {
        if (tree instanceof AutoScrollingTree) {
            return super.getTreeCellEditorComponent(tree,
                ((AutoScrollingTree)tree).getUtility().getName(value), 
                selected, expanded, leaf, row);
        }
        throw new IllegalArgumentException("tree must be an AutoScrollingTree!");
    }
}