package bank.mapper;

import bank.dto.BankAccountDto;
import bank.entities.BankAccount;
import bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

    @Autowired
    UserService userService;

    public BankAccountDto toDto(BankAccount account) {
        BankAccountDto accountDto = new BankAccountDto();
        accountDto.setId(account.getId());
        accountDto.setType(account.getType());
        accountDto.setUserId(account.getUser().getId());
        return accountDto;
    }

    public BankAccount toEntity(BankAccountDto bankAccountDto) {
        BankAccount bankAccount = new BankAccount();
        if(bankAccountDto.getId()!=null)
            bankAccount.setId(bankAccountDto.getId());
        bankAccount.setUser(UserMapper.toEntity(userService.getById(bankAccountDto.getUserId())));
        bankAccount.setType(bankAccountDto.getType());
        return bankAccount;
    }
}
