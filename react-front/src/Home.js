import React, { Component } from 'react';
import './App.css';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
    render() {
        return (
            <div>
                <Container fluid>
                    <Button color="link"><Link to="/users">Users</Link></Button>
                    <Button color="link"><Link to="/currencies">Currencies</Link></Button>
                    <Button color="link"><Link to="/accounts">Bank Accounts</Link></Button>
                    <Button color="link"><Link to="/bankaccountcurrencies">Bank Accounts Currencies</Link></Button>
                </Container>
            </div>
        );
    }
}
export default Home;