import React, {useState} from 'react';
import './table.scss';
import {TableRow} from "../table-row/table-row";

export const Table: React.FC<{ headers: string[], body: any[] }> = ({headers, body}) => {
  const [selectedRowKey, setSelectedRowKey] = useState(-1);

  const toggleClass = (e: any) => {
    let rowKey = e.target.parentElement.rowIndex;
    setSelectedRowKey(rowKey);
  };

  return (
      <table className={"styled-table"}>
        <thead>
        {<TableRow row={headers} toggleClass={null}/>}
        </thead>
        <tbody>
        {body.map((row, key) => <TableRow row={row} rowKey={key} toggleClass={toggleClass}
                                          selectedRowKey={selectedRowKey - 1} key={key}/>)}
        </tbody>
      </table>
  )
}

