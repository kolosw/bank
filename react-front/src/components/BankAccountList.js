import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../AppNavbar';
import { Link } from 'react-router-dom';

class BankAccountList extends Component {

    constructor(props) {
        super(props);
        this.state = {bankAccounts : []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('api/account')
            .then(response => response.json())
            .then(data => this.setState({bankAccounts: data}));
    }

    async remove(id) {
        await fetch(`api/bankAccounts/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedBankAccounts = [...this.state.bankAccounts].filter(i => i.id !== id);
            this.setState({bankAccounts : updatedBankAccounts});
        });
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
                <td>{bankAccount.balance}</td>
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
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/account/new">Add Bank Account</Button>
                    </div>
                    <h3>Bank Accounts</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="20%">userID</th>
                            <th width="20%">Type</th>
                            <th width="20%">balance</th>
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