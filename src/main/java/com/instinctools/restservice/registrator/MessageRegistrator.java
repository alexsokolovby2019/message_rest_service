package com.instinctools.restservice.registrator;

import com.instinctools.restservice.entity.Message;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class MessageRegistrator {
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(Message item) {
        logger.info("Create message mapping: " + item);
        entityManager.merge(item);
    }

    public void update(Message item) {
        logger.info("Update message mapping: " + item);
        entityManager.merge(item);
    }

    public void delete(Message item) {
        logger.info("Delete message mapping: " + item);
        entityManager.remove(item);
    }
}
