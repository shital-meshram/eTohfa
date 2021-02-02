import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { data } from 'jquery';
import { Observable } from 'rxjs';
import { ProductServiceService } from '../product-service.service';
import { Products } from '../products.model';

@Component({
  selector: 'app-get-all-product',
  templateUrl: './get-all-product.component.html',
  styleUrls: ['./get-all-product.component.css']
})
export class GetAllProductComponent implements OnInit {

 products:Products[];
 existingProduct:Products;
 

  constructor(private service:ProductServiceService, private router:Router) { }

  ngOnInit(): void {
    this.getProductList();
  }

  getProductList() {
    this.service.getProductList().subscribe(
      data=>{
        this.products=data as Products[];
        console.log("Data Received");
      },error=>{
        console.log("data receiver fails..!!");
      }
    );
  }

  getProductById(category_id_for_getproductbyid)
  {
    this.service.getProductById(category_id_for_getproductbyid).subscribe(
      data=>{
        this.existingProduct = data as Products;
        console.log(this.existingProduct);
        console.log("data received");
      },error=>{
        console.log("data not received");
      }
    )
    
  }

  
}
