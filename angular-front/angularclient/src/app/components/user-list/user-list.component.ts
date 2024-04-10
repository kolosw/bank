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
  sortedUsers: User[] = [];
  sortColumn: keyof User | null = null; // Allow sortColumn to be nullable
  sortReverse: boolean = false;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.loadUsers();
  }

  loadUsers() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
      this.sortUsers();
    });
  }

  sortUsers() {
    this.sortedUsers = [...this.users].sort((a, b) => {
      if (this.sortColumn) {
        const valueA = a[this.sortColumn] as any; // Use 'as any' to access the property dynamically
        const valueB = b[this.sortColumn] as any; // Use 'as any' to access the property dynamically
        if (valueA < valueB) return this.sortReverse ? 1 : -1;
        if (valueA > valueB) return this.sortReverse ? -1 : 1;
      }
      return 0;
    });
  }

  sort(column: keyof User) { // Specify the type of column as keyof User
    if (this.sortColumn === column) {
      this.sortReverse = !this.sortReverse;
    } else {
      this.sortColumn = column;
      this.sortReverse = false;
    }
    this.sortUsers();
  }

  delete(userId: number) {
    this.userService.delete(userId).subscribe(() => {
      this.loadUsers(); // Refresh the user list after deletion
    });
  }
}
