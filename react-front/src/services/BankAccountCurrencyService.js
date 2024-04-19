import CrudService from './CrudService';
import axios from 'axios';

class BankAccountCurrencyService extends CrudService {
  constructor() {
    super('/accountcurrency');
  }

  async deleteBankAccountCurrency(accountId, currencyId) {
    const response = await axios.delete(`${this.apiUrl}/${accountId}/${currencyId}`);
    return response;
  }

  async getBy2Id(accountId, currencyId) {
    const response = await axios.get(`${this.apiUrl}/${accountId}/${currencyId}`);
    return response;
  }

  async updateBankAccountCurrency(currencyId, accountId, updatedData) {
    const response = await axios.put(`${this.apiUrl}/${accountId}/${currencyId}`, updatedData);
    return response;
  }
}

export default BankAccountCurrencyService;