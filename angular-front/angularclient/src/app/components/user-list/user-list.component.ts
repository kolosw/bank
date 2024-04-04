import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { UserService } from '../../service/user-service/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[] = [];

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }
  loadUsers() {
      this.userService.findAll().subscribe(data => {
        this.users = data;
      });
    }

    delete(userId: number) {
      this.userService.delete(userId).subscribe(() => {
        this.loadUsers(); // Refresh the user list after deletion
      });
    }
}
