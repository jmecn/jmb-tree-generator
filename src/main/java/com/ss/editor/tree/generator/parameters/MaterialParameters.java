package com.ss.editor.tree.generator.parameters;

import com.jme3.material.Material;
import com.simsilica.arboreal.Parameters;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * The implementation of parameters to configure material of a tree.
 *
 * @author JavaSaBr
 */
public class MaterialParameters extends Parameters {

    /**
     * The material change handler.
     */
    @NotNull
    private final Consumer<@NotNull Material> changeHandler;

    /**
     * The material sync handler.
     */
    @NotNull
    private final Supplier<@NotNull Material> syncHandler;

    /**
     * The material.
     */
    @NotNull
    private final Material material;

    /**
     * The material name.
     */
    @NotNull
    private final String name;

    public MaterialParameters(@NotNull final Consumer<@NotNull Material> changeHandler,
                              @NotNull final Supplier<@NotNull Material> syncHandler,
                              @NotNull final String name) {
        this.changeHandler = changeHandler;
        this.syncHandler = syncHandler;
        this.material = syncHandler.get();
        this.name = name;
    }

    /**
     * @return the material.
     */
    public @NotNull Material getMaterial() {
        return material;
    }

    /**
     * @return the material name.
     */
    public @NotNull String getName() {
        return name;
    }

    /**
     * @return the material change handler.
     */
    public @NotNull Consumer<@NotNull Material> getChangeHandler() {
        return changeHandler;
    }

    /**
     * @return the material sync handler.
     */
    public @NotNull Supplier<@NotNull Material> getSyncHandler() {
        return syncHandler;
    }
}