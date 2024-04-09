package bank.mapper;

import bank.dto.TransactionDto;
import bank.entities.Transaction;

public class TransactionMapper {

    public static TransactionDto toDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setDate(transaction.getDate());
        transactionDto.setTime(transaction.getTime());
        transactionDto.setRecipientId(transaction.getRecipientId());
        transactionDto.setSenderId(transaction.getSenderId());
        return transactionDto;
    }

    public static Transaction toEntity(TransactionDto dto) {
        Transaction transaction = new Transaction();
        if(dto.getId()!=null)
            transaction.setId(dto.getId());
        transaction.setSenderId(dto.getSenderId());
        transaction.setRecipientId(dto.getRecipientId());
        transaction.setTime(dto.getTime());
        transaction.setDate(dto.getDate());
        return transaction;
    }
}
