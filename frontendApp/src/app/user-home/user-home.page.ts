import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationExtras} from '@angular/router';
import { User } from '../models/user';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.page.html',
  styleUrls: ['./user-home.page.scss'],
})
export class UserHomePage implements OnInit {
  userData:User;
  usertoUpdate:User;
  usertoDelete:User;
  id:number;
  constructor(
    public route: ActivatedRoute,
    public router: Router,
    public apiService: ApiService
  ) {
    this.route.queryParams.subscribe(params => {
      if (this.router.getCurrentNavigation().extras.state) {
        this.userData = this.router.getCurrentNavigation().extras.state.user;
        this.id=this.userData.id;
        this.usertoUpdate=this.userData;
        this.usertoDelete=this.userData;
        
      }
    });
    
  }

  ngOnInit() {
  }

  Logout(){
    this.apiService.Logout(this.id, this.userData).subscribe(response => {
      this.router.navigate(['home']);
    })
  }
  sendtoEditPage(){
    
    let navigationExtras: NavigationExtras = {
      state: {
        user2: this.userData
      }
    };
    
    this.router.navigate(['user-edit'], navigationExtras);}

  delete(){
    this.apiService.deleteItem(this.usertoDelete.id).subscribe(response=>{
      this.router.navigate(['home']);
    })
  }

} 
