import React, { Component } from 'react'
import { Navbar, Nav, NavItem } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'
import { Link } from 'react-router'

class App extends Component {
  render() {
    return (
      <div>
        <Navbar inverse collapseOnSelect>
          <Navbar.Header>
              <Navbar.Brand>
                <Link to="/diet" id="menu_home_link">Automation Appetite</Link>
              </Navbar.Brand>
              <Navbar.Toggle />
          </Navbar.Header>
          <Navbar.Collapse>
            <Nav pullRight>
              <LinkContainer to="/diet" id="menu_diet_link"><NavItem>Diet</NavItem></LinkContainer>
              <LinkContainer to="/exercise" id="menu_exercise_link"><NavItem>Exercise</NavItem></LinkContainer>
              </Nav>
          </Navbar.Collapse>
      </Navbar>
        {this.props.children}
      </div>
    );
  }
}

export default App;
