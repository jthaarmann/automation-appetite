import React from 'react'
import { connect } from 'react-redux'
import NavLink from '../components/NavLink'
import { Button, Panel, Alert, Nav, NavItem } from 'react-bootstrap'


class Days extends React.Component {
	  
	render() {
		return (
				<Panel id="daily_summary_panel" header={'Daily Summary'} bsStyle="success">
				<Nav bsStyle="pills" stacked>
			    	<NavItem><NavLink id="sunday_link" to="/days/Su">Sunday</NavLink></NavItem>
			    	<NavItem><NavLink id="monday_link" to="/days/M">Monday</NavLink></NavItem>
			    	<NavItem><NavLink id="tuesday_link" to="/days/Tu">Tuesday</NavLink></NavItem>
			    	<NavItem><NavLink id="wednesday_link" to="/days/W">Wednesday</NavLink></NavItem>
			    	<NavItem><NavLink id="thursday_link" to="/days/Th">Thursday</NavLink></NavItem>
			    	<NavItem><NavLink id="friday_link" to="/days/F">Friday</NavLink></NavItem>
			    	<NavItem><NavLink id="saturday_link" to="/days/Sa">Saturday</NavLink></NavItem>
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