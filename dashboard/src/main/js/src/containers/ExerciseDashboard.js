import React, { Component } from 'react';
import { connect } from 'react-redux'
import { PageHeader, Grid, Row, Col, } from 'react-bootstrap'
import ExerciseByType from '../components/ExerciseByType'
import ExerciseByDay from '../components/ExerciseByDay'
import Days from '../components/Days'


class ExerciseDashboard extends Component {
  render() {
    return (
    		<div className="container">
			<div className="container">
				<PageHeader className="center">Exercise (Past Week)</PageHeader>
			</div>        

			<div className="container">
				<Grid>
					<Row className="show-grid">
					<Col md={4}>                
						<ExerciseByType />
					</Col>
					<Col md={4}>                
						<ExerciseByDay />
					</Col>					
					<Col md={4}>
						<Days />
					</Col>					
					</Row>
				</Grid>
			</div>
			
			<div className="container">
				{this.props.children}
			</div>
		</div>
    );
  }
}

const mapStateToProps = (state, ownProps) => {
	const { entities } = state
	return { entities }
}

export default connect(mapStateToProps, { 
}) (ExerciseDashboard);