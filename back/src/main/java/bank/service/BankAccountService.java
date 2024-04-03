package bank.service;

import bank.dto.BankAccountDto;
import bank.dto.CurrencyDto;
import bank.entities.BankAccount;
import bank.entities.Currency;
import bank.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    @Autowired
    BankAccountRepository bankAccountRepository;

    public void create(BankAccountDto bankAccountDto)
    {
        BankAccount bankAccount = new BankAccount(bankAccountDto.getId(),bankAccountDto.getUser(),bankAccountDto.getType(),bankAccountDto.getBalance());
        bankAccountRepository.save(bankAccount);
    }
    public BankAccountDto getById(int i)
    {
        BankAccount bankAccount = bankAccountRepository.getReferenceById(i);
        return new BankAccountDto(bankAccount.getId(),bankAccount.getUser(),bankAccount.getType(),bankAccount.getBalance());
    }
    public void deleteById(int i)
    {
        bankAccountRepository.delete(bankAccountRepository.getReferenceById(i));
    }
    public void update (Integer id, BankAccountDto bankAccountDto)
    {
        BankAccount bankAccount = bankAccountRepository.getReferenceById(id);
        if(bankAccountDto.getUser() != null)
            bankAccount.setUser(bankAccountDto.getUser());
        if(bankAccountDto.getBalance() != null)
            bankAccount.setBalance(bankAccountDto.getBalance());
        if(bankAccountDto.getType() != null)
            bankAccount.setType(bankAccountDto.getType());
        bankAccountRepository.save(bankAccount);
    }
}
