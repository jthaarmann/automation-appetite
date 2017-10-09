import React from 'react'
import { connect } from 'react-redux'
import NavLink from '../components/NavLink'
import { Button, Panel } from 'react-bootstrap'
import ErrorMessage from './ErrorMessage'
import SimplePieChart from './SimplePieChart'
import { loadExerciseSessions, loadExerciseSessionsChartData} from '../actions'

class ExerciseByType extends React.Component {
	  
	componentWillMount() {
		 this.props.loadExerciseSessions();
		 this.props.loadExerciseSessionsChartData();
	}
	  
	chartData() {
			let chartData = Object.keys(this.props.entities.exerciseSessionsChart).map(key => this.props.entities.exerciseSessionsChart[key]);
			return chartData;
	}
	
	render() {
		
		 const { 
				entities
			} = this.props
			
		let content = null;
		if(entities.exerciseSessionsPage.page.totalElements){
			content = <NavLink to="/exercise/exerciseSessions"><Button block bsStyle="success" bsSize="large">Total Count: {entities.exerciseSessionsPage.page.totalElements}</Button></NavLink>	
		} 
		else {
			content =  <ErrorMessage/> 
		}		

		return (
				<Panel id="exercise_panel" header={'Exercise By Types'} bsStyle="success">
					<SimplePieChart data={this.chartData()}/>
					{content}	
				</Panel>
		);
	} 
} 

const mapStateToProps = (state, ownProps) => {
	const { entities } = state
	return { entities }
}

export default connect(mapStateToProps, { 
	loadExerciseSessions, loadExerciseSessionsChartData
}) (ExerciseByType);