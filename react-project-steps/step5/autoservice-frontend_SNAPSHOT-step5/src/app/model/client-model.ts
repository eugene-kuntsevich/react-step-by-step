export class ClientModel {
  id: number;
  firstName: string;
  secondName: string;
  phoneNumber: string;


  constructor(id: number, firstName: string, secondName: string, phoneNumber: string) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.phoneNumber = phoneNumber;
  }
}
