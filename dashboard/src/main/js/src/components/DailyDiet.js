import { connect } from 'react-redux'
import { Panel, Row, Col } from 'react-bootstrap'
import React, { PropTypes } from 'react';
import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table'
import { loadDailyDiet} from '../actions'
import DashboardPanel from './DashboardPanel'

class DailyDiet extends DashboardPanel {
	constructor(props){
		super(props);
		this.props.loadDailyDiet(this.props.dayAbbreviation);
	}
	
	static propTypes = {
		dayAbbreviation: PropTypes.string.isRequired
	}

	foodItems(){
		let foodItems =[];
		if(this.props.entities.foodItems){
			foodItems = Object.keys(this.props.entities.foodItems).map(key => this.props.entities.foodItems[key]);
		}
		return foodItems;
	}
	
	
render() {
		
		const { 
			entities
		} = this.props
			
		let dayAbbreviation = this.props.dayAbbreviation;
		
		let showGroup = function(cell){
			return cell.name;
		}
		
		let sortGroup = function(a, b, order){
			if (order === 'desc') {
				return a.name - b.name;
			} else {
				return b.name - a.name;
			}
		}
		

		let content = null;
		if(dayAbbreviation) {
			content = (
					<Col xs={12} id="foodItems">
						<Panel id="daily_foodItems" header={'Diet'} bsStyle="success">
							<BootstrapTable data={this.foodItems()} striped={true} hover={true} >
			                    <TableHeaderColumn id="id" dataField="id" isKey={true} hidden={true}>d</TableHeaderColumn>
			                    <TableHeaderColumn id="name" dataSort dataField="name">Name</TableHeaderColumn>
			                    <TableHeaderColumn id="group" dataSort dataField="group" dataFormat={showGroup} sortFunc={sortGroup}>Group</TableHeaderColumn>
			                </BootstrapTable>
						</Panel>
					</Col>
				);
		}
			
		return (

			<Row className="show-grid">
				{content}
			</Row>
		);
	}
}

const mapStateToProps = (state, ownProps) => {
	const { entities } = state
	return { entities }
}

export default connect(mapStateToProps, { 
	loadDailyDiet
}) (DailyDiet);

