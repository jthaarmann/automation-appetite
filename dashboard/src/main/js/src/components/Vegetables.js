import React from 'react'
import { connect } from 'react-redux'
import NavLink from '../components/NavLink'
import { Button, Panel } from 'react-bootstrap'
import ErrorMessage from './ErrorMessage'
import SimpleBarChart from './SimpleBarChart'
import { loadVegetablePortions, loadVegetablePortionsChartData } from '../actions'

class Vegetables extends React.Component {

	
	 componentWillMount() {
			this.props.loadVegetablePortions()
			this.props.loadVegetablePortionsChartData()
	 }
		chartData() {
			let chartData = Object.keys(this.props.entities.vegetablePortionsChart).map(key => this.props.entities.vegetablePortionsChart[key]);
			return chartData;
	}
	

	render() {
		const { 
			entities
		} = this.props
		
		
		let content = null;
		if(entities.vegetablePortionsPage.page.totalElements){
			content = <NavLink to="/diet/vegetables"><Button block bsStyle="success" bsSize="large">Total Count: {entities.vegetablePortionsPage.page.totalElements}</Button></NavLink>
		} 
		else {
			content =  <ErrorMessage/> 
		}
	      return (
			<Panel id="vegetables_panel" header={'Vegetables'} bsStyle="success">
			<SimpleBarChart data={this.chartData()}/>
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
	loadVegetablePortions, loadVegetablePortionsChartData
}) (Vegetables);