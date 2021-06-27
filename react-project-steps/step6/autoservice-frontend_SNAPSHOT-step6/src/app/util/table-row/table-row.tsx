import React from 'react';
import './table-row.scss';

export const TableRow: React.FC<{
  row: string[],
  rowKey?: number,
  toggleClass: any,
  selectedRowKey?: number
}> = ({
        row,
        rowKey,
        toggleClass,
        selectedRowKey
      }) => {

  return (
      <tr className={selectedRowKey === rowKey ? 'active-row' : null} onClick={toggleClass}>
        {row.map((val, key) => <td key={key}>{val}</td>)}
      </tr>
  )
}

