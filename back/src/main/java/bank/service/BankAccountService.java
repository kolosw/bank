package bank.service;

import bank.dto.BankAccountDto;
import bank.dto.BankUserDto;
import bank.dto.CurrencyDto;
import bank.entities.BankAccount;
import bank.entities.Currency;
import bank.entities.User;
import bank.repository.BankAccountRepository;
import bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BankAccountService {
    @Autowired
    BankAccountRepository bankAccountRepository;
    @Autowired
    UserService userService;
    public void create(BankAccountDto bankAccountDto)
    {
        BankUserDto dtoUser = userService.getById(bankAccountDto.getUser());
        User user = new User(dtoUser.getName(), dtoUser.getSurname(), dtoUser.getEmail(), dtoUser.getPassword());
        BankAccount bankAccount = new BankAccount(bankAccountDto.getId(),user,
                bankAccountDto.getType(),bankAccountDto.getBalance());
        bankAccountRepository.save(bankAccount);
    }
    public BankAccountDto getById(int i)
    {
        BankAccount bankAccount = bankAccountRepository.getReferenceById(i);
        return new BankAccountDto(bankAccount.getId(),bankAccount.getUser().getId(),bankAccount.getType(),bankAccount.getBalance());
    }
    public void deleteById(int i)
    {
        bankAccountRepository.delete(bankAccountRepository.getReferenceById(i));
    }
    public void update (Integer id, BankAccountDto bankAccountDto)
    {
        BankUserDto dtoUser = userService.getById(bankAccountDto.getUser());
        User user = new User(dtoUser.getName(), dtoUser.getSurname(), dtoUser.getEmail(), dtoUser.getPassword());
        BankAccount bankAccount = bankAccountRepository.getReferenceById(id);
        if(bankAccountDto.getUser() != null)
            bankAccount.setUser(user);
        if(bankAccountDto.getBalance() != null)
            bankAccount.setBalance(bankAccountDto.getBalance());
        if(bankAccountDto.getType() != null)
            bankAccount.setType(bankAccountDto.getType());
        bankAccountRepository.save(bankAccount);
    }

    public List<BankAccountDto> getaccountList()
    {
        System.out.println(bankAccountRepository.findAll());
        List<BankAccountDto> dtoList = new LinkedList<>();
        for (BankAccount bankAccount : bankAccountRepository.findAll())
            dtoList.add(new BankAccountDto(bankAccount.getId(),bankAccount.getUser().getId(),bankAccount.getType(),bankAccount.getBalance()));
        System.out.println(dtoList);
        return dtoList;
    }
}
