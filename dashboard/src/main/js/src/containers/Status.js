import React, { Component } from 'react';
import { PageHeader, Grid, Row, Col, } from 'react-bootstrap'
import { getEnvironment} from '../Environment'
import Versions from '../components/Versions'

class Status extends Component {
  render() {
    return (
		<div className="container">
			<div className="container">
				<PageHeader className="center">Status  ({getEnvironment()})</PageHeader>
			</div>        

			<div className="container">
				<Grid>
					<Row className="show-grid">
						<Col xs={12}>
							<Versions />
						</Col>
					</Row>
				</Grid>
			</div>
		</div>
    );
  }
}

export default Status;
