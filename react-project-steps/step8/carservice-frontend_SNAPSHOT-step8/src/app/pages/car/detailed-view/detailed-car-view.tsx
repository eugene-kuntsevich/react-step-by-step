import React, {ChangeEvent, useEffect, useState} from 'react';
import './detailed-car-view.scss';
import {getCar, updateCar} from "../../../service/car-service";
import {CarModel} from "../../../model/car-model";

export const DetailedCarView: React.FC<{ selectedCarIdentity: number }> = ({
                                                                             selectedCarIdentity
                                                                           }) => {

  const [selectedCar, setSelectedCar] = useState<CarModel>();

  useEffect(() => {
    getCar(selectedCarIdentity).then(item => {
      setSelectedCar(item);
    });
  }, [selectedCarIdentity])

  function submitForm(): void {
    updateCar(selectedCar);
  }

  function changeCarNumberHandler(e: ChangeEvent<HTMLInputElement>): void {
    selectedCar.carNumber = e.target.value;
    setSelectedCar({...selectedCar});
  }

  function changeClientFirstNameHandler(e: ChangeEvent<HTMLInputElement>): void {
    selectedCar.client.firstName = e.target.value;
    setSelectedCar({...selectedCar});
  }

  function changeClientSecondNameHandler(e: ChangeEvent<HTMLInputElement>): void {
    selectedCar.client.secondName = e.target.value;
    setSelectedCar({...selectedCar});
  }

  function changeClientPhoneHandler(e: ChangeEvent<HTMLInputElement>): void {
    selectedCar.client.phoneNumber = e.target.value;
    setSelectedCar({...selectedCar});
  }

  return (
      <div className={'left'}>
        <form onSubmit={submitForm}>
          <p>car id: <input type="text" value={selectedCarIdentity} disabled={true}/></p>

          <p>car number: <input type="text" onChange={changeCarNumberHandler}
                                value={(selectedCar && selectedCar.carNumber) ? selectedCar.carNumber : ''}/>
          </p>

          <p>client name: <input type="text" onChange={changeClientFirstNameHandler}
                                 value={(selectedCar && selectedCar.client && selectedCar.client.firstName) ? selectedCar.client.firstName : ''}/>
          </p>
          <p>client surname: <input type="text" onChange={changeClientSecondNameHandler}
                                    value={(selectedCar && selectedCar.client && selectedCar.client.secondName) ? selectedCar.client.secondName : ''}/>
          </p>
          <p>client phone: <input type="text" onChange={changeClientPhoneHandler}
                                  value={(selectedCar && selectedCar.client && selectedCar.client.phoneNumber) ? selectedCar.client.phoneNumber : ''}/>
          </p>
          <p>order id: <input type="text" disabled={true}
                              value={(selectedCar && selectedCar.order && selectedCar.order.id) ? selectedCar.order.id : ''}/>
          </p>
          <p><input type="submit" value={'Update car'}/></p>
        </form>
      </div>
  )
}

