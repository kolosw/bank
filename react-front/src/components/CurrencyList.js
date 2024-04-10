import React, { Component } from 'react'
import { Button, ButtonGroup, Container, Table } from 'reactstrap'
import AppNavbar from '../AppNavbar'
import { Link } from 'react-router-dom'
import './SortButon.css';

class CurrencyList extends Component {
  constructor(props) {
    super(props)
    this.state = {
      currencies: [],
      isLoading: true,
      sortColumn: 'name',
      sortDirection: 'asc'
    }
    this.remove = this.remove.bind(this)
  }

  componentDidMount() {
    this.fetchCurrencies()
  }

  async fetchCurrencies() {
    const { sortColumn, sortDirection } = this.state
    const response = await fetch(`api/currency?sort=${sortColumn}&direction=${sortDirection}`)
    const data = await response.json()
    this.setState({ currencies: data, isLoading: false })
  }

  async remove(id) {
    await fetch(`api/currency/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(response => {
      if (response.ok) {
      let updatedCurrencies = [...this.state.currencies].filter(i => i.id !== id)
      this.setState({ currencies: updatedCurrencies })
      }
    })
  }

  handleSort(column) {
    this.setState(prevState => {
      const { sortColumn, sortDirection } = prevState;
      const direction = column === sortColumn && sortDirection === 'asc' ? 'desc' : 'asc';

      const sortedCurrencies = [...prevState.currencies].sort((a, b) => {
        if (a[column] < b[column]) return direction === 'asc' ? -1 : 1;
        if (a[column] > b[column]) return direction === 'asc' ? 1 : -1;
        return 0;
      });

      return {
        currencies: sortedCurrencies,
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
    const { currencies, isLoading } = this.state

    if (isLoading) {
      return <p>Loading...</p>
    }

    const currencyList = currencies.map(currency => {
      return (
        <tr key={currency.id}>
          <td style={{ whiteSpace: 'nowrap' }}>{currency.name}</td>
          <td>{currency.shortname}</td>
          <td>{currency.symbol}</td>
          <td>
            <ButtonGroup>
              <Button size="sm" color="primary" tag={Link} to={"/currency/" + currency.id}>Edit</Button>
              <Button size="sm" color="danger" onClick={() => this.remove(currency.id)}>Delete</Button>
            </ButtonGroup>
          </td>
        </tr>
      )
    })

    return (
      <div>
        <AppNavbar />
        <Container fluid>
          <div className="float-right">
            <Button color="success" tag={Link} to="/currency/new">Add Currency</Button>
          </div>
          <h3>Currencies</h3>
          <Table className="mt-4">
            <thead>
              <tr>
                <th width="25%">
                  Name
                  {this.renderSortButton('name')}
                </th>
                <th width="25%">
                  Short name
                  {this.renderSortButton('shortname')}
                </th>
                <th width="25%">
                  Symbol
                  {this.renderSortButton('symbol')}
                </th>
                <th width="25%">Actions</th>
              </tr>
            </thead>
            <tbody>
              {currencyList}
            </tbody>
          </Table>
        </Container>
      </div>
    )
  }
}

export default CurrencyList