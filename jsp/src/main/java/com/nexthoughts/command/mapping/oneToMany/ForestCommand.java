package com.nexthoughts.command.mapping.oneToMany;

import com.nexthoughts.domain.mapping.onetomany.Forest;

import java.util.HashSet;
import java.util.Set;

public class ForestCommand {
    private Integer forestId;
    private String forestName;
    private Set<TreeCommand> trees = new HashSet<TreeCommand>(0);

    public ForestCommand() {
    }

    public Integer getForestId() {
        return forestId;
    }

    public void setForestId(Integer forestId) {
        this.forestId = forestId;
    }

    public ForestCommand(String forestName) {
        this.forestName = forestName;
    }

    public ForestCommand(Forest forest) {
        this.setForestId(forest.getForestId());
        this.setForestName(forest.getForestName());
    }

    public ForestCommand(String forestName, Set<TreeCommand> trees) {
        this.forestName = forestName;
        this.trees = trees;
    }

    public String getForestName() {
        return forestName;
    }

    public void setForestName(String forestName) {
        this.forestName = forestName;
    }

    public Set<TreeCommand> getTrees() {
        return trees;
    }

    public void setTrees(Set<TreeCommand> trees) {
        this.trees = trees;
    }
}