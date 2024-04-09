package bank.mapper;

import bank.dto.BankAccountCurrencyDto;
import bank.entities.BankAccountCurrency;
import bank.entities.BankAccountCurrencyId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountCurrencyMapper {

    @Autowired
    BankAccountMapper accountMapper;

    public BankAccountCurrencyDto toDto(BankAccountCurrency bankAccountCurrency) {
        BankAccountCurrencyDto bankAccountCurrencyDto = new BankAccountCurrencyDto();
        bankAccountCurrencyDto.setAccount(accountMapper.toDto(bankAccountCurrency.getAccount()));
        bankAccountCurrencyDto.setCurrency(CurrencyMapper.toDto(bankAccountCurrency.getCurrency()));
        bankAccountCurrencyDto.setBalance(bankAccountCurrency.getBalance());
        return bankAccountCurrencyDto;
    }

    public BankAccountCurrency toEntity(BankAccountCurrencyDto bankAccountCurrencyDto) {
        BankAccountCurrency bankAccountCurrency = new BankAccountCurrency();
        bankAccountCurrency.setId(new BankAccountCurrencyId(bankAccountCurrencyDto.getAccount().getId(),
                bankAccountCurrencyDto.getCurrency().getId()));
        bankAccountCurrency.setAccount(accountMapper.toEntity(bankAccountCurrencyDto.getAccount()));
        bankAccountCurrency.setCurrency(CurrencyMapper.toEntity(bankAccountCurrencyDto.getCurrency()));
        bankAccountCurrency.setBalance(bankAccountCurrencyDto.getBalance());
        return bankAccountCurrency;
    }
}
