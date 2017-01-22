package com.nexthoughts.domain.mapping.onetomany;

import com.nexthoughts.command.mapping.oneToMany.TreeCommand;

import javax.persistence.*;

@Entity
@Table(name = "tree", uniqueConstraints = {
        @UniqueConstraint(columnNames = "TREE_IDENTITY")
})
public class Tree implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TREE_ID", unique = true, nullable = false)
    private Integer treeId;

    @Column(name = "TREE_IDENTITY", unique = true, nullable = false, length = 8)
    private String treeIdentity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOREST_ID", nullable = false)
    private Forest forest;

    public Tree() {
    }

    public Tree(String treeIdentity, Forest forest) {
        this.treeIdentity = treeIdentity;
        this.forest = forest;
    }

    public Tree(TreeCommand treeCommand) {
        this.treeIdentity = treeCommand.getTreeIdentity();
    }

    public String getTreeIdentity() {
        return treeIdentity;
    }

    public Integer getTreeId() {
        return treeId;
    }

    public void setTreeId(Integer treeId) {
        this.treeId = treeId;
    }

    public void setTreeIdentity(String treeIdentity) {
        this.treeIdentity = treeIdentity;
    }

    public Forest getForest() {
        return forest;
    }

    public void setForest(Forest forest) {
        this.forest = forest;
    }

    public Tree updateTree(TreeCommand treeCommand) {
        this.treeId = treeCommand.getTreeId();
        this.treeIdentity = treeCommand.getTreeIdentity();
        return this;
    }
}