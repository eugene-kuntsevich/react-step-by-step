import {ClientModel} from "./client-model";
import {OrderModel} from "./order-model";

export class CarModel {
  id: number;
  carNumber: string;
  client: ClientModel;
  order: OrderModel;

  constructor(id: number, carNumber: string, client: ClientModel, order: OrderModel = null) {
    this.id = id;
    this.carNumber = carNumber;
    this.client = client;
    this.order = order;
  }
}
