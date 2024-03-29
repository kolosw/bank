package bank.repository;

import bank.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UserRepository() {
    }

    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(User user) {
        entityManager.remove(user);
    }

}
