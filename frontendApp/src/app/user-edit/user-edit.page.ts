//student-edit.page
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../models/user';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-user-edit/',
  templateUrl: './user-edit.page.html',
  styleUrls: ['./user-edit.page.scss'],
})
export class UserEditPage implements OnInit {
  data:User
  userData:User;
  id:number;
  constructor(
    public route: ActivatedRoute,
    public router: Router,
    public apiService: ApiService
  ) {
    this.data = new User();
    this.route.queryParams.subscribe(params => {
      if (this.router.getCurrentNavigation().extras.state) {
        this.userData = this.router.getCurrentNavigation().extras.state.user2;
        this.id=this.userData.id;
        
      }
    });
    
  }
  

  ngOnInit() {
    
  }

  update() {
    
    this.apiService.updateItem(this.id, this.data).subscribe(response => {
      this.router.navigate(['home']);
    })
  }

}

