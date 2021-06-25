import React, {useEffect, useState} from 'react';
import './car.scss';
import {Table} from "../../util/table/table";
import {CarModel} from "../../model/car-model";
import {getCarList} from "../../service/car-service";

export const Car: React.FC<any> = () => {
  const headers = ['Id', 'Car Number', 'Client Name', 'Client Phone', 'Order Id'];
  const [carsList, setCars] = useState<CarModel[]>([]);

  useEffect(() => {
    getCarList().then(items => {
      setCars(items);
    })
  }, [])

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

