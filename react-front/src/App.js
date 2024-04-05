import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import UserList from './components/UserList';
import UserEdit from "./components/UserEdit";
import CurrencyList from './components/CurrencyList';
import CurrencyEdit from "./components/CurrencyEdit";
import BankAccountList from './components/BankAccountList';
import BankAccountEdit from "./components/BankAccountEdit";
import BankAccountCurrencyList from './components/BankAccountCurrencyList';
import BankAccountCurrencyEdit from "./components/BankAccountCurrencyEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/users' exact={true} component={UserList}/>
            <Route path='/users/:id' exact={true} component={UserEdit}/>
            <Route path='/currencies' exact={true} component={CurrencyList}/>
            <Route path='/currency/:id' exact={true} component={CurrencyEdit}/>
            <Route path='/accounts' exact={true} component={BankAccountList}/>
            <Route path='/account/:id' exact={true} component={BankAccountEdit}/>
            <Route path='/bankaccountcurrencies' exact={true} component={BankAccountCurrencyList}/>
            <Route path='/bankaccountcurrencies/:id1/:id2' exact={true} component={BankAccountCurrencyEdit}/>
            <Route path="/bankaccountcurrency/new" component={BankAccountCurrencyEdit} />
          </Switch>
        </Router>
    )
  }
}

export default App;