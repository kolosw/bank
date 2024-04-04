import { Component, OnInit } from '@angular/core';
import { BankAccountCurrency } from '../../model/bank-account-currency';
import { BankAccountCurrencyService } from '../../service/bank-account-currency-service/bank-account-currency.service';

@Component({
  selector: 'app-bank-account-currency-list',
  templateUrl: './bank-account-currency-list.component.html',
  styleUrls: ['./bank-account-currency-list.component.css']
})
export class BankAccountCurrencyListComponent implements OnInit {

  bankAccountCurrency: BankAccountCurrency[] = [];

  constructor(private bankAccountCurrencyService: BankAccountCurrencyService) {
  }

  ngOnInit() {
    this.bankAccountCurrencyService.findAll().subscribe(data => {
      this.bankAccountCurrency = data;
    });
  }
  loadAccountCurrencies() {
      this.bankAccountCurrencyService.findAll().subscribe(data => {
        this.bankAccountCurrency = data;
      });
    }

    delete(accountId : number, currencyId : number) {
      this.bankAccountCurrencyService.delete(accountId,currencyId).subscribe(() => {
        this.loadAccountCurrencies(); // Refresh the user list after deletion
      });
    }
}
