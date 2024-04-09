import { Currency } from './currency';
import { BankAccount } from './bank-account';

export class BankAccountCurrency {
    account!: BankAccount;
    currency!: Currency;
    balance!: number;
}
