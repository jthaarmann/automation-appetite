import React from 'react'
import { connect } from 'react-redux'
import NavLink from '../components/NavLink'
import { Button, Panel, Alert } from 'react-bootstrap'
import SimplePieChart from './SimplePieChart'
import { loadPortions, loadFoodGroupsChartData} from '../actions'


class Portions extends React.Component {
	  
	 componentWillMount() {
			this.props.loadPortions();
			this.props.loadFoodGroupsChartData();
	 }
	  
	 chartData() {
		 let chartData = Object.keys(this.props.entities.foodGroupsChart).map(key => this.props.entities.foodGroupsChart[key]);
		 return chartData;
	 }
	  
	render() {
		const { 
			entities
		} = this.props
		
		
		let content = null;
		if(entities.foodPortionsPage.page.totalElements){
			content = <NavLink to="/diet/portions"><Button block bsStyle="success" bsSize="large">Total Count: {entities.foodPortionsPage.page.totalElements}</Button></NavLink>	
		} 
		else {
			content = <Alert bsStyle='warning'> Loading data, Please wait....</Alert>
		}	
		return (
				<Panel id="portions_panel" header={'Portions By Food Group'} bsStyle="success">
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
	loadPortions, loadFoodGroupsChartData
}) (Portions);