import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from '../AppNavbar';

class BankAccountEdit extends Component {

    emptyItem = {
        userId: '',
        type: '',
        balance: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const bankAccount = await (await fetch(`/api/bankaccounts/${this.props.match.params.id}`)).json();
            this.setState({item : bankAccount});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }
    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch(`/api/bankaccounts{item.id ? '/' + item.id : ''}`, {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/bankaccounts');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Bank Account' : 'Add Bank Account'}</h2>;

        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="userid">User Id</Label>
                        <Input type="text" name="userid" id="userid" value={item.userId || ''}
                               onChange={this.handleChange} autoComplete="userid"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="type">type</Label>
                        <Input type="text" name="type" id="type" value={item.type || ''}
                               onChange={this.handleChange} autoComplete="type"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="balance">Balance</Label>
                        <Input type="text" name="balance" id="balance" value={item.email || ''}
                               onChange={this.handleChange} autoComplete="Balance"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/bankaccounts">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}
export default withRouter(BankAccountEdit);