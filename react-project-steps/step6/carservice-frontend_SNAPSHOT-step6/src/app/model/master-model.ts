import {OrderModel} from "./order-model";

export class MasterModel {
  id: number;
  firstName: string;
  secondName: string;
  order: OrderModel;


  constructor(id: number, firstName: string, secondName: string, order: OrderModel) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.order = order;
  }
}
