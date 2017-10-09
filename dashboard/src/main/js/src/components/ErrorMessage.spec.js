import React from 'react'
import { shallow } from 'enzyme'

import { Alert } from 'react-bootstrap'
import ErrorMessage from './ErrorMessage'


const setup = () => {

    const component = shallow(
        <ErrorMessage/>
    )

    return {
        component: component,
        alert: component.find(Alert)
    }
}

describe('ErrorMessage component', () => {
    it('should render alert with Error Message', () => {
        const { alert } = setup()
        expect(alert.at(0).props().children).toContain('We are experiencing difficulty. Please try again later.')
    })


})