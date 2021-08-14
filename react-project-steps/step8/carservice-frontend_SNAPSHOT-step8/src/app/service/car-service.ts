import axios from 'axios';
import {BASE_URL} from "./base-url";
import {CarModel} from "../model/car-model";

export function getCarList() {
  return axios.get(BASE_URL + '/car/find-all').then(res => res.data);
}

export function getCar(id: number) {
  return axios.get(BASE_URL + '/car/find-by-id/' + id).then(res => res.data);
}

export function updateCar(car: CarModel) {
  return axios.put(BASE_URL + '/car/update', car).then(res => res.data);
}
