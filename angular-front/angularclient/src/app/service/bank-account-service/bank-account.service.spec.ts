import { TestBed } from '@angular/core/testing';

import { BankAccountServiceService } from './bank-account.service';

describe('BankAccountService', () => {
  let service: BankAccountServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BankAccountServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
