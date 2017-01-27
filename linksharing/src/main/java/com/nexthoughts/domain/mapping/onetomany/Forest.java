package com.nexthoughts.domain.mapping.onetomany;

import com.nexthoughts.command.mapping.oneToMany.ForestCommand;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "forest", uniqueConstraints = {
        @UniqueConstraint(columnNames = "FOREST_NAME")
})
public class Forest implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOREST_ID", unique = true, nullable = false)
    private Integer forestId;

    @Column(name = "FOREST_NAME", unique = true, nullable = false, length = 20)
    private String forestName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "forest")
    private Set<Tree> trees = new HashSet<Tree>(0);

    public Forest() {
    }

    public Integer getForestId() {
        return forestId;
    }

    public void setForestId(Integer forestId) {
        this.forestId = forestId;
    }

    public Forest(String forestName) {
        this.forestName = forestName;
    }

    public Forest(ForestCommand forestCommand) {
        this.setForestName(forestCommand.getForestName());
    }

    public Forest(String forestName, Set<Tree> trees) {
        this.forestName = forestName;
        this.trees = trees;
    }

    public String getForestName() {
        return forestName;
    }

    public void setForestName(String forestName) {
        this.forestName = forestName;
    }

    public Set<Tree> getTrees() {
        return trees;
    }

    public void setTrees(Set<Tree> trees) {
        this.trees = trees;
    }

    public Forest updateForest(ForestCommand forestCommand) {
        this.forestId = forestCommand.getForestId();
        this.forestName = forestCommand.getForestName();
        return this;
    }
}