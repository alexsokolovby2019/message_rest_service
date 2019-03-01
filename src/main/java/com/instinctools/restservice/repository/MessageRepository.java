package com.instinctools.restservice.repository;

import com.instinctools.restservice.entity.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class MessageRepository {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public Message getById(long id){
        logger.info("Get message mapping by id: " + id);
        return entityManager.find(Message.class, id);
    }

    public List<Message> getAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Message> criteria = criteriaBuilder.createQuery(Message.class);
        return entityManager.createQuery(criteria).getResultList();
    }

}
