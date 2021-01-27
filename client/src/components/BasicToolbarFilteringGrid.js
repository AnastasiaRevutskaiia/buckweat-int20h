import React, { useState, useEffect } from 'react'
import PropTypes from 'prop-types'
import { DataGrid } from '@material-ui/data-grid'

const columns = [
  {
    field: 'imageUrl',
    headerName: 'Image',
    headerClassName: 'grid-column-header',
    flex: 0.5,
    filterable: false,
    headerAlign: 'center',
    renderCell: function renderImage(params) {
      return (
        <div
          style={{
            height: '130px',
            width: '130px',
            display: 'flex',
            justifyContent: 'center',
            position: 'relative',
            overflow: 'hidden',
            borderRadius: '50%',
            border: '1px solid #ff7043',
          }}
        >
          <img
            alt=""
            src={params.getValue('imageUrl')}
            style={{
              maxWidth: '100%',
              maxHeight: '100%',
            }}
          />
        </div>
      )
    },
    renderHeader: function renderImageHeader() {
      return <b>{'Image'}</b>
    },
  },
  {
    field: 'name',
    headerName: 'Name',
    flex: 0.6,
    headerAlign: 'center',
    renderCell: function renderName(params) {
      return (
        <em
          style={{
            whiteSpace: 'normal',
            wordWrap: 'break-word',
            lineHeight: '24px',
          }}
        >
          {params.getValue('name')}
        </em>
      )
    },
    renderHeader: function renderImageHeader() {
      return <b>{'Name'}</b>
    },
  },
  {
    field: 'price',
    headerName: 'Price(uah)',
    flex: 0.4,
    type: 'number',
    headerAlign: 'center',
    renderHeader: function renderImageHeader() {
      return <b>{'Price(uah)'}</b>
    },
  },
  {
    field: 'weightInGrams',
    headerName: 'Weight(grams)',
    flex: 0.4,
    type: 'number',
    headerAlign: 'center',
    align: 'center',
    renderHeader: function renderImageHeader() {
      return <b>{'Weight(grams)'}</b>
    },
    valueFormatter: function valueFormatterWeight(params) {
      return Number(params.getValue('weightInGrams')) > 0
        ? params.getValue('weightInGrams')
        : '---'
    },
  },
  {
    field: 'storeLink',
    headerName: 'Link',
    flex: 1.5,
    filterable: false,
    headerAlign: 'center',
    renderCell: function renderLink(params) {
      return (
        <a href={params.getValue('storeLink')} target="_blank" rel="noreferrer">
          {params.getValue('storeLink')}
        </a>
      )
    },
    renderHeader: function renderImageHeader() {
      return <b>{'Link'}</b>
    },
  },
]
export default function BasicToolbarFilteringGrid({ prices, isLoading }) {
  const [rows, setRows] = useState([])
  useEffect(() => {
    const sortedPrices = prices ? prices.sort((a, b) => a.price - b.price) : []
    setRows(sortedPrices.map((elem, idx) => ({ ...elem, ['id']: idx })))
  }, [prices])

  return (
    <DataGrid
      rows={rows}
      columns={columns}
      pageSize={10}
      loading={isLoading}
      showColumnRightBorder={true}
      rowHeight={150}
      disableColumnMenu
      showToolbar
    />
  )
}

BasicToolbarFilteringGrid.propTypes = {
  prices: PropTypes.arrayOf(PropTypes.object),
  isLoading: PropTypes.bool,
}
