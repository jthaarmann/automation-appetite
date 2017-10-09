import React from 'react'
import { Panel, ProgressBar } from 'react-bootstrap'

class DashboardPanel extends React.Component {

	constructor(props){
	   super(props);
	   this.state = {loading: true};
	}
		
	componentDidMount(){
	   this.state = {loading: false};
	}

	header(){
		//override this method and return header for the panel
	}

	panelId(){
		//override this method and return html id for the panel
	}
	
	content(){
		//override this method and return content for the panel
	}

	render() {
		let content = null;
		if(this.state.loading){
			content =  <ProgressBar active bsStyle="success" now={100} />
		}
		else {
			content = this.content(); 
		}

	    return (
			<Panel id={this.panelId()} header={this.header()} bsStyle="success">
				{content}
			</Panel>
		);
	} 
} 

export default DashboardPanel;