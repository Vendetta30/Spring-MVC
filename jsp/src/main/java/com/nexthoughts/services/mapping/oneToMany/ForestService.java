package com.nexthoughts.services.mapping.oneToMany;

import com.nexthoughts.command.mapping.oneToMany.ForestCommand;
import com.nexthoughts.domain.mapping.onetomany.Forest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForestService {
    private final Logger logger = LoggerFactory.getLogger(ForestService.class);
    private SessionFactory sessionFactory;

    @Autowired
    ForestService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public List<ForestCommand> list() {

        List<ForestCommand> forestCommands = new ArrayList<ForestCommand>();
        List<Forest> forests = getSession().createCriteria(Forest.class).list();
        for (Forest forest : forests) {
            forestCommands.add(new ForestCommand(forest));
        }
        return forestCommands;
    }

    public int create(ForestCommand forestCommand) {
        Forest forest = new Forest(forestCommand);
        getSession().save(forest);
        getSession().close();
        return forest.getForestId();
    }

    public Forest read(int id) {
        Session session = getSession();
        Forest forest = (Forest) session.get(Forest.class, id);
        session.close();
        return forest;
    }

    public void update(ForestCommand forestCommand) {
        Session session = getSession();
        Forest forest = (Forest) session.get(Forest.class, forestCommand.getForestId());
        forest = forest.updateForest(forestCommand);
        session.update(forest);
        session.flush();
        session.close();
    }

    public void delete(int id) {
        Session session = getSession();
        Forest forest = (Forest) getSession().get(Forest.class, id);
        session.delete(forest);
        session.flush();
        session.close();
    }
}