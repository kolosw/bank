package bank.DAO;

import bank.entities.AccountCurrency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class AccountCurrencyDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(AccountCurrency accountCurrency) {
        entityManager.persist(accountCurrency);
    }

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
