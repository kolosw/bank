import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../service/user-service/user.service';
import { User } from '../../model/user';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent {

  user: User = new User;

  constructor(
  private router: Router,
  private userService: UserService) {}

  onSubmit() {
    this.userService.update(this.user).subscribe(() => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }
}
