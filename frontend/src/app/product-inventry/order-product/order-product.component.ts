import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Orders } from '../orders';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-order-product',
  templateUrl: './order-product.component.html',
  styleUrls: ['./order-product.component.css']
})
export class OrderProductComponent implements OnInit {

  cartArray:any;
  currentUser:any;
  order:Orders;
  totalAmount:number;
  total:number;
  loginStatus:boolean;


  constructor(private service: ProductServiceService,private route: Router) { }

  
  ngOnInit(): void {
    
    this.placeOrder(); 
    //this.CalculateAmount();
    this.checkUserLoginStatus();
  }

  placeOrder()
  {
    //debugger;
    this.cartArray = JSON.parse(sessionStorage.getItem('shoppingCart'));
    console.log(this.cartArray);
    this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
    console.log(this.currentUser);

    var request = {
      product : this.cartArray.products,
      customer : this.currentUser.customer
    };

    this.service.placeOrder(request).subscribe(
      data=>{
        this.order=data as Orders;
        console.log(this.order);
        console.log("order place");
        this.CalculateAmount(this.order.orderId);
        alert("order place successfully...!!")
    },error=>{
      console.log("placing order cancel..!!!")
    })
  }

  CalculateAmount(order_id)
  {
    //debugger;

    this.service.getTotalAmount(order_id).subscribe(data=>{
      console.log("total bill"+ data);
      console.log(data);
      this.total=data as number;
    },error=>{
      console.log("error calculating total amount");
    })

  }

  checkUserLoginStatus()
  {
    if(sessionStorage.getItem("currentUser").length==0)
    {
      this.route.navigate(['/loginform']);
    }
  }

}
