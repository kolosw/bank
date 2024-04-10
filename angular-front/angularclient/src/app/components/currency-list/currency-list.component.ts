import { Component, OnInit } from '@angular/core';
import { Currency } from '../../model/currency';
import { CurrencyService } from '../../service/currency-service/currency.service';

@Component({
  selector: 'app-currency-list',
  templateUrl: './currency-list.component.html',
  styleUrls: ['./currency-list.component.css']
})
export class CurrencyListComponent implements OnInit {

  currencies: Currency[] = [];
  sortColumn: string = 'id';
  sortReverse: boolean = false;

  constructor(private currencyService: CurrencyService) {
  }

  ngOnInit() {
    this.loadCurrencies();
  }

  loadCurrencies() {
    this.currencyService.findAll().subscribe(data => {
      this.currencies = data;
    });
  }

  delete(currencyId: number) {
    this.currencyService.delete(currencyId).subscribe(() => {
      this.loadCurrencies();
    });
  }

  sort(column: string) {
    if (this.sortColumn === column) {
      this.sortReverse = !this.sortReverse;
    } else {
      this.sortColumn = column;
      this.sortReverse = false;
    }
  }

  get sortedCurrencies(): Currency[] {
    return this.currencies.sort((a, b) => {
      const valueA = a[this.sortColumn as keyof Currency];
      const valueB = b[this.sortColumn as keyof Currency];

      if (typeof valueA === 'string' && typeof valueB === 'string') {
        if (this.sortReverse) {
          return valueB.localeCompare(valueA);
        } else {
          return valueA.localeCompare(valueB);
        }
      } else if (typeof valueA === 'number' && typeof valueB === 'number') {
        return this.sortReverse ? valueB - valueA : valueA - valueB;
      } else {
        return 0; // Handle other types or mixed types as per your requirements
      }
    });
  }
}
