import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';
import BankAccountCurrencyService from '../services/BankAccountCurrencyService'
import './SortButon.css';

class BankAccountCurrencyList extends Component {
  bankAccountCurrencyService = new BankAccountCurrencyService();
  constructor(props) {
    super(props);
    this.state = { bankAccountCurrencies: [],
                isLoading: true,
                sortColumn: 'account.id',
                sortDirection: 'asc'
                };
    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    this.fetchAccountCurrencies()
  }

  async fetchAccountCurrencies() {
    const response = await this.bankAccountCurrencyService.getAll();
    const data = response.data;
    this.setState({ bankAccountCurrencies : data, isLoading: false })
  }

  async remove(accountId, currencyId) {
    this.bankAccountCurrencyService.deleteBankAccountCurrency(accountId, currencyId).then(response => {
    if (response.ok) {
      this.setState(prevState => ({
        bankAccountCurrencies: prevState.bankAccountCurrencies.filter(i => i.account.id !== accountId || i.currency.id !== currencyId)
      }));
    }
  });
}

    handleSort(column) {
      this.setState(prevState => {
        const { sortColumn, sortDirection } = prevState;
        const direction = column === sortColumn && sortDirection === 'asc' ? 'desc' : 'asc';
        const sortedBankAccountCurrencies = [...prevState.bankAccountCurrencies].sort((a, b) => {
          if (column === 'account.id') {
            // Custom comparison logic for account IDs as strings
            const idA = parseInt(a.account.id);
            const idB = parseInt(b.account.id);
            return direction === 'asc' ? idA - idB : idB - idA;
          }
          else if (column === 'currency.symbol') {
                  // Custom comparison logic for currency symbols as strings
                  const symbolA = a.currency.symbol.toLowerCase();
                  const symbolB = b.currency.symbol.toLowerCase();
                  return direction === 'asc' ? symbolA.localeCompare(symbolB) : symbolB.localeCompare(symbolA);
                }
          else if (column === 'account.type') {
                            // Custom comparison logic for currency symbols as strings
                            const symbolA = a.account.type.toLowerCase();
                            const symbolB = b.account.type.toLowerCase();
                            return direction === 'asc' ? symbolA.localeCompare(symbolB) : symbolB.localeCompare(symbolA);
                          }
          else {
            // Default alphabetical sorting for other fields
            if (a[column] < b[column]) return direction === 'asc' ? -1 : 1;
            if (a[column] > b[column]) return direction === 'asc' ? 1 : -1;
            return 0;
          }
        });
        return {
          bankAccountCurrencies: sortedBankAccountCurrencies,
          sortColumn: column,
          sortDirection: direction
        };
      });
    }

  renderSortButton(column) {
    const { sortColumn, sortDirection } = this.state;
    const isActive = column === sortColumn;
    const buttonClass = isActive ? 'active' : '';
    const buttonIcon = isActive && sortDirection === 'asc' ? '\u25B2' : '\u25BC';

    return (
      <Button
        color="link"
        className={`sort-button ${buttonClass}`}
        onClick={() => this.handleSort(column)}
      >
        {buttonIcon}
      </Button>
    );
  }

  render() {
    const { bankAccountCurrencies, isLoading } = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const bankAccountCurrenciesList = bankAccountCurrencies.map(bankAccountCurrency => (
      <tr key={bankAccountCurrency.id}>
        <td style={{ whiteSpace: 'nowrap' }}>{bankAccountCurrency.account.id}</td>
        <td>{bankAccountCurrency.balance}</td>
        <td>{bankAccountCurrency.currency.symbol}</td>
        <td>{bankAccountCurrency.account.type}</td>
        <td>
          <ButtonGroup>
            <Button size="sm" color="primary" tag={Link} to={"/bankaccountcurrency/" +
            bankAccountCurrency.currency.id + '/' + bankAccountCurrency.account.id}>Edit</Button>
            <Button
              size="sm"
              color="danger"
              onClick={() => this.remove(bankAccountCurrency.account.id, bankAccountCurrency.currency.id)}
            >
              Delete
            </Button>
          </ButtonGroup>
        </td>
      </tr>
    ));

    return (
      <div>
        <Container fluid>
          <div className="float-right">
            <Button color="success" tag={Link} to="/bankaccountcurrency/new">
              Add Bank Account Currency
            </Button>
          </div>
          <h3>Bank Accounts Currencies</h3>
          <Table className="mt-4">
            <thead>
              <tr>
                <th width="20%">
                  Account ID
                  {this.renderSortButton('account.id')}
                </th>
                <th width="20%">
                  Balance
                  {this.renderSortButton('balance')}
                </th>
                <th width="20%">
                  Symbol
                  {this.renderSortButton('currency.symbol')}
                </th>
                <th width="20%">
                  Type
                  {this.renderSortButton('account.type')}
                </th>
                <th width="20%">Actions</th>
              </tr>
            </thead>
            <tbody>{bankAccountCurrenciesList}</tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default BankAccountCurrencyList;