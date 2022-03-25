import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {

  name: string;
  x: number;
  y: number;

  nums: number[];
  showArry: boolean;
  showAddress: boolean;
  tempArray: number[];

  constructor() { }

  ngOnInit(): void {
    console.log('init called...');
    this.name = 'Harry Potter';
    this.x = 10;
    this.y = 20;

    this.nums = [1, 2, 3, 4, 5, 6, 7, 8];
    this.showArry = false;
    this.showAddress = false;
    this.tempArray = this.nums;
  }

  showArrayContent() {
    this.showArry = true;
  }

  showAddressContent = () => {
    this.showAddress = !this.showAddress;
  }

  showAllNumbers = () => {
    this.tempArray = this.nums;
  }

  showAllEvenNumbers = () => {
    this.tempArray = this.nums.filter(e => e % 2 === 0);
  }

  showAllOddNumbers = () => {
    this.tempArray = this.nums.filter(e => e % 2 === 1);
  }
}
