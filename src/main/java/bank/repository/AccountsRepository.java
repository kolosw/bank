package bank.repository;

import bank.entities.Accounts;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class AccountsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Accounts accounts) {
        entityManager.persist(accounts);
    }

    public Accounts getById(int id) {
        return entityManager.find(Accounts.class, id);
    }

    public void update(Accounts accounts) {
        entityManager.merge(accounts);
    }
    public void delete(Accounts accounts) {
        entityManager.remove(accounts);
    }
}
