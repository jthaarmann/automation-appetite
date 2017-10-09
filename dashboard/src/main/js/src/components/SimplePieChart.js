import React, { Component , PropTypes}  from 'react'
import { PieChart, Pie, Cell } from 'recharts';

const COLORS = ['#0088FE', '#00C49F', '#FFBB28', '#FF8042', '#FE6028'];

const RADIAN = Math.PI / 180;                    
const renderCustomizedLabel = ({ cx, cy, midAngle, innerRadius, outerRadius, items, value}) => {
  const radius = outerRadius + (outerRadius - innerRadius) * 0.25;
  const x  = cx + radius * Math.cos(-midAngle * RADIAN);
  const y = cy  + radius * Math.sin(-midAngle * RADIAN);
 
  return (
    <text x={x} y={y} fill="black" textAnchor={x > cx ? 'start' : 'end'} dominantBaseline="central" fontSize="12" style={{fontWeight: "bold"}}>
        {items} - {value}        
    </text>
  );
};

class SimplePieChart extends Component {
  static propTypes = {
		    data: PropTypes.array.isRequired
	  }

	render () {
  	return (
    <PieChart width={800} height={250} onMouseEnter={this.onPieEnter} >
        <Pie
          data={this.props.data} 
          cx={175} 
          cy={125} 
          labelLine={true}
          label={renderCustomizedLabel}          
          outerRadius={80} 
          fill="#8884d8" >
        	{this.props.data.map((entry, index) => <Cell key={index} fill={COLORS[index % COLORS.length]}  /> )}
        </Pie>
      </PieChart>     
    );
  }
}

export default SimplePieChart;