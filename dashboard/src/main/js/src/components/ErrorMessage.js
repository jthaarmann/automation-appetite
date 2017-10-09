import React from 'react'
import { Alert } from 'react-bootstrap'

class ErrorMessage extends React.Component {

    render() {
		return (
				<Alert bsStyle='danger'> We are experiencing difficulty. Please try again later.</Alert>				
		);
	} 
}

 export default ErrorMessage;