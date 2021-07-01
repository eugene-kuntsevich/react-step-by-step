import {OrderStatusModel} from "./order-status-model";
import {MasterModel} from "./master-model";
import {CarModel} from "./car-model";

export class OrderModel {
  id: number;
  orderStatus: OrderStatusModel;
  car: CarModel;
  master: MasterModel;


  constructor(id: number, orderStatus: OrderStatusModel, car: CarModel, master: MasterModel) {
    this.id = id;
    this.orderStatus = orderStatus;
    this.car = car;
    this.master = master;
  }
}
