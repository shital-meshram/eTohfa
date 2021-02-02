import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-delete-product',
  templateUrl: './delete-product.component.html',
  styleUrls: ['./delete-product.component.css']
})
export class DeleteProductComponent implements OnInit {

  constructor(private service:ProductServiceService, private Activerouter:ActivatedRoute) { }

  ngOnInit(): void {
    this.service.deleteProduct(this.Activerouter.snapshot.params.id).subscribe(
      data=>{
        alert("product deleted sucessfully")
      },error=>{
        alert("product can't be deleted")
      }
    )
  }


}
