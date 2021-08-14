import React, {useEffect, useState} from 'react';
import './detailed-car-view.scss';
import {getCar} from "../../../service/car-service";
import {CarModel} from "../../../model/car-model";

export const DetailedCarView: React.FC<{ selectedCarId: number }> = ({selectedCarId}) => {

  const [selectedCar, setSelectedCar] = useState<CarModel>();

  useEffect(() => {
    getCar(selectedCarId).then(item => {
      setSelectedCar(item);
    });
  }, [selectedCarId])

  return (
      <div>
        <p>id: <span>{selectedCarId}</span></p>
        <p>car
          number: <span>{(selectedCar && selectedCar.carNumber) ? selectedCar.carNumber : ''}</span>
        </p>
        <p>client
          name: <span>{(selectedCar && selectedCar.client && selectedCar.client.firstName) ? selectedCar.client.firstName : ''}</span>
        </p>
        <p>client
          surname: <span>{(selectedCar && selectedCar.client && selectedCar.client.secondName) ? selectedCar.client.secondName : ''}</span>
        </p>
        <p>client
          phone: <span>{(selectedCar && selectedCar.client && selectedCar.client.phoneNumber) ? selectedCar.client.phoneNumber : ''}</span>
        </p>
        <p>order
          id: <span>{(selectedCar && selectedCar.order && selectedCar.order.id) ? selectedCar.order.id : ''}</span>
        </p>
      </div>
  )
}

