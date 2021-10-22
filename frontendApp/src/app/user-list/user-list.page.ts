//student-list.page.ts
import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';
import { Router, NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.page.html',
  styleUrls: ['./user-list.page.scss'],
})
export class UserListPage implements OnInit {

  usersData: any;

  constructor(
    public apiService: ApiService,
    private router: Router
  ) {
    this.usersData = [];
  }

  ngOnInit() {
    // this.getAllStudents();
  }

  ionViewWillEnter() {
    // Used ionViewWillEnter as ngOnInit is not 
    // called due to view persistence in Ionic
    this.getAllUsers();
  }

  getAllUsers() {
    //Get saved list of students
    console.log('get request gönderilecek')

    this.apiService.getList().subscribe(response => {
      console.log(response);
      this.usersData = response;
    })

    console.log('get request gönderildi!!!')

  }
  
  sendtoEditPage(){
    
    let navigationExtras: NavigationExtras = {
      state: {
        user: this.usersData
      }
    };
    this.router.navigate(['user-edit'], navigationExtras);
  }
  delete(item) {
    //Delete item in Student data
    this.apiService.deleteItem(item.id).subscribe(Response => {
      //Update list after delete is successful
      this.getAllUsers();
    });
  }

}
