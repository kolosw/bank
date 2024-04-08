package bank.mapper;

import bank.dto.BankAccountCurrencyDto;
import bank.entities.BankAccountCurrency;
import bank.entities.BankAccountCurrencyId;
import org.springframework.stereotype.Component;

@Component
public class BankAccountCurrencyMapper {

    public BankAccountCurrencyDto toDto(BankAccountCurrency bankAccountCurrency) {
        BankAccountCurrencyDto bankAccountCurrencyDto = new BankAccountCurrencyDto();
        bankAccountCurrencyDto.setAccount(bankAccountCurrency.getAccount());
        bankAccountCurrencyDto.setCurrency(bankAccountCurrency.getCurrency());
        return bankAccountCurrencyDto;
    }

    public BankAccountCurrency toEntity(BankAccountCurrencyDto bankAccountCurrencyDto) {
        BankAccountCurrency bankAccountCurrency = new BankAccountCurrency();
        bankAccountCurrency.setId(new BankAccountCurrencyId(bankAccountCurrencyDto.getAccount().getId(),
                bankAccountCurrencyDto.getCurrency().getId()));
        bankAccountCurrency.setAccount(bankAccountCurrencyDto.getAccount());
        bankAccountCurrency.setCurrency(bankAccountCurrencyDto.getCurrency());
        return bankAccountCurrency;
    }
}
