import React, { Component } from 'react'
import { BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table'
import { loadPortions } from '../actions'
import {connect} from 'react-redux'

class DietTable extends Component {
   constructor(props){
	   super(props);
   }
  
   
    componentWillMount() {
        this.props.loadPortions;
    }

    render() {
        let data = Object.keys(this.props.entities.foodPortions).map(key => this.props.entities.foodPortions[key]);
        
        return (
            <div>          
                <BootstrapTable data={data} striped={true} hover={true} remote={true} options={this.options}>
                    <TableHeaderColumn dataField="id" isKey={true} dataAlign="center">Id</TableHeaderColumn>
                </BootstrapTable>
            </div>
        )
    }
}
const mapStateToProps = (state, ownProps) => {
	const { entities } = state
	return { entities }
}
export default connect(mapStateToProps, { loadPortions }) (DietTable);