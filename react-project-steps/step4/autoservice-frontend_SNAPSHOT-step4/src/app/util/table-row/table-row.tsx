import React from 'react';
import './table-row.scss';

export const TableRow: React.FC<{ row: string[] }> = ({row}) => {

  return (
      <tr className={"active-row"}>
        {row.map(val => <td>{val}</td>)}
      </tr>
  )
}

