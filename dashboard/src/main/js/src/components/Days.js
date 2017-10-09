import React from 'react'
import { connect } from 'react-redux'
import NavLink from '../components/NavLink'
import { Button, Panel, Alert, Nav, NavItem } from 'react-bootstrap'


class Days extends React.Component {
	  
	render() {
		return (
				<Panel id="portions_panel" header={'Daily Summary'} bsStyle="success">
				<Nav bsStyle="pills" stacked>
			    	<NavItem><NavLink to="/days/Su">Sunday</NavLink></NavItem>
			    	<NavItem><NavLink to="/days/M">Monday</NavLink></NavItem>
			    	<NavItem><NavLink to="/days/Tu">Tuesday</NavLink></NavItem>
			    	<NavItem><NavLink to="/days/W">Wednesday</NavLink></NavItem>
			    	<NavItem><NavLink to="/days/Th">Thursday</NavLink></NavItem>
			    	<NavItem><NavLink to="/days/F">Friday</NavLink></NavItem>
			    	<NavItem><NavLink to="/days/Sa">Saturday</NavLink></NavItem>
				</Nav>
				</Panel>
		);
	} 
} 

const mapStateToProps = (state, ownProps) => {
	const { entities } = state
	return { entities }
}

export default connect(mapStateToProps, { 
}) (Days);