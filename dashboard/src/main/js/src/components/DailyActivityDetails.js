import { connect } from 'react-redux'
import { PageHeader, Row, Col } from 'react-bootstrap'
import React, { PropTypes } from 'react';
import DashboardPanel from './DashboardPanel'


class DailyActivityDetails extends DashboardPanel {

	static propTypes = {
		dayAbbreviation: PropTypes.string.isRequired
	}
	
	dayName(dayAbbreviation) {
		let map = {
				'Su' : 'Sunday',
				'M' : 'Monday',
				'Tu' : 'Tuesday',
				'W' : 'Wednesday',
				'Th' : 'Thursday',
				'F' : 'Friday',
				'Sa' : 'Saturday'
				};
		return map[dayAbbreviation];
	}
	
render() {
		
		const { 
			entities
		} = this.props
			
		let dayAbbreviation = this.props.dayAbbreviation;
		
		return (

			<Row className="show-grid">
				<Col xs={12}>
				<Row>
				<div className="container"  id="dayPageTitle">
					<PageHeader className="center">{this.dayName(dayAbbreviation)}</PageHeader>
				</div> 
				</Row>
				</Col>
			</Row>
		);
	}
}

const mapStateToProps = (state, ownProps) => {
	const { entities } = state
	return { entities }
}

export default connect(mapStateToProps, { 
}) (DailyActivityDetails);

