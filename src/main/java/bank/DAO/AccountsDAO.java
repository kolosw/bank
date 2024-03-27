package bank.DAO;

import bank.entities.Accounts;
import bank.entities.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AccountsDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Accounts accounts) {
        entityManager.persist(accounts);
    }

    public Transaction getById(int id) {
        return entityManager.find(Transaction.class, id);
    }

    public void update(Accounts accounts) {
        entityManager.merge(accounts);
    }
    public void delete(Accounts accounts) {
        entityManager.remove(accounts);
    }
}
