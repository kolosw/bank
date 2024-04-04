import { TestBed } from '@angular/core/testing';

import { BankAccountCurrencyService } from './bank-account-currency.service';

describe('BankAccountCurrencyService', () => {
  let service: BankAccountCurrencyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BankAccountCurrencyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
