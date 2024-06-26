import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CurrencyService } from '../../service/currency-service/currency.service';
import { Currency } from '../../model/currency';

@Component({
  selector: 'app-currency-update',
  templateUrl: './currency-update.component.html',
  styleUrls: ['./currency-update.component.css']
})
export class CurrencyUpdateComponent {

  currency : Currency = new Currency();

  constructor(
  private router: Router,
  private currencyService : CurrencyService) {
    this.currency = new Currency();
  }

  onSubmit() {
    this.currencyService.update(this.currency).subscribe(() => this.gotoCurrencyList());
  }

  gotoCurrencyList() {
    this.router.navigate(['/currencies']);
  }
}
