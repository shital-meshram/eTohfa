import { Customer } from "../membership/customer";
import { Products } from "./products.model";

export class Orders {
    orderId:number;
    products: Products;
    customer: Customer;

    constructor(){};
}
