import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from '../AppNavbar';

class BankAccountCurrencyEdit extends Component {
  emptyItem = {
    account: { id: '' },
    currency: { id: '' }
  };

  constructor(props) {
    super(props);
    this.state = {
      item: this.emptyItem,
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

async componentDidMount() {
  const { id1, id2 } = this.props.match.params;

  if (id1 === 'new') {
    // In "Add" mode, initialize an empty bank account currency
    this.setState({ item: this.emptyItem });
  } else {
    // In "Edit" mode, fetch the existing bank account currency details
    const bankAccount = await (
      await fetch(`/api/accountcurrency/${id1}/${id2}`)
    ).json();
    this.setState({ item: bankAccount });
  }
}

handleChange(event) {
  const target = event.target;
  const value = target.value;
  const name = target.name;
  let item = { ...this.state.item };

  if (name === 'accountid') {
    item = {
      ...item,
      account: {
        ...item.account,
        id: value
      }
    };
  } else if (name === 'currencyid') {
    item = {
      ...item,
      currency: {
        ...item.currency,
        id: value
      }
    };
  } else {
    item[name] = value;
  }

  this.setState({ item });
}

async handleSubmit(event) {
  event.preventDefault();
  const { item } = this.state;
  const { id1, id2 } = this.props.match.params;
  console.log('whatever')
  if (id1 && id2) {
    await fetch(`/api/accountcurrency/${id1}/${id2}`, {
      method: 'PUT',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(item),
    });
    this.props.history.push('/bankaccountcurrency');
  } else {
  const id1 = item.account.id;
  const id2 = item.currency.id;
   await fetch(`/api/accountcurrency/${id1}/${id2}`, {
        method: 'PUT',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(item),
        })
    // Handle the case when one or both IDs are missing
    console.log('Missing ID1 or ID2');
  }
}

render() {
  const { item } = this.state;
  const { id1, id2 } = this.props.match.params;
  const title = <h2>{id1 && id2 ? 'Edit Bank Account' : 'Add Bank Account'}</h2>;

  return (
    <div>
      <AppNavbar />
      <Container>
        {title}
        <Form onSubmit={this.handleSubmit}>
          <FormGroup>
            <Label for="accountid">Account Id</Label>
            <Input
              type="text"
              name="accountid"
              id="accountid"
              value={item.account && item.account.id ? item.account.id : ''}
              onChange={this.handleChange}
              autoComplete="accountid"
            />
          </FormGroup>
          <FormGroup>
            <Label for="currencyid">Currency Id</Label>
            <Input
              type="text"
              name="currencyid"
              id="currencyid"
              value={item.currency && item.currency.id ? item.currency.id : ''}
              onChange={this.handleChange}
              autoComplete="currencyid"
            />
          </FormGroup>
          <FormGroup>
            <Button color="primary" type="submit">
              Save
            </Button>{' '}
            <Button color="secondary" tag={Link} to="/bankaccountcurrencies">
              Cancel
            </Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  );
}
}

export default withRouter(BankAccountCurrencyEdit);