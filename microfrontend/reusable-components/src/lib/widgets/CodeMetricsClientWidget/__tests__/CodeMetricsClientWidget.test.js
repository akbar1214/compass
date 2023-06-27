import React from 'react'
import { render, waitFor, cleanup } from '@testing-library/react'
import { baseUrl } from '../../../../__tests__/commonTestFunction'
import CodeMetricsClientWidget from '../CodeMetricsClientWidget'
import data from './data'
import { mockJest } from '../../../../__tests__/mockData'

describe('CodeMetricsClientWidget', () => {
  const unmockedFetch = global.fetch

  afterEach(() => {
    cleanup()
    global.fetch = unmockedFetch
  })

  it('render component', async () => {
    mockJest(200, JSON.stringify(data))
    await waitFor(() => {
      render(
        <CodeMetricsClientWidget
          apiEndPointUrl={`${baseUrl}/psr-service/project/1232123/sprint/leave`}
          sprintId="123"
          navigate={jest.fn()}
        />,
      )
    })
  })
})
