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

  user: User;

  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private userService: UserService) {
    this.user = new User();
  }

  onSubmit() {
    this.userService.update(this.user).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }
}
