import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-scheduler-job',
  templateUrl: './scheduler-job.component.html',
  styles: [
  ]
})
export class SchedulerJobComponent extends BaseCtl {
  constructor(public locator: ServiceLocatorService, route: ActivatedRoute) {
    super(locator.endpoints.SCHEDULERJOB, locator, route);
  }
}
