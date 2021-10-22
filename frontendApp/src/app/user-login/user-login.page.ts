import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { ApiService } from '../services/api.service';
import { Router, NavigationExtras } from '@angular/router';


@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.page.html',
  styleUrls: ['./user-login.page.scss'],
})
export class UserLoginPage implements OnInit {

  user:User
  loggedinUser: User
  constructor(
    public apiService: ApiService,
    public router: Router
  ) {
    this.user = new User();
  }

  ngOnInit() {
  }
  
  loginForm() {
          

    this.apiService.Login(this.user).subscribe((response) => {
      this.loggedinUser=response;
      if(this.loggedinUser.isLoggedIn){

        let navigationExtras: NavigationExtras = {
          state: {
            user: this.loggedinUser
          }
        };
        
        this.router.navigate(['user-home'], navigationExtras);}
      else
        this.router.navigate(['user-login']);
    });


  }
  

}
