import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from '../AppNavbar';
import { Link } from 'react-router-dom';
import './SortButon.css';

class UserList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      users: [],
      isLoading: true,
      sortColumn: 'name',
      sortDirection: 'asc'
    };
    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    this.fetchUsers();
  }

  async fetchUsers() {
    const { sortColumn, sortDirection } = this.state;
    const response = await fetch(`api/users?sort=${sortColumn}&direction=${sortDirection}`);
    const data = await response.json();
    this.setState({ users: data, isLoading: false });
  }

  async remove(id) {
    await fetch(`api/users/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(response => {
      if (response.ok) {
      let updatedUsers = [...this.state.users].filter(i => i.id !== id);
      this.setState({ users: updatedUsers });
      }
    });
  }

  handleSort(column) {
    this.setState(prevState => {
      const { sortColumn, sortDirection } = prevState;
      const direction = column === sortColumn && sortDirection === 'asc' ? 'desc' : 'asc';

      const sortedUsers = [...prevState.users].sort((a, b) => {
        if (a[column] < b[column]) return direction === 'asc' ? -1 : 1;
        if (a[column] > b[column]) return direction === 'asc' ? 1 : -1;
        return 0;
      });

      return {
        users: sortedUsers,
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
    const { users, isLoading } = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const userList = users.map(user => {
      return (
        <tr key={user.id}>
          <td style={{ whiteSpace: 'nowrap' }}>{user.name}</td>
          <td>{user.surname}</td>
          <td>{user.email}</td>
          <td>{user.password}</td>
          <td>
            <ButtonGroup>
              <Button size="sm" color="primary" tag={Link} to={"/users/" + user.id}>Edit</Button>
              <Button size="sm" color="danger" onClick={() => this.remove(user.id)}>Delete</Button>
            </ButtonGroup>
          </td>
        </tr>
      );
    });

    return (
      <div>
        <AppNavbar />
        <Container fluid>
          <div className="float-right">
            <Button color="success" tag={Link} to="/users/new">Add User</Button>
          </div>
          <h3>Users</h3>
          <Table className="mt-4">
            <thead>
              <tr>
                <th width="20%">
                  Name
                  {this.renderSortButton('name')}
                </th>
                <th width="20%">
                  Surname
                  {this.renderSortButton('surname')}
                </th>
                <th width="20%">
                  Email
                  {this.renderSortButton('email')}
                </th>
                <th width="20%">
                  Password
                  {this.renderSortButton('password')}
                </th>
                <th width="20%">Actions</th>
              </tr>
            </thead>
            <tbody>
              {userList}
            </tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default UserList;