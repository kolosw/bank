import CrudService from './CrudService';

export class BankAccountService extends CrudService {
  constructor() {
    super('/account');
  }
}
