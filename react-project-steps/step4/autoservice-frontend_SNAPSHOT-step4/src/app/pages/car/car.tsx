import React from 'react';
import './car.scss';
import {Table} from "../../util/table/table";
import {CarModel} from "../../model/car-model";
import {ClientModel} from "../../model/client-model";

export const Car: React.FC<any> = () => {
  const headers = ['Id', 'Car Nmber', 'Client Name', 'Client Phone', 'Order Id'];
  const carsList = // TODO test data, should be replaced by server call
      [
        new CarModel(1, '1234 GK-3', new ClientModel(1, 'John', 'Smith', '+345-78-2590572'), null),
        new CarModel(2, '5678 WC-5', new ClientModel(2, 'Max', 'Payne', '+379-21-7370861'), null)
      ];

  function convertCarsToArray(carsList: CarModel[]): string[][] {
    return carsList.map(car => convertCarToArray(car));
  }

  function convertCarToArray(car: CarModel): string[] {
    let result: string[] = [];
    result.push(car.id.toString());
    result.push(car.carNumber);
    result.push(car.client.firstName + ' ' + car.client.secondName);
    result.push(car.client.phoneNumber);
    result.push(String(car.order && car.order.id ? car.order.id : ''));
    return result;
  }

  return (
      <div>
        <Table headers={headers} body={convertCarsToArray(carsList)}/>
      </div>
  )
}

