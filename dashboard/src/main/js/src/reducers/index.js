import { routerReducer as routing } from 'react-router-redux'
import { combineReducers } from 'redux'

import entities from './entities'
import errorMessage from './errors'

const rootReducer = combineReducers({
  entities,
  errorMessage,
  routing
})

export default rootReducer
