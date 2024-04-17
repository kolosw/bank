import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BankAccountCurrencyService } from '../../service/bank-account-currency-service/bank-account-currency.service';
import { BankAccountCurrency } from '../../model/bank-account-currency';
import { BankAccount } from '../../model/bank-account';
import { Currency } from '../../model/currency';
import { BankAccountService } from '../../service/bank-account-service/bank-account.service';
import { CurrencyService } from '../../service/currency-service/currency.service';

@Component({
  selector: 'app-bank-account-currency-form',
  templateUrl: './bank-account-currency-form.component.html',
  styleUrls: ['./bank-account-currency-form.component.css']
})
export class BankAccountCurrencyFormComponent {

  bankAccountCurrency: BankAccountCurrency;

  constructor(
    private router: Router,
    private bankAccountCurrencyService: BankAccountCurrencyService,
    private bankAccountService: BankAccountService,
    private currencyService: CurrencyService
  ) {
    this.bankAccountCurrency = new BankAccountCurrency();
    this.bankAccountCurrency.account = new BankAccount();
    this.bankAccountCurrency.currency = new Currency();
  }

  onSubmit() {
    this.bankAccountService.getById(this.bankAccountCurrency.account.id).subscribe((account: BankAccount) => {
      this.bankAccountCurrency.account = account;
      this.currencyService.getById(this.bankAccountCurrency.currency.id).subscribe((currency: Currency) => {
        this.bankAccountCurrency.currency = currency;
        console.log('here')
        this.bankAccountCurrencyService.save(this.bankAccountCurrency).subscribe(() => this.gotoCurrencyList());
      });
    });
  }

  gotoCurrencyList() {
    this.router.navigate(['/accountcurrency']);
  }
}
