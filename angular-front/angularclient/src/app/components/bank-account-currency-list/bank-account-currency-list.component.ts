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
  sortColumn: string = '';
  sortReverse: boolean = false;

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
      this.sortData();
    });
  }

  delete(accountId: number, currencyId: number) {
    this.bankAccountCurrencyService.delete(accountId, currencyId).subscribe(() => {
      this.loadAccountCurrencies();
    });
  }

  sort(column: string) {
    if (this.sortColumn === column) {
      this.sortReverse = !this.sortReverse;
    } else {
      this.sortColumn = column;
      this.sortReverse = false;
    }
    this.sortData();
  }

  sortData() {
    if (this.sortColumn) {
      this.bankAccountCurrency.sort((a, b) => {
        const aValue = this.getPropertyValue(a, this.sortColumn);
        const bValue = this.getPropertyValue(b, this.sortColumn);
        if (aValue < bValue) {
          return this.sortReverse ? 1 : -1;
        } else if (aValue > bValue) {
          return this.sortReverse ? -1 : 1;
        } else {
          return 0;
        }
      });
    }
  }

  getPropertyValue(obj: any, path: string) {
    const properties = path.split('.');
    let value = obj;
    for (const property of properties) {
      value = value[property];
    }
    return value;
  }
}
