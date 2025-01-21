// types/payoutsTypes.ts

import { Order } from "./orderTypes";
import { Seller } from "./sellerTypes";
import { Transaction } from "./Transaction";
import { User } from "./userTypes";

export interface Payouts {
  id: number;
  transactions: Transaction[];
  seller: Seller;
  amount: number;
  status: "PENDING" | "SUCCESS" | "REJECTED";
  date: string;
}
