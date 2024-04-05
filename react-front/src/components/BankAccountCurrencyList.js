import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../AppNavbar';
import { Link } from 'react-router-dom';

class BankAccountCurrencyList extends Component {
  constructor(props) {
    super(props);
    this.state = { bankAccountCurrencies: [] };
    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    fetch('api/accountcurrency')
      .then(response => response.json())
      .then(data => this.setState({ bankAccountCurrencies: data }));
  }

  async remove(accountId, currencyId) {
    await fetch(`api/bankAccountCurrencies/${accountId}/${currencyId}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(() => {
      let updatedBankAccountCurrencies = [...this.state.bankAccountCurrencies].filter(
        i => i.account.id !== accountId && i.currency.id !== currencyId
      );
      this.setState({ bankAccountCurrencies: updatedBankAccountCurrencies });
    });
  }

  render() {
    const { bankAccountCurrencies, isLoading } = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const bankAccountCurrenciesList = bankAccountCurrencies.map(bankAccountCurrency => (
      <tr key={bankAccountCurrency.id}>
        <td style={{ whiteSpace: 'nowrap' }}>{bankAccountCurrency.account.id}</td>
        <td>{bankAccountCurrency.currency.id}</td>
        <td>{bankAccountCurrency.account.balance}</td>
        <td>
          <ButtonGroup>
            <Button
              size="sm"
              color="primary"
              tag={Link}
              to={`/bankaccountcurrencies/${bankAccountCurrency.account.id}/${bankAccountCurrency.currency.id}`}
            >
              Edit
            </Button>
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
        <AppNavbar />
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
                <th width="20%">accountId</th>
                <th width="20%">currencyId</th>
                <th width="20%">balance</th>
                <th width="40%">Actions</th>
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