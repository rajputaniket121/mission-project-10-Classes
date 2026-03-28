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
    this.httpservice.get("http://localhost:8080/Marksheet/rollno/" + this.form.data.rollNo, function (res: any) {

      if (res.success) {
        _self.form.list = res.result.data;
        if (_self.form.list.length == 0) {
          _self.form.message = "No record found";
          _self.form.error = true;
          _self.form.success = res.success;
        }
        console.log("List Size", _self.form.list.length);
      } else {
        _self.form.error = false;
        _self.form.message = res.result.message;
        _self.form.success = res.success;
      }
      // console.log('FORM', _self.form);
      console.log("Success value ", _self.form.success);
    });

  }

}
