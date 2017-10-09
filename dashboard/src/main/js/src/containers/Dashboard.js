import React, { Component} from 'react'
import { connect } from 'react-redux'
import { PageHeader, Grid, Row, Col, } from 'react-bootstrap'
import Portions from '../components/Portions'
import Vegetables from '../components/Vegetables'
import Days from '../components/Days'


class Dashboard extends Component {

	render() {

		return (
				<div className="container">
					<div className="container">
						<PageHeader className="center">Diet (Past Week)</PageHeader>
					</div>        

					<div className="container">
						<Grid>
							<Row className="show-grid">
								<Col md={4}>                
									<Portions />
								</Col>
								<Col md={4}>                
									<Vegetables />
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
}) (Dashboard);