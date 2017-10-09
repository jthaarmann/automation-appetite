import React, { Component } from 'react'
import { Row, Grid } from 'react-bootstrap'
import DailyActivityDetails from '../components/DailyActivityDetails'
import DailyExercises from '../components/DailyExercises'
import DailyDiet from '../components/DailyDiet'

class Day extends Component {
	
	constructor(props){
		super(props);
		this.state = {
				dayAbbreviation: this.props.params.dayAbbreviation
		};
	}
	
	render() {
		return (
			<Grid>
				<Row className="show-grid">
					<DailyActivityDetails dayAbbreviation={this.state.dayAbbreviation}/>
				</Row>
				<Row className="show-grid">
					<DailyDiet dayAbbreviation={this.state.dayAbbreviation}/>
				</Row>
				<Row className="show-grid">
					<DailyExercises dayAbbreviation={this.state.dayAbbreviation}/>
				</Row>
			</Grid>	
		);
	}
}

export default Day;
