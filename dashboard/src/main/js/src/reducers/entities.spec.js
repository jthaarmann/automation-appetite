import entities from './entities'
import merge from 'lodash/merge'

describe('reducers', () => {

    describe('entities', () => {

        const defaultState = {apiDataRequests: {items: [], count: 0}, commissionErrors: {items: [], count: 0}}

        it('should provide initial state', () => {
            expect(entities(undefined, {}).apiDataRequests.items).toBeDefined();
        })

        const action = { response: { entities: {apiDataRequests: { items: [], count: 0}, commissionErrors: {items: [], count: 0} } }}

        it('should handle action with response entities', () => {
            expect(entities([], action)).toEqual(
                merge({}, defaultState, action.response.entities)
            )
        })
    })
})