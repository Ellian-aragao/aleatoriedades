import { Injectable } from '@angular/core';
import { CanActivateChild, CanLoad, Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardChildService implements CanActivateChild, CanLoad {

  constructor(private auth: AuthService, private router: Router) { }

  canActivateChild(): boolean {
    return this.canLoad();
  }
  canLoad(): boolean {
    if (this.auth.isUserAuthenticated()) {
      return true;
    }
    this.router.navigate(['login']);
    return false;
  }
}
