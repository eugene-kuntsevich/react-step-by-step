import React from 'react';
import './table-row.scss';

export const TableRow: React.FC<{ row: string[] }> = ({row}) => {

  return (
      <tr className={"active-row"}>
        {row.map((val, key) => <td key={key}>{val}</td>)}
      </tr>
  )
}

