import React, { Component, PropTypes } from 'react'
import { connect } from 'react-redux'
import { Panel } from 'react-bootstrap'

import DietTable from '../components/DietTable'

class BoardModule extends Component {
  static propTypes = {
    entities: PropTypes.object.isRequired,
  }
  
  camelizeWithSpaces(s) {
	    return s.split(/(?=[A-Z])/).map(function(p) {
	        return p.charAt(0).toUpperCase() + p.slice(1);
	    }).join(' ');
  }

  render() {
    
    const { 
      params: {moduleName},
      entities
    } = this.props
    
    return (
      <div className="container">
        <Panel id="list_panel" header={this.camelizeWithSpaces(moduleName)}>
          <div id="list_panel_table">
          	<DietTable/>
          </div>    
        </Panel>
      </div>
    )
  }
}

const mapStateToProps = (state, ownProps) => {
  const { entities } = state

  return { entities }
}

export default connect(mapStateToProps, {  })(BoardModule);
