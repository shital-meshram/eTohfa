import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from '../category';
import { ProductServiceService } from '../product-service.service';
import { Products } from '../products.model';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

  viewProduct=new Products();
  viewCategory= new Category();
  category_id_for_getproductbyid:number;

  constructor(private service : ProductServiceService, private Activerouter:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    console.log(this.Activerouter.snapshot.params.id);
    this.service.getProductById(this.Activerouter.snapshot.params.id).subscribe(
      data=>{
        this.viewProduct= data as Products ;
        console.log(this.viewProduct);
        console.log("data received");
      },error=>{
        console.log("data not received");
      }
    )
  }

}
