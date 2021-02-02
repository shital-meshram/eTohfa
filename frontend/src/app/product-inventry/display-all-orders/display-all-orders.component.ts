import { Component, OnInit } from '@angular/core';
import { Orders } from '../orders';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-display-all-orders',
  templateUrl: './display-all-orders.component.html',
  styleUrls: ['./display-all-orders.component.css']
})
export class DisplayAllOrdersComponent implements OnInit {

  orderList:Orders[]=[];
  constructor(private service:ProductServiceService) { }

  ngOnInit(): void {
    this.getAllOrder();
  }


  getAllOrder()
  {
    this.service.getAllOrders().subscribe(data=>{
      console.log("data received");
      console.log(data);
      this.orderList=data as Orders[];
    },error=>{
      console.log("error");
    });
  }
}
