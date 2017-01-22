package com.nexthoughts.services.mapping.oneToMany;

import com.nexthoughts.command.mapping.oneToMany.ForestCommand;
import com.nexthoughts.command.mapping.oneToMany.TreeCommand;
import com.nexthoughts.domain.mapping.onetomany.Forest;
import com.nexthoughts.domain.mapping.onetomany.Tree;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeService {
    private final Logger logger = LoggerFactory.getLogger(TreeService.class);
    private SessionFactory sessionFactory;

    @Autowired
    TreeService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public List<ForestCommand> forestList() {
        logger.debug("****************************************************************");
        logger.debug("****************************************************************");
        logger.debug("******************************3333333333333**********************************");
        List<ForestCommand> forestCommands = new ArrayList<ForestCommand>();
        List<Forest> forests = getSession().createCriteria(Forest.class).list();
        for (Forest forest : forests) {
            forestCommands.add(new ForestCommand(forest));
        }
        return forestCommands;
    }

    public List<TreeCommand> list() {
        List<TreeCommand> treeCommands = new ArrayList<TreeCommand>();
        List<Tree> trees = getSession().createCriteria(Tree.class).list();
        for (Tree tree : trees) {
            treeCommands.add(new TreeCommand(tree));
        }
        logger.debug("**************************************");
        logger.debug("**************************************");
        logger.debug("**************************************");
        logger.debug("**************************************");
        logger.debug("treeCommands " + treeCommands);
        logger.debug("**************************************");
        logger.debug("**************************************");
        logger.debug("**************************************");
        logger.debug("**************************************");
        return treeCommands;
    }

    public int create(TreeCommand treeCommand) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Tree tree = new Tree(treeCommand);
        logger.debug("#########################################");
        logger.debug("#########################################");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        tree.setForest(getForest(treeCommand.getForestId()));
        logger.debug("tree " + tree.getForest());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("#########################################");
        logger.debug("#########################################");
        logger.debug("#########################################");
        session.save(tree);
        transaction.commit();
        session.close();
        return tree.getTreeId();
    }

    public Tree read(int id) {
        Session session = getSession();
        Tree tree = (Tree) session.get(Tree.class, id);
        session.close();
        return tree;
    }

    public void update(TreeCommand treeCommand) {
        Session session = getSession();
        Tree tree = (Tree) session.get(Forest.class, treeCommand.getTreeId());
        tree = tree.updateTree(treeCommand);
        session.update(tree);
        session.flush();
        session.close();
    }

    public void delete(int id) {
        Session session = getSession();
        Tree tree = (Tree) getSession().get(Tree.class, id);
        session.delete(tree);
        session.flush();
        session.close();
    }

    public Forest getForest(int id) {
        Session session = getSession();
        Forest forest = (Forest) session.get(Forest.class, id);
        session.close();
        return forest;
    }
}