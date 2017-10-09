import { schema } from 'normalizr'
///////////////////////////////////////////////////////////////////////////////
// Portions Schema /////////////////////////////////////
const foodPortionsSchema = new schema.Entity('foodPortions', {}, {
    idAttribute: foodPortion => foodPortion.id
})
// Portions Pagination
const foodPortionsPageSchema = new schema.Entity('foodPortionsPage', {}, {
    idAttribute: () => 'page'
})
// Quarantine API data
const foodPortionsDataSchema = new schema.Entity('foodPortionsData', {
    embedded: {
    	foodPortions: [foodPortionsSchema]
    },
    page: foodPortionsPageSchema
}, {
    idAttribute: () => 'data'
})
///////////////////////////////////////////////////////////////////////////////
//foodGroups CHart data/////////////////////////////////////
const foodGroupsChartSchema = new schema.Entity('foodGroupsChart', {
}, {
    idAttribute: foodGroup => foodGroup.items
})

const foodGroupsChartDataSchema = new schema.Entity('foodGroupsChartData', {
	chartData: [foodGroupsChartSchema]
}, {
    idAttribute: () => 'data'
})
///////////////////////////////////////////////////////////////////////////////
// Exercise Schema ////////////////////////////////////////
const exerciseSessionsSchema = new schema.Entity('exerciseSessions', {}, {
    idAttribute: exerciseSession => exerciseSession.id
})
// exerciseSession Pagination
const exerciseSessionsPageSchema = new schema.Entity('exerciseSessionsPage', {}, {
    idAttribute: () => 'page'
})
// exerciseSession API data
const exerciseSessionsDataSchema = new schema.Entity('exerciseSessionsData', {
    embedded: {
    	exerciseSessions: [exerciseSessionsSchema]
    },
    page: exerciseSessionsPageSchema
}, {
    idAttribute: () => 'data'
})
///////////////////////////////////////////////////////////////////////////////
//exerciseSession Chart data////////////////////////////
const exerciseSessionsChartSchema = new schema.Entity('exerciseSessionsChart', {
}, {
    idAttribute: exerciseSession => exerciseSession.items
})

const exerciseSessionsChartDataSchema = new schema.Entity('exerciseSessionsChartData', {
	chartData: [exerciseSessionsChartSchema]
}, {
    idAttribute: () => 'data'
})
///////////////////////////////////////////////////////////////////////////////
// Vegetables Schema ////////////////////////////////////////
const vegetablePortionsSchema = new schema.Entity('vegetablePortions', {}, {
    idAttribute: vegetablePortion => vegetablePortion.id
})
// vegetablePortions Pagination
const vegetablePortionsPageSchema = new schema.Entity('vegetablePortionsPage', {}, {
    idAttribute: () => 'page'
})
// vegetablePortions API data
const vegetablePortionsDataSchema = new schema.Entity('vegetablePortionsData', {
    embedded: {
        foodPortions: [vegetablePortionsSchema]
    },
    page: vegetablePortionsPageSchema
}, {
    idAttribute: () => 'data'
})
///////////////////////////////////////////////////////////////////////////////
//vegetablePortions Chart data//////////////////////////////
const vegetablePortionsChartSchema = new schema.Entity('vegetablePortionsChart', {
}, {
    idAttribute: vegetablePortion => vegetablePortion.items
})
//vegetablePortions Chart API Data
const vegetablePortionsChartDataSchema = new schema.Entity('vegetablePortionsChartData', {
	chartData: [vegetablePortionsChartSchema]
}, {
    idAttribute: () => 'data'
})
///////////////////////////////////////////////////////////////////////////////
//dailyExercises Schema/////////////////////////////
const dailyExercisesSchema = new schema.Entity('exercises', {}, {
	idAttribute: exercise => exercise.id
})
const dailyExercisesPageSchema = new schema.Entity('exercisesPage', {}, {
    idAttribute: () => 'page'
})
const dailyExercisesDataSchema = new schema.Entity('exercisesData', {
   embedded: {
	   exercises: [dailyExercisesSchema]
   },
   page: dailyExercisesPageSchema
}, {
   idAttribute: () => 'data'
})
///////////////////////////////////////////////////////////////////////////////
//dailyDietSchema/////////////////////////////
const dailyDietSchema = new schema.Entity('foodItems', {}, {
	idAttribute: foodItem => foodItem.id
})
const dailyDietPageSchema = new schema.Entity('foodItemsPage', {}, {
	idAttribute: () => 'page'
})
const dailyDietDataSchema = new schema.Entity('foodItemsData', {
	embedded: {
		foodItems: [dailyDietSchema]
	},
	page: dailyDietPageSchema
}, {
	idAttribute: () => 'data'
})
//Exercise By DayChart data
const exerciseByDayChartSchema = new schema.Entity('exerciseByDayChart', {
}, {
    idAttribute: exerciseByDay => exerciseByDay.items
})

const exerciseByDayChartDataSchema = new schema.Entity('exerciseByDayChartData', {
	chartData: [exerciseByDayChartSchema]
}, {
    idAttribute: () => 'data'
})


export const Schema = {
    PORTIONS_DATA: foodPortionsDataSchema,
    FOOD_GROUPS_CHART_DATA: foodGroupsChartDataSchema,
    VEGETABLES_DATA: vegetablePortionsDataSchema,
    VEGETABLES_CHART_DATA: vegetablePortionsChartDataSchema,
    EXERCISE_SESSIONS_DATA: exerciseSessionsDataSchema,
    EXERCISE_SESSIONS_CHART_DATA: exerciseSessionsChartDataSchema,
    EXERCISE_BY_DAY_CHART_DATA: exerciseByDayChartDataSchema,
    DAILY_EXERCISES_DATA: dailyExercisesDataSchema,
    DAILY_DIET_DATA: dailyDietDataSchema,
}
