import React, { useEffect, useState } from 'react'
import { useAsyncRequest } from '../hooks/useAsyncRequest'
import BasicToolbarFilteringGrid from './BasicToolbarFilteringGrid.js'

export const BuckwheatPrices = () => {
  const [prices, setPrices] = useState([])
  const { isLoading, asyncRequest } = useAsyncRequest()

  useEffect(() => {
    debugger
    async function fetchPrices() {
      debugger
      // const PROXY_URL = 'https://quiet-inlet-75795.herokuapp.com/' // TODO: ask to configure server
      // const URL = 'https://store-prices-app.herokuapp.com/v1/prices/buckwheat'
      const PROXY_URL = ''
      const URL = '/storePrices'
      const data = await asyncRequest(PROXY_URL + URL)
      debugger
      // setPrices(
      //   data && data.storePrices
      //     ? data.storePrices.sort((a, b) => a.price - b.price)
      //     : []
      // )
      setPrices(data ? data.sort((a, b) => a.price - b.price) : [])
    }
    fetchPrices()
  }, [asyncRequest])

  return <BasicToolbarFilteringGrid prices={prices} isLoading={isLoading} />
}
