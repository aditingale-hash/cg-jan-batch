import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

import { ProductService } from '../product/service/product.service';
import { Review } from './model/review.model';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  reviews: Review[];
  starNums: number[];
  pid:number;
  reviewArry:Review[];
  showReviewForm: boolean;

  reviewForm: FormGroup;

  constructor(private actRoute: ActivatedRoute , private productService: ProductService) { }

  ngOnInit(): void {

    this.showReviewForm = false;
    this.starNums =[0,0,0,0,0];
    this.actRoute.params.subscribe(params=>{
      this.pid=params.pid;
       this.productService.getReviewsByProductId(params.pid).subscribe(data=>{
            this.reviews=data;
            this.reviewArry = this.reviews;
            this.starNums[0] = this.reviews.filter(r=>r.rating === 5).length;
            this.starNums[1] = this.reviews.filter(r=>r.rating === 4).length;
            this.starNums[2] = this.reviews.filter(r=>r.rating === 3).length;
            this.starNums[3] = this.reviews.filter(r=>r.rating === 2).length;
            this.starNums[4] = this.reviews.filter(r=>r.rating === 1).length;

       });
    });
  }

  filterReviews = (rating: number)=>{
     this.reviewArry = this.reviews.filter(r=>r.rating === rating);
  }

  showAllReviews = ()=>{
    this.reviewArry = this.reviews;
  }

  postReview(){
     this.showReviewForm =  !this.showReviewForm;

  }


  OnChangeRating(){

  }
}
