import CrudService from './CrudService';
import axios from 'axios';

export class BankAccountCurrencyService extends CrudService {
  constructor() {
    super('/accountcurrency');
  }

  async deleteBankAccountCurrency(currencyId, accountId) {
    const response = await axios.delete(`${this.apiUrl}/${accountId}/${currencyId}`);
    return response;
  }

  async getBy2Id(currencyId, accountId) {
    const response = await axios.get(`${this.apiUrl}/${accountId}/${currencyId}`);
    return response;
  }

  async updateBankAccountCurrency(currencyId, accountId, updatedData) {
    const response = await axios.put(`${this.apiUrl}/${accountId}/${currencyId}`, updatedData);
    return response;
  }
}
