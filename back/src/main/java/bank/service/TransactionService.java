package bank.service;

import bank.dto.TransactionDto;
import bank.dto.CurrencyDto;
import bank.entities.Currency;
import bank.entities.Transaction;
import bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

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
    public void update (TransactionDto transactionDto)
    {
        Transaction transaction = new Transaction(transactionDto.getId(),transactionDto.getSenderId(),
                transactionDto.getRecipientId(), transactionDto.getDate(), transactionDto.getTime());
        transactionRepository.save(transaction);
    }
}
