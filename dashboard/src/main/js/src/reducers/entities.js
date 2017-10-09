import merge from 'lodash/merge'
import assign from 'lodash/assign'

const defaultState = {
  foodItems: {},
  foodItemsPage: {
	  page: {
		  totalElements: 0
	  }
  },
  foodPortions: {},
  foodPortionsPage: {
	page: {
		totalElements: 0,
		size: 0,
		totalPages: 0,
		number: 0
	}
  },
  foodGroupsChart: {},
  foodGroupsChartData: {},
  vegetablePortions: {},
  vegetablePortionsPage: {
	  page: {
		  totalElements: 0
	  }
  },
  vegetablePortionsChart: {},
  vegetablePortionsChartData: {},
  exercises: {},
  exercisesPage: {
	  page: {
		  totalElements: 0
	  }
  },
  exerciseSessions: {},
  exerciseSessionsPage: {
	  page: {
		  totalElements: 0
	  }
  },
  exerciseSessionsChart: {},
  exerciseSessionsChartData: {},
  exerciseByDayChart: {},
  exerciseByDayChartData: {}
}



// Updates an entity cache in response to any action with response.entities.

const entities = (state = defaultState , action) => {

  if (action.response && action.response.entities) {
	  if(action.type === 'QUARANTINES_SUCCESS' || action.type === 'QUARANTINES_SORTED_SUCCESS'){     
		  return assign({}, state, action.response.entities)
	  } else {
		  return merge({}, state, action.response.entities)
	  }
  }
  return state
}

export default entities