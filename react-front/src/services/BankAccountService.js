import CrudService from './CrudService';

class BankAccountService extends CrudService {
  constructor() {
    super('/account');
  }
}

export default BankAccountService;