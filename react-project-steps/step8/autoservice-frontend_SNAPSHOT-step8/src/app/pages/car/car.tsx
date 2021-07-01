import React, {useEffect, useState} from 'react';
import './car.scss';
import {Table} from "../../util/table/table";
import {CarModel} from "../../model/car-model";
import {getCarList} from "../../service/car-service";
import {DetailedCarView} from "./detailed-view/detailed-car-view";

export const Car: React.FC<any> = () => {
  const headers = ['Id', 'Car Number', 'Client Name', 'Client Phone', 'Order Id'];
  const [carsList, setCars] = useState<CarModel[]>([]);
  const [selectedRowId, setSelectedRowId] = useState<number>(-1);

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
        <div className={"half"}>
          <Table headers={headers} body={convertCarsToArray(carsList)}
                 setSelectedRowId={setSelectedRowId}/>
        </div>
        {selectedRowId > -1 &&
        <DetailedCarView selectedCarIdentity={selectedRowId}/>}
      </div>
  )
}

