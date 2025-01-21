import { Order } from "./orderTypes";
import { Seller } from "./sellerTypes";
import { User } from "./userTypes";

export interface Transaction {
  id: number;
  customer: User;
  order: Order;
  seller: Seller;
  date: string;
}
