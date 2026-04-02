import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-getmarksheet',
  templateUrl: './getmarksheet.component.html',
  styles: [
  ]
})
export class GetmarksheetComponent extends BaseCtl {

  constructor(public locator: ServiceLocatorService, route: ActivatedRoute, private httpservice: HttpServiceService) {
    super(locator.endpoints.MARKSHEET, locator, route);

  }

  go() {
    var _self = this;
    this.httpservice.get("http://localhost:8081/Marksheet/rollno/" + this.form.data.rollNo, function (res: any) {
      _self.form.success = res.success;
      _self.form.message = res.result.message;
      if (res.success) {
        _self.form.list = res.result.data;
      } else {
        _self.form.error = false;
      }
    });
  }

}
