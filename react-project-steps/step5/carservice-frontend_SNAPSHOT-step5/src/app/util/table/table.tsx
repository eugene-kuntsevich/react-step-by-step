import React from 'react';
import './table.scss';
import {TableRow} from "../table-row/table-row";

export const Table: React.FC<{ headers: string[], body: any[] }> = ({headers, body}) => {

  return (
      <table className={"styled-table"}>
        <thead>
        {<TableRow row={headers}/>}
        </thead>
        <tbody>
        {body.map((row, key) => <TableRow row={row} key={key}/>)}
        </tbody>
      </table>
  )
}

