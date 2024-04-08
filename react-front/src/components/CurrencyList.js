import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../AppNavbar';
import { Link } from 'react-router-dom';

class CurrencyList extends Component {

    constructor(props) {
        super(props);
        this.state = {currencies : []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('api/currency')
            .then(response => response.json())
            .then(data => this.setState({currencies: data}));
    }

    async remove(id) {
        await fetch(`api/currency/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedCurrencies = [...this.state.currencies].filter(i => i.id !== id);
            this.setState({currencies : updatedCurrencies});
        });
    }

    render() {
        const {currencies, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const currencyList = currencies.map(currency => {
            return <tr key={currency.id}>
                <td>{currency.id}</td>
                <td style={{whiteSpace: 'nowrap'}}>{currency.name}</td>
                <td>{currency.shortname}</td>
                <td>{currency.symbol}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/currency/" + currency.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(currency.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/currency/new">Add Currency</Button>
                    </div>
                    <h3>Currencies</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="10%">#</th>
                            <th width="20%">Name</th>
                            <th width="20%">Shortname</th>
                            <th width="20%">Symbol</th>
                            <th width="30%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {currencyList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default CurrencyList;