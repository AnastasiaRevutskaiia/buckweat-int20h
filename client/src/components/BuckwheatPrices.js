import React, { useEffect, useState } from 'react'
import { useAsyncRequest } from '../hooks/useAsyncRequest'
import BasicToolbarFilteringGrid from './BasicToolbarFilteringGrid.js'
import configData from '../config.json'

export const BuckwheatPrices = () => {
  const [prices, setPrices] = useState([])
  const { isLoading, asyncRequest } = useAsyncRequest()

  useEffect(() => {
    async function fetchPrices() {
      const URL = configData.PRICES_URL + '/v1/prices/buckwheat'
      const data = await asyncRequest(URL)
      setPrices(data)
    }
    fetchPrices()
  }, [asyncRequest])

  return <BasicToolbarFilteringGrid prices={prices} isLoading={isLoading} />
}
