import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BankAccountCurrencyListComponent } from './bank-account-currency-list.component';

describe('BankAccountCurrencyListComponent', () => {
  let component: BankAccountCurrencyListComponent;
  let fixture: ComponentFixture<BankAccountCurrencyListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BankAccountCurrencyListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BankAccountCurrencyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
