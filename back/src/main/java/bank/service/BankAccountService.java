package bank.service;

import bank.dto.BankAccountDto;
import bank.dto.UserDto;
import bank.entities.BankAccount;
import bank.entities.User;
import bank.mapper.BankAccountMapper;
import bank.mapper.UserMapper;
import bank.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    private final UserService userService;

    private final BankAccountMapper bankAccountMapper;


    public BankAccountService(BankAccountRepository bankAccountRepository, UserService userService, BankAccountMapper bankAccountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.userService = userService;
        this.bankAccountMapper = bankAccountMapper;
    }

    public void create(BankAccountDto bankAccountDto)
    {
        bankAccountRepository.save(bankAccountMapper.toEntity(bankAccountDto));
    }

    public BankAccountDto getById(int i)
    {
        BankAccount bankAccount = bankAccountRepository.getReferenceById(i);
        return bankAccountMapper.toDto(bankAccount);
    }

    public void deleteById(int i)
    {
        bankAccountRepository.delete(bankAccountRepository.getReferenceById(i));
    }

    public void update (Integer id, BankAccountDto bankAccountDto)
    {
        UserDto dtoUser = userService.getById(bankAccountDto.getUserId());
        User user = UserMapper.toEntity(dtoUser);
        BankAccount bankAccount = bankAccountRepository.getReferenceById(id);
        if(bankAccountDto.getUserId() != null)
            bankAccount.setUser(user);
        if(bankAccountDto.getType() != null)
            bankAccount.setType(bankAccountDto.getType());
        bankAccountRepository.save(bankAccount);
    }

    public List<BankAccountDto> getList()
    {
        List<BankAccountDto> dtoList = new LinkedList<>();
        for (BankAccount bankAccount : bankAccountRepository.findAll())
            dtoList.add(bankAccountMapper.toDto(bankAccount));
        return dtoList;
    }
}
