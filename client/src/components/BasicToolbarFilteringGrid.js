import React, { useState, useEffect } from 'react'
import PropTypes from 'prop-types'
import { DataGrid } from '@material-ui/data-grid'

const columns = [
  { field: 'name', headerName: 'Name', flex: 0.75 },
  { field: 'price', headerName: 'Price', flex: 0.5, type: 'number' },
  {
    field: 'link',
    headerName: 'Link',
    flex: 2,
    renderCell: function renderLink(params) {
      return (
        <a href={params.getValue('link')} target="_blank" rel="noreferrer">
          {params.getValue('link')}
        </a>
      )
    },
  },
]

export default function BasicToolbarFilteringGrid({ prices, isLoading }) {
  const [rows, setRows] = useState([])
  useEffect(() => {
    setRows(prices.map((elem, idx) => ({ ...elem, ['id']: idx })))
  }, [prices])

  return (
    <div style={{ height: 400, width: '100%', marginTop: '20px' }}>
      {/* <DataGrid {...data} filterModel={riceFilterModel} showToolbar /> */}
      <DataGrid
        rows={rows}
        columns={columns}
        pageSize={10}
        loading={isLoading}
        showColumnRightBorder={true}
      />
    </div>
  )
}

BasicToolbarFilteringGrid.propTypes = {
  prices: PropTypes.arrayOf(PropTypes.object),
  isLoading: PropTypes.bool,
}
