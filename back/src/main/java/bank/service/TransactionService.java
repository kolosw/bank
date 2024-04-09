package bank.service;

import bank.dto.TransactionDto;
import bank.entities.Transaction;
import bank.mapper.TransactionMapper;
import bank.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public void create(TransactionDto transactionDto)
    {
        transactionRepository.save(TransactionMapper.toEntity(transactionDto));
    }
    public TransactionDto getById(int i)
    {
        return TransactionMapper.toDto(transactionRepository.getReferenceById(i));
    }
    public void deleteById(int i)
    {
        transactionRepository.delete(transactionRepository.getReferenceById(i));
    }
    public void update ( TransactionDto transactionDto, Integer id)
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
    public List<TransactionDto> getList() {
        List<TransactionDto> list = new LinkedList<>();
        for (Transaction transaction : transactionRepository.findAll())
            list.add(TransactionMapper.toDto(transaction));
        return list;
    }
}
