import React from 'react'
import { connect } from 'react-redux'
import { Button, Panel } from 'react-bootstrap'
import NavLink from '../components/NavLink'
import { loadExerciseByDayChartData } from '../actions'
import ErrorMessage from './ErrorMessage'
import SimpleBarChart from './SimpleBarChart'

class ExerciseByDay extends React.Component{

   componentWillMount(){
        this.props.loadExerciseByDayChartData();
   }

   chartData(){
       let chartData = Object.keys(this.props.entities.exerciseByDayChart).map(key => this.props.entities.exerciseByDayChart[key])
       return chartData;
   }

   render(){
      const { entities } = this.props;

      let content = null;
    
      if(entities.exerciseSessionsPage.page.totalElements >= 0){
	    content = <NavLink to="/exercise/byDay"><Button block bsStyle="success" bsSize="large"> Total Count: {entities.exerciseSessionsPage.page.totalElements} </Button></NavLink>	
      }

      return (
          <Panel id="exerciseByDay_Panel" header={'Exercise By Day'} bsStyle="success">
            <SimpleBarChart data={this.chartData()}/>
            {content}
          </Panel>
      );
   }
}

const mapStateToProps = (state, ownProps) => {
    const { entities } = state
    return {entities}
}

export default connect(mapStateToProps,{
	loadExerciseByDayChartData
}) (ExerciseByDay);
