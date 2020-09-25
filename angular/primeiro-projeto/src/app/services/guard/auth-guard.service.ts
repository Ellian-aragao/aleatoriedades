import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanLoad, Route, Router, RouterStateSnapshot, UrlSegment, UrlTree } from '@angular/router';

import { AuthService } from '../auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate, CanLoad {

  constructor(private auth: AuthService, private router: Router) { }
  // tslint:disable-next-line: variable-name
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
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
