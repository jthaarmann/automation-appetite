import React from 'react'
import { Route, IndexRoute } from 'react-router'

import App from './containers/App'
import Dashboard from './containers/Dashboard'
import ExerciseDashboard from './containers/ExerciseDashboard'
import BoardModule from './containers/BoardModule'
import Day from './containers/Day'

export default 
<Route path="/" component={App}>
	<Route path="/diet" component={Dashboard}>
    	<Route path="/diet/:moduleName" component={BoardModule}/>
    </Route>
    <Route path="/days/:dayAbbreviation" component={Day}/>
    <Route path="/exercise" component={ExerciseDashboard}>
    	<Route path="/exercise/:moduleName" component={BoardModule}/>
    </Route>
    <IndexRoute component={Dashboard}/>    
</Route>
