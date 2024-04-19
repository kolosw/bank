import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import BankAccountService from '../services/BankAccountService';

class BankAccountEdit extends Component {

    bankAccountService = new BankAccountService();

    emptyItem = {
        userId: '',
        type: ''
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
            const bankAccount = (await this.bankAccountService.getById(this.props.match.params.id)).data;
            this.setState({item : bankAccount});
        }
    }

    handleChange(event) {
       const target = event.target;
       const value = target.value;
       const name = target.name;
       this.setState(prevState => {
         const item = { ...prevState.item };
         item[name] = value;
         return { item };
       });
     }
    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;
        this.bankAccountService.create(item);
        this.props.history.push('/accounts');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Bank Account' : 'Add Bank Account'}</h2>;

        return <div>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="userId">User Id</Label>
                        <Input type="text" name="userId" id="userId" value={item.userId || ''}
                               onChange={this.handleChange} autoComplete="userId"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="type">Type</Label>
                        <Input type="text" name="type" id="type" value={item.type || ''}
                               onChange={this.handleChange} autoComplete="type"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/accounts">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}
export default BankAccountEdit;