import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';
import BankAccountService from '../services/BankAccountService'
import './SortButon.css';

class BankAccountList extends Component {

    bankAccountService = new BankAccountService();

    constructor(props) {
        super(props);
        this.state = {
            bankAccounts : [],
            isLoading: true,
            sortColumn: 'type',
            sortDirection: 'asc'};
        this.remove = this.remove.bind(this);
    }

  componentDidMount() {
    this.fetchAccounts()
  }

  async fetchAccounts() {
    const response = await this.bankAccountService.getAll();
    const data = response.data;
    this.setState({ bankAccounts: data, isLoading: false })
  }

    async remove(id) {
    this.bankAccountService.delete(id).then(response => {
    if (response.ok) {
      this.setState(prevState => ({
        users: prevState.bankAccounts.filter(i => i.id !== id)
      }));
    }
  });
}

  handleSort(column) {
    this.setState(prevState => {
      const { sortColumn, sortDirection } = prevState;
      const direction = column === sortColumn && sortDirection === 'asc' ? 'desc' : 'asc';

      const sortedBankAccounts = [...prevState.bankAccounts].sort((a, b) => {
        if (a[column] < b[column]) return direction === 'asc' ? -1 : 1;
        if (a[column] > b[column]) return direction === 'asc' ? 1 : -1;
        return 0;
      });

      return {
        bankAccounts: sortedBankAccounts,
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
        const {bankAccounts, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const bankAccountList = bankAccounts.map(bankAccount => {
            return <tr key={bankAccount.id}>
                <td style={{whiteSpace: 'nowrap'}}>{bankAccount.userId}</td>
                <td>{bankAccount.type}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/account/" + bankAccount.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(bankAccount.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/account/new">Add Bank Account</Button>
                    </div>
                    <h3>Bank Accounts</h3>
                    <Table className="mt-4">
                        <thead>
                    <tr>
                    <th width="30%">
                        User ID
                        {this.renderSortButton('userId')}
                    </th>
                    <th width="30%">
                        Type
                        {this.renderSortButton('type')}
                    </th>
                     <th width="40%">Actions</th>
                     </tr>
                        </thead>
                        <tbody>
                        {bankAccountList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default BankAccountList;