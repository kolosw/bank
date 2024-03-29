package bank.repository;

import bank.entities.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AccountsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Account account) {
        entityManager.persist(account);
    }

    @Transactional
    public Account getById(int id) {
        return entityManager.find(Account.class, id);
    }

    public void update(Account account) {
        entityManager.merge(account);
    }
    public void delete(Account account) {
        entityManager.remove(account);
    }
}
