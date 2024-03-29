package bank.repository;

import bank.entities.AccountCurrency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AccountCurrencyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(AccountCurrency accountCurrency) {
        entityManager.persist(accountCurrency);
    }

    @Transactional
    public AccountCurrency getById(int id) {
        return entityManager.find(AccountCurrency.class, id);
    }

    public void update(AccountCurrency accountCurrency) {
        entityManager.merge(accountCurrency);
    }
    public void delete(AccountCurrency accountCurrency) {
        entityManager.remove(accountCurrency);
    }
}
