package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Category;

@ApplicationScoped
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Category createCategory(Category category) {
        entityManager.persist(category);
        return category;
    }

    @Transactional
    public void deleteCategory(long id) {
        Category category = entityManager.find(Category.class, id);
        entityManager.remove(category);
    }

    @Transactional
    public Category updateCategory(Category category) {
        entityManager.merge(category);
        return category;
    }

    public List<Category> findAllCategories() {
        var query = entityManager.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }
}
