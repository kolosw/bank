import CrudService from './CrudService';

export class CurrencyService extends CrudService {
  constructor() {
    super('/currency');
  }
}
