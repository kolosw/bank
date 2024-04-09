package bank.service;

import bank.dto.TransactionDto;
import bank.entities.Transaction;
import bank.repository.TransactionRepository;
import bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public void create(TransactionDto transactionDto)
    {
        Transaction transaction = new Transaction(transactionDto.getId(),transactionDto.getSenderId(),
                transactionDto.getRecipientId(), transactionDto.getDate(), transactionDto.getTime());
        transactionRepository.save(transaction);
    }
    public TransactionDto getById(int i)
    {
        Transaction transaction = transactionRepository.getReferenceById(i);
        return new TransactionDto(transaction.getId(),transaction.getSenderId(),
                transaction.getRecipientId(), transaction.getDate(), transaction.getTime());
    }
    public void deleteById(int i)
    {
        transactionRepository.delete(transactionRepository.getReferenceById(i));
    }
    public void update (Integer id, TransactionDto transactionDto)
    {
        Transaction transaction = transactionRepository.getReferenceById(id);
        if(transaction.getDate() != null)
            transaction.setDate(transactionDto.getDate());
        if(transaction.getTime() != null)
            transaction.setTime(transactionDto.getTime());
        if(transaction.getRecipientId() != null)
            transaction.setRecipientId(transactionDto.getRecipientId());
        if(transaction.getSenderId() != null)
            transaction.setSenderId(transactionDto.getSenderId());
        transactionRepository.save(transaction);
    }
}
