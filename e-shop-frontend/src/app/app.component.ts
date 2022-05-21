import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass'],
})
export class AppComponent {
  title = 'E-Shop';

  constructor(private router: Router) {}

  hasRoute(route: string) {
    return this.router.url.includes(route);
  }
}
