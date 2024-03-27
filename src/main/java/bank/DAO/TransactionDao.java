package bank.DAO;

import bank.entities.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Transaction transaction) {
        entityManager.persist(transaction);
    }

    public Transaction getById(int id) {
        return entityManager.find(Transaction.class, id);
    }

    public void update(Transaction transaction) {
        entityManager.merge(transaction);
    }
    public void delete(Transaction transaction) {
        entityManager.remove(transaction);
    }
}