import React, { Component , PropTypes} from 'react'
import {BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from 'recharts';



class SimpleBarChart extends Component {
  static propTypes = {
		    data: PropTypes.array.isRequired
	  }
	render () {
  	return (
    	<BarChart width={325} height={250} data={this.props.data}
            margin={{top: 0, right: 0, left: 0, bottom: 0}}>
       <XAxis dataKey="items"/>
       <YAxis />
       <CartesianGrid strokeDasharray="2 2"/>
       <Tooltip/>
       <Legend />
       <Bar dataKey="value" fill="#0088FE" />
      </BarChart>
    );
  }
}

export default SimpleBarChart