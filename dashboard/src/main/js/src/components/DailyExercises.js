import { connect } from 'react-redux'
import { Panel, Row, Col } from 'react-bootstrap'
import React, { PropTypes } from 'react';
import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table'
import { loadDailyExercises } from '../actions'
import DashboardPanel from './DashboardPanel'

class DailyExercises extends DashboardPanel {
	constructor(props){
		super(props);
		this.props.loadDailyExercises(this.props.dayAbbreviation);
	}
	
	static propTypes = {
		dayAbbreviation: PropTypes.string.isRequired
	}

	exercises(){
		let exercises =[];
		if(this.props.entities.exercises){
			exercises = Object.keys(this.props.entities.exercises).map(key => this.props.entities.exercises[key]);
		}
		return exercises;
	}
	
	
render() {
		
		const { 
			entities
		} = this.props
			
		let dayAbbreviation = this.props.dayAbbreviation;
		
		let showType = function(cell){
			return cell.name;
		}
		
		let sortType = function(a, b, order){
			if (order === 'desc') {
				return a.name - b.name;
			} else {
				return b.name - a.name;
			}
		}
		

		let content = null;
		if(dayAbbreviation) {
			content = (
					<Col xs={12} id="exercises">
						<Panel id="daily_exercises" header={'Exercises'} bsStyle="success">
							<BootstrapTable data={this.exercises()} striped={true} hover={true} >
			                    <TableHeaderColumn id="id" dataField="id" isKey={true} hidden={true}>d</TableHeaderColumn>
			                    <TableHeaderColumn id="name" dataSort dataField="name">Name</TableHeaderColumn>
			                    <TableHeaderColumn id="type" dataSort dataField="exerciseType" dataFormat={showType} sortFunc={sortType}>Type</TableHeaderColumn>
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
	loadDailyExercises
}) (DailyExercises);

