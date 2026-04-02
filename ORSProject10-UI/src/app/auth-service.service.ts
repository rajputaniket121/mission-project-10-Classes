import { HttpErrorResponse, HttpEvent, HttpHandler, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  token: any

  constructor(private router: Router) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {


    if (localStorage.getItem('fname') && localStorage.getItem('token')) {
      this.token = localStorage.getItem('token')

      req = req.clone({
        "withCredentials": true,
        setHeaders: {
          "name": "Aniket",
          Authorization: this.token
        }
      })
    }
    //console.log(req.headers.get("Authorization"))
    return next.handle(req).pipe(
      catchError((error: HttpErrorResponse) => {

        // if (error.status === 503) {
        //   const message = error.error?.result?.message;
        //   this.router.navigate([this.router.url], {
        //     queryParams: { errorMessage: message },
        //   });
        // }

        if (error.status === 401) {
          this.router.navigate(['/login'], {
            queryParams: { errorMessage: error.error },
          });
        }

        if (error.status === 403) {
          localStorage.clear();
          this.router.navigate(['/login'], {
            queryParams: { errorMessage: 'Token is expired... plz login again..!!' },
          });
        }
        return throwError(error);
      })
    );
  }
}
