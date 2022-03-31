import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import {users} from '../userdata';
@Component({
  selector: 'app-login-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  users:any;
  errorMsg: string;
  constructor(private router: Router, private appService: AppService) { }

  ngOnInit(): void {
    this.users = users;
    this.loginForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    });
  }

  onFormSubmit(){
     let username = this.loginForm.value.username;
     let password = this.loginForm.value.password;

     let user  = this.users.find(u=> (u.username === username && u.password === password));

     if(user){
        localStorage.setItem("isLoggedIn","true");
        let token = btoa(username + ':' + password);
        localStorage.setItem("token", token);
        this.appService.loggedIn.next(true);
        this.router.navigateByUrl('/');
     }else{
        this.errorMsg = 'Invalid Credentials';
     }
  }
}
