import React from 'react';
import AppNavbar from './AppNavbar';

const AppNavbarLayout = ({ children }) => {
  return (
    <div>
      <AppNavbar />
      {children}
    </div>
  );
};

export default AppNavbarLayout;