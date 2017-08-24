package com.ss.editor.tree.generator.tree.node;

import com.simsilica.arboreal.BranchParameters;
import com.simsilica.arboreal.TreeParameters;
import com.ss.editor.tree.generator.parameters.RootsParameters;
import com.ss.editor.ui.control.tree.NodeTree;
import com.ss.editor.ui.control.tree.node.TreeNode;
import com.ss.rlib.util.array.Array;
import com.ss.rlib.util.array.ArrayFactory;
import org.jetbrains.annotations.NotNull;

/**
 * The implementation of presentation roots parameters node in the {@link ParametersTreeNode}
 *
 * @author JavaSaBr
 */
public class RootsParametersTreeNode extends ParametersTreeNode<RootsParameters> {

    public RootsParametersTreeNode(@NotNull final RootsParameters element, final long objectId) {
        super(element, objectId);
    }

    @Override
    public @NotNull String getName() {
        return "Roots";
    }

    @Override
    public @NotNull Array<TreeNode<?>> getChildren(@NotNull final NodeTree<?> nodeTree) {

        final RootsParameters rootsParameters = getElement();
        final TreeParameters treeParameters = rootsParameters.getTreeParameters();

        final Array<TreeNode<?>> children = ArrayFactory.newArray(TreeNode.class);

        final BranchParameters[] roots = treeParameters.getRoots();
        for (final BranchParameters root : roots) {
            children.add(FACTORY_REGISTRY.createFor(root));
        }

        for (int i = 0; i < children.size(); i++) {
            final BranchParametersTreeNode node = (BranchParametersTreeNode) children.get(i);
            node.setName("Root #" + i);
        }

        return children;
    }

    @Override
    public boolean hasChildren(@NotNull final NodeTree<?> nodeTree) {
        return true;
    }
}
