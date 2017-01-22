package com.nexthoughts.command.mapping.oneToMany;


import com.nexthoughts.domain.mapping.onetomany.Tree;

public class TreeCommand {
    private Integer treeId;
    private String treeIdentity;
    private Integer forestId;

    public TreeCommand() {
    }

    public TreeCommand(String treeIdentity, ForestCommand forest) {
        this.treeIdentity = treeIdentity;
        this.forestId = forest.getForestId();
    }

    public TreeCommand(Tree tree) {
        this.treeId = tree.getTreeId();
        this.treeIdentity = tree.getTreeIdentity();
    }

    public Integer getTreeId() {
        return treeId;
    }

    public void setTreeId(Integer treeId) {
        this.treeId = treeId;
    }

    public String getTreeIdentity() {
        return treeIdentity;
    }

    public void setTreeIdentity(String treeIdentity) {
        this.treeIdentity = treeIdentity;
    }

    public Integer getForestId() {
        return forestId;
    }

    public void setForestId(Integer forestId) {
        this.forestId = forestId;
    }
}