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

  constructor(private currencyService: CurrencyService) {
  }

  ngOnInit() {
    this.currencyService.findAll().subscribe(data => {
      this.currencies = data;
    });
  }
  loadCurrencies() {
      this.currencyService.findAll().subscribe(data => {
        this.currencies = data;
      });
    }

    delete(currencyId : number) {
      this.currencyService.delete(currencyId).subscribe(() => {
        this.loadCurrencies(); // Refresh the user list after deletion
      });
    }
}
