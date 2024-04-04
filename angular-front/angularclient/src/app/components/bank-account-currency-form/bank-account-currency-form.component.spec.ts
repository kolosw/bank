import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BankAccountCurrencyFormComponent } from './bank-account-currency-form.component';

describe('BankAccountCurrencyFormComponent', () => {
  let component: BankAccountCurrencyFormComponent;
  let fixture: ComponentFixture<BankAccountCurrencyFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BankAccountCurrencyFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BankAccountCurrencyFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
