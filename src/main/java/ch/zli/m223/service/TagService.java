package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Tags;

@ApplicationScoped
public class TagService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Tags createTag(Tags category) {
        entityManager.persist(category);
        return category;
    }

    @Transactional
    public void deleteTag(long id) {
        Tags category = entityManager.find(Tags.class, id);
        entityManager.remove(category);
    }

    @Transactional
    public Tags updateTag(Tags category) {
        entityManager.merge(category);
        return category;
    }

    public List<Tags> findAllTags() {
        var query = entityManager.createQuery("FROM Tags", Tags.class);
        return query.getResultList();
    }
}
