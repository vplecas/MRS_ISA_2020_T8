import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { IUserLogin, UserLogin } from 'src/app/model/userLogin';
import { LoginService } from 'src/app/services/login-service/login.service';
import { AuthService } from 'src/app/services/authService/auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  //simpleForm: FormGroup;
  user : IUserLogin = new UserLogin("", "");
  response : any;
  submitted = false;
  errorMsg : string;
  private router: Router;
/*
  constructor(public fb: FormBuilder) {
    this.simpleForm = fb.group({
      simpleFormEmailEx: ['', [Validators.required, Validators.email]],
      simpleFormPasswordEx: ['', Validators.required],
    });
   }*/
   constructor(private _loginService: LoginService, private _authService: AuthService) {}

  ngOnInit(): void {
  }

  onSubmit(form : NgForm) {
    //if someone tries to send invalid data do not send request
    if(form.invalid){
      form.resetForm();
      return;
    }

    this.submitted = true;
    this.errorMsg = undefined;

    this._authService.login(this.user)
      .subscribe(data => {
          this._loginService.getMyInfo().subscribe();
          //this.router.navigate(['user-page']);
        },
        error => {
          this.submitted = false;
          this.errorMsg = 'Incorrect username or password.';
          form.resetForm();
        });
        console.log(this._loginService.currentUser);
  }

}
