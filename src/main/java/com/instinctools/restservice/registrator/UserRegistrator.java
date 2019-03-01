package com.instinctools.restservice.registrator;

import com.instinctools.restservice.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class UserRegistrator {
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(User item) {
        logger.info("Create message mapping: " + item);
        entityManager.merge(item);
    }

    public void update(User item) {
        logger.info("Update message mapping: " + item);
        entityManager.merge(item);
    }

    public void delete(User item) {
        logger.info("Delete message mapping: " + item);
        entityManager.remove(item);
    }
}
