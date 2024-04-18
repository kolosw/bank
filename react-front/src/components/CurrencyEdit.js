import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import { CurrencyService } from '../services/CurrencyService';

class CurrencyEdit extends Component {

    emptyItem = {
        name: '',
        shortname: '',
        symbol: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.currencyService = new CurrencyService();
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const currency = (await this.currencyService.getById(this.props.match.params.id)).data;
            this.setState({item : currency});
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
        this.currencyService.create(item);
        this.props.history.push('/currencies');
    }

    render() {
        const {item} = this.state;
        const title = <h2>{item.id ? 'Edit Currency' : 'Add Currency'}</h2>;

        return <div>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="name">Name</Label>
                        <Input type="text" name="name" id="name" value={item.name || ''}
                               onChange={this.handleChange} autoComplete="name"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="Shortname">Shortname</Label>
                        <Input type="text" name="shortname" id="shortname" value={item.shortname || ''}
                               onChange={this.handleChange} autoComplete="shortname"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="symbol">Symbol</Label>
                        <Input type="text" name="symbol" id="symbol" value={item.symbol || ''}
                               onChange={this.handleChange} autoComplete="symbol"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/currencies">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}
export default CurrencyEdit;