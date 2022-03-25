import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {
  //constructors are used to inject the services...

  //Go to Post service and fetch the data for post-grid component
  constructor() {

  }

  //Lifecycle Hook : Called when the component is about to initialize instance variables
  ngOnInit(): void {
  }

  //Lifecycle hook that gets called whenever the control moves away from this component
  //switching to another screen. 
  ngOnDestroy(): void {

  }
}
