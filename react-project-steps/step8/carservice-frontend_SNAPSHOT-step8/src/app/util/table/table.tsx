import React, {useState} from 'react';
import './table.scss';
import {TableRow} from "../table-row/table-row";

export const Table: React.FC<{ headers: string[], body: any[], setSelectedRowId?: (id: number) => void }> = ({
                                                                                                               headers,
                                                                                                               body,
                                                                                                               setSelectedRowId
                                                                                                             }) => {
  const [selectedRowKey, setSelectedRowKey] = useState(-1);

  const toggleClass = (e: any) => {
    let rowKey: number = e.target.parentElement.rowIndex;
    let rowId: string = e.target.parentElement.cells[0].innerText;
    setSelectedRowKey(rowKey);
    setSelectedRowId(Number.parseInt(rowId));
  };

  return (
      <table className={"styled-table"}>
        <thead>
        {<TableRow row={headers}/>}
        </thead>
        <tbody>
        {body.map((row, key) => <TableRow row={row} rowKey={key} toggleClass={toggleClass}
                                          selectedRowKey={selectedRowKey - 1} key={key}/>)}
        </tbody>
      </table>
  )
}

