import { CALL_API } from '../middleware/api'
import { Schema } from '../middleware/schema'

export const RESET_ERROR_MESSAGE = 'RESET_ERROR_MESSAGE'

// Resets the currently visible error message.
export const resetErrorMessage = () => ({
    type: RESET_ERROR_MESSAGE
})

// PORTIONS actions ////////////////////////
export const PORTIONS_REQUEST = 'PORTIONS_REQUEST'
export const PORTIONS_SUCCESS = 'PORTIONS_SUCCESS'
export const PORTIONS_FAILURE = 'PORTIONS_FAILURE'
	
// Middleware meta
const fetchPortions = (endpoint) => ({
  [CALL_API]: {
    types: [ PORTIONS_REQUEST, PORTIONS_SUCCESS, PORTIONS_FAILURE ],
    endpoint: endpoint,
    schema: Schema.PORTIONS_DATA
  }
})

// Dispatch quarantine action
export const loadPortions = (pageNumber,sortName, sortOrder) => (dispatch, getState) => {
  let queryParams = '';
  if(sortName){
    queryParams = 'page=' + pageNumber + '&sort=' + sortName + ',' + sortOrder;
  } else {
    queryParams = 'page=' + pageNumber;
  }
  return dispatch(fetchPortions('entities/foodPortions?' + queryParams))
}

export const FOOD_GROUPS_CHART_REQUEST = 'FOOD_GROUPS_CHART_REQUEST'
export const FOOD_GROUPS_CHART_SUCCESS = 'FOOD_GROUPS_CHART_SUCCESS'
export const FOOD_GROUPS_CHART_FAILURE = 'FOOD_GROUPS_CHART_FAILURE'

// Middleware meta
const fetchFoodGroupsChartData = (endpoint) => ({
  [CALL_API]: {
    types: [ FOOD_GROUPS_CHART_REQUEST, FOOD_GROUPS_CHART_SUCCESS, FOOD_GROUPS_CHART_FAILURE ],
    endpoint: endpoint,
    schema: Schema.FOOD_GROUPS_CHART_DATA
  }
})

// Dispatch food group chart action
export const loadFoodGroupsChartData = () => (dispatch, getState) => {
  return dispatch(fetchFoodGroupsChartData('portions/chartDataByFoodGroups'))
}

// Exercise actions ///////////////////////////
export const EXERCISE_SESSIONS_REQUEST = 'EXERCISE_SESSIONS_REQUEST'
export const EXERCISE_SESSIONS_SUCCESS = 'EXERCISE_SESSIONS_SUCCESS'
export const EXERCISE_SESSIONS_FAILURE = 'EXERCISE_SESSIONS_FAILURE'
// Middleware meta
const fetchExerciseSessions = (endpoint) => ({
  [CALL_API]: {
    types: [ EXERCISE_SESSIONS_REQUEST, EXERCISE_SESSIONS_SUCCESS, EXERCISE_SESSIONS_FAILURE ],
    endpoint: endpoint,
    schema: Schema.EXERCISE_SESSIONS_DATA
  }
})
// Dispatch Exercise sessions action
export const loadExerciseSessions = () => (dispatch, getState) => {
  return dispatch(fetchExerciseSessions('entities/exerciseSessions'))
}

export const EXERCISE_SESSIONS_CHART_REQUEST = 'EXERCISE_SESSIONS_CHART_REQUEST'
export const EXERCISE_SESSIONS_CHART_SUCCESS = 'EXERCISE_SESSIONS_CHART_SUCCESS'
export const EXERCISE_SESSIONS_CHART_FAILURE = 'EXERCISE_SESSIONS_CHART_FAILURE'
// Middleware meta
const fetchExerciseSessionsChartData = (endpoint) => ({
  [CALL_API]: {
    types: [ EXERCISE_SESSIONS_CHART_REQUEST, EXERCISE_SESSIONS_CHART_SUCCESS, EXERCISE_SESSIONS_CHART_FAILURE ],
    endpoint: endpoint,
    schema: Schema.EXERCISE_SESSIONS_CHART_DATA
  }
})

// Dispatch ExerciseSessions chart action
export const loadExerciseSessionsChartData = () => (dispatch, getState) => {
  return dispatch(fetchExerciseSessionsChartData('exercises/chartDataByType'))
}

// Vegatable actions ///////////////////////////
export const VEGETABLES_REQUEST = 'VEGETABLES_REQUEST'
export const VEGETABLES_SUCCESS = 'VEGETABLES_SUCCESS'
export const VEGETABLES_FAILURE = 'VEGETABLES_FAILURE'
// Middleware meta
const fetchVegetables = (endpoint) => ({
  [CALL_API]: {
    types: [ VEGETABLES_REQUEST, VEGETABLES_SUCCESS, VEGETABLES_FAILURE ],
    endpoint: endpoint,
    schema: Schema.VEGETABLES_DATA
  }
})
// Dispatch Vegetable action
export const loadVegetablePortions = () => (dispatch, getState) => {
  return dispatch(fetchVegetables('entities/foodPortions/search/findByItemGroupName?group=Vegetable'))
}

export const VEGETABLES_CHART_REQUEST = 'VEGETABLES_CHART_REQUEST'
export const VEGETABLES_CHART_SUCCESS = 'VEGETABLES_CHART_SUCCESS'
export const VEGETABLES_CHART_FAILURE = 'VEGETABLES_CHART_FAILURE'

// Middleware meta
const fetchVegetablesChartData = (endpoint) => ({
  [CALL_API]: {
    types: [ VEGETABLES_CHART_REQUEST, VEGETABLES_CHART_SUCCESS, VEGETABLES_CHART_FAILURE ],
    endpoint: endpoint,
    schema: Schema.VEGETABLES_CHART_DATA
  }
})
// Dispatch commission errors chart action
export const loadVegetablePortionsChartData = () => (dispatch, getState) => {
  return dispatch(fetchVegetablesChartData('portions/chartDataVegetablesByDay'))
}

export const DAILY_EXERCISES_REQUEST = 'DAILY_EXERCISES_REQUEST'
export const DAILY_EXERCISES_SUCCESS = 'DAILY_EXERCISES_SUCCESS'
export const DAILY_EXERCISES_FAILURE = 'DAILY_EXERCISES_FAILURE'
	
const fetchDailyExercises = (endpoint) => ({
  [CALL_API]: {
    types: [ DAILY_EXERCISES_REQUEST, DAILY_EXERCISES_SUCCESS, DAILY_EXERCISES_FAILURE ],
    endpoint: endpoint,
    schema: Schema.DAILY_EXERCISES_DATA
  }
})
export const loadDailyExercises = (dayAbbreviation) => (dispatch, getState) => {
  return dispatch(fetchDailyExercises('entities/exercises/search/findByDay?day='+dayAbbreviation))
}

export const DAILY_DIET_REQUEST = 'DAILY_DIET_REQUEST'
export const DAILY_DIET_SUCCESS = 'DAILY_DIET_SUCCESS'
export const DAILY_DIET_FAILURE = 'DAILY_DIET_FAILURE'
			
const fetchDailyDiet = (endpoint) => ({
	[CALL_API]: {
		types: [ DAILY_DIET_REQUEST, DAILY_DIET_SUCCESS, DAILY_DIET_FAILURE ],
		endpoint: endpoint,
		schema: Schema.DAILY_DIET_DATA
	}
})
export const loadDailyDiet = (dayAbbreviation) => (dispatch, getState) => {
	return dispatch(fetchDailyDiet('entities/foodItems/search/findByDay?day='+dayAbbreviation))
}

export const EXERCISE_BY_DAY_CHART_REQUEST = 'EXERCISE_BY_DAY_CHART_REQUEST'
export const EXERCISE_BY_DAY_CHART_SUCCESS = 'EXERCISE_BY_DAY_CHART_SUCCESS'
export const EXERCISE_BY_DAY_CHART_FAILURE = 'EXERCISE_BY_DAY_CHART_FAILURE'

// Middleware meta
const fetchExerciseByDayChartData = (endpoint) => ({
  [CALL_API]: {
    types: [ EXERCISE_BY_DAY_CHART_REQUEST, EXERCISE_BY_DAY_CHART_SUCCESS, EXERCISE_BY_DAY_CHART_FAILURE ],
    endpoint: endpoint,
    schema: Schema.EXERCISE_BY_DAY_CHART_DATA
  }
})

// Dispatch EXERCISE_BY_DAY chart action
export const loadExerciseByDayChartData = () => (dispatch, getState) => {
  return dispatch(fetchExerciseByDayChartData('exercises/chartDataByDay'))
}
