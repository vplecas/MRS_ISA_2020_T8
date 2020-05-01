import { Component, OnInit } from '@angular/core';
import { IUser, User } from 'src/app/model/user';
import { HttpUserService } from 'src/app/services/user-service/http-user.service';
import { SomeLogicService } from 'src/app/some-logic.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user: IUser = new User("","","","", "", "", "", "");

  constructor(
    private httpClientService: HttpUserService,
    private _someLogic: SomeLogicService
  ) { }

  ngOnInit(): void {
    this.httpClientService.getUserData().subscribe(response => this.handleSuccessfulResponse(response));
    

  }

  handleSuccessfulResponse( r )
  {
    this.user = r;
  }

  saveChanges(): void {
    this.httpClientService.changeUserData(this.user)
        .subscribe( data => {
          alert("Changes saved!");
        });

  };

}