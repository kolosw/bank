import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CurrencyService } from '../../service/currency-service/currency.service';
import { Currency } from '../../model/currency';

@Component({
  selector: 'app-currency-form',
  templateUrl: './currency-form.component.html',
  styleUrls: ['./currency-form.component.css']
})
export class CurrencyFormComponent {

  currency : Currency = new Currency();

  constructor(
  private router: Router,
  private currencyService: CurrencyService) {}

  onSubmit() {
    this.currencyService.save(this.currency).subscribe(() => this.gotoCurrencyList());
  }

  gotoCurrencyList() {
    this.router.navigate(['/currencies']);
  }
}
